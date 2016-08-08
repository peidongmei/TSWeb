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

import com.igeek11.bishe.bean.Super;
import com.igeek11.bishe.bean.Teacher;
import com.igeek11.bishe.biz.ISuperBiz;
import com.igeek11.bishe.biz.ITeacherBiz;
import com.igeek11.bishe.biz.impl.SuperBiz;;

@Controller
@RequestMapping("/super") // 这是servlet的路径 而URL的路径就是 xxx.jsp 注意把上级文件夹的名称加上
public class SuperController {
	@Autowired
	private ISuperBiz superBiz;
	@Autowired
	private ITeacherBiz teacherBiz;

	@RequestMapping(value = "/login")
	public String login(Super super1, HttpSession session) {// session
															// 直接声明对象调用方法就好
		String aaa = null;
		Super sup = superBiz.login(super1);
		if (sup != null) {
			session.setAttribute("sup", sup);
			aaa = "/superAdmin.jsp";
		} else {
			aaa = "Error";
		}
		return aaa;
	}

	// 多身份登录
	@RequestMapping(value = "/commonlogin", method = RequestMethod.POST)
	public String commonlogin(Super super1, Teacher teacher, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {// session
																				// 直接声明对象调用方法就好
		String aaa = request.getParameter("grade");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		if ("1".equals(aaa)) {
			super1.setSupername(name);
			super1.setSuperpwd(pwd);
			Super sup = superBiz.login(super1);
			if (sup != null) {
				session.setAttribute("sup", sup);
				request.getRequestDispatcher("/superAdmin.jsp").forward(request, response);
			} else {
				/*
				 * request.getRequestDispatcher("/commonlogin.jsp").forward(
				 * request, response);
				 */
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("<script>alert('用户名或密码错误');</script>");
				response.getWriter().write("<script>window.location='/bishe/commonlogin.jsp';</script>");

				
				
				
				
				
				

				
			}
		} else if ("2".equals(aaa)) {
			teacher.setTeachnickname(name);
			teacher.setTeachpwd(pwd);
			Teacher tea = teacherBiz.tealogin(teacher);
			if (tea != null) {
				session.setAttribute("tea", tea);// 存好喽，后面要用的
				request.getRequestDispatcher("/teacherAdmin.jsp").forward(request, response);
			} else {
				/*
				 * request.getRequestDispatcher("/commonlogin.jsp").forward(
				 * request, response);
				 */
					response.setContentType("text/html;charset=utf-8");
					response.getWriter().write("<script>alert('用户名或密码错误');</script>");
					response.getWriter().write("<script>window.location='/bishe/commonlogin.jsp';</script>");
			}
		}

		return null;

	}

	// 更新管理员账户密码1
	@RequestMapping(value = "/superUpdate1")
	public String superUpdate1(String superno, HttpServletRequest req) throws SQLException {
		int superno1 = Integer.parseInt(req.getParameter("superno"));
		String resp = null;
		Super super1 = superBiz.superUpdate1(superno1);
		req.setAttribute("super1", super1);
		resp = "/smallJsp/superUpdate.jsp";
		return resp;
	}

	// 更新管理员账户密码2
	@RequestMapping(value = "/superUpdate2")
	public String superUpdate2(Super super1, HttpServletRequest req, HttpServletResponse response)
			throws SQLException, IOException {

		superBiz.superUpdate2(super1);
		/////////////////////////////////////////////////////// 消息弹窗 配合script使用
		/*
		 * 放在jsp <script type="text/javascript"> alert{${msg}} </script>
		 */
		String msg = null;
		int a = superBiz.superUpdate2(super1);
		if (a > 0) {
			msg = "OK!";
		} else {
			msg = "Error!";
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(msg);
		out.flush();
		HttpSession session = req.getSession(false);// 防止创建Session
		if (session == null) {
			try {
				response.sendRedirect("/bishe/commonlogin.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		session.removeAttribute("super1");
		try {
			response.sendRedirect("/bishe/commonlogin.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	// 管理员退出登录
	@RequestMapping(value = "/superquit")
	public String teacherquit(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 先获取当前教师id
		Super super1 = (Super) session.getAttribute("sup");
		session.removeAttribute("super1");
		response.sendRedirect("/bishe/commonlogin.jsp");
		return null;
	}
}
