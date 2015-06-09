package com.hzkdxh.daoImp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.hzkdxh.bean.News;
import com.hzkdxh.dao.BaseDao;
import com.hzkdxh.dao.NewsDao;
import com.hzkdxh.query.NewsQuery;

@Repository
public class NewsDaoImp extends BaseDao implements NewsDao{
	
	private static final Logger logger = Logger.getLogger(NewsDaoImp.class);  

	@SuppressWarnings("unchecked")
	public List<News> getNewsListByNewsType(int newstype) {
		List<News> news = null;
		try {
			news = getSqlMapClientTemplate().queryForList("getNewsListByNewsType", newstype);
		} catch (Exception e) {
			logger.error("�����������ͻ�ȡ������Ϣ����" +  ",errMsg=" + e.getMessage());
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
			logger.error("�����������ͺ������ͻ�ȡ������Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		return news;
	}

	@SuppressWarnings("unchecked")
	public List<News> getNewsListByNewsTypeAndSubTypeAndPage(int newstype, int subtype,int start,int pagesize) {
		List<News> news = null;
		NewsQuery newsQuery = new NewsQuery();
		newsQuery.setNewstype(newstype);
		if (subtype != 0) {
			newsQuery.setSubtype(subtype);
		}
		newsQuery.setStart(start);
		newsQuery.setPagesize(pagesize);
		try {
			if (subtype == 0) {
				news = getSqlMapClientTemplate().queryForList("getNewsListByNewsTypeAndPage", newsQuery);
			}else {
				news = getSqlMapClientTemplate().queryForList("getNewsListByNewsTypeAndSubTypeAndPage", newsQuery);
			}
		} catch (Exception e) {
			logger.error("�����������ͺ������ͻ�ȡ������Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		return news;
	}

	
	public News getByNewsId(String newsid) {
		News news = null;
		try {
			news = (News) getSqlMapClientTemplate().queryForObject("getByNewsId",newsid);
		} catch (Exception e) {
			logger.error("��������id��ȡ������Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		return news; 
	}

	public boolean addNews(News news) {
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("addNews", news);
		} catch (Exception e) {
			logger.error("���������Ϣ����" +  ",errMsg=" + e.getMessage());
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
			logger.error("����������Ϣ����" +  ",errMsg=" + e.getMessage());
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
			logger.error("ɾ��������Ϣ����" +  ",errMsg=" + e.getMessage());
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
			if (subtype == 0) {
				count = (Integer)getSqlMapClientTemplate().queryForObject("getNewsCountByNewsType", newstype);
			}else {
				count = (Integer)getSqlMapClientTemplate().queryForObject("getNewsCount", newsQuery);
			}
		} catch (Exception e) {
			logger.error("�����������ͺ������ͻ�ȡ����������" +  ",errMsg=" + e.getMessage());
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
			logger.error("�������������ȡ�����б����" +  ",errMsg=" + e.getMessage());
		}
		return news;
	}

	public int getNewsCountByTitle(String title) {
		int count = 0;
		try {
			count = (Integer)getSqlMapClientTemplate().queryForObject("getNewsCountByTitle", title);
		} catch (Exception e) {
			logger.error("�����������ű����ȡ����������" +  ",errMsg=" + e.getMessage());
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<News> getNewsListByNewsType(int newstype, int start,
			int pagesize) {
		List<News> news = null;
		NewsQuery newsQuery = new NewsQuery();
		newsQuery.setNewstype(newstype);
		newsQuery.setStart(start);
		newsQuery.setPagesize(pagesize);
		try {
			news = getSqlMapClientTemplate().queryForList("getNewsListByNewsTypeAndPage", newsQuery);
		} catch (Exception e) {
			logger.error("�����������ͻ�ȡ������Ϣ����(����ҳ)��" +  ",errMsg=" + e.getMessage());
		}
		return news;
	}

}
