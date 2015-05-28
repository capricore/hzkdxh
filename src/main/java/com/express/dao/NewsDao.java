package com.express.dao;

import java.util.List;

import com.express.bean.News;

public interface NewsDao {
	
	/* 查询表中大类下的新闻 */
    public List<News> getNewsListByNewsType(int newstype);
    
    /* 根据大类型号和之类型号查询子类下新闻*/
    public List<News> getNewsListByNewsTypeAndSubType(int newstype, int subtype);  
    
    /* 根据大类型号和之类型号分页查询子类下新闻*/
    public List<News> getNewsListByNewsTypeAndSubTypeAndPage(int newstype, int subtype,int start, int pagesize); 
    
    /* 根据新闻标题搜索新闻*/
    public List<News> getNewsListByTitle(String title, int start, int pagesize); 
    
    /*返回某一类型的新闻页数*/
    public int getNewsCount(int newstype,int subtype);
    
    /*返回搜索结果的新闻数*/
    public int getNewsCountByTitle(String title);

    /* 根据newsid查询指定新闻 */
    public News getByNewsId(String newsid); 
    
    /* 添加新闻*/
    public boolean addNews(News news);
    
    /* 更新新闻*/
    public boolean updateNews(News news);
    
    /* 删除新闻*/
    public boolean deleteNews(String newsid);
}
