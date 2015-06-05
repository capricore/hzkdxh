package com.express.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.express.bean.Message;
import com.express.service.BaseService;
import com.express.service.MessageService;

@Service
public class MessageServiceImp extends BaseService implements MessageService{

	public List<Message> getMessageListByTime(int start, int pagesize) {
		return getMessageDao().getMessageListByTime(start, pagesize);
	}

	public Message getMessageById(String id) {
		return getMessageDao().getMessageById(id);
	}

	public boolean addMessage(Message message) {
		return getMessageDao().addMessage(message);
	}

	public boolean updateMessage(Message message) {
		return getMessageDao().updateMessage(message);
	}

	public boolean deleteMessage(String id) {
		return getMessageDao().deleteMessage(id);
	}

}
