package com.hzkdxh.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hzkdxh.bean.Company;
import com.hzkdxh.bean.Downloadzone;
import com.hzkdxh.bean.Message;
import com.hzkdxh.bean.MessageList;
import com.hzkdxh.bean.News;
import com.hzkdxh.bean.RollingPicture;
import com.hzkdxh.bean.StaticPicture;
import com.hzkdxh.bean.User;
import com.hzkdxh.service.CompanyService;
import com.hzkdxh.service.DownloadzoneService;
import com.hzkdxh.service.MessageService;
import com.hzkdxh.service.NewsService;
import com.hzkdxh.service.RollingPictureService;
import com.hzkdxh.service.StaticPictureService;
import com.hzkdxh.service.UserService;
import com.hzkdxh.util.StringUtils;

@Controller
@RequestMapping(value = "/news")
public class IndexController extends BaseController {
	@Autowired
	private NewsService newsService;
	@Autowired
	private UserService userService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private RollingPictureService rpService;
	@Autowired
	private StaticPictureService spService;
	@Autowired
	private DownloadzoneService downloadzoneService;
	@Autowired
	private MessageService messageService;

	private static final Logger logger = Logger
			.getLogger(IndexController.class);

	private String[] NewsType = { "", "关于协会", "政策法规", "行业统计", "会员风采", "重要公告",
			"行业资讯", "行业公告", "协会动态" };
	private String[][] SubType = { {}, { "", "协会简介", "协会章程", "协会制度", "协会成员" },
			{ "", "法律法规", "部门规章", "规范性文件", "地方性法规", "其它行业要求" },
			{ "", "统计报告", "申诉通告" }, { "" }, { "" }, { "" }, { "" }, { "" } };
	private String[] Company = { "","杭州市邮政管理局", "杭州市快递行业协会","邮政", "顺丰", "申通", "圆通", "中通", "韵达", "天天",
			"汇通", "国通", "德邦", "外资", "单一", "其他"  };
	private int pagesize = 15; // 每次查询返回的次数

	/**
	 * 返回文章列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/index.do")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {

			List<News> xhdtList = new ArrayList<News>();
			xhdtList = newsService.getNewsListByNewsType(8);// 获取协会动态
			if (xhdtList.size() > 8) {
				xhdtList = xhdtList.subList(0, 8);
			}

			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);// 获取重要公告
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}

			List<News> hyggList = new ArrayList<News>();
			hyggList = newsService.getNewsListByNewsTypeAndSubTypeAndPage(5, 0,
					8, 8);// 获取行业公告

			List<News> hyzxList = new ArrayList<News>();
			hyzxList = newsService.getNewsListByNewsType(6);// 获取行业资讯
			if (hyzxList.size() > 8) {
				hyzxList = hyzxList.subList(0, 8);
			}

			List<News> hytjList = new ArrayList<News>();
			hytjList = newsService.getNewsListByNewsType(7);// 获取行业统计
			if (hytjList.size() > 8) {
				hytjList = hytjList.subList(0, 8);
			}

			List<News> hyfcList = new ArrayList<News>();
			hyfcList = newsService.getNewsListByNewsType(4);// 获取会员风采
			if (hyfcList.size() > 8) {
				hyfcList = hyfcList.subList(0, 8);
			}

			List<News> zcfgList = new ArrayList<News>();
			zcfgList = newsService.getNewsListByNewsType(2);// 获取政策法规
			if (zcfgList.size() > 8) {
				zcfgList = zcfgList.subList(0, 8);
			}

			List<RollingPicture> rpList = new ArrayList<RollingPicture>();
			rpList = rpService.getListBySequence(); // 获取新闻轮播图片
			if (rpList.size() > 6) {
				rpList = rpList.subList(0, 6);
			}

			List<StaticPicture> spList = new ArrayList<StaticPicture>();
			spList = spService.getPicturetList(); // 获取静态轮播图片

			Map map = new HashMap();
			map.put("rpList", rpList);
			map.put("xhdtList", xhdtList);
			map.put("zyggList", zyggList);
			map.put("hyggList", hyggList);
			map.put("hyzxList", hyzxList);
			map.put("hytjList", hytjList);
			map.put("hyfcList", hyfcList);
			map.put("zcfgList", zcfgList);
			map.put("spList", spList);
			return new ModelAndView("index").addAllObjects(map);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			logger.error("获取首页信息出错！" + ",errMsg=" + e.getMessage());
			return null;
		}
	}

	/**
	 * 展示文章
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/detail.do")
	public ModelAndView newsView(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			String newsid = request.getParameter("newsid"); // 获取文章id
			News news = newsService.getByNewsId(newsid);

			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);// 获取重要公告
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			// 根据文章id获取文章
			int newstype = news.getNewstype();
			int subtype = news.getSubtype();
			String newstype_name = NewsType[newstype];
			String subtype_name = SubType[newstype][subtype];
			String type = newstype + "" + subtype; // 根据新闻类别和子类，组合成type
			Map map = new HashMap();
			map.put("type", SubType[newstype][subtype]);
			map.put("news", news);
			map.put("r_newstype", newstype);
			map.put("r_subtype", subtype);
			map.put("newstype", newstype_name);
			map.put("subtype", subtype_name);
			map.put("zyggList", zyggList);
			return new ModelAndView("detail").addAllObjects(map);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("根据新闻类型获取新闻信息出错！" + ",errMsg=" + e.getMessage());
			return null;
		}
	}

	/**
	 * 返回文章列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/newsList.do")
	public ModelAndView newsList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			int newstype = 0;
			int subtype = 0;
			int start = 1;
			int pagecount = 0;
			String r_newstype = request.getParameter("newstype"); // 新闻大类
			String r_subtype = request.getParameter("subtype"); // 新闻戏类
			String r_start = request.getParameter("start"); // 请求首页
			if (StringUtils.isNotEmpty(r_start))
				start = Integer.valueOf(r_start);

			List<News> newsList = new ArrayList<News>();
			if (StringUtils.isNumber(r_newstype)
					&& StringUtils.isNumber(r_subtype)) {
				newstype = Integer.valueOf(r_newstype);
				subtype = Integer.valueOf(r_subtype);
			} else if (StringUtils.isNumber(r_newstype)) {
				newstype = Integer.valueOf(r_newstype);
			}
			if (newstype == 7) {// 行业公告，从重要公告中第八个开始取
				newsList = newsService.getNewsListByNewsTypeAndSubTypeAndPage(
						5, 0, (start - 1) * pagesize + 8, pagesize); // 获取文章列表
			} else {
				newsList = newsService.getNewsListByNewsTypeAndSubTypeAndPage(
						newstype, subtype, (start - 1) * pagesize, pagesize);
			}
			int pageSum = newsService.getNewsCount(newstype, subtype);
			pagecount = pageSum / pagesize + 1; // 新闻总页数

			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);// 获取重要公告
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}

			String newstype_name = NewsType[newstype];
			String subtype_name = SubType[newstype][subtype];
			Map map = new HashMap();
			String type = null;
			if (subtype_name != "") {
				type = subtype_name;
			} else {
				type = newstype_name;
			}
			map.put("newstype", newstype_name);
			map.put("subtype", subtype_name);
			map.put("type", type);
			map.put("r_newstype", r_newstype);
			map.put("r_subtype", r_subtype);
			map.put("newsList", newsList);
			map.put("pagecount", pagecount);
			map.put("start", start);
			map.put("zyggList", zyggList);
			return new ModelAndView("list").addAllObjects(map);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}

	/**
	 * 下载中心
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/downloadList.do")
	public ModelAndView downloadList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			int start = 1;
			int level = 1;
			int pagecount = 0;
			String r_start = request.getParameter("start");
			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);// 获取重要公告
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}

			if (StringUtils.isNotEmpty(r_start))
				start = Integer.valueOf(r_start);
			Map map = new HashMap();
			List<Downloadzone> downlist = downloadzoneService.getFileList(
					level, (start - 1) * pagesize, pagesize);
			int pageSum = downloadzoneService.getFileCount(level);
			pagecount = pageSum / pagesize + 1;
			String type = "下载中心";
			map.put("type", type);
			map.put("pagecount", pagecount);
			map.put("start", start);
			map.put("level", level);
			map.put("downlist", downlist);
			map.put("zyggList", zyggList);
			return new ModelAndView("downloadList").addAllObjects(map);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("获取下载中心信息出错！" + ",errMsg=" + e.getMessage());
			return null;
		}
	}

	/**
	 * 短信发送
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/message.do")
	public ModelAndView message(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			HttpSession session = request.getSession(true);
			String username = (String) session.getAttribute("username");
			User user = userService.getByUserName(username);
			List<MessageList> messageList = new ArrayList<MessageList>();
			Map map = new HashMap();
			if (user.getLevel() == 1) {
				List<User> adminmessageList = userService.getUserListByLevel(3); // 获得管局、协会（管理员）列表
				HashMap<String, MessageList> hasAddList = new HashMap<String, MessageList>();
				for (User user2 : adminmessageList) {//将管理员所属的公司大类加到短信列表中
					if (!hasAddList.containsKey(Company[user2.getCompany()])) {
						MessageList message = new MessageList();
						message.setName(Company[user2.getCompany()]);
						message.setId(String.valueOf(user2.getCompany()));
						message.setPhone("null");
						message.setPid("0");
						messageList.add(message);
						hasAddList.put(Company[user2.getCompany()], message);
					}
				}
				for (User user2 : adminmessageList) {//将管理员的电话加到短信列表中
					MessageList message = new MessageList();
					message.setName(user2.getLinkman());
					message.setId(user2.getUserid());
					message.setPhone(user2.getPhone());
					message.setPid(String.valueOf(user2.getCompany()));
					messageList.add(message);
				}
				List<User> submessageList = userService.getUserListByLevel(1);// 获得所有会员单位列表
				for (User user2 : submessageList) {//将会员单位所属的公司大类加到短信列表中
					if (!hasAddList.containsKey(Company[user2.getCompany()])) {
						MessageList message = new MessageList();
						message.setName(Company[user2.getCompany()]);
						message.setId(String.valueOf(user2.getCompany()));
						message.setPhone("null");
						hasAddList.put(Company[user2.getCompany()], message);
						messageList.add(message);
					}
				}
				HashMap<String, MessageList> hasAddSub = new HashMap<String, MessageList>();
				for (User user2 : submessageList) {//将会员单位的公司加到短信列表中
					Company company = companyService.getByCompanyId(user2.getCompid());
					if (!hasAddSub.containsKey(company.getCompid())) {
						MessageList message = new MessageList();
						message.setName(company.getCompname());
						message.setId(user2.getCompid());
						message.setPid(String.valueOf(user2.getCompany()));
						message.setPhone("null");
						messageList.add(message);
						hasAddSub.put(company.getCompid(),message);
					}
				}
				for (User user2 : submessageList) {//将会员单位公司的人员号码加到短信列表中
						MessageList message = new MessageList();
						message.setName(user2.getLinkman());
						message.setId(user2.getUserid());
						message.setPid(user2.getCompid());
						message.setPhone(user2.getPhone());
						messageList.add(message);
				}
				Company company = companyService.getByCompanyId(user.getCompid());
				if(company.getPcompid() != null){
					MessageList lishi = new MessageList();
					lishi.setName(company.getCompname());
					lishi.setId(company.getCompid());
					lishi.setPid(Company[user.getCompany()]);
					lishi.setPhone("null");
					messageList.add(lishi);
					MessageList linkman = new MessageList();
					linkman.setName(user.getUsername());
					linkman.setId(user.getUserid());
					linkman.setPid(user.getCompid());
					linkman.setPhone(user.getPhone());
					messageList.add(linkman);
				}
			} else if (user.getLevel() == 2) {
				List<User> adminmessageList = userService.getUserListByLevel(3); // 获得管局、协会（管理员）列表
				HashMap<String, MessageList> hasAddList = new HashMap<String, MessageList>();
				for (User user2 : adminmessageList) {//将管理员所属的公司大类加到短信列表中
					if (!hasAddList.containsKey(Company[user2.getCompany()])) {
						MessageList message = new MessageList();
						message.setName(Company[user2.getCompany()]);
						message.setId(String.valueOf(user2.getCompany()));
						message.setPhone("null");
						message.setPid("0");
						messageList.add(message);
						hasAddList.put(Company[user2.getCompany()], message);
					}
				}
				for (User user2 : adminmessageList) {//将管理员的电话加到短信列表中
					MessageList message = new MessageList();
					message.setName(user2.getLinkman());
					message.setId(user2.getUserid());
					message.setPhone(user2.getPhone());
					message.setPid(String.valueOf(user2.getCompany()));
					messageList.add(message);
				}
				List<User> submessageList = userService.getUserListByLevel(2);// 获得所有理事单位列表
				for (User user2 : submessageList) {//将理事单位所属的公司大类加到短信列表中
					if (!hasAddList.containsKey(Company[user2.getCompany()])) {
						MessageList message = new MessageList();
						message.setName(Company[user2.getCompany()]);
						message.setId(String.valueOf(user2.getCompany()));
						message.setPhone("null");
						hasAddList.put(Company[user2.getCompany()], message);
						messageList.add(message);
					}
				}
				HashMap<String, MessageList> hasAddSub = new HashMap<String, MessageList>();
				for (User user2 : submessageList) {//将理事单位的公司加到短信列表中
					Company company = companyService.getByCompanyId(user2.getCompid());
					if (!hasAddSub.containsKey(company.getCompid())) {
						MessageList message = new MessageList();
						message.setName(company.getCompname());
						message.setId(user2.getCompid());
						message.setPid(String.valueOf(user2.getCompany()));
						message.setPhone("null");
						messageList.add(message);
						hasAddSub.put(company.getCompid(),message);
					}
				}
				for (User user2 : submessageList) {//将理事单位公司的人员号码加到短信列表中
					MessageList message = new MessageList();
					message.setName(user2.getLinkman());
					message.setId(user2.getUserid());
					message.setPid(user2.getCompid());
					message.setPhone(user2.getPhone());
					messageList.add(message);
				}
				List<Company> companyList = companyService.getSubcompanyListByCompId(user.getCompid());
				for (Company company : companyList) {//添加该理事下的子公司到短信列表中
					MessageList message = new MessageList();
					message.setName(company.getCompname());
					message.setId(company.getCompid());
					message.setPid(String.valueOf(user.getCompany()));
					message.setPhone("null");
					messageList.add(message);
				}
				for (Company company : companyList) {
					List<User> userList = userService.getUserListByCompid(company.getCompid());
					for (User user2 : userList) {//添加该理事下的子公司的成员号码到短信列表中
						MessageList message = new MessageList();
						message.setName(user2.getLinkman());
						message.setId(user2.getUserid());
						message.setPid(user2.getCompid());
						message.setPhone(user2.getPhone());
						messageList.add(message);
					}
				}
			} else if (user.getLevel() == 3) {
				List<User> userList = userService.getUserList();// 获得所有所有会员列表
				for (int i = 1; i < Company.length; i++) {//将公司大类加到短信列表中
					MessageList message = new MessageList();
					message.setName(Company[i]);
					message.setId(String.valueOf(i));
					message.setPhone("null");
					message.setPid("0");
					messageList.add(message);
				}
				HashMap<String, MessageList> hasAddSub = new HashMap<String, MessageList>();
				for (User user2 : userList) {//将所有会员的公司加到短信列表中
					Company company = companyService.getByCompanyId(user2.getCompid());
					if (!hasAddSub.containsKey(company.getCompid())) {
						MessageList message = new MessageList();
						message.setName(company.getCompname());
						message.setId(user2.getCompid());
						message.setPid(String.valueOf(user2.getCompany()));
						message.setPhone("null");
						messageList.add(message);
						hasAddSub.put(company.getCompid(),message);
					}
				}
				for (User user2 : userList) {//将理事单位公司的人员号码加到短信列表中
					MessageList message = new MessageList();
					message.setName(user2.getLinkman());
					message.setId(user2.getUserid());
					message.setPid(user2.getCompid());
					message.setPhone(user2.getPhone());
					messageList.add(message);
				}
			}
			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);// 获取重要公告
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			String type = "短信发送";
			JSONArray jsonArray = null;
			if (messageList != null && messageList.size() > 0) {
				jsonArray = new JSONArray(messageList);
			}
			String content ="{}";
			if(jsonArray!=null)
				content = jsonArray.toString();
			map.put("type", type);
			map.put("messageList", content);
			map.put("zyggList", zyggList);
			return new ModelAndView("message").addAllObjects(map);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("获取短信发送信息出错！" + ",errMsg=" + e.getMessage());
			return null;
		}
	}

	/**
	 * 短信查看
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/messageList.do")
	public ModelAndView messageList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			int start = 1;
			int pagecount = 0;
			String r_start = request.getParameter("start");
			if (StringUtils.isNotEmpty(r_start))
				start = Integer.valueOf(r_start);
			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);// 获取重要公告
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			List<Message> messageList = messageService.getMessageListByTime(
					(start - 1) * pagesize, pagesize);
			int pageSum = messageService.getMessageCount();
			pagecount = pageSum / pagesize + 1;
			Map map = new HashMap();
			String type = "短信查看";
			map.put("type", type);
			map.put("pagecount", pagecount);
			map.put("start", start);
			map.put("messageList", messageList);
			map.put("zyggList", zyggList);
			return new ModelAndView("messageList").addAllObjects(map);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("获取短信查看信息出错！" + ",errMsg=" + e.getMessage());
			return null;
		}
	}

	/**
	 * 诚信建设
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/blackList.do")
	public ModelAndView blackList(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);// 获取重要公告
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			Map map = new HashMap();
			String type = "诚信建设";
			map.put("type", type);
			map.put("zyggList", zyggList);
			return new ModelAndView("blackList").addAllObjects(map);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("获取诚信建设信息出错！" + ",errMsg=" + e.getMessage());
			return null;
		}
	}

	/**
	 * 下载专区
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/download.do")
	public ModelAndView download(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			int start = 1;
			int level = 2;
			int pagecount = 0;
			String r_start = request.getParameter("start");
			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);// 获取重要公告
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}

			if (StringUtils.isNotEmpty(r_start))
				start = Integer.valueOf(r_start);
			Map map = new HashMap();
			List<Downloadzone> downlist = downloadzoneService.getFileList(
					level, (start - 1) * pagesize, pagesize);
			int pageSum = downloadzoneService.getFileCount(level);
			pagecount = pageSum / pagesize + 1;
			String type = "下载专区";
			map.put("type", type);
			map.put("pagecount", pagecount);
			map.put("start", start);
			map.put("level", level);
			map.put("downlist", downlist);
			map.put("zyggList", zyggList);
			return new ModelAndView("downloadList").addAllObjects(map);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("获取下载专区信息出错！" + ",errMsg=" + e.getMessage());
			return null;
		}
	}

}
