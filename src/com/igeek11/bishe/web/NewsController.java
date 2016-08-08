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
import com.igeek11.bishe.bean.News;
import com.igeek11.bishe.bean.Super;
import com.igeek11.bishe.biz.INewsBiz;

@Controller
@RequestMapping("/news")
public class NewsController {
	@Autowired
	private INewsBiz newsBiz;
//增加一个新闻
	@RequestMapping(value= "/newsAdd")
	public String newsAdd(News news,HttpSession session,HttpServletResponse response) throws ServletException, IOException{
	Super  sup= (Super)session.getAttribute("sup");
	int newssupno=sup.getSuperno();
	news.setNewssupno(newssupno);
	

	 int a= newsBiz.newsAdd(news);
///////////////////////////////////////////////////////消息弹窗 配合script使用
/*	  放在jsp	<script type="text/javascript">
alert{${msg}}
</script>*/
String msg = null;
if(a>0){msg="OK!";}
else{msg="Error!";}
response.setContentType("text/html;charset=utf-8");
PrintWriter out=response.getWriter();
out.println(msg);
out.flush();
///////////////////////////////////////////////////////
		return null;
	}
// 查询新闻列表
	@RequestMapping(value = "/newsList")
	public String newsList(News news,HttpServletRequest req) {
		String resp = null;
		List<News> news1= newsBiz.newsList(news);
		req.setAttribute("news1", news1);
		resp = "/smallJsp/newsList.jsp";
		return resp;
	}
//	首页显示新闻列表
	@RequestMapping(value= "/mainnewsList")
	public String questionteachersList(HttpServletRequest request,HttpServletResponse response){
		List<News> news1=null;
		news1	 =newsBiz.mainnewsList();
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			GsonBuilder builder = new GsonBuilder();
			builder.setDateFormat("yyyy-MM-dd");
			Gson gson = builder.create();
			out.println(gson.toJson(news1));
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
//显示当前新闻具体信息
	@RequestMapping(value = "/newsDisplay")
	public String newsDisplay(String newsno, HttpServletRequest req) throws SQLException {
		int newsno1 = Integer.parseInt(req.getParameter("newsno"));
		String resp = null;
		News news = newsBiz.newsDisplay(newsno1);
		req.setAttribute("news", news);
		resp = "/middleJsp/newsDisplay.jsp";
		return resp;
	}

//	删除某条新闻

	@RequestMapping(value = "/newsdelete")
public String newsdelete(HttpServletRequest req,News news) throws SQLException {
		String resp = null;
		int newsno1 = Integer.parseInt(req.getParameter("newsno"));
		int a = newsBiz.newsdelete(newsno1);
	List<News> news1= newsBiz.newsList(news);
	req.setAttribute("news1", news1);
		resp = "/smallJsp/newsList.jsp";
		return resp;
	}

}
