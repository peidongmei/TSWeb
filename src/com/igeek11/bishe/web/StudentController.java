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
//ѧ��ע��
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
//ѧ����¼
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Student student,HttpServletRequest req,HttpServletResponse response,HttpSession session) throws IOException, ServletException{//��ȡ���ݿ���ֵ ��ͨ����
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
			msg="�˺Ż��������";
		}
		}
		else{msg="��֤�����!";
          req.setAttribute("msg", msg);
          req.getRequestDispatcher("/studentLogin.jsp").forward(req, response);
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		/*out.println(msg);*/
		return null;
		}

///////////////////////////////////////////////////////��Ϣ���� ���scriptʹ��
/*	  ����jsp	<script type="text/javascript">
alert{${msg}}
</script>*/


///////////////////////////////////////////////////////
		
		
//����ѧ����Ϣ1
@RequestMapping(value="/studentUpdate1")
public String studentUpdate1(int stuno,HttpServletRequest req)throws SQLException {
	String resp=null;
	int stuno1=Integer.parseInt(req.getParameter("stuno"));
	System.out.println(stuno1);
		Student student = studentBiz.studentUpdate1(stuno1);
		req.setAttribute("student",student);//����ֵ(��һ����ȡ��)
		resp ="/smallJsp/studentUpdate.jsp";
		return resp;
	}
//����ѧ����Ϣ2
	@RequestMapping(value="/studentUpdate2")
public String studentUpdate2(Student student,HttpServletRequest req,HttpServletResponse response)throws SQLException{	
		int a=studentBiz.studentUpdate2(student);
		String msg = null;
		 HttpSession session = req.getSession(false);//��ֹ����Session  
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
				 msg = "���³ɹ�";
				 
				 }else{
				 msg="����ʧ��";
				 }
				 System.out.println(msg);
				 return null;
	
	}
	
	// �б���ʾѧ����Ϣ�ķ���
	@RequestMapping(value = "/studentList")
	public String studentList(Student student, HttpServletRequest req) {
		String resp = null;
		List<Student> stus = studentBiz.querystudent(student);
		req.setAttribute("students", stus);
		resp = "/smallJsp/studentList.jsp";
		return resp;
	}

	// ɾ��ѧ���û�
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
