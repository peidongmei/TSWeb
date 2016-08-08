package com.igeek11.bishe.web;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.igeek11.bishe.bean.Teacher;
import com.igeek11.bishe.bean.Teachresource;
import com.igeek11.bishe.biz.ITeachresourceBiz;

@Controller
@MultipartConfig
@RequestMapping("/teachresource")
public class TeachrescourceController {
	@Autowired
	private ITeachresourceBiz teachresourceBiz ;
	//资源上传
	@RequestMapping(value= "/upload")
	
	public String upload(Teachresource teachresource,HttpSession session,HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
//////////////////////////////////////把数据保存到数据库
//resno(序列),resname(前面获取),oldname(前面获取),restype(前面获取),ressubno(前面获取),resupdate(sys),resteachno
Teacher tea1= (Teacher) session.getAttribute("tea");//取出来那个保存的对象
int resteachno = tea1.getTeachno();//把老师的id传给现在的老师对象
int ressubno =tea1.getTeachsubjectnum();//获取教师所属学科号 传给资源所属学科号
int  type=Integer.parseInt(request.getParameter("type"));//获取资源类型编号


Part part = request.getPart("resname");
String contentType = part.getContentType();
//将文件保存在服务器中

//if(!"image/jpeg".equals(contentType)){
//	//错误提示
//	response.sendRedirect("/message.jsp");
//}else{
	//将资源保存在服务器中
	String oldName = part.getSubmittedFileName();
	String dir = request.getServletContext().getRealPath("/WEB-INF/upload");
	String uniqueFileName = UUID.randomUUID().toString();
	String extendName = oldName.substring(oldName.lastIndexOf('.'));
	String url=uniqueFileName+extendName;
	String fileName=dir+"/"+uniqueFileName+extendName;
	part.write(fileName);
//	AsyncContext ac = request.startAsync();
//	ac.start(new Runnable() {
//		
//		@Override
//		public void run() {
//			System.out.println(12);
//			try {
//				part.write(fileName);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	});
	
	//将数据保存到数据库
	teachresource.setResteachno(resteachno);//保存了resteachno
	teachresource.setOldname(oldName);
	teachresource.setRestype(type);//保存了restype
	teachresource.setRessubno(ressubno);//保存了ressubno
	teachresource.setResname(url);//保存了带扩展名的UUIDname
	//执行插入数据库的操作
	int a=teachresourceBiz.upload(teachresource);
	
	String msg =null;
	if (a > 0) {
		msg = "OK!";
	} else {
		msg = "Error!";
	}
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out = response.getWriter();
	out.println(msg);
	out.flush();
//}
return null;
	}
	
	// 学生查询教学资源 列表显示
	@RequestMapping(value = "/downList")
	public String downList(Teachresource teachresource, HttpServletRequest req,HttpServletResponse response) throws ServletException, IOException {
		String resp = null;
		int subject=Integer.parseInt(req.getParameter("subject"));
		int type=Integer.parseInt(req.getParameter("type"));
		teachresource.setRestype(type);
		teachresource.setRessubno(subject);
		List<Teachresource> teas = teachresourceBiz.typesubjectres(teachresource);
		req.setAttribute("teas", teas);
	/*	resp = "/smallJsp/downList.jsp";*/
		/*resp = "/filter/testziyuan.jsp";*/
		req.getRequestDispatcher("/filter/testziyuan.jsp").forward(req, response);
		return null;
	}
	//下载
	@RequestMapping(value = "/down")
		protected String down( Teachresource teachresource,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//可以根据resno到数据库中查询到imgpath和oldname
			String resno = req.getParameter("resno");
			//查询数据库获取oldname 和 rename
			Teachresource teachresource1=	teachresourceBiz.downquery(teachresource);
			String	oldname=teachresource1.getOldname();
			String resourcepath=teachresource1.getResname();
			//要将WEB-INF/userimgs中的imgpath对应的文件以oldname这个名字下载到客户端
			//设置响应头，以便于浏览器能正确的处理响应的内容
			resp.setContentType("image/jpeg");//MIME,浏览器知道MIME后，才知道应该使用什么程序来处理响应内容
			//设置下面这两个响应头，浏览器才会打开下载文件的对话框
			resp.setHeader("Location",oldname);
			resp.setHeader("Content-Disposition", "attachment; filename=" + oldname);
			InputStream is = null;
			OutputStream os = null;
			try {
				is = req.getServletContext().getResourceAsStream("/WEB-INF/upload/"+resourcepath);
				os = resp.getOutputStream();
				byte[] buf=new byte[8*1024];
				int len=-1;
				while((len=is.read(buf))!=-1){
					os.write(buf, 0, len);
				}
				os.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(is!=null){
					is.close();
				}
				//请注意，在servlet中，输出流容器自动回处理的
			}
			return null;
			
		}
	// 教师查看列表资源信息的方法
	//仅查看自己上传的资源
	@RequestMapping(value = "/resourceList")
	public String resourceList(Teachresource teachresource, HttpServletRequest req,HttpServletResponse response,HttpSession session) throws ServletException, IOException {
		//先获取当前教师id
				Teacher teacher=(Teacher)session.getAttribute("tea");
				int resteachno=teacher.getTeachno();
				teachresource.setResteachno(resteachno);//将教师id封装成question对象 查询

		List<Teachresource> teas = teachresourceBiz.queryteachresource(teachresource);
		req.setAttribute("teas", teas);
		//请求转发
		req.getRequestDispatcher("/smallJsp/resourceList.jsp").forward(req, response);

		return null;
	}
	//更新资源名称1：查询结果并返回到teacherUpdate.jsp
	@RequestMapping(value = "/resUpdate1")
		public String resUpdate1( HttpServletRequest req) {
			String resno = req.getParameter("resno");
			String resp = null;
				Teachresource teachresource;
				teachresource = teachresourceBiz.resUpdate1(resno);
				req.setAttribute("teachresource", teachresource);
				resp = "/smallJsp/resUpdate.jsp";
				return resp;
		}

		@RequestMapping(value = "/resUpdate2")
	//	更新资源名称2：更新到数据库当中
		public String resUpdate2(HttpServletRequest req,HttpServletResponse response) throws SQLException, IOException {
			
			int resno1 = Integer.parseInt(req.getParameter("resno"));
			String  oldname =req.getParameter("oldname");
			String  resno=req.getParameter("resno");
			Teachresource teachresource =new Teachresource() ;
			teachresource.setOldname(oldname);
			teachresource.setResno(resno1);
		// 实现更新的操作
		int aaa=	teachresourceBiz.resUpdate2(teachresource);
			List<Teachresource> teas = teachresourceBiz.queryteachresource(teachresource);
			req.setAttribute("teas", teas);
			String msg =null;
			if(aaa>0){msg="OK!";}
			else{msg="Error!";}
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println(msg);
			out.flush();
			return null;
		}
	//资源删除
	@RequestMapping(value = "/resdelete")
	public String teachresourcedelete(Teachresource teachresource, HttpServletRequest req,HttpSession session,HttpServletResponse response) throws SQLException, ServletException, IOException {
		Teacher teacher=(Teacher)session.getAttribute("tea");
		int resno = Integer.parseInt(req.getParameter("resno"));
		int resteachno=teacher.getTeachno();
		teachresourceBiz.teachresourcedelete(teachresource);
		teachresource.setResteachno(resteachno);//将教师id封装成question对象 查询

		List<Teachresource> teas = teachresourceBiz.queryteachresource(teachresource);
		req.setAttribute("teas", teas);
		//请求转发
		req.getRequestDispatcher("/smallJsp/resourceList.jsp").forward(req, response);
		return null;
	}
}