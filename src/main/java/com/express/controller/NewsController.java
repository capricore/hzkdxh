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
import com.express.service.NewsService;
import com.express.util.CodeGenerator;
import com.express.util.DateUtils;
import com.express.util.StringUtils;

@Controller
@RequestMapping(value="/news")
public class NewsController extends BaseController{

	@Autowired
	private NewsService newsService;
	
	private static final Logger logger = Logger.getLogger(NewsController.class);  
	
	private String[] NewsType = {"","����Э��","���߷���","��ҵ����","��Ա���"};
	private String[][] SubType = {{},{"","Э����","Э���³�","Э���ƶ�","Э���Ա"},{"","��ҵ���ɹ淶","���Ź���","�淶���ļ�","�ط��Է���","��ҵ����Ҫ��"}
	,{"","ͳ�Ʊ���","����������ͨ��","��������"},{"","���»"}};
	
	/**
	 * ��������
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/save.do")
	public void addNews(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String title = new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");				//���±���
			String content = new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");			//��������
			String type = request.getParameter("type");																//��������������newstype��subtype������˵���Ź��£���ôtype=22
			int newstype = type.charAt(0)-'0';
			int subtype = type.charAt(1)-'0';
			Timestamp crtime = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());									//���´���ʱ��
			System.out.println("title:"+title);
			System.out.println("content:"+content);
			System.out.println("newstype:"+newstype);
			News news = new News();
			news.setNewsid(CodeGenerator.createUUID());																//��������id
			news.setTitle(title);				
			news.setContent(content);
			news.setNewstype(newstype);
			news.setSubtype(subtype);
			news.setCrtime(crtime);
			news.setDel(0);
			newsService.addNews(news);
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	
	/**
	 * �޸�����
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/update.do")
	public void uodateNews(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String newsid = request.getParameter("newsid");																//��ȡ����id
			String title = new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
			String content = new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
			String type = request.getParameter("type");
			int newstype = type.charAt(0)-'0';
			int subtype = type.charAt(1)-'0';
			Timestamp crtime = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());
			News news = new News();
			news.setNewsid(newsid);				
			news.setTitle(title);				
			news.setContent(content);
			news.setNewstype(newstype);
			news.setSubtype(subtype);
			news.setCrtime(crtime);
			news.setDel(0);
			newsService.updateNews(news);
			outputJsonResponse(response, true, "updateSuccess");
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	
	/**
	 * չʾ����
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view.do")
	public ModelAndView newsView(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String newsid = request.getParameter("newsid");													//��ȡ����id
			News news = newsService.getByNewsId(newsid);													//��������id��ȡ����
			int newstype = news.getNewstype();
			int subtype = news.getSubtype();
			String type = newstype+""+subtype;																//���������������࣬��ϳ�type
			Map map = new HashMap();
			map.put("type", type);
			map.put("news", news);
			return new ModelAndView("news/newsView").addAllObjects(map);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("�����������ͻ�ȡ������Ϣ����" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}
	
	/**
	 * ���������б�
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			int newstype = 0;
			int subtype = 0;
			String r_newstype = request.getParameter("newstype");											//���Ŵ���
			String r_subtype = request.getParameter("subtype");												//����Ϸ��
			List<News> newsList = new ArrayList<News>();
			if(StringUtils.isNumber(r_newstype)&&StringUtils.isNumber(r_subtype)){
				newstype = Integer.valueOf(r_newstype);
				subtype = Integer.valueOf(r_subtype);
				newsList = newsService.getNewsListByNewsTypeAndSubType(newstype,subtype); 					//��ȡ�����б�
			}
			else if(StringUtils.isNumber(r_newstype)){
				newstype = Integer.valueOf(r_newstype);
				newsList = newsService.getNewsListByNewsType(newstype);
			}
			String newstype_name = NewsType[newstype];
			String subtype_name = SubType[newstype][subtype];
			Map map = new HashMap();
			map.put("newstype", newstype_name);
			map.put("subtype", subtype_name);
			map.put("newsList", newsList);
			return new ModelAndView("news/newsList").addAllObjects(map);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}

	/**
	 * ���ؿ����ҵЭ����ҳ
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/index.do")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			List<News> hyList = new ArrayList<News>();
			hyList = newsService.getNewsListByNewsType(3);//��ȡ��ҵ�б�
			if (hyList.size() > 8) {
				hyList = hyList.subList(0, 8);
			}
			
			List<News> xhList = new ArrayList<News>();
			xhList = newsService.getNewsListByNewsType(1);//��ȡЭ���б�
			if (xhList.size() > 8) {
				xhList = xhList.subList(0, 8);
			}
			
			List<News> zcList = new ArrayList<News>();
			zcList = newsService.getNewsListByNewsType(2);//��ȡ�����б�
			if (zcList.size() > 8) {
				zcList = zcList.subList(0, 8);
			}
			
			List<News> fcList = new ArrayList<News>();
			fcList = newsService.getNewsListByNewsType(4);//��ȡ��Ա����б�
			if (fcList.size() > 8) {
				fcList = fcList.subList(0, 8);
			}
		
			Map map = new HashMap();
			map.put("hyList", hyList);
			map.put("xhList", xhList);
			map.put("zcList", zcList);
			map.put("fcList", fcList);
			return new ModelAndView("index").addAllObjects(map);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	/**
	 * ������������
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/newsDetail.do")
	public ModelAndView newsDetail(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String newsid = request.getParameter("newsid");
			News news = newsService.getByNewsId(newsid);	
			return new ModelAndView("newsDetail").addObject("news", news);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}

	/**
	 * ���������б�
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
			String r_newstype = request.getParameter("newstype");											//���Ŵ���
			String r_subtype = request.getParameter("subtype");												//����Ϸ��
			List<News> newsList = new ArrayList<News>();
			if(StringUtils.isNumber(r_newstype)&&StringUtils.isNumber(r_subtype)){
				newstype = Integer.valueOf(r_newstype);
				subtype = Integer.valueOf(r_subtype);
				newsList = newsService.getNewsListByNewsTypeAndSubType(newstype,subtype); 					//��ȡ�����б�
			}
			else if(StringUtils.isNumber(r_newstype)){
				newstype = Integer.valueOf(r_newstype);
				newsList = newsService.getNewsListByNewsType(newstype);
			}
			String newstype_name = NewsType[newstype];
			String subtype_name = SubType[newstype][subtype];
			Map map = new HashMap();
			map.put("newstype", newstype_name);
			map.put("subtype", subtype_name);
			map.put("newsList", newsList);
			return new ModelAndView("newsList").addAllObjects(map);
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
}
