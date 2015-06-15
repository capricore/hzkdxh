package com.hzkdxh.query;

public class ReplyQuery {
	
	//手机号码
	private String mdn;
	//接入号
	private String callmdn;
	//回复内容
	private String content;
	//回复时间，格式yyyy-MM-dd HH:mm:ss
	private String reply_time;
	//回复id编号
	private String id;
	//所属短信id编号
	private String messageid;
	
	private String deadline;
	
	private String starttime;

	private int start;			//查询起始页
	
	private int pagesize;		//每次查询返回的数量
	
	
	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
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

	public String getMessageid() {
		return messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}


}
