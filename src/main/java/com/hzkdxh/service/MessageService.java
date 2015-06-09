package com.hzkdxh.service;

import java.util.List;

import com.hzkdxh.bean.Message;

public interface MessageService {
	
	/* ����ʱ���ѯ�����б�*/
    public List<Message> getMessageListByTime(int start, int pagesize);
    
    /* ����id��ѯ������Ϣ*/
    public Message getMessageById(String id);
    
    /* ����¶��� */
    public boolean addMessage(Message message);
    
    /* ���¶�����Ϣ*/
    public boolean updateMessage(Message message);
    
    /* ɾ��������Ϣ*/
    public boolean deleteMessage(String id);
    
    public int getMessageCount();

}
