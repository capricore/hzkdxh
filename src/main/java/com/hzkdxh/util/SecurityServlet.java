package com.hzkdxh.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityServlet extends HttpServlet implements Filter{

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest)arg0;  
		HttpServletResponse response  =(HttpServletResponse) arg1; 
		HttpSession session = request.getSession(true); 
		String username = (String)session.getAttribute("username");//登录人角色
		String servletPath = request.getServletPath(); 
		String url=request.getRequestURI();  
//		if(url.indexOf("login") != -1 || url.indexOf("user") != -1){
//			arg2.doFilter(arg0, arg1);
//			return;
//		}
		if( username == null || "".equals(username)) {    
			//判断获取的路径不为空且不是访问登录页面或执行登录操作时跳转     
			request.getSession().setAttribute("returnUri", servletPath); 
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return ;
		}
		arg2.doFilter(arg0, arg1);
		return;   
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
