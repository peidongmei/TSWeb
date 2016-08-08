package com.igeek11.bishe.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.igeek11.bishe.bean.Notice;
import com.igeek11.bishe.bean.Super;
import com.igeek11.bishe.biz.INoticeBiz;


@Controller
@RequestMapping("/notice")
public class NoticeController {

		@Autowired
		private INoticeBiz noticeBiz;
	//����һ������
		@RequestMapping(value= "/noticeAdd")
		public String noticeAdd(Notice notice,HttpSession session,HttpServletResponse response) throws ServletException, IOException{
		Super  sup= (Super)session.getAttribute("sup");
		int noticesupno=sup.getSuperno();
		notice.setNoticesupno(noticesupno);
		 int a= noticeBiz.noticeAdd(notice);
		 String msg = null;
		
			if(a>0){msg="OK!";}
			else{msg="Error!";}
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println(msg);
			out.flush();
			return null;
		}
	//��ѯ�����б�
		@RequestMapping(value = "/noticeList")
		public String noticeList(Notice notice,HttpServletRequest req) {
			String resp = null;
			List<Notice> notice1= noticeBiz.noticeList(notice);
			req.setAttribute("notice1", notice1);
			resp = "/smallJsp/noticeList.jsp";
			return resp;
		}
	//��ʾ��ǰ���������Ϣ
		@RequestMapping(value = "/noticeDisplay")
		public String noticeDisplay(String noticeno, HttpServletRequest req) throws SQLException {
			int noticeno1 = Integer.parseInt(req.getParameter("noticeno"));
			String resp = null;
			Notice notice = noticeBiz.noticeDisplay(noticeno1);
			req.setAttribute("notice", notice);
			resp = "/smallJsp/noticeDisplay.jsp";
			return resp;
		}
//		ɾ��ĳ������
	
		@RequestMapping(value = "/noticedelete")
	public String noticedelete(HttpServletRequest req,Notice notice) throws SQLException {
			String resp = null;
			int noticeno1 = Integer.parseInt(req.getParameter("noticeno"));
			int a = noticeBiz.noticedelete(noticeno1);
		List<Notice> notice1= noticeBiz.noticeList(notice);
		req.setAttribute("notice1", notice1);
			resp = "/smallJsp/noticeList.jsp";
			return resp;
		}
//	��ҳ��ʾ�����б�
	@RequestMapping(value= "/mainnoticeList")
	public String questionteachersList(HttpServletRequest request,HttpServletResponse response){
		List<Notice> notice1=null;
		notice1	 =noticeBiz.mainnoticeList();
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			GsonBuilder builder = new GsonBuilder();
			builder.setDateFormat("yyyy-MM-dd");
			Gson gson = builder.create();//�������ζ�ʱ����и�ʽ��
			out.println(gson.toJson(notice1));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
