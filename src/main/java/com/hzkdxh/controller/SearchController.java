package com.hzkdxh.controller;

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

import com.hzkdxh.bean.News;
import com.hzkdxh.service.NewsService;
import com.hzkdxh.util.StringUtils;

@Controller
@RequestMapping(value="/news")
public class SearchController extends BaseController{
	
	@Autowired
	private NewsService newsService;
	
	private static final Logger logger = Logger.getLogger(SearchController.class); 
	
	private int pagesize = 15;			//ÿ�β�ѯ���صĴ��� 
	
	@RequestMapping("/search.do")
	public ModelAndView searchNews(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			int start = 1;
			int pagecount = 0;
			String r_start = request.getParameter("start");												
			String title = new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");				//���±���

			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);//��ȡ��Ҫ����
			if(StringUtils.isNotEmpty(r_start))
				start = Integer.valueOf(r_start);
			pagecount = newsService.getNewsCountByTitle(title)/pagesize+1;	
			List<News> newsList = newsService.getNewsListByTitle(title,(start-1)*pagesize,start*pagesize);
			Map map = new HashMap();
			map.put("title", title);
			map.put("newsList", newsList);
			map.put("pagecount", pagecount);
			map.put("start", start);
			map.put("zyggList", zyggList);
			return new ModelAndView("search").addAllObjects(map);
		}catch (RuntimeException e) {
			logger.error("�������������ȡ�����б����" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}

}
