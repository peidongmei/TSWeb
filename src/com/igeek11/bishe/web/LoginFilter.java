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
 * ����û�û�е�¼��url����check��ͷ�Ķ����ܷ��ʵ�
 * 	�����¼�˵ģ���session����user���key
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
		//ֻ�е�¼����session����user�����������Ŀ����Դ
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		Student user = (Student) session.getAttribute("student1");
		
		if (user!=null) {//�Ѿ���¼��
			chain.doFilter(req, resp);
			return;//�����������У�����
		}
		//�����ض��򵽵�¼����
		
		/*resp.sendRedirect("/bishe/middleJsp/index.jsp");*/
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("<script>alert('���ȵ�¼');</script>");
		response.getWriter().write("<script>window.location='/bishe/studentLogin.jsp';</script>");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
