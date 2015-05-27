package com.express.controller;

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

import com.express.bean.News;
import com.express.bean.OrganizationBlacklist;
import com.express.service.NewsService;
import com.express.service.OrganizationBlacklistService;
import com.express.util.CodeGenerator;
import com.express.util.DateUtils;


@Controller
@RequestMapping(value="/organizationblacklist")
public class OrganizationBlacklistController extends BaseController{
	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private OrganizationBlacklistService organizationBlacklistService;
	
	private static final Logger logger = Logger.getLogger(OrganizationBlacklistController.class); 
	
	/**
	 * �����û�������
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save.do")
	public void addblacklist(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String organizationname = new String(request.getParameter("organizationname").getBytes("ISO-8859-1"),"UTF-8");
			OrganizationBlacklist organizationBlacklist = new OrganizationBlacklist();
			organizationBlacklist.setOrganizationname(organizationname);
			organizationBlacklist.setOrganizationid(CodeGenerator.createUUID());
			Timestamp crtime = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());
			organizationBlacklist.setCrtime(crtime);
			organizationBlacklistService.addBlackList(organizationBlacklist);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	
	/**
	 * �޸ĺ�����
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/update.do")
	public void updateBlacklist(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String organizationid = request.getParameter("organizationid");															
			String organizationname = new String(request.getParameter("organizationname").getBytes("ISO-8859-1"),"UTF-8");
			OrganizationBlacklist organizationBlacklist = new OrganizationBlacklist();
			organizationBlacklist.setOrganizationname(organizationname);
			organizationBlacklist.setOrganizationid(organizationid);
			Timestamp crtime = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());
			organizationBlacklist.setCrtime(crtime);
			organizationBlacklistService.updateBlackList(organizationBlacklist);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	
	/**
	 * ����������
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view.do")
	public ModelAndView blacklistView(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String organizationid = request.getParameter("organizationid");		
			OrganizationBlacklist user = organizationBlacklistService.getByOrganizationId(organizationid);
			return new ModelAndView("organizationblacklist/userView").addObject("user",user);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("����mercid��ȡ�������û���Ϣ����" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}

	
	/**
	 * ���ص��̺������б�
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.do")
	public ModelAndView blackList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			List<OrganizationBlacklist> blacklists = new ArrayList<OrganizationBlacklist>();
			blacklists = organizationBlacklistService.getBlackList();
			return new ModelAndView("organizationblacklist/userList").addObject("blacklists",blacklists);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	/**
	 * �༭������
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/edit.do")
	public ModelAndView blacklistEdit(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String organizationid = request.getParameter("organizationid");													
			OrganizationBlacklist user = organizationBlacklistService.getByOrganizationId(organizationid);
			return new ModelAndView("organizationblacklist/userEdit").addObject("user",user);
		}catch (RuntimeException e) {
			logger.error("����organizationid��ȡ�༭������Ա����Ϣ����" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	/**
	 * ��ӿ�ݹ�˾������
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/organizationAdd.do")
	public ModelAndView addCompany(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{			
			ModelAndView view = new ModelAndView("organizationblacklist/userAdd");
			return view;
		}catch (RuntimeException e) {
			logger.error("��ȡ��ӿ�ݹ�˾��������Ϣ����" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	/**
	 * ɾ����Ա
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delUser.do")
	public void delUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String organizationid = request.getParameter("organizationid");	
			organizationBlacklistService.deleteBlacklist(organizationid);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			logger.error("ɾ���������û�����" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	
	/**
	 * ���ص��̺������б�
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getList.do")
	public ModelAndView getblackList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);//��ȡ��Ҫ����
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			Map map = new HashMap();
			List<OrganizationBlacklist> blacklists = new ArrayList<OrganizationBlacklist>();
			blacklists = organizationBlacklistService.getBlackList();
			String type1 = "���Ž���";
			String type2 = "��ݹ�˾������";
			map.put("type1", type1);
			map.put("type2", type2);
			map.put("blacklists", blacklists);
			map.put("zyggList", zyggList);
			return new ModelAndView("organizationblackDetail").addAllObjects(map);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}

}
