package com.express.controller;

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

import com.express.bean.Message;
import com.express.bean.News;
import com.express.bean.Reply;
import com.express.message.ReplyThread;
import com.express.service.MessageService;
import com.express.service.NewsService;
import com.express.service.ReplyService;
import com.express.service.UserService;
import com.express.util.CodeGenerator;
import com.express.util.DateUtils;
import com.express.util.StringUtils;

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
			String content = new String(request.getParameter("content").getBytes("ISO-8859-1"), "UTF-8"); 
			String[] compid = request.getParameterValues("select"); 
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
			message.setSend_time(crtime.toString().substring(0, 19));
			messageService.addMessage(message);
			ReplyThread replyThread = new ReplyThread();
			replyThread.run();
			outputJsonResponse(response, true, "uploadSuccess");
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
			pageSum = replyService.getReplyCount(formatter.format(deadtime));
			pagecount = pageSum/pagesize+1;	
			replyList = replyService.getReplyListByDeadline(formatter.format(deadtime),(start-1)*pagesize,start*pagesize);
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
