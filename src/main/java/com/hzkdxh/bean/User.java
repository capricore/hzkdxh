package com.hzkdxh.bean;

import java.sql.Timestamp;

public class User {

	private String userid; 		// 用户id

	private String compid; 		// 用户所属公司id

	private String username; 	// 用户名称

	private String passwd; 		// 用户密码

	private String phone; 		// 用户手机号码

	private String linkman; 		// 用户邮箱

	private int level; 			// 用户权限，0：普通，1：单位，2：理事，3：管理员
	
	private int company; 		// 公司大类，0：邮政，1：顺丰，2：申通，3：圆通，4：中通，5：韵达，6：天天，7：汇通，8：国通，9：德邦，10：外资，11，单一，12：其他,13:管局,14杭州快递协会

	private Timestamp restime; 		// 用户注册时间

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getCompany() {
		return company;
	}

	public void setCompany(int company) {
		this.company = company;
	}

	public String getCompid() {
		return compid;
	}

	public void setCompid(String compid) {
		this.compid = compid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Timestamp getRestime() {
		return restime;
	}

	public void setRestime(Timestamp restime) {
		this.restime = restime;
	}


}
