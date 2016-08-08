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
			session.setAttribute("tea", tea);//���ඣ�����Ҫ�õ�
			resp = "/teacherAdmin.jsp";
		} else {
			resp = "��¼ʧ��,�������µ�¼";
		}
		return resp;
	}

	// �б���ʾ��ʦ��Ϣ�ķ���
	@RequestMapping(value = "/teacherList")
	public String teacherList(Teacher teacher, HttpServletRequest req) {
		String resp = null;
		List<Teacher> teas = teacherBiz.queryteacher(teacher);
		req.setAttribute("teachers", teas); 
		resp = "/smallJsp/teacherList.jsp";
		return resp;
	}

	// ���½�ʦ�ķ���1:��ѯ��������ص�teacherUpdate.jsp
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

	// ���½�ʦ�ķ���2:���½�ʦȨ�޺�����ѧ�ƺ�
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
		// ʵ�ָ��µĲ���
		teacherBiz.teacherUpdate2(teacher1);
		aaa = "/smallJsp/teacherList.jsp";

		return aaa;
	}

	// ɾ����ʦ�û�
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

	// ��ʦ���Ҹ��µķ���1:��ѯ��������ص�teacherselfUpdate.jsp
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

	// ��ʦ���Ҹ��µķ���2:���½�ʦ������Ϣ
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
//��ʦ����ͷ��
	@RequestMapping(value = "/teacherphoto")
	public String teacherphoto (Teacher teacher,HttpServletRequest req,HttpServletResponse resp,HttpSession session){
		Teacher tea1= (Teacher) session.getAttribute("tea");//ȡ�����Ǹ�����Ķ���
		int teachno1 = tea1.getTeachno();//����ʦ��id�������ڵ���ʦ����
		teacher.setTeachno(teachno1);//
		String aaa = null;
		try {
			Part part = req.getPart("teachphurl");
			String contentType = part.getContentType();
		if(!"image/jpeg".equals(contentType)){
			//������ʾ
			System.out.println("Error!");
			resp.sendRedirect("/teacherAdmin.jsp");
		}else{
			//��img�����ڷ�������
			String oldName = part.getSubmittedFileName();
			String dir = req.getServletContext().getRealPath("/teacherimgs");
			String uniqueFileName = UUID.randomUUID().toString();
			String extendName = oldName.substring(oldName.lastIndexOf('.'));
			String fileName=dir+"/"+uniqueFileName+extendName;
			part.write(fileName);//��������п��ܻ��ܳ���ʱ��

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
//	��ʦ�޸��Լ��û�������1
	@RequestMapping(value = "/teacherselfPwd1")
	public String teacherselfPwd1(String teachno,HttpServletRequest req )throws SQLException{
	int teachno1 = Integer.parseInt(req.getParameter("teachno"));
	String resp = null;
	Teacher teacher = teacherBiz.teacherselfPwd1(teachno1);
	req.setAttribute("teacher", teacher);
	resp = "/smallJsp/teacherselfPwd.jsp";
	return resp;
	}
//	��ʦ�޸��Լ��û�������2
	@RequestMapping(value = "/teacherselfPwd2")
	public String teacherselfPwd2( Teacher teacher1,HttpServletRequest req,HttpServletResponse response) throws SQLException {

		teacherBiz.teacherselfPwd2(teacher1);
		int a = teacherBiz.teacherselfPwd2(teacher1);
		 HttpSession session = req.getSession(false);//��ֹ����Session  
		        if(session == null){  
		        	 try {
						response.sendRedirect("/bishe/commonlogin.jsp");
					} catch (IOException e) {
						e.printStackTrace();
					}  
		        	
		        }  
			   //�˳���ǰ��¼       
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
//����Ա����һ����ʦ
	@RequestMapping(value="/teacherAdd")
	public String teacherAdd(Teacher teacher,HttpServletResponse response) throws ServletException, IOException{
//public String teacherAdd(Teacher teacher, HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	 String msg = null;
	 int a= teacherBiz.teacherAdd(teacher);
	 if(a>0){
		 msg = "�����ɹ�";
		 }else{
		 msg="����ʧ��";
		 }
//	 request.getRequestDispatcher("/bishe/superAdmin.jsp").forward(request, response);
	 response.setContentType("text/html;charset=utf-8");
	 PrintWriter out=response.getWriter();
	 out.println(msg);
	 out.flush();
		return null;
//	return msg;		
	}

	// �б���ʾ��ʦ��Ϣ�ķ���
	@RequestMapping(value = "/teacherDisplayList")
	public String 	teacherDisplayList(Teacher teacher, HttpServletRequest req) {
		String resp = null;
		List<Teacher> teas = teacherBiz.teacherDisplayList(teacher);
		req.setAttribute("teachers", teas);
		resp = "/smallJsp/teacherDisplayList.jsp";
		return resp;
	}	
	

//��ʦ������Ϣչʾ
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
//��ʦ�˳���¼
	@RequestMapping(value = "/teacherquit")
	public String teacherquit(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		//�Ȼ�ȡ��ǰ��ʦid
				Teacher teacher=(Teacher)session.getAttribute("tea");
			    session.removeAttribute("teacher");  
			    /*	request.getRequestDispatcher("/commonlogin.jsp").forward(request, response);		
		*/
			    response.sendRedirect("/bishe/commonlogin.jsp");
			    return null;
	}
//��ҳ�Խ�ʦ�б�
@RequestMapping(value= "/mainteacherList")
public String mainteacherList(HttpServletRequest request,HttpServletResponse response){
	List<Teacher> teacher=null;
	teacher	 =teacherBiz.mainteacherList();
	response.setContentType("text/json;charset=utf-8");
	PrintWriter out; //��ȡһ�������
	try {
		out = response.getWriter();//����һ����׼����������ڰ���Ҫ�������ݴ��䵽ҳ����
		out.println(new Gson().toJson(teacher));//����Ҫ�������ݴ��䵽ҳ����
		out.flush();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;
}

}
