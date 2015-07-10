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

	private String[] NewsType = { "", "����Э��", "���߷���", "��ҵͳ��", "��Ա���", "��Ҫ����",
			"��ҵ��Ѷ", "��ҵ����", "Э�ᶯ̬" };
	private String[][] SubType = { {}, { "", "Э����", "Э���³�", "Э���ƶ�", "Э���Ա" },
			{ "", "���ɷ���", "���Ź���", "�淶���ļ�", "�ط��Է���", "������ҵҪ��" },
			{ "", "ͳ�Ʊ���", "����ͨ��" }, { "" }, { "" }, { "" }, { "" }, { "" } };
	private String[] Company = { "","���������������", "�����п����ҵЭ��","����", "˳��", "��ͨ", "Բͨ", "��ͨ", "�ϴ�", "����",
			"��ͨ", "��ͨ", "�°�", "����", "��һ", "����"  };
	private int pagesize = 15; // ÿ�β�ѯ���صĴ���

	/**
	 * ���������б�
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
			xhdtList = newsService.getNewsListByNewsType(8);// ��ȡЭ�ᶯ̬
			if (xhdtList.size() > 8) {
				xhdtList = xhdtList.subList(0, 8);
			}

			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);// ��ȡ��Ҫ����
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}

			List<News> hyggList = new ArrayList<News>();
			hyggList = newsService.getNewsListByNewsTypeAndSubTypeAndPage(5, 0,
					8, 8);// ��ȡ��ҵ����

			List<News> hyzxList = new ArrayList<News>();
			hyzxList = newsService.getNewsListByNewsType(6);// ��ȡ��ҵ��Ѷ
			if (hyzxList.size() > 8) {
				hyzxList = hyzxList.subList(0, 8);
			}

			List<News> hytjList = new ArrayList<News>();
			hytjList = newsService.getNewsListByNewsType(7);// ��ȡ��ҵͳ��
			if (hytjList.size() > 8) {
				hytjList = hytjList.subList(0, 8);
			}

			List<News> hyfcList = new ArrayList<News>();
			hyfcList = newsService.getNewsListByNewsType(4);// ��ȡ��Ա���
			if (hyfcList.size() > 8) {
				hyfcList = hyfcList.subList(0, 8);
			}

			List<News> zcfgList = new ArrayList<News>();
			zcfgList = newsService.getNewsListByNewsType(2);// ��ȡ���߷���
			if (zcfgList.size() > 8) {
				zcfgList = zcfgList.subList(0, 8);
			}

			List<RollingPicture> rpList = new ArrayList<RollingPicture>();
			rpList = rpService.getListBySequence(); // ��ȡ�����ֲ�ͼƬ
			if (rpList.size() > 6) {
				rpList = rpList.subList(0, 6);
			}

			List<StaticPicture> spList = new ArrayList<StaticPicture>();
			spList = spService.getPicturetList(); // ��ȡ��̬�ֲ�ͼƬ

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
			logger.error("��ȡ��ҳ��Ϣ����" + ",errMsg=" + e.getMessage());
			return null;
		}
	}

	/**
	 * չʾ����
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
			String newsid = request.getParameter("newsid"); // ��ȡ����id
			News news = newsService.getByNewsId(newsid);

			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);// ��ȡ��Ҫ����
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			// ��������id��ȡ����
			int newstype = news.getNewstype();
			int subtype = news.getSubtype();
			String newstype_name = NewsType[newstype];
			String subtype_name = SubType[newstype][subtype];
			String type = newstype + "" + subtype; // ���������������࣬��ϳ�type
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
			logger.error("�����������ͻ�ȡ������Ϣ����" + ",errMsg=" + e.getMessage());
			return null;
		}
	}

	/**
	 * ���������б�
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
			String r_newstype = request.getParameter("newstype"); // ���Ŵ���
			String r_subtype = request.getParameter("subtype"); // ����Ϸ��
			String r_start = request.getParameter("start"); // ������ҳ
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
			if (newstype == 7) {// ��ҵ���棬����Ҫ�����еڰ˸���ʼȡ
				newsList = newsService.getNewsListByNewsTypeAndSubTypeAndPage(
						5, 0, (start - 1) * pagesize + 8, pagesize); // ��ȡ�����б�
			} else {
				newsList = newsService.getNewsListByNewsTypeAndSubTypeAndPage(
						newstype, subtype, (start - 1) * pagesize, pagesize);
			}
			int pageSum = newsService.getNewsCount(newstype, subtype);
			pagecount = pageSum / pagesize + 1; // ������ҳ��

			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);// ��ȡ��Ҫ����
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
	 * ��������
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
			zyggList = newsService.getNewsListByNewsType(5);// ��ȡ��Ҫ����
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
			String type = "��������";
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
			logger.error("��ȡ����������Ϣ����" + ",errMsg=" + e.getMessage());
			return null;
		}
	}

	/**
	 * ���ŷ���
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
				List<User> adminmessageList = userService.getUserListByLevel(3); // ��ùܾ֡�Э�ᣨ����Ա���б�
				HashMap<String, MessageList> hasAddList = new HashMap<String, MessageList>();
				for (User user2 : adminmessageList) {//������Ա�����Ĺ�˾����ӵ������б���
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
				for (User user2 : adminmessageList) {//������Ա�ĵ绰�ӵ������б���
					MessageList message = new MessageList();
					message.setName(user2.getLinkman());
					message.setId(user2.getUserid());
					message.setPhone(user2.getPhone());
					message.setPid(String.valueOf(user2.getCompany()));
					messageList.add(message);
				}
				List<User> submessageList = userService.getUserListByLevel(1);// ������л�Ա��λ�б�
				for (User user2 : submessageList) {//����Ա��λ�����Ĺ�˾����ӵ������б���
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
				for (User user2 : submessageList) {//����Ա��λ�Ĺ�˾�ӵ������б���
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
				for (User user2 : submessageList) {//����Ա��λ��˾����Ա����ӵ������б���
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
				List<User> adminmessageList = userService.getUserListByLevel(3); // ��ùܾ֡�Э�ᣨ����Ա���б�
				HashMap<String, MessageList> hasAddList = new HashMap<String, MessageList>();
				for (User user2 : adminmessageList) {//������Ա�����Ĺ�˾����ӵ������б���
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
				for (User user2 : adminmessageList) {//������Ա�ĵ绰�ӵ������б���
					MessageList message = new MessageList();
					message.setName(user2.getLinkman());
					message.setId(user2.getUserid());
					message.setPhone(user2.getPhone());
					message.setPid(String.valueOf(user2.getCompany()));
					messageList.add(message);
				}
				List<User> submessageList = userService.getUserListByLevel(2);// ����������µ�λ�б�
				for (User user2 : submessageList) {//�����µ�λ�����Ĺ�˾����ӵ������б���
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
				for (User user2 : submessageList) {//�����µ�λ�Ĺ�˾�ӵ������б���
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
				for (User user2 : submessageList) {//�����µ�λ��˾����Ա����ӵ������б���
					MessageList message = new MessageList();
					message.setName(user2.getLinkman());
					message.setId(user2.getUserid());
					message.setPid(user2.getCompid());
					message.setPhone(user2.getPhone());
					messageList.add(message);
				}
				List<Company> companyList = companyService.getSubcompanyListByCompId(user.getCompid());
				for (Company company : companyList) {//��Ӹ������µ��ӹ�˾�������б���
					MessageList message = new MessageList();
					message.setName(company.getCompname());
					message.setId(company.getCompid());
					message.setPid(String.valueOf(user.getCompany()));
					message.setPhone("null");
					messageList.add(message);
				}
				for (Company company : companyList) {
					List<User> userList = userService.getUserListByCompid(company.getCompid());
					for (User user2 : userList) {//��Ӹ������µ��ӹ�˾�ĳ�Ա���뵽�����б���
						MessageList message = new MessageList();
						message.setName(user2.getLinkman());
						message.setId(user2.getUserid());
						message.setPid(user2.getCompid());
						message.setPhone(user2.getPhone());
						messageList.add(message);
					}
				}
			} else if (user.getLevel() == 3) {
				List<User> userList = userService.getUserList();// ����������л�Ա�б�
				for (int i = 1; i < Company.length; i++) {//����˾����ӵ������б���
					MessageList message = new MessageList();
					message.setName(Company[i]);
					message.setId(String.valueOf(i));
					message.setPhone("null");
					message.setPid("0");
					messageList.add(message);
				}
				HashMap<String, MessageList> hasAddSub = new HashMap<String, MessageList>();
				for (User user2 : userList) {//�����л�Ա�Ĺ�˾�ӵ������б���
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
				for (User user2 : userList) {//�����µ�λ��˾����Ա����ӵ������б���
					MessageList message = new MessageList();
					message.setName(user2.getLinkman());
					message.setId(user2.getUserid());
					message.setPid(user2.getCompid());
					message.setPhone(user2.getPhone());
					messageList.add(message);
				}
			}
			List<News> zyggList = new ArrayList<News>();
			zyggList = newsService.getNewsListByNewsType(5);// ��ȡ��Ҫ����
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			String type = "���ŷ���";
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
			logger.error("��ȡ���ŷ�����Ϣ����" + ",errMsg=" + e.getMessage());
			return null;
		}
	}

	/**
	 * ���Ų鿴
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
			zyggList = newsService.getNewsListByNewsType(5);// ��ȡ��Ҫ����
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			List<Message> messageList = messageService.getMessageListByTime(
					(start - 1) * pagesize, pagesize);
			int pageSum = messageService.getMessageCount();
			pagecount = pageSum / pagesize + 1;
			Map map = new HashMap();
			String type = "���Ų鿴";
			map.put("type", type);
			map.put("pagecount", pagecount);
			map.put("start", start);
			map.put("messageList", messageList);
			map.put("zyggList", zyggList);
			return new ModelAndView("messageList").addAllObjects(map);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("��ȡ���Ų鿴��Ϣ����" + ",errMsg=" + e.getMessage());
			return null;
		}
	}

	/**
	 * ���Ž���
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
			zyggList = newsService.getNewsListByNewsType(5);// ��ȡ��Ҫ����
			if (zyggList.size() > 8) {
				zyggList = zyggList.subList(0, 8);
			}
			Map map = new HashMap();
			String type = "���Ž���";
			map.put("type", type);
			map.put("zyggList", zyggList);
			return new ModelAndView("blackList").addAllObjects(map);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			logger.error("��ȡ���Ž�����Ϣ����" + ",errMsg=" + e.getMessage());
			return null;
		}
	}

	/**
	 * ����ר��
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
			zyggList = newsService.getNewsListByNewsType(5);// ��ȡ��Ҫ����
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
			String type = "����ר��";
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
			logger.error("��ȡ����ר����Ϣ����" + ",errMsg=" + e.getMessage());
			return null;
		}
	}

}
