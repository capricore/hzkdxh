package com.hzkdxh.bean;

import java.sql.Timestamp;

public class Blacklist {
	
	private String name; 			// 黑名单姓名

	private String compname; 		// 黑名单人员所属公司

	private Timestamp crtime; 		// 最后修改时间

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname;
	}

	public Timestamp getCrtime() {
		return crtime;
	}

	public void setCrtime(Timestamp crtime) {
		this.crtime = crtime;
	}

}
