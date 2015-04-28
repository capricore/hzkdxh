package com.express.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.express.dao.NewsDao;
import com.express.dao.UserDao;

public class BaseService {
	
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:/applicationContext.xml");

	private NewsDao newsDao = (NewsDao) context.getBean("newsDao");
	
	private UserDao userDao = (UserDao)context.getBean("userDao");
	
	public  NewsDao getNewsDao(){
		return newsDao;
	}
	
	public UserDao getUserDao(){
		return userDao;
	}
}
