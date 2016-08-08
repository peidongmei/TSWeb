package com.igeek11.bishe.web;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.stream.events.StartDocument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.igeek11.bishe.bean.Student;
import com.igeek11.bishe.biz.IStudentBiz;
import com.igeek11.bishe.biz.impl.StudentBiz;;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private IStudentBiz studentBiz;
	@RequestMapping(value="/regist",method=RequestMethod.POST)
//学生注册
	public @ResponseBody String doRegist(Student student,HttpServletRequest req,HttpServletResponse response) throws IOException, ServletException {
	     
	       String stupwd=null;
	      String oldpwd= req.getParameter("stupwd");
	      try {
	    	  stupwd = MD5Util.md5Encode(oldpwd);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
	         student.setStupwd(stupwd);
	       
		     studentBiz.registStudent(student);
		       req.getRequestDispatcher("/studentLogin.jsp").forward(req, response);
		       	return null;
	}
//学生登录
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Student student,HttpServletRequest req,HttpServletResponse response,HttpSession session) throws IOException, ServletException{//获取数据库中值 普通方法
		String vc=req.getParameter("vc");
	       String stupwd=null;
		      String oldpwd= req.getParameter("stupwd");
		      try {
		    	  stupwd = MD5Util.md5Encode(oldpwd);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		      student.setStupwd(stupwd);
		
		String msg = null;
		if(vc!=null&&vc.equalsIgnoreCase((String)req.getSession().getAttribute("vc"))){		
		Student student1 = studentBiz.login(student);
		if(student1!=null){			
			session.setAttribute("student1",student1);
			req.getRequestDispatcher("/middleJsp/index.jsp").forward(req, response);
		}else{
			msg="账号或密码错误！";
		}
		}
		else{msg="验证码错误!";
          req.setAttribute("msg", msg);
          req.getRequestDispatcher("/studentLogin.jsp").forward(req, response);
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		/*out.println(msg);*/
		return null;
		}

///////////////////////////////////////////////////////消息弹窗 配合script使用
/*	  放在jsp	<script type="text/javascript">
alert{${msg}}
</script>*/


///////////////////////////////////////////////////////
		
		
//更新学生信息1
@RequestMapping(value="/studentUpdate1")
public String studentUpdate1(int stuno,HttpServletRequest req)throws SQLException {
	String resp=null;
	int stuno1=Integer.parseInt(req.getParameter("stuno"));
	System.out.println(stuno1);
		Student student = studentBiz.studentUpdate1(stuno1);
		req.setAttribute("student",student);//键、值(上一步获取的)
		resp ="/smallJsp/studentUpdate.jsp";
		return resp;
	}
//更新学生信息2
	@RequestMapping(value="/studentUpdate2")
public String studentUpdate2(Student student,HttpServletRequest req,HttpServletResponse response)throws SQLException{	
		int a=studentBiz.studentUpdate2(student);
		String msg = null;
		 HttpSession session = req.getSession(false);//防止创建Session  
	        if(session == null){  
	        	 try {
					response.sendRedirect("/bishe/studentLogin.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}  
	        	
	        }          
	        session.removeAttribute("student");  
	 	        try {
					response.sendRedirect("/bishe/studentLogin.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
			
				 if(a>0){
				 msg = "更新成功";
				 
				 }else{
				 msg="更新失败";
				 }
				 System.out.println(msg);
				 return null;
	
	}
	
	// 列表显示学生信息的方法
	@RequestMapping(value = "/studentList")
	public String studentList(Student student, HttpServletRequest req) {
		String resp = null;
		List<Student> stus = studentBiz.querystudent(student);
		req.setAttribute("students", stus);
		resp = "/smallJsp/studentList.jsp";
		return resp;
	}

	// 删除学生用户
	@RequestMapping(value = "/studentdelete")
	public String studentdelete(Student student, HttpServletRequest req) throws SQLException {
		String resp = null;
		int stuno = Integer.parseInt(req.getParameter("stuno"));
		int a = studentBiz.studentdelete(stuno);
		List<Student> stus = studentBiz.querystudent(student);
		req.setAttribute("students", stus);
		resp = "/smallJsp/studentList.jsp";
		return resp;
	}
}
