package com.hzkdxh.daoImp;

import java.util.List;

import org.apache.log4j.Logger;

import com.hzkdxh.bean.Reply;
import com.hzkdxh.dao.BaseDao;
import com.hzkdxh.dao.ReplyDao;
import com.hzkdxh.query.ReplyQuery;

public class ReplyDaoImp extends BaseDao implements ReplyDao{
	
	private static final Logger logger = Logger.getLogger(MercBlacklistDaoImp.class);

	@SuppressWarnings("unchecked")
	public List<Reply> getReplyListByDeadline(String starttime, String deadline,int start, int pagesize) {
		List<Reply> replylists = null;
		ReplyQuery replyQuery = new ReplyQuery();
		replyQuery.setDeadline(deadline);
		replyQuery.setStart(start);
		replyQuery.setStarttime(starttime);
		replyQuery.setPagesize(pagesize);
		try {
			replylists = getSqlMapClientTemplate().queryForList("getReplyListByDeadline",replyQuery);
		} catch (Exception e) {
			logger.error("��ȡ���Żظ���Ϣ�б����" +  ",errMsg=" + e.getMessage());
		}
		return replylists; 
	}

	public boolean addReply(Reply reply) {
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("addReply", reply);
		} catch (Exception e) {
			logger.error("��ӻظ���Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean updateReply(Reply reply) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("updateReply", reply);
		} catch (Exception e) {
			logger.error("���»ظ���Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean deleteReply(String id) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("deleteReply", id);
		} catch (Exception e) {
			logger.error("ɾ��ָ���ظ���Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public int getReplyCount(String deadtime) {
		int count = 0;
		try {
			count = (Integer) getSqlMapClientTemplate().queryForObject("getReplyCount",deadtime);
		} catch (Exception e) {
			logger.error("��ȡ�ظ�������Ϣ����" +  ",errMsg=" + e.getMessage());
		}
		return count; 
	}

}
