package com.hzkdxh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hzkdxh.service.UserService;

@Controller
@RequestMapping(value="/user")
public class LoginController extends BaseController{
	@Autowired
	private UserService userService;
	
	private static final Logger logger = Logger.getLogger(LoginController.class); 
	
	/**
	 * 会员登录
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/login.do")
	public void login(HttpServletRequest request, HttpServletResponse response){
		try {
			HttpSession hs = request.getSession();
			String username = request.getParameter("username");												//获取会员名称
			String password = request.getParameter("password");	
			String message = "";
			if(username!=null && hs.getAttribute("username")!=null){
				if(hs.getAttribute("username").equals(username))
					outputJsonResponse(response, true, message);
			}else{
				String userid = userService.getUserIdbyLogin(username, password);
				if(userid != null){
					hs.setAttribute("username",username);
					hs.setAttribute("userid", userid);
					message = "loginSuccess";
					outputJsonResponse(response, true, message);
				}else{
					message = "loginFailed";
					outputJsonResponse(response, false, message);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("会员登录信息出错！" +  ",errMsg=" + e.getMessage());
		}

	}
	
	@RequestMapping("/logout.do")
	public void logout(HttpServletRequest request, HttpServletResponse response){
		try {
			HttpSession hs = request.getSession();
			hs.removeAttribute("username");
			hs.removeAttribute("userid");
			String message = "";
			message = "logoutSuccess";
			outputJsonResponse(response, true, message);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("会员登录信息出错！" +  ",errMsg=" + e.getMessage());
		}

	}

	

	
}
