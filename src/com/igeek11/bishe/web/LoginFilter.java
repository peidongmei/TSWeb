package com.igeek11.bishe.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.igeek11.bishe.bean.Student;
import com.igeek11.bishe.bean.Super;
import com.igeek11.bishe.bean.Teacher;

/**
 * 如果用户没有登录，url中以check开头的都不能访问的
 * 	如果登录了的，在session中有user这个key
 * @author NIIT
 *
 */
@WebFilter(urlPatterns={"/filter/*","/teachresource/downList"})
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//只有登录了且session中有user才能允许访问目标资源
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Student user = (Student) session.getAttribute("student1");
		
		if (user!=null) {//已经登录过
			chain.doFilter(req, resp);
			return;//结束方法运行，返回
		}
		//否则重定向到登录界面
		
		/*resp.sendRedirect("/bishe/middleJsp/index.jsp");*/
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("<script>alert('请先登录');</script>");
		response.getWriter().write("<script>window.location='/bishe/studentLogin.jsp';</script>");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
