package com.express.bean;

import java.sql.Timestamp;

public class Company {
	
	private String compid; 			// ��˾id

	private String compname; 		// ��˾����

	private String address; 		// ��˾��ַ

	private String tel; 			// ��˾�̻�
	
	private String email;			// ��˾����
	
	private Timestamp  crtime;			// ��˾���ʱ��

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
