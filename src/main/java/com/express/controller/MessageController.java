package com.express.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.express.service.MessageService;

@Controller
@RequestMapping(value="/message")
public class MessageController extends BaseController {
	
	@Autowired 
	private MessageService messageService;
	
	private static final Logger logger = Logger.getLogger(MessageController.class);
	
	@RequestMapping("/save.do")
	public void addMessage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String content = new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");			//文章内容
			String select = request.getParameter("select");																//文章类别，其包含了newstype和subtype，比如说部门规章，那么type=22
			System.out.print(select.length());
			outputJsonResponse(response, true, "uploadSuccess");
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}

}
