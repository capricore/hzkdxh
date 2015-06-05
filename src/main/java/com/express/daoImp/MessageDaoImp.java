package com.express.daoImp;

import java.util.List;

import com.express.bean.Message;
import com.express.dao.BaseDao;
import com.express.dao.MessageDao;
import com.express.query.MessageQuery;

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
			logger.error("��ȡ������Ϣ�б����" +  ",errMsg=" + e.getMessage());
		}
		return replylists; 
	}

	public Message getMessageById(String id) {
		Message message = null;
		try {
			message = (Message) getSqlMapClientTemplate().queryForObject("getMessageById",id);
		} catch (Exception e) {
			logger.error("����id��ȡ��Ϣ��Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		return message; 
	}

	public boolean addMessage(Message message) {
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("addMessage", message);
		} catch (Exception e) {
			logger.error("��Ӷ�����Ϣ����" +  ",errMsg=" + e.getMessage());
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
			logger.error("���¶�����Ϣ����" +  ",errMsg=" + e.getMessage());
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
			logger.error("ɾ��ָ��������Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

}
