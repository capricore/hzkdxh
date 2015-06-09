package com.hzkdxh.daoImp;

import java.util.List;

import com.hzkdxh.bean.Message;
import com.hzkdxh.dao.BaseDao;
import com.hzkdxh.dao.MessageDao;
import com.hzkdxh.query.MessageQuery;

public class MessageDaoImp extends BaseDao implements MessageDao{

	@SuppressWarnings("unchecked")
	public List<Message> getMessageListByTime(int start, int pagesize) {
		List<Message> replylists = null;
		MessageQuery messageQuery = new MessageQuery();
		messageQuery.setStart(start);
		messageQuery.setPagesize(pagesize);
		try {
			replylists = getSqlMapClientTemplate().queryForList("getMessageListByTime",messageQuery);
		} catch (Exception e) {
			logger.error("获取短信信息列表出错！" +  ",errMsg=" + e.getMessage());
		}
		return replylists; 
	}

	public Message getMessageById(String id) {
		Message message = null;
		try {
			message = (Message) getSqlMapClientTemplate().queryForObject("getMessageById",id);
		} catch (Exception e) {
			logger.error("根据id获取信息信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return message; 
	}

	public boolean addMessage(Message message) {
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("addMessage", message);
		} catch (Exception e) {
			logger.error("添加短信信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean updateMessage(Message message) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("updateMessage", message);
		} catch (Exception e) {
			logger.error("更新短信信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean deleteMessage(String id) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("deleteMessage", id);
		} catch (Exception e) {
			logger.error("删除指定短信信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public int getMessageCount() {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject("getMessageCount");
		} catch (Exception e) {
			logger.error("获取信息数量信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return count; 
	}

}
