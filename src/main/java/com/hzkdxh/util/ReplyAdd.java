package com.hzkdxh.util;

import org.apache.log4j.Logger;

import com.hzkdxh.bean.Reply;
import com.hzkdxh.dao.BaseDao;

public class ReplyAdd extends BaseDao {
	
	private static final Logger logger = Logger.getLogger(ReplyAdd.class);
	
	public  boolean addReply(Reply reply) {
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("addReply", reply);
		} catch (Exception e) {
			logger.error("添加回复信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}
}
