package com.express.service;

import java.util.List;

import com.express.bean.Reply;

public interface ReplyService {
	
	/* 根据截至时间查询回复列表*/
    public List<Reply> getReplyListByDeadline(String deadline);
    
    /* 添加新回复 */
    public boolean addReply(Reply reply);
    
    /* 更新回复信息*/
    public boolean updateReply(Reply reply);
    
    /* 删除回复信息*/
    public boolean deleteReply(String id);

}
