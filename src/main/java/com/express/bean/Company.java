package com.express.bean;

import java.sql.Timestamp;

public class Company {
	
	private String compid; 			// 公司id
	
	private String pcompid;			// 上一级公司id：若没有为null

	private String compname; 		// 公司名称

	private String address; 		// 公司地址

	private String tel; 			// 公司固话
	
	private String email;			// 公司邮箱
	
	public String getPcompid() {
		return pcompid;
	}

	public void setPcompid(String pcompid) {
		this.pcompid = pcompid;
	}

	private Timestamp  crtime;			// 公司添加时间

	public String getCompid() {
		return compid;
	}

	public void setCompid(String compid) {
		this.compid = compid;
	}

	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCrtime() {
		return crtime;
	}

	public void setCrtime(Timestamp crtime) {
		this.crtime = crtime;
	}
	

}
