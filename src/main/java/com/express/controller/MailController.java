package com.express.controller;

import java.util.ArrayList;
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

import com.express.bean.News;
import com.express.service.NewsService;
import com.express.util.MailSenderInfo;
import com.express.util.SimpleMailSender;

@Controller
@RequestMapping(value="/mail")
public class MailController extends BaseController{
	@Autowired 
	private NewsService newsService;
	
	private static final Logger logger = Logger.getLogger(MailController.class);
	
	/**
	 * 展示文章
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/send.do")
	public void newsView(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			//获取联系方式
			String contact = new String(request.getParameter("contact").getBytes("ISO-8859-1"),"UTF-8");
			//获取邮件内容
			String message = new String(request.getParameter("message").getBytes("ISO-8859-1"),"UTF-8");	
	        //这个类主要是设置邮件  
		     MailSenderInfo mailInfo = new MailSenderInfo();   
		     mailInfo.setMailServerHost("smtp.sina.com.cn");   
		     mailInfo.setMailServerPort("25");   
		     mailInfo.setValidate(true);   
		     mailInfo.setUserName("lpff1218@sina.com");   
		     mailInfo.setPassword("mumu0201lpf");//您的邮箱密码   
		     mailInfo.setFromAddress("lpff1218@sina.com");   
		     mailInfo.setToAddress("496512833@qq.com");   
		     mailInfo.setSubject("用户反馈");
		     message = "联系方式:"+contact + "\n" +"邮件内容:"+message;
		     mailInfo.setContent(message);   
		        //这个类主要来发送邮件  
		     SimpleMailSender sms = new SimpleMailSender();  
		         sms.sendTextMail(mailInfo);//发送文体格式   
		         //sms.sendHtmlMail(mailInfo);//发送html格式  
			outputJsonResponse(response, true, "sendSuccess");
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("发送邮件出错！" +  ",errMsg=" + e.getMessage());
		}
	}
	
	@RequestMapping("/contact.do")
	public ModelAndView contact(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);//获取重要公告
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			Map map = new HashMap();
			map.put("zyggList", zyggList);
			return new ModelAndView("contact").addAllObjects(map);
		}catch(RuntimeException e) {
			logger.error("发送邮件出错！" +  ",errMsg=" + e.getMessage());
			return null;
		}
	}
	
}
