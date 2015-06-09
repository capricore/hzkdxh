package com.hzkdxh.service;

import java.util.List;

import com.hzkdxh.bean.Message;

public interface MessageService {
	
	/* 根据时间查询发送列表*/
    public List<Message> getMessageListByTime(int start, int pagesize);
    
    /* 根据id查询发送信息*/
    public Message getMessageById(String id);
    
    /* 添加新短信 */
    public boolean addMessage(Message message);
    
    /* 更新短信信息*/
    public boolean updateMessage(Message message);
    
    /* 删除短信信息*/
    public boolean deleteMessage(String id);
    
    public int getMessageCount();

}
