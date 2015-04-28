package com.express.bean;

public class UploadFile {
	
	private String fileid;				//文件id
	private String filename;			//文件名字
	private String filepath;			//文件路径
	private double filesize;			//文件大小
	private String filetype;			//文件类型
	private String filedesc;			//文件描述
	private String objectid;			//文件所属物的id
	
	
	public String getFileid() {
		return fileid;
	}
	public void setFileid(String fileid) {
		this.fileid = fileid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public double getFilesize() {
		return filesize;
	}
	public void setFilesize(double filesize) {
		this.filesize = filesize;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getFiledesc() {
		return filedesc;
	}
	public void setFiledesc(String filedesc) {
		this.filedesc = filedesc;
	}
	public String getObjectid() {
		return objectid;
	}
	public void setObjectid(String objectid) {
		this.objectid = objectid;
	}
}
