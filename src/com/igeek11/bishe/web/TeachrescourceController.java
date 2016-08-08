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
	//��Դ�ϴ�
	@RequestMapping(value= "/upload")
	
	public String upload(Teachresource teachresource,HttpSession session,HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
//////////////////////////////////////�����ݱ��浽���ݿ�
//resno(����),resname(ǰ���ȡ),oldname(ǰ���ȡ),restype(ǰ���ȡ),ressubno(ǰ���ȡ),resupdate(sys),resteachno
Teacher tea1= (Teacher) session.getAttribute("tea");//ȡ�����Ǹ�����Ķ���
int resteachno = tea1.getTeachno();//����ʦ��id�������ڵ���ʦ����
int ressubno =tea1.getTeachsubjectnum();//��ȡ��ʦ����ѧ�ƺ� ������Դ����ѧ�ƺ�
int  type=Integer.parseInt(request.getParameter("type"));//��ȡ��Դ���ͱ��


Part part = request.getPart("resname");
String contentType = part.getContentType();
//���ļ������ڷ�������

//if(!"image/jpeg".equals(contentType)){
//	//������ʾ
//	response.sendRedirect("/message.jsp");
//}else{
	//����Դ�����ڷ�������
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
	
	//�����ݱ��浽���ݿ�
	teachresource.setResteachno(resteachno);//������resteachno
	teachresource.setOldname(oldName);
	teachresource.setRestype(type);//������restype
	teachresource.setRessubno(ressubno);//������ressubno
	teachresource.setResname(url);//�����˴���չ����UUIDname
	//ִ�в������ݿ�Ĳ���
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
	
	// ѧ����ѯ��ѧ��Դ �б���ʾ
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
	//����
	@RequestMapping(value = "/down")
		protected String down( Teachresource teachresource,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//���Ը���resno�����ݿ��в�ѯ��imgpath��oldname
			String resno = req.getParameter("resno");
			//��ѯ���ݿ��ȡoldname �� rename
			Teachresource teachresource1=	teachresourceBiz.downquery(teachresource);
			String	oldname=teachresource1.getOldname();
			String resourcepath=teachresource1.getResname();
			//Ҫ��WEB-INF/userimgs�е�imgpath��Ӧ���ļ���oldname����������ص��ͻ���
			//������Ӧͷ���Ա������������ȷ�Ĵ�����Ӧ������
			resp.setContentType("image/jpeg");//MIME,�����֪��MIME�󣬲�֪��Ӧ��ʹ��ʲô������������Ӧ����
			//����������������Ӧͷ��������Ż�������ļ��ĶԻ���
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
				//��ע�⣬��servlet�У�����������Զ��ش����
			}
			return null;
			
		}
	// ��ʦ�鿴�б���Դ��Ϣ�ķ���
	//���鿴�Լ��ϴ�����Դ
	@RequestMapping(value = "/resourceList")
	public String resourceList(Teachresource teachresource, HttpServletRequest req,HttpServletResponse response,HttpSession session) throws ServletException, IOException {
		//�Ȼ�ȡ��ǰ��ʦid
				Teacher teacher=(Teacher)session.getAttribute("tea");
				int resteachno=teacher.getTeachno();
				teachresource.setResteachno(resteachno);//����ʦid��װ��question���� ��ѯ

		List<Teachresource> teas = teachresourceBiz.queryteachresource(teachresource);
		req.setAttribute("teas", teas);
		//����ת��
		req.getRequestDispatcher("/smallJsp/resourceList.jsp").forward(req, response);

		return null;
	}
	//������Դ����1����ѯ��������ص�teacherUpdate.jsp
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
	//	������Դ����2�����µ����ݿ⵱��
		public String resUpdate2(HttpServletRequest req,HttpServletResponse response) throws SQLException, IOException {
			
			int resno1 = Integer.parseInt(req.getParameter("resno"));
			String  oldname =req.getParameter("oldname");
			String  resno=req.getParameter("resno");
			Teachresource teachresource =new Teachresource() ;
			teachresource.setOldname(oldname);
			teachresource.setResno(resno1);
		// ʵ�ָ��µĲ���
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
	//��Դɾ��
	@RequestMapping(value = "/resdelete")
	public String teachresourcedelete(Teachresource teachresource, HttpServletRequest req,HttpSession session,HttpServletResponse response) throws SQLException, ServletException, IOException {
		Teacher teacher=(Teacher)session.getAttribute("tea");
		int resno = Integer.parseInt(req.getParameter("resno"));
		int resteachno=teacher.getTeachno();
		teachresourceBiz.teachresourcedelete(teachresource);
		teachresource.setResteachno(resteachno);//����ʦid��װ��question���� ��ѯ

		List<Teachresource> teas = teachresourceBiz.queryteachresource(teachresource);
		req.setAttribute("teas", teas);
		//����ת��
		req.getRequestDispatcher("/smallJsp/resourceList.jsp").forward(req, response);
		return null;
	}
}