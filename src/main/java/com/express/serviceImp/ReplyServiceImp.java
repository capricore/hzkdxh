package com.express.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.express.bean.Reply;
import com.express.service.BaseService;
import com.express.service.ReplyService;

@Service
public class ReplyServiceImp extends BaseService implements ReplyService{

	public List<Reply> getReplyListByDeadline(String deadline,int start, int pagesize) {
		return getReplyDao().getReplyListByDeadline(deadline,start,pagesize);
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
