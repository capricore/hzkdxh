package com.hzkdxh.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hzkdxh.bean.Company;
import com.hzkdxh.bean.User;
import com.hzkdxh.service.CompanyService;
import com.hzkdxh.service.UserService;
import com.hzkdxh.util.CodeGenerator;
import com.hzkdxh.util.DateUtils;

@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyService compService;
	

	private static final Logger logger = Logger.getLogger(UserController.class);  
	
	
	/**
	 * 保存用户
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save.do")
	public void addNews(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String username = request.getParameter("username");			//username
			String password = request.getParameter("password");			//password
			String compid = request.getParameter("compid");
			String phone = request.getParameter("phone");
			int level = Integer.parseInt(request.getParameter("level"));
			String linkman = new String(request.getParameter("linkman").getBytes("ISO-8859-1"),"UTF-8");
			User user = new User();
			user.setCompid(compid);
			user.setUsername(username);
			user.setPasswd(password);
			user.setLinkman(linkman);
			user.setPhone(phone);
			user.setLevel(level);
			Timestamp crtime = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());								
			user.setRestime(crtime);
			user.setUserid(CodeGenerator.createUUID());
			userService.addUser(user);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			logger.error("添加用户失败！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	
	/**
	 * 返回用户列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.do")
	public ModelAndView userList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			List<User> userList = new ArrayList<User>();
			userList = userService.getUserList();
			return new ModelAndView("user/userList").addObject("userList",userList);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	/**
	 * 修改用户
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/update.do")
	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String userid = request.getParameter("userid");
			String username = request.getParameter("username");			//username
			String password = request.getParameter("password");			//password
			String compid = request.getParameter("compid");
			String phone = request.getParameter("phone");
			int level = Integer.parseInt(request.getParameter("level"));
			String linkman = new String(request.getParameter("linkman").getBytes("ISO-8859-1"),"UTF-8");
			User user = new User();
			user.setCompid(compid);
			user.setUsername(username);
			user.setPasswd(password);
			user.setLinkman(linkman);
			user.setPhone(phone);
			user.setLevel(level);
			Timestamp crtime = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());
			user.setRestime(crtime);
			user.setUserid(userid);
			userService.updateUser(user);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	
	/**
	 * 展示用户
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userView.do")
	public ModelAndView userView(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String userid = request.getParameter("userid");													
			User user = userService.getByUserId(userid);
			Company company = compService.getByCompanyId(user.getCompid());
			String level = new String();
			if (user.getLevel() == 0) {
				level = "普通会员";
			}else if (user.getLevel() == 1) {
				level = "单位";
			}else if (user.getLevel() == 2) {
				level = "理事";
			}else if (user.getLevel() == 3) {
				level = "管理员";
			}
			Map map = new HashMap();
			map.put("company", company);
			map.put("user", user);
			map.put("level", level);
			return new ModelAndView("user/userView").addAllObjects(map);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("根据userid获取用户信息出错！" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}
	
	/**
	 * 编辑用户
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userEdit.do")
	public ModelAndView userEdit(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String userid = request.getParameter("userid");													
			User user = userService.getByUserId(userid);
			List<Company> compList = compService.getCompanyList();
			Map map = new HashMap();
			map.put("compList", compList);
			map.put("user", user);
			return new ModelAndView("user/userEdit").addAllObjects(map);
		}catch (RuntimeException e) {
			logger.error("根据userid获取编辑用户信息出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	/**
	 * 添加会员
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/userAdd.do")
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			List<Company> compList = compService.getCompanyList();
			ModelAndView view = new ModelAndView("user/userAdd").addObject("compList",compList);
			return view;
		}catch (RuntimeException e) {
			logger.error("获取公司信息列表出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	/**
	 * 删除会员
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delUser.do")
	public void delUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String userid = request.getParameter("userid");	
			userService.deleteUser(userid);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			logger.error("删除用户出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
}
