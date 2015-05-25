package com.express.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.express.service.UserService;

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
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		try {
			String username = request.getParameter("username");												//获取会员名称
			String password = request.getParameter("password");	
			String userid = userService.getUserIdbyLogin(username, password);
			if(userid != null){
				HttpSession hs = request.getSession();
				hs.setAttribute("userid",userid);
				return new ModelAndView("news/index");
			}else{
				return new ModelAndView("newsList").addObject("error", "用户名密码错误");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("会员登录信息出错！" +  ",errMsg=" + e.getMessage());
			return null;
		}

	}

	

	
}
