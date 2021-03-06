package com.hzkdxh.query;

import java.sql.Date;

public class NewsQuery {
	
	private String newsid; 		// 新闻id

	private String title; 		// 新闻标题

	private String content; 	// 新闻内容

	private Date crtime; 		// 最后修改时间

	private int newstype; 		// 新闻所属类目：1：关于协会，2：政策法规，3：行业公告，4：会员风采

	private int subtype; 		// 新闻所属类目下二级目录

	private int del; 			// 该新闻是否被删除，0：正常，1：删除
	
	private int level;			//文件级别，1，需要登录，2，不需要登录
	
	private int start;			//查询起始页
	
	private int pagesize;		//每次查询返回的数量

	public String getNewsid() {
		return newsid;
	}

	public void setNewsid(String newsid) {
		this.newsid = newsid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCrtime() {
		return crtime;
	}

	public void setCrtime(Date crtime) {
		this.crtime = crtime;
	}

	public int getNewstype() {
		return newstype;
	}

	public void setNewstype(int newstype) {
		this.newstype = newstype;
	}

	public int getSubtype() {
		return subtype;
	}

	public void setSubtype(int subtype) {
		this.subtype = subtype;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}
