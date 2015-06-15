package com.hzkdxh.message;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hzkdxh.bean.Reply;
import com.hzkdxh.dao.ReplyDao;


public class ReplyThread implements Runnable {
	
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:/applicationContext.xml");

	ReplyDao replyDao = (ReplyDao) context.getBean("replyDao");

	public void run() {
		try {
			long tStart = System.currentTimeMillis(); 
			while (true) {
				// ��ѯ���лظ�
				Map map = SendMsg.reply();
				// ��ѯ�ɹ�
				if (map.get("result") != null && map.get("result").equals("0")) {
					// ȡ�ûظ�
					List<Reply> replys = (List<Reply>) map.get("replys");
					// ����ظ���Ϊ�յĻ�
					if (replys != null) {
						for (int i = 0; i < replys.size(); i++) {
							replyDao.addReply(replys.get(i));
						}
						String id = (String) map.get("id");
						if(id!=null){				//���лظ�ȷ��
							SendMsg.replyConfirm(id);
						}
					}
				}
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				long tEnd = System.currentTimeMillis();
				if (tEnd - tStart >= 100000) { // 86400000ms����һ��
					break;
				}
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
