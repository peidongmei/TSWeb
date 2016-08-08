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
	private IAnswerBiz answerBiz;//�ύ���õ�
	@Autowired
	private IQuestionBiz questionBiz;//ɾ��һ��question��
	// �ش�����ķ���2:�ش����Ⲣ�ύ��answer��
	@RequestMapping(value = "/teacherAnswer")
	public String teacherAnswer(HttpServletRequest req,HttpServletResponse resp,HttpSession session) throws SQLException {
		Answer answer1 = new Answer();
		//�Ȼ�ȡ��ǰ��ʦid
		Teacher teacher=(Teacher)session.getAttribute("tea");
		int queteachno=teacher.getTeachno();
		answer1.setAnswerteachno(queteachno);//����ʦid��װ��answer���� ��ѯ
//form����Ķ�����ֱ����set������ȡ Ҳ�Ͳ��ô�ǰ��ҳ���ȡ��
		String answertitle = req.getParameter("answertitle");
		String answerque = req.getParameter("answerque");
		String answerdetail = req.getParameter("answerdetail");
		
		//answerdetailֱ�ӷ�װ��answer������
		int answerstuno = Integer.parseInt(req.getParameter("questuno"));
		
		answer1.setAnswertitle(answertitle);
		answer1.setAnswerque(answerque);
		answer1.setAnswerstuno(answerstuno);
		answer1.setAnswerdetail(answerdetail);

		answerBiz.teacherAnswer(answer1);
		int a =answerBiz.teacherAnswer(answer1);
		//���ò���answer�ɹ�һ��ɾ��questionһ����ģʽ
		String aaa = null;
		 String msg = null;
		 if(a>0){
			 int queno = Integer.parseInt(req.getParameter("queno"));
			 questionBiz.deleteQuestion(queno);
		 msg = "���ɳɹ�";
		 }else{
		 msg="����ʧ��";
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
		// ʵ�ָ��µĲ���		
//		aaa = "/teacherAdmin.jsp";
		return aaa;
	}
//��ʦ��ѯ�����ѻش������

	@RequestMapping(value = "/answerList")
	public String answerList(Answer answer, HttpServletRequest req) {
		String resp = null;
		List <Answer> answers = answerBiz.queryanswer(answer);
		req.setAttribute("answers", answers);
		resp = "/smallJsp/answerList.jsp";
		return resp;
	}
// ѧ���鿴�Ѿ��������� �б���ʾ
	@RequestMapping(value = "/queryAnswer2")
	public String queryAnswer2(Answer answer, HttpServletRequest req) {
		String resp = null;
//		List <Answer> answers = answerBiz.queryanswer2(answer);
		List<Answer> answers =answerBiz.queryanswer3(answer);
		req.setAttribute("answers", answers);
		resp = "/smallJsp/testanswer.jsp";
		return resp;
	}
//ѧ���鿴��ϸ�Ļش�
	@RequestMapping(value = "/answerDisplay")
	public String answerDisplay(String answerno, HttpServletRequest req) throws SQLException {
		int answerno1 = Integer.parseInt(req.getParameter("answerno"));	
		String resp = null;
		Answer answer = answerBiz.answerDisplay(answerno1);
		req.setAttribute("answer", answer);
		resp = "/middleJsp/tiwen2.jsp";
		return resp;
	}
	
	
	//ɾ��һ�����𰸵�����
	@RequestMapping(value = "/answerDelete")
	public String answerDelete(HttpServletRequest req,Answer answer) throws SQLException {
	String resp = null;
	int answerno = Integer.parseInt(req.getParameter("answerno"));
	int a = answerBiz.answerDelete(answerno);
	resp = "/smallJsp/answerList.jsp";//�ض���
//	�ٲ�ѯһ�� ����������
	List <Answer> answers = answerBiz.queryanswer(answer);
	req.setAttribute("answers", answers);
	
	return resp;
}
}
