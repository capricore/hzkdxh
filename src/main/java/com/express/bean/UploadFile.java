package com.express.bean;

public class UploadFile {
	
	private String fileid;				//�ļ�id
	private String filename;			//�ļ�����
	private String filepath;			//�ļ�·��
	private double filesize;			//�ļ���С
	private String filetype;			//�ļ�����
	private String filedesc;			//�ļ�����
	private String objectid;			//�ļ��������id
	
	
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
