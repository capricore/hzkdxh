package com.express.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.express.bean.Message;
import com.express.message.ReplyThread;
import com.express.service.MessageService;
import com.express.service.UserService;
import com.express.util.CodeGenerator;
import com.express.util.DateUtils;

@Controller
@RequestMapping(value = "/message")
public class MessageController extends BaseController {

	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;

	private static final Logger logger = Logger.getLogger(MessageController.class);

	@RequestMapping("/save.do")
	public void addMessage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String content = new String(request.getParameter("content").getBytes("ISO-8859-1"), "UTF-8"); 
			String select = request.getParameter("select");
			String query = request.getQueryString(); 
			String[] compid = parseResult(query);
			StringBuilder phone = new StringBuilder();
			for (String comp : compid) {
				List<String> phonelist = userService.getPhoneByCompId(comp);
				for (String number : phonelist) {
					phone.append(number);
					phone.append(",");
				}
			}
//			SendMsg.sendMessage(phone.toString(), content);
			Message message = new Message();
			message.setId(CodeGenerator.createUUID());
			message.setContent(content);
			message.setMdn(phone.toString());
			Timestamp crtime = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());
			//2015-06-01 18:06:52
			message.setSend_time(crtime.toString().substring(0, 19));
			messageService.addMessage(message);
			ReplyThread replyThread = new ReplyThread();
			replyThread.run();
			outputJsonResponse(response, true, "uploadSuccess");
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}

	public static String[] parseResult(String response) {
		String query[] = response.split("&");
		String result[] = new String[query.length-1];
		for (int i = 0; i < query.length - 1; i++) {
			result[i] = query[i].substring(7, query[i].length());
		}
		return result;
	}

}
