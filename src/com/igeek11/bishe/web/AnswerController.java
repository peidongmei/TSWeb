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

import com.igeek11.bishe.bean.Answer;
import com.igeek11.bishe.bean.Teacher;
import com.igeek11.bishe.biz.IAnswerBiz;
import com.igeek11.bishe.biz.IQuestionBiz;

@Controller
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	private IAnswerBiz answerBiz;//提交答案用的
	@Autowired
	private IQuestionBiz questionBiz;//删除一条question用
	// 回答问题的方法2:回答问题并提交到answer表
	@RequestMapping(value = "/teacherAnswer")
	public String teacherAnswer(HttpServletRequest req,HttpServletResponse resp,HttpSession session) throws SQLException {
		Answer answer1 = new Answer();
		//先获取当前教师id
		Teacher teacher=(Teacher)session.getAttribute("tea");
		int queteachno=teacher.getTeachno();
		answer1.setAnswerteachno(queteachno);//将教师id封装成answer对象 查询
//form表单填的东西能直接由set方法获取 也就不用从前端页面获取了
		String answertitle = req.getParameter("answertitle");
		String answerque = req.getParameter("answerque");
		String answerdetail = req.getParameter("answerdetail");
		
		//answerdetail直接封装到answer对象当中
		int answerstuno = Integer.parseInt(req.getParameter("questuno"));
		
		answer1.setAnswertitle(answertitle);
		answer1.setAnswerque(answerque);
		answer1.setAnswerstuno(answerstuno);
		answer1.setAnswerdetail(answerdetail);

		answerBiz.teacherAnswer(answer1);
		int a =answerBiz.teacherAnswer(answer1);
		//采用插入answer成功一条删除question一条的模式
		String aaa = null;
		 String msg = null;
		 if(a>0){
			 int queno = Integer.parseInt(req.getParameter("queno"));
			 questionBiz.deleteQuestion(queno);
		 msg = "答疑成功";
		 }else{
		 msg="答疑失败";
		 }
			resp.setContentType("text/html;charset=utf-8");
			try {
				PrintWriter out = resp.getWriter();
				out.println(msg);
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 System.out.println(msg);
		// 实现更新的操作		
//		aaa = "/teacherAdmin.jsp";
		return aaa;
	}
//教师查询所有已回答的问题

	@RequestMapping(value = "/answerList")
	public String answerList(Answer answer, HttpServletRequest req) {
		String resp = null;
		List <Answer> answers = answerBiz.queryanswer(answer);
		req.setAttribute("answers", answers);
		resp = "/smallJsp/answerList.jsp";
		return resp;
	}
// 学生查看已经解答的问题 列表显示
	@RequestMapping(value = "/queryAnswer2")
	public String queryAnswer2(Answer answer, HttpServletRequest req) {
		String resp = null;
//		List <Answer> answers = answerBiz.queryanswer2(answer);
		List<Answer> answers =answerBiz.queryanswer3(answer);
		req.setAttribute("answers", answers);
		resp = "/smallJsp/testanswer.jsp";
		return resp;
	}
//学生查看详细的回答
	@RequestMapping(value = "/answerDisplay")
	public String answerDisplay(String answerno, HttpServletRequest req) throws SQLException {
		int answerno1 = Integer.parseInt(req.getParameter("answerno"));	
		String resp = null;
		Answer answer = answerBiz.answerDisplay(answerno1);
		req.setAttribute("answer", answer);
		resp = "/middleJsp/tiwen2.jsp";
		return resp;
	}
	
	
	//删除一个带答案的问题
	@RequestMapping(value = "/answerDelete")
	public String answerDelete(HttpServletRequest req,Answer answer) throws SQLException {
	String resp = null;
	int answerno = Integer.parseInt(req.getParameter("answerno"));
	int a = answerBiz.answerDelete(answerno);
	resp = "/smallJsp/answerList.jsp";//重定向
//	再查询一遍 看最新数据
	List <Answer> answers = answerBiz.queryanswer(answer);
	req.setAttribute("answers", answers);
	
	return resp;
}
}
