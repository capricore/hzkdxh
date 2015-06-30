package com.hzkdxh.query;

import java.sql.Date;

public class NewsQuery {
	
	private String newsid; 		// ����id

	private String title; 		// ���ű���

	private String content; 	// ��������

	private Date crtime; 		// ����޸�ʱ��

	private int newstype; 		// ����������Ŀ��1������Э�ᣬ2�����߷��棬3����ҵ���棬4����Ա���

	private int subtype; 		// ����������Ŀ�¶���Ŀ¼

	private int del; 			// �������Ƿ�ɾ����0��������1��ɾ��
	
	private int level;			//�ļ�����1����Ҫ��¼��2������Ҫ��¼
	
	private int start;			//��ѯ��ʼҳ
	
	private int pagesize;		//ÿ�β�ѯ���ص�����

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
