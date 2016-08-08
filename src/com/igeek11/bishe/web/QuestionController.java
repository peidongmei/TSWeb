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
	private ITeacherBiz teacherBiz;//查询教师列表时用
	
//	@RequestMapping("/questionteachersList")//该方法自动在前端显示gson格式的数据
//	public @ResponseBody List<Teacher> questionteachersList(){
//		List<Teacher> questionteachers=null;
//		questionteachers	 =teacherBiz.questionteachers();
//		return questionteachers;
//	}	
//学生提问前先获取老师名字
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
//学生问题提交
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
			 response.getWriter().write("<script>alert('提交成功');</script>");
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
	// 列表显示问题信息的方法
	@RequestMapping(value = "/questionList")
	public String questionList(Question question,HttpServletRequest req,HttpSession session) {
		//先获取当前教师id
		Teacher teacher=(Teacher)session.getAttribute("tea");
		int queteachno=teacher.getTeachno();
		question.setQueteachno(queteachno);//将教师id封装成question对象 查询
		String resp = null;
		List<Question> questions = questionBiz.queryquestion(question);
		req.setAttribute("questions", questions);
		resp = "/smallJsp/questionList.jsp";
		return resp;
	}
	
	// 回答问题的方法1:查询结果并返回到teacherAnswer.jsp
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
