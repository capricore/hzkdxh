package com.hzkdxh.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hzkdxh.bean.Reply;
import com.hzkdxh.service.BaseService;
import com.hzkdxh.service.ReplyService;

@Service
public class ReplyServiceImp extends BaseService implements ReplyService{

	public List<Reply> getReplyListByDeadline(String starttime,String deadline,int start, int pagesize) {
		return getReplyDao().getReplyListByDeadline(starttime,deadline,start,pagesize);
	}

	public boolean addReply(Reply reply) {
		return getReplyDao().addReply(reply);
	}

	public boolean updateReply(Reply reply) {
		return getReplyDao().updateReply(reply);
	}

	public boolean deleteReply(String id) {
		return getReplyDao().deleteReply(id);
	}

	public int getReplyCount(String deadtime) {
		return getReplyDao().getReplyCount(deadtime);
	}

}
