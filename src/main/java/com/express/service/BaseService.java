package com.express.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.express.dao.CompanyDao;
import com.express.dao.RollingPictureDao;
import com.express.dao.MercBlacklistDao;
import com.express.dao.NewsDao;
import com.express.dao.OrganizationBlacklistDao;
import com.express.dao.StaticPictureDao;
import com.express.dao.UserBlacklistDao;
import com.express.dao.UserDao;

public class BaseService {
	
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:/applicationContext.xml");

	private NewsDao newsDao = (NewsDao) context.getBean("newsDao");
	
	private UserDao userDao = (UserDao)context.getBean("userDao");
	
	private CompanyDao companyDao = (CompanyDao)context.getBean("companyDao");
	
	private RollingPictureDao rollingpictureDao = (RollingPictureDao)context.getBean("rollingpictureDao");
	
	private UserBlacklistDao userBlacklistDao = (UserBlacklistDao)context.getBean("userBlacklistDao");
	
	private MercBlacklistDao mercBlacklistDao = (MercBlacklistDao)context.getBean("mercBlacklistDao");
	
	private OrganizationBlacklistDao organizationBlacklistDao = (OrganizationBlacklistDao)context.getBean("organizationBlacklistDao");
	
	public MercBlacklistDao getMercBlacklistDao() {
		return mercBlacklistDao;
	}

	public OrganizationBlacklistDao getOrganizationBlacklistDao() {
		return organizationBlacklistDao;
	}

	public UserBlacklistDao getUserBlacklistDao() {
		return userBlacklistDao;
	}

	public  NewsDao getNewsDao(){
		return newsDao;
	}
	
	public UserDao getUserDao(){
		return userDao;
	}
	
	public  CompanyDao getCompanyDao(){
		return companyDao;
	}

	public RollingPictureDao getRollingpictureDao() {
		return rollingpictureDao;
	}
	
}
