package com.express.message;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.express.bean.Reply;
import com.express.util.JsonUtils;

//import com.pet.util.JsonUtils;

public class SendMsg {

	public static final String UTF8 = "utf-8";
	public static final String GB2312 = "GB2312";
	//中国网建短信平台参数
	public static final String UID = "秦殇007";
	public static final String KEY = "4aaa53ecb1ca403d9a07";
	public static final String SMS_SEND_URI = "http://utf8.sms.webchinese.cn";
	public static final String SMS_NUM_URI = "http://sms.webchinese.cn/web_api/SMS/?Action=SMS_Num";
	//一信通短信平台参数
	public static final String SPCODE = "220264";				//企业编号
	public static final String LOGINNAME = "haz_glwl";			//用户名称
	public static final String PASSWORD = "glwl568980";			//用户密码
	public static final String YXT_SEND_URI = "http://ums.zj165.com:8888/sms/Api/Send.do"; //发送短信
	public static final String YXT_REPLY_URI = "http://gd.ums86.com:8899/sms/Api/reply.do";	//上行回复内容查询接口
	public static final String YXT_REPLY_CONFIRM_URI = "http://gd.ums86.com:8899/sms/Api/replyConfirm.do";	//上行回复内容查询接口
	
	/**
	 * 中国网建短信发送
	 * @param phone
	 * @param smsText
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public static int sendMessage(String phone, String smsText) throws HttpException, IOException{
		PostMethod post = new PostMethod(SMS_SEND_URI);
		NameValuePair[] data = { new NameValuePair("Uid", UID),
				new NameValuePair("Key", KEY),
				new NameValuePair("smsMob", phone),
				new NameValuePair("smsText", smsText) };
		String result = executeMethod(post, data,UTF8);
		System.out.println("发送短信数量：" + result + "，手机号：" + phone + " 信息：" + smsText);
		post.releaseConnection();
		return Integer.parseInt(result);
	}
	

	
	/**
	 * 中国网建获取短信数量
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static int smsNum() throws UnsupportedEncodingException, IOException{
		PostMethod post = new PostMethod(SMS_NUM_URI);
		NameValuePair[] data = { new NameValuePair("Uid", UID), new NameValuePair("Key", KEY) };
		String result = executeMethod(post, data,UTF8);
		System.out.println("短信数量：" + result);
		post.releaseConnection();
		return Integer.parseInt(result);
	}
	
	/**
	 * 一信通短信发送
	 * @param phone
	 * @param smsText
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public static void sendMessage_yxt(String phone, String smsText) throws HttpException, IOException{
		PostMethod post = new PostMethod(YXT_SEND_URI);
		NameValuePair[] data = { 
				new NameValuePair("SpCode", SPCODE),
				new NameValuePair("LoginName", LOGINNAME),
				new NameValuePair("Password", PASSWORD),
				new NameValuePair("MessageContent", smsText),
				new NameValuePair("UserNumber", phone),
				new NameValuePair("SerialNumber", ""),
				new NameValuePair("ScheduleTime", ""),
				new NameValuePair("f", "1")};
		String result = executeMethod(post, data,GB2312);
		System.out.println("手机号：" + phone + " 信息：" + smsText+" 服务器回执：" + result);
		post.releaseConnection();
	}
	
	/**
	 * 一信通短信上行内容查询
	 * @param phone
	 * @param smsText
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public static Map reply() throws HttpException, IOException{
		PostMethod post = new PostMethod(YXT_REPLY_URI);
		NameValuePair[] data = { 
				new NameValuePair("SpCode", SPCODE),
				new NameValuePair("LoginName", LOGINNAME),
				new NameValuePair("Password", PASSWORD)};
		String result = executeMethod(post, data,GB2312);
		Map map = praseResult(result);
		System.out.println(" 服务器回执：" + result);
		post.releaseConnection();
		return map;
	}

	/**
	 * 一信通回复内容确认接口
	 * @param phone
	 * @param smsText
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	public static void replyConfirm(String id) throws HttpException, IOException{
		PostMethod post = new PostMethod(YXT_REPLY_CONFIRM_URI);
		NameValuePair[] data = { 
				new NameValuePair("SpCode", SPCODE),
				new NameValuePair("LoginName", LOGINNAME),
				new NameValuePair("Password", PASSWORD),
				new NameValuePair("id", id)};
		String result = executeMethod(post, data,GB2312);
		System.out.println(" 服务器回执：" + result);
		post.releaseConnection();
	}

	
	/**
	 * 发送post请求
	 * @param post
	 * @param data
	 * @param charset
	 * @return
	 * @throws HttpException
	 * @throws IOException
	 */
	private static String executeMethod(PostMethod post, NameValuePair[] data,String charset) throws HttpException, IOException{
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset="+charset);
		post.setRequestBody(data);
		HttpClient client = new HttpClient();
		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:" + statusCode);
		for (Header h : headers) {
			System.out.println(h.toString());
		}
		return new String(post.getResponseBodyAsString().getBytes("ISO-8859-1"),charset);
	}
	
	/**
	 * 解析上行回复内容
	 * @param response
	 * @return
	 */
	public static Map praseResult(String response){
		Map map = new HashMap();
		String res[] = response.split("&");
		//取得result
		String result = res[0].substring(7);
		map.put("result", result);
		//取得confirm_time
		if(res.length>=2){
		String confirm_time = res[1].substring(13);
		map.put("confirm_time", confirm_time);
		}
		//取得id
		if(res.length>=3){
		String id = res[2].substring(3);
		map.put("id", id);
		}
		//取得replys
		if(res.length>=4){
			String replys = res[3].substring(7);
			List<Reply> r = JsonUtils.jsonToBeanList(replys, Reply.class);
			map.put("replys", r);
		}
		return map;
		
	}
	
	public static void main(String[] args) throws Exception{
		String phone = "13757125744";
		String text = "验证码：678910，请您在5分钟内填写。如非本人操作，请忽略本短信。";
		String reply = "服务器回执：result=0&description=发送短信成功&taskid=203150025019&faillist=&task_id=203150025019";
//		SendMsg.sendMessage_yxt(phone, text);
//		SendMsg.reply();
//		SendMsg.replyConfirm("2037453502");
//		String replys = "[{'callmdn':'1069026200121551','mdn':'15088785126','content':'你好啊','reply_time':'2015-06-01 18:06:52','id':'2037453383'},{'callmdn':'1069026200121551','mdn':'15088785126','content':'哈哈','reply_time':'2015-06-01 18:30:21','id':'2037453502'}]";
//		List<Reply> r = JsonUtils.jsonToBeanList(replys, Reply.class);
//		System.out.println(r.get(0).getContent());
	}
}