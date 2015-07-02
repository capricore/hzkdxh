package com.hzkdxh.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hzkdxh.bean.Message;
import com.hzkdxh.bean.News;
import com.hzkdxh.bean.Reply;
import com.hzkdxh.message.ReplyThread;
import com.hzkdxh.message.SendMsg;
import com.hzkdxh.service.MessageService;
import com.hzkdxh.service.NewsService;
import com.hzkdxh.service.ReplyService;
import com.hzkdxh.service.UserService;
import com.hzkdxh.util.CodeGenerator;
import com.hzkdxh.util.DateUtils;
import com.hzkdxh.util.StringUtils;

@Controller
@RequestMapping(value = "/message")
public class MessageController extends BaseController {

	@Autowired
	private MessageService messageService;
	@Autowired
	private ReplyService replyService;
	@Autowired
	private UserService userService;
	@Autowired
	private NewsService newsService;

	private static final Logger logger = Logger.getLogger(MessageController.class);
	
	private int pagesize = 15;			//每次查询返回的次数 

	@RequestMapping("/save.do")
	public void addMessage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
//			String content = new String(request.getParameter("content").getBytes("ISO-8859-1"), "UTF-8"); 
			String content = request.getParameter("content"); 
			String[] compid = request.getParameterValues("select"); 
			StringBuilder phone = new StringBuilder();
			for (String comp : compid) {
				List<String> phonelist = userService.getPhoneByCompId(comp);
				for (String number : phonelist) {
					phone.append(number);
					phone.append(",");
				}
			}
			SendMsg.sendMessage_yxt(phone.toString(), content);
			Message message = new Message();
			message.setId(CodeGenerator.createUUID());
			message.setContent(content);
			message.setMdn(phone.toString());
			Timestamp crtime = Timestamp.valueOf(DateUtils.getCurrDateTimeStr());
			message.setSend_time(crtime.toString().substring(0, 19));
			messageService.addMessage(message);
			outputJsonResponse(response, true, "uploadSuccess");
			ReplyThread replyThread = new ReplyThread();
			Thread t1 = new Thread(replyThread);
			t1.start();
		} catch (RuntimeException e) {
			logger.error("发送短信出错！" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
	
	@RequestMapping("/messageDetail.do")
	public ModelAndView detailMessage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int start = 1;
		int pagecount = 0;
		String id = request.getParameter("id"); 
		String r_start = request.getParameter("start");	
		if(StringUtils.isNotEmpty(r_start))
			start = Integer.valueOf(r_start);
		Message message = messageService.getMessageById(id);
		String deanline = request.getParameter("deadline");
		List<Reply> replyList = null;
		int pageSum = 0;
		if (deanline !=null) {
			String sendtime = message.getSend_time();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date time = formatter.parse(sendtime);
			Date deadtime = new Date(time.getTime()+Integer.parseInt(deanline)*60*60*1000);
			pageSum = replyService.getReplyCount(message.getSend_time(),formatter.format(deadtime));
			pagecount = pageSum/pagesize+1;	
			replyList = replyService.getReplyListByDeadline(message.getSend_time(),formatter.format(deadtime),(start-1)*pagesize,pagesize);
		}
		Map map = new HashMap();
		List<News> zyggList = new ArrayList<News>();
		zyggList = newsService.getNewsListByNewsType(5);//获取重要公告
		if (zyggList.size() > 8) {
			zyggList = zyggList.subList(0, 8);
		}
		map.put("pagecount", pagecount);
		map.put("start", start);
		map.put("messagenum", pageSum);
		map.put("deanline", deanline);
		map.put("message", message);
		map.put("replyList", replyList);
		map.put("zyggList", zyggList);
		return new ModelAndView("messageDetail").addAllObjects(map);
	}
	

}
