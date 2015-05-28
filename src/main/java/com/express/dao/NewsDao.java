package com.express.dao;

import java.util.List;

import com.express.bean.News;

public interface NewsDao {
	
	/* ��ѯ���д����µ����� */
    public List<News> getNewsListByNewsType(int newstype);
    
    /* ���ݴ����ͺź�֮���ͺŲ�ѯ����������*/
    public List<News> getNewsListByNewsTypeAndSubType(int newstype, int subtype);  
    
    /* ���ݴ����ͺź�֮���ͺŷ�ҳ��ѯ����������*/
    public List<News> getNewsListByNewsTypeAndSubTypeAndPage(int newstype, int subtype,int start, int pagesize); 
    
    /* �������ű�����������*/
    public List<News> getNewsListByTitle(String title, int start, int pagesize); 
    
    /*����ĳһ���͵�����ҳ��*/
    public int getNewsCount(int newstype,int subtype);
    
    /*�������������������*/
    public int getNewsCountByTitle(String title);

    /* ����newsid��ѯָ������ */
    public News getByNewsId(String newsid); 
    
    /* �������*/
    public boolean addNews(News news);
    
    /* ��������*/
    public boolean updateNews(News news);
    
    /* ɾ������*/
    public boolean deleteNews(String newsid);
}
