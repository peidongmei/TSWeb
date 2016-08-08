package com.igeek11.bishe.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.stream.events.StartDocument;
import javax.servlet.http.Part;

import org.apache.catalina.valves.rewrite.Substitution.RewriteRuleBackReferenceElement;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.igeek11.bishe.bean.Teacher;
import com.igeek11.bishe.biz.ITeacherBiz;
import com.igeek11.bishe.biz.impl.TeacherBiz;

@Controller
@MultipartConfig
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private ITeacherBiz teacherBiz;

	@RequestMapping(value = "/tealogin", method = RequestMethod.POST)
	public String tealogin(Teacher teacher, HttpSession session) {// HttpServletRequest
		String resp = null;
		Teacher tea = teacherBiz.tealogin(teacher);
		if (tea != null) {
			session.setAttribute("tea", tea);//存好喽，后面要用的
			resp = "/teacherAdmin.jsp";
		} else {
			resp = "登录失败,返回重新登录";
		}
		return resp;
	}

	// 列表显示教师信息的方法
	@RequestMapping(value = "/teacherList")
	public String teacherList(Teacher teacher, HttpServletRequest req) {
		String resp = null;
		List<Teacher> teas = teacherBiz.queryteacher(teacher);
		req.setAttribute("teachers", teas); 
		resp = "/smallJsp/teacherList.jsp";
		return resp;
	}

	// 更新教师的方法1:查询结果并返回到teacherUpdate.jsp
	@RequestMapping(value = "/teacherUpdate1")
	public String teacherUpdate1( HttpServletRequest req) {
		String teachno1 = req.getParameter("teachno");
		String resp = null;
			Teacher teacher;
			try {
				teacher = teacherBiz.teacherUpdate1(teachno1);
				req.setAttribute("teacher", teacher);
				resp = "/smallJsp/teacherUpdate.jsp";
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return resp;
	}

	// 更新教师的方法2:更新教师权限和所属学科号
	@RequestMapping(value = "/teacherUpdate2")

	public String teacherUpdate2(Teacher teacher, HttpServletRequest req) throws SQLException {
		String aaa = null;
		
//		try {
//			req.setCharacterEncoding("utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		String teachno = req.getParameter("teachno");
		int teachpermlevel = Integer.parseInt(req.getParameter("teachpermlevel"));
		int teachsubjectnum = Integer.parseInt(req.getParameter("teachsubjectnum"));
		Teacher teacher1 = new Teacher();
		teacher1.setTeachno(Integer.parseInt(teachno));
		teacher1.setTeachpermlevel(teachpermlevel);
		teacher1.setTeachsubjectnum(teachsubjectnum);
		// 实现更新的操作
		teacherBiz.teacherUpdate2(teacher1);
		aaa = "/smallJsp/teacherList.jsp";

		return aaa;
	}

	// 删除教师用户
	@RequestMapping(value = "/teacherdelete")
	public String teacherdelete(Teacher teacher, HttpServletRequest req) throws SQLException {
		String resp = null;
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int teachno = Integer.parseInt(req.getParameter("teachno"));
		int a = teacherBiz.teacherdelete(teachno);
		List<Teacher> teas = teacherBiz.queryteacher(teacher);
		req.setAttribute("teachers", teas);
		
		resp = "/smallJsp/teacherList.jsp";
		
		return resp;
	}

	// 教师自我更新的方法1:查询结果并返回到teacherselfUpdate.jsp
	@RequestMapping(value = "/teacherselfUpdate1")
	public String teacherselfUpdate1(String teachno, HttpServletRequest req) throws SQLException {
		int teachno1 = Integer.parseInt(req.getParameter("teachno"));
		String resp = null;
		Teacher teacher = teacherBiz.teacherselfUpdate1(teachno1);
		req.setAttribute("teacher", teacher);
		resp = "/smallJsp/teacherselfUpdate.jsp";
		return resp;
	}
	// teachno,teachnickname,teachpwd,teachname,teachsex,teachbirth,terminaldegree,
	// teachresume,resdirection,teachtitle,teachtreatise,teachprize,teachmail,teachphurl,teachpermlevel,teachsubjectnum)

	// 教师自我更新的方法2:更新教师个人信息
	@RequestMapping(value = "/teacherselfUpdate2")
	public String teacherselfUpdate2( Teacher teacher1,HttpServletRequest req,HttpServletResponse resp) throws SQLException {
		String aaa = null;
		teacherBiz.teacherselfUpdate2(teacher1);
		 int a = teacherBiz.teacherselfUpdate2(teacher1);
		 String msg = null;
		 if (a > 0) {
				msg = "OK!";
			} else {
				msg = "Error!";
			}
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			try {
				out = resp.getWriter();
				out.println(msg);
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return aaa;	
	}
//教师更新头像
	@RequestMapping(value = "/teacherphoto")
	public String teacherphoto (Teacher teacher,HttpServletRequest req,HttpServletResponse resp,HttpSession session){
		Teacher tea1= (Teacher) session.getAttribute("tea");//取出来那个保存的对象
		int teachno1 = tea1.getTeachno();//把老师的id传给现在的老师对象
		teacher.setTeachno(teachno1);//
		String aaa = null;
		try {
			Part part = req.getPart("teachphurl");
			String contentType = part.getContentType();
		if(!"image/jpeg".equals(contentType)){
			//错误提示
			System.out.println("Error!");
			resp.sendRedirect("/teacherAdmin.jsp");
		}else{
			//将img保存在服务器中
			String oldName = part.getSubmittedFileName();
			String dir = req.getServletContext().getRealPath("/teacherimgs");
			String uniqueFileName = UUID.randomUUID().toString();
			String extendName = oldName.substring(oldName.lastIndexOf('.'));
			String fileName=dir+"/"+uniqueFileName+extendName;
			part.write(fileName);//这个操作有可能化很长的时间

			 teacher.setTeachphurl(uniqueFileName);
			 int a = teacherBiz.teacherphoto(teacher);
			 String msg = null;
			 if (a > 0) {
					msg = "OK!";
				} else {
					msg = "Error!";
				}
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				out.println(msg);
				out.flush();
				 
			}
	} catch (IOException | ServletException e) {
		e.printStackTrace();
	}	
			 
			return null;

	}
//	教师修改自己用户名密码1
	@RequestMapping(value = "/teacherselfPwd1")
	public String teacherselfPwd1(String teachno,HttpServletRequest req )throws SQLException{
	int teachno1 = Integer.parseInt(req.getParameter("teachno"));
	String resp = null;
	Teacher teacher = teacherBiz.teacherselfPwd1(teachno1);
	req.setAttribute("teacher", teacher);
	resp = "/smallJsp/teacherselfPwd.jsp";
	return resp;
	}
//	教师修改自己用户名密码2
	@RequestMapping(value = "/teacherselfPwd2")
	public String teacherselfPwd2( Teacher teacher1,HttpServletRequest req,HttpServletResponse response) throws SQLException {

		teacherBiz.teacherselfPwd2(teacher1);
		int a = teacherBiz.teacherselfPwd2(teacher1);
		 HttpSession session = req.getSession(false);//防止创建Session  
		        if(session == null){  
		        	 try {
						response.sendRedirect("/bishe/commonlogin.jsp");
					} catch (IOException e) {
						e.printStackTrace();
					}  
		        	
		        }  
			   //退出当前登录       
		        session.removeAttribute("teacher1");  
		 	      /*  try {
						response.sendRedirect("/bishe/commonlogin.jsp");
					} catch (IOException e) {
						e.printStackTrace();
					}
*/
		 String msg = null;
		 if (a > 0) {
				msg = "OK!";
			} else {
				msg = "Error!";
			}
			response.setContentType("text/html;charset=utf-8");
			try {
				PrintWriter out = response.getWriter();
				out.println(msg);
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return null;
	}
//管理员增加一个教师
	@RequestMapping(value="/teacherAdd")
	public String teacherAdd(Teacher teacher,HttpServletResponse response) throws ServletException, IOException{
//public String teacherAdd(Teacher teacher, HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	 String msg = null;
	 int a= teacherBiz.teacherAdd(teacher);
	 if(a>0){
		 msg = "创建成功";
		 }else{
		 msg="创建失败";
		 }
//	 request.getRequestDispatcher("/bishe/superAdmin.jsp").forward(request, response);
	 response.setContentType("text/html;charset=utf-8");
	 PrintWriter out=response.getWriter();
	 out.println(msg);
	 out.flush();
		return null;
//	return msg;		
	}

	// 列表显示教师信息的方法
	@RequestMapping(value = "/teacherDisplayList")
	public String 	teacherDisplayList(Teacher teacher, HttpServletRequest req) {
		String resp = null;
		List<Teacher> teas = teacherBiz.teacherDisplayList(teacher);
		req.setAttribute("teachers", teas);
		resp = "/smallJsp/teacherDisplayList.jsp";
		return resp;
	}	
	

//教师个人信息展示
	@RequestMapping(value = "/teacherDisplay")
	public String teacherDisplay(String teachno, HttpServletRequest req) throws SQLException {
		int teachno1 = Integer.parseInt(req.getParameter("teachno"));
		String resp = null;
		Teacher teacher = teacherBiz.teacherDisplay(teachno1);
		req.setAttribute("teacher", teacher);
//		resp = "/smallJsp/teacherDisplay.jsp";
		resp = "/include/in_teamBulid.jsp";
		return resp;
	}
//教师退出登录
	@RequestMapping(value = "/teacherquit")
	public String teacherquit(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//先获取当前教师id
				Teacher teacher=(Teacher)session.getAttribute("tea");
			    session.removeAttribute("teacher");  
			    /*	request.getRequestDispatcher("/commonlogin.jsp").forward(request, response);		
		*/
			    response.sendRedirect("/bishe/commonlogin.jsp");
			    return null;
	}
//首页显教师列表
@RequestMapping(value= "/mainteacherList")
public String mainteacherList(HttpServletRequest request,HttpServletResponse response){
	List<Teacher> teacher=null;
	teacher	 =teacherBiz.mainteacherList();
	response.setContentType("text/json;charset=utf-8");
	PrintWriter out; //获取一个输出流
	try {
		out = response.getWriter();//构造一个标准输出流，用于把想要表达的内容传输到页面上
		out.println(new Gson().toJson(teacher));//把想要表达的内容传输到页面上
		out.flush();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;
}

}
