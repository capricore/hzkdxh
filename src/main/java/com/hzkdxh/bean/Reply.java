package com.hzkdxh.bean;

public class Reply {
	
	//�ֻ�����
	private String mdn;
	//�����
	private String callmdn;
	//�ظ�����
	private String content;
	//�ظ�ʱ�䣬��ʽyyyy-MM-dd HH:mm:ss
	private String reply_time;
	//�ظ�id���
	private String id;
	//��������id���
	private String messageid;
	
	public String getMessageid() {
		return messageid;
	}
	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getCallmdn() {
		return callmdn;
	}
	public void setCallmdn(String callmdn) {
		this.callmdn = callmdn;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReply_time() {
		return reply_time;
	}
	public void setReply_time(String reply_time) {
		this.reply_time = reply_time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
