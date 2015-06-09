package com.hzkdxh.dao;

import java.util.List;

import com.hzkdxh.bean.Reply;

public interface ReplyDao {
	
	/* ���ݽ���ʱ���ѯ�ظ��б�*/
    public List<Reply> getReplyListByDeadline(String deadline,int start, int pagesize);
    
    /* ����»ظ� */
    public boolean addReply(Reply reply);
    
    /* ���»ظ���Ϣ*/
    public boolean updateReply(Reply reply);
    
    /* ɾ���ظ���Ϣ*/
    public boolean deleteReply(String id);
    
    public int getReplyCount(String deadtime);

}
