package com.hzkdxh.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzkdxh.dao.CompanyDao;
import com.hzkdxh.dao.DownloadzoneDao;
import com.hzkdxh.dao.MercBlacklistDao;
import com.hzkdxh.dao.MessageDao;
import com.hzkdxh.dao.NewsDao;
import com.hzkdxh.dao.OrganizationBlacklistDao;
import com.hzkdxh.dao.ReplyDao;
import com.hzkdxh.dao.RollingPictureDao;
import com.hzkdxh.dao.StaticPictureDao;
import com.hzkdxh.dao.UserBlacklistDao;
import com.hzkdxh.dao.UserDao;

public class BaseService {
	
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:/applicationContext.xml");

	private NewsDao newsDao = (NewsDao) context.getBean("newsDao");
	
	private UserDao userDao = (UserDao)context.getBean("userDao");
	
	private CompanyDao companyDao = (CompanyDao)context.getBean("companyDao");
	
	private RollingPictureDao rollingpictureDao = (RollingPictureDao)context.getBean("rollingpictureDao");
	
	private StaticPictureDao staticpictureDao = (StaticPictureDao) context.getBean("staticpictureDao");
	
	private UserBlacklistDao userBlacklistDao = (UserBlacklistDao)context.getBean("userBlacklistDao");
	
	private DownloadzoneDao downloadzoneDao = (DownloadzoneDao)context.getBean("downloadzoneDao");
	
	private ReplyDao replyDao = (ReplyDao)context.getBean("replyDao");
	
	private MessageDao messageDao = (MessageDao)context.getBean("messageDao");

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
	
	public DownloadzoneDao getDownloadzoneDao() {
		return downloadzoneDao;
	}
	
	public  CompanyDao getCompanyDao(){
		return companyDao;
	}

	public RollingPictureDao getRollingpictureDao() {
		return rollingpictureDao;
	}
	
	public StaticPictureDao getStaticpictureDao(){
		return staticpictureDao;
	}

	public ReplyDao getReplyDao() {
		return replyDao;
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}
	
}
