package com.hzkdxh.message;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpException;

import com.hzkdxh.bean.Reply;
import com.hzkdxh.service.ReplyService;


public class ReplyThread implements Runnable{
	
	private ReplyService replyService;
	
	
	public void run() {
		try {
			long tStart = System.currentTimeMillis(); 
			while (true) {
				// 查询上行回复
				Map map = SendMsg.reply();
				// 查询成功
				if (map.get("result") != null && map.get("result").equals("0")) {
					// 取得回复
					List<Reply> replys = (List<Reply>) map.get("replys");
					// 如果回复不为空的话
					if (replys != null) {
						for (int i = 0; i < replys.size(); i++) {
							replyService.addReply(replys.get(i));
						}
						String id = (String) map.get("id");
						if(id!=null){				//上行回复确认
							SendMsg.replyConfirm(id);
						}
					}
				}
				try {
					Thread.sleep(3600000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				long tEnd = System.currentTimeMillis();
				if (tEnd - tStart >= 86400000) { // 86400000ms等于一天
					break;
				}
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args){
//		String clid = "123456789";
//		ReplyThread rt = new ReplyThread(clid);
//		rt.run();
//	}
//	
	
}
