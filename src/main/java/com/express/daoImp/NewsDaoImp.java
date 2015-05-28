package com.express.daoImp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.express.bean.News;
import com.express.dao.BaseDao;
import com.express.dao.NewsDao;
import com.express.query.NewsQuery;

@Repository
public class NewsDaoImp extends BaseDao implements NewsDao{
	
	private static final Logger logger = Logger.getLogger(NewsDaoImp.class);  

	@SuppressWarnings("unchecked")
	public List<News> getNewsListByNewsType(int newstype) {
		List<News> news = null;
		try {
			news = getSqlMapClientTemplate().queryForList("getNewsListByNewsType", newstype);
		} catch (Exception e) {
			logger.error("根据新闻类型获取新闻信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return news; 
	}

	@SuppressWarnings("unchecked")
	public List<News> getNewsListByNewsTypeAndSubType(int newstype, int subtype) {
		List<News> news = null;
		NewsQuery newsQuery = new NewsQuery();
		newsQuery.setNewstype(newstype);
		newsQuery.setSubtype(subtype);
		try {
			news = getSqlMapClientTemplate().queryForList("getNewsListByNewsTypeAndSubType", newsQuery);
		} catch (Exception e) {
			logger.error("根据新闻类型和子类型获取新闻信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return news;
	}

	@SuppressWarnings("unchecked")
	public List<News> getNewsListByNewsTypeAndSubTypeAndPage(int newstype, int subtype,int start,int pagesize) {
		List<News> news = null;
		NewsQuery newsQuery = new NewsQuery();
		newsQuery.setNewstype(newstype);
		newsQuery.setSubtype(subtype);
		newsQuery.setStart(start);
		newsQuery.setPagesize(pagesize);
		try {
			news = getSqlMapClientTemplate().queryForList("getNewsListByNewsTypeAndSubTypeAndPage", newsQuery);
		} catch (Exception e) {
			logger.error("根据新闻类型和子类型获取新闻信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return news;
	}

	
	public News getByNewsId(String newsid) {
		News news = null;
		try {
			news = (News) getSqlMapClientTemplate().queryForObject("getByNewsId",newsid);
		} catch (Exception e) {
			logger.error("根据新闻id获取新闻信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return news; 
	}

	public boolean addNews(News news) {
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("addNews", news);
		} catch (Exception e) {
			logger.error("添加新闻信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean updateNews(News news) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("updateNews", news);
		} catch (Exception e) {
			logger.error("更新新闻信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean deleteNews(String newsid) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("deleteNews", newsid);
		} catch (Exception e) {
			logger.error("删除新闻信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public int getNewsCount(int newstype, int subtype) {
		int count = 0;
		NewsQuery newsQuery = new NewsQuery();
		newsQuery.setNewstype(newstype);
		newsQuery.setSubtype(subtype);
		try {
			count = (Integer)getSqlMapClientTemplate().queryForObject("getNewsCount", newsQuery);
		} catch (Exception e) {
			logger.error("根据新闻类型和子类型获取新闻总数！" +  ",errMsg=" + e.getMessage());
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<News> getNewsListByTitle(String title, int start, int pagesize) {
		List<News> news = null;
		NewsQuery newsQuery = new NewsQuery();
		newsQuery.setTitle(title);
		newsQuery.setStart(start);
		newsQuery.setPagesize(pagesize);
		try {
			news = getSqlMapClientTemplate().queryForList("getNewsListByTitle", newsQuery);
		} catch (Exception e) {
			logger.error("根据搜索标题获取新闻列表出错！" +  ",errMsg=" + e.getMessage());
		}
		return news;
	}

	public int getNewsCountByTitle(String title) {
		int count = 0;
		try {
			count = (Integer)getSqlMapClientTemplate().queryForObject("getNewsCountByTitle", title);
		} catch (Exception e) {
			logger.error("根据搜索新闻标题获取新闻总数！" +  ",errMsg=" + e.getMessage());
		}
		return count;
	}

}
