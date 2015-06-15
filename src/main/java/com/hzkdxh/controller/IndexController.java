package com.hzkdxh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hzkdxh.bean.Company;
import com.hzkdxh.bean.Downloadzone;
import com.hzkdxh.bean.Message;
import com.hzkdxh.bean.News;
import com.hzkdxh.bean.RollingPicture;
import com.hzkdxh.bean.StaticPicture;
import com.hzkdxh.bean.User;
import com.hzkdxh.service.CompanyService;
import com.hzkdxh.service.DownloadzoneService;
import com.hzkdxh.service.MessageService;
import com.hzkdxh.service.NewsService;
import com.hzkdxh.service.RollingPictureService;
import com.hzkdxh.service.StaticPictureService;
import com.hzkdxh.service.UserService;
import com.hzkdxh.util.StringUtils;

@Controller
@RequestMapping(value="/news")
public class IndexController extends BaseController{
	@Autowired
	private NewsService newsService;
	@Autowired
	private UserService userService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private RollingPictureService rpService;
	@Autowired
	private StaticPictureService spService;
	@Autowired
	private DownloadzoneService	downloadzoneService;
	@Autowired
	private MessageService messageService;
	
	
	private static final Logger logger = Logger.getLogger(IndexController.class);  
	
	private String[] NewsType = {"","关于协会","政策法规","行业公告","会员风采","重要公告","行业资讯","行业统计","协会动态"};
	private String[][] SubType = {{},{"","协会简介","协会章程","协会制度","协会成员"},{"","行业法规","部门规章","规范性文件","地方性法规","其它要求"}
	,{"","统计报告","消费者申述","旺季提示"},{"","最新活动"},{""},{""},{""},{""}};

	private int pagesize = 15;			//每次查询返回的次数 
	
	/**
	 * 返回文章列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/index.do")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{

			List<News> xhdtList = new ArrayList<News>();
			xhdtList = newsService.getNewsListByNewsType(8);//获取协会动态
			if (xhdtList.size() > 8) {
				xhdtList = xhdtList.subList(0, 8);
			}
			
			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);//获取重要公告
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			
			List<News> hyggList = new ArrayList<News>();
			hyggList = newsService.getNewsListByNewsType(3);//获取行业公告
			if (hyggList.size() > 8) {
				hyggList = hyggList.subList(0, 8);
			}
			
			List<News> hyzxList = new ArrayList<News>();
			hyzxList = newsService.getNewsListByNewsType(6);//获取行业资讯
			if (hyzxList.size() > 8) {
				hyzxList = hyzxList.subList(0, 8);
			}
			
			List<News> hytjList = new ArrayList<News>();
			hytjList = newsService.getNewsListByNewsType(7);//获取行业统计
			if (hytjList.size() > 8) {
				hytjList = hytjList.subList(0, 8);
			}

			List<News> hyfcList = new ArrayList<News>();
			hyfcList = newsService.getNewsListByNewsType(4);//获取会员风采
			if (hyfcList.size() > 8) {
				hyfcList = hyfcList.subList(0, 8);
			}

			List<News> zcfgList = new ArrayList<News>();
			zcfgList = newsService.getNewsListByNewsType(2);//获取政策法规
			if (zcfgList.size() > 8) {
				zcfgList = zcfgList.subList(0, 8);
			}

			List<RollingPicture> rpList = new ArrayList<RollingPicture>();
			rpList = rpService.getListBySequence();	//获取新闻轮播图片
			if(rpList.size() > 6){
				rpList = rpList.subList(0, 6);
			}
			
			List<StaticPicture> spList = new ArrayList<StaticPicture>();
			spList = spService.getPicturetList(); //获取静态轮播图片
			
			Map map = new HashMap();
			map.put("rpList", rpList);
			map.put("xhdtList", xhdtList);
			map.put("zyggList", zyggList);
			map.put("hyggList", hyggList);
			map.put("hyzxList", hyzxList);
			map.put("hytjList", hytjList);
			map.put("hyfcList", hyfcList);
			map.put("zcfgList", zcfgList);
			map.put("spList", spList);
			return new ModelAndView("index").addAllObjects(map);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			logger.error("获取首页信息出错！" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}

	/**
	 * 展示文章
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/detail.do")
	public ModelAndView newsView(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String newsid = request.getParameter("newsid");													//获取文章id
			News news = newsService.getByNewsId(newsid);	
			
			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);//获取重要公告
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			//根据文章id获取文章
			int newstype = news.getNewstype();
			int subtype = news.getSubtype();
			String type = newstype+""+subtype;																//根据新闻类别和子类，组合成type
			Map map = new HashMap();
			map.put("type", SubType[newstype][subtype]);
			map.put("news", news);
			map.put("zyggList", zyggList);
			return new ModelAndView("detail").addAllObjects(map);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("根据新闻类型获取新闻信息出错！" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}
	
	/**
	 * 返回文章列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/newsList.do")
	public ModelAndView newsList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			int newstype = 0;
			int subtype = 0;
			int start = 1;
			int pagecount = 0;
			String r_newstype = request.getParameter("newstype");											//新闻大类
			String r_subtype = request.getParameter("subtype");												//新闻戏类
			String r_start = request.getParameter("start");													//请求首页
			if(StringUtils.isNotEmpty(r_start))
				start = Integer.valueOf(r_start);
		
			List<News> newsList = new ArrayList<News>();
			if(StringUtils.isNumber(r_newstype)&&StringUtils.isNumber(r_subtype)){
				newstype = Integer.valueOf(r_newstype);
				subtype = Integer.valueOf(r_subtype);
			}
			else if(StringUtils.isNumber(r_newstype)){
				newstype = Integer.valueOf(r_newstype);
			}
			newsList = newsService.getNewsListByNewsTypeAndSubTypeAndPage(newstype,subtype,(start-1)*pagesize,pagesize); 					//获取文章列表
			int pageSum = newsService.getNewsCount(newstype, subtype);
			pagecount = pageSum/pagesize+1;																	//新闻总页数

			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);//获取重要公告
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			
			String newstype_name = NewsType[newstype];
			String subtype_name = SubType[newstype][subtype];
			Map map = new HashMap();
			String type = null;
			if (subtype_name != "") {
				type = subtype_name;
			}else {
				type = newstype_name;
			}
			map.put("newstype", newstype_name);
			map.put("subtype", subtype_name);
			map.put("type", type);
			map.put("r_newstype", r_newstype);
			map.put("r_subtype", r_subtype);
			map.put("newsList", newsList);
			map.put("pagecount", pagecount);
			map.put("start", start);
			map.put("zyggList", zyggList);
			return new ModelAndView("list").addAllObjects(map);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	

	/**
	 * 下载中心
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/downloadList.do")
	public ModelAndView downloadList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			int start = 1;
			int pagecount = 0;
			String r_start = request.getParameter("start");
			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);//获取重要公告
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			
			if(StringUtils.isNotEmpty(r_start))
				start = Integer.valueOf(r_start);
			Map map = new HashMap();
			List<Downloadzone> downlist = downloadzoneService.getFileList((start-1)*pagesize,pagesize);
			int pageSum = downloadzoneService.getFileCount();
			pagecount = pageSum/pagesize+1;
			String type = "下载中心";
			map.put("type", type);
			map.put("pagecount", pagecount);
			map.put("start", start);
			map.put("downlist", downlist);
			map.put("zyggList", zyggList);
			return new ModelAndView("downloadList").addAllObjects(map);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("获取下载中心信息出错！" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}
	
	/**
	 * 短信发送
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/message.do")
	public ModelAndView message(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			HttpSession session = request.getSession(true); 
			String username = (String)session.getAttribute("username");
			User user = userService.getByUserName(username);
			List<Company> mainmessageList = new ArrayList<Company>();
			List<Company> submessageList = new ArrayList<Company>();
			Map map = new HashMap();
			if (user.getLevel() == 1) {
				Company company = companyService.getByCompanyId(user.getCompid());
				List<String> adminList = userService.getAdminCompanyByLevel(3);
				for (String string : adminList) {
					mainmessageList.add(companyService.getByCompanyId(string));
				}
				mainmessageList.add(companyService.getByCompanyId(company.getPcompid()));
				submessageList = companyService.getSubcompanyListByCompId(company.getPcompid());
			}else if(user.getLevel() == 2){
				Company company = companyService.getByCompanyId(user.getCompid());
				mainmessageList = companyService.getMainCompanyList();
				submessageList = companyService.getSubcompanyListByCompId(company.getCompid());
				
			}else if(user.getLevel() == 3){
				mainmessageList = companyService.getMainCompanyList();
				submessageList = companyService.getSubcompanyList();
			}
			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);//获取重要公告
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			String type = "短信发送";
			map.put("type", type);
			map.put("mainmessageList", mainmessageList);
			map.put("submessageList", submessageList);
			map.put("zyggList", zyggList);
			return new ModelAndView("message").addAllObjects(map);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("获取短信发送信息出错！" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}
	
	/**
	 * 短信查看
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/messageList.do")
	public ModelAndView messageList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			int start = 1;
			int pagecount = 0;
			String r_start = request.getParameter("start");	
			if(StringUtils.isNotEmpty(r_start))
				start = Integer.valueOf(r_start);
			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);//获取重要公告
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			List<Message> messageList = messageService.getMessageListByTime((start-1)*pagesize,pagesize);
			int pageSum = messageService.getMessageCount();
			pagecount = pageSum/pagesize+1;
			Map map = new HashMap();
			String type = "短信查看";
			map.put("type", type);
			map.put("pagecount", pagecount);
			map.put("start", start);
			map.put("messageList", messageList);
			map.put("zyggList", zyggList);
			return new ModelAndView("messageList").addAllObjects(map);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("获取短信查看信息出错！" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}
	
	/**
	 * 诚信建设
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/blackList.do")
	public ModelAndView blackList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);//获取重要公告
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			Map map = new HashMap();
			String type = "诚信建设";
			map.put("type", type);
			map.put("zyggList", zyggList);
			return new ModelAndView("blackList").addAllObjects(map);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("获取诚信建设信息出错！" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}
	
	/**
	 * 下载专区
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/download.do")
	public ModelAndView download(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);//获取重要公告
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			Map map = new HashMap();
			map.put("zyggList", zyggList);
			return new ModelAndView("downloadZone").addAllObjects(map);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("获取下载专区信息出错！" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}

}
