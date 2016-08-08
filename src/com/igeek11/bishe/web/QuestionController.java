package com.igeek11.bishe.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.igeek11.bishe.bean.Answer;
import com.igeek11.bishe.bean.Question;
import com.igeek11.bishe.bean.Student;
import com.igeek11.bishe.bean.Teacher;
import com.igeek11.bishe.biz.IAnswerBiz;
import com.igeek11.bishe.biz.IQuestionBiz;
import com.igeek11.bishe.biz.ITeacherBiz;

@Controller
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private IQuestionBiz questionBiz;
	@Autowired
	private ITeacherBiz teacherBiz;//��ѯ��ʦ�б�ʱ��
	
//	@RequestMapping("/questionteachersList")//�÷����Զ���ǰ����ʾgson��ʽ������
//	public @ResponseBody List<Teacher> questionteachersList(){
//		List<Teacher> questionteachers=null;
//		questionteachers	 =teacherBiz.questionteachers();
//		return questionteachers;
//	}	
//ѧ������ǰ�Ȼ�ȡ��ʦ����
	@RequestMapping(value= "/questionteachersList")
	public String questionteachersList(HttpServletRequest request,HttpServletResponse response){
		List<Teacher> questionteachers=null;
		questionteachers	 =teacherBiz.questionteachers();
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(new Gson().toJson(questionteachers));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
//ѧ�������ύ
	@RequestMapping(value= "/studentUpquestion")
	public String studentUpquestion(Question question,HttpServletRequest req,HttpSession session,HttpServletResponse response) throws IOException{
		 String msg = null;
		 Student student=(Student) session.getAttribute("student1");
		int questuno=student.getStuno();
		 question.setQuestuno(questuno);
		 question.setQueteachno(Integer.parseInt( req.getParameter("teachno")));
		 
		 System.out.println(questuno);

		 
		 int a= questionBiz.studentUpquestion(question);
		 response.setContentType("text/html;charset=utf-8");
		 
		 if (a > 0) {
				//msg = "OK!";
			 response.getWriter().write("<script>alert('�ύ�ɹ�');</script>");
			 response.getWriter().write("<script>window.location='/bishe/middleJsp/jxzy.jsp';</script>");
			} else {
				msg = "Error!";
			}
			/*try {
				
				PrintWriter out = response.getWriter();
				out.println(msg);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			return null;
	}
	// �б���ʾ������Ϣ�ķ���
	@RequestMapping(value = "/questionList")
	public String questionList(Question question,HttpServletRequest req,HttpSession session) {
		//�Ȼ�ȡ��ǰ��ʦid
		Teacher teacher=(Teacher)session.getAttribute("tea");
		int queteachno=teacher.getTeachno();
		question.setQueteachno(queteachno);//����ʦid��װ��question���� ��ѯ
		String resp = null;
		List<Question> questions = questionBiz.queryquestion(question);
		req.setAttribute("questions", questions);
		resp = "/smallJsp/questionList.jsp";
		return resp;
	}
	
	// �ش�����ķ���1:��ѯ��������ص�teacherAnswer.jsp
	@RequestMapping(value = "/questionUpdate1")
	public String questionUpdate1(HttpServletRequest req) throws SQLException {
		String queno = req.getParameter("queno");
		String resp = null;
			Question question;
			question = questionBiz.questionUpdate1(queno);
			req.setAttribute("question", question);
			resp = "/smallJsp/teacherAnswer.jsp";
		return resp;
	}
	

}
