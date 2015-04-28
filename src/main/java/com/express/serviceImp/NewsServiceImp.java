package com.express.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.express.bean.News;
import com.express.service.BaseService;
import com.express.service.NewsService;

@Service
public class NewsServiceImp extends BaseService implements NewsService {

	
	public List<News> getNewsListByNewsType(int newstype) {
		// TODO Auto-generated method stub
		return getNewsDao().getNewsListByNewsType(newstype);
	}

	public List<News> getNewsListByNewsTypeAndSubType(int newstype, int subtype) {
		// TODO Auto-generated method stub
		return getNewsDao().getNewsListByNewsTypeAndSubType(newstype, subtype);
	}

	public News getByNewsId(String newsid) {
		// TODO Auto-generated method stub
		return getNewsDao().getByNewsId(newsid);
	}

	public boolean addNews(News news) {
		// TODO Auto-generated method stub
		if(getNewsDao().addNews(news))
			return true;
		else
			return false;
	}

	public boolean updateNews(News news) {
		// TODO Auto-generated method stub
		if(getNewsDao().updateNews(news))
			return true;
		else
			return false;
	}

}
