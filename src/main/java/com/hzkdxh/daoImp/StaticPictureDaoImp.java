package com.hzkdxh.daoImp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.hzkdxh.bean.StaticPicture;
import com.hzkdxh.dao.BaseDao;
import com.hzkdxh.dao.StaticPictureDao;

@Repository
public class StaticPictureDaoImp extends BaseDao implements StaticPictureDao{
	
	private static final Logger logger = Logger.getLogger(StaticPictureDaoImp.class);

	@SuppressWarnings("unchecked")
	public List<StaticPicture> getPicturetList() {
		List<StaticPicture> list= null;
		try {
			list = getSqlMapClientTemplate().queryForList("getPicturetList");
		} catch (Exception e) {
			logger.error("查询图片列表信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return list; 
	}

	public StaticPicture getById(String id) {
		StaticPicture pic = null;
		try {
			pic = (StaticPicture) getSqlMapClientTemplate().queryForObject("getStaticPictureById",id);
		} catch (Exception e) {
			logger.error("根据id获取图片信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return pic; 
	}

	public boolean addStaticPicture(StaticPicture staticPicture) {
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("addStaticPicture", staticPicture);
		} catch (Exception e) {
			logger.error("添加图片信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean updateStaticPicture(StaticPicture staticPicture) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("updateStaticPicture", staticPicture);
		} catch (Exception e) {
			logger.error("更新图片信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean deleteStaticPicture(String id) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("deleteStaticPicture", id);
		} catch (Exception e) {
			logger.error("删除图片信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}  

}
