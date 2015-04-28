package com.express.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.express.bean.News;
import com.express.service.NewsService;

@Controller
@RequestMapping(value="/news")
public class NewsListsController extends BaseController{
	@Autowired
	private NewsService newsService;
	
	/**
	 * 返回文章列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getList.do")
	public ModelAndView newsList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			List<News> hyList = new ArrayList<News>();
			hyList = newsService.getNewsListByNewsType(3);//获取行业列表
			if (hyList.size() > 8) {
				hyList = hyList.subList(0, 8);
			}
			
			List<News> xhList = new ArrayList<News>();
			xhList = newsService.getNewsListByNewsType(1);//获取协会列表
			if (xhList.size() > 8) {
				xhList = xhList.subList(0, 8);
			}
			
			List<News> zcList = new ArrayList<News>();
			zcList = newsService.getNewsListByNewsType(2);//获取政策列表
			if (zcList.size() > 8) {
				zcList = zcList.subList(0, 8);
			}
			
			List<News> fcList = new ArrayList<News>();
			fcList = newsService.getNewsListByNewsType(4);//获取会员风采列表
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

}
