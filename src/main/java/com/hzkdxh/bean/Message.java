package com.hzkdxh.bean;

public class Message {
	
	// �ֻ�����
	private String mdn;
	
	// ��������
	private String content;
	
	// ����ʱ�䣬��ʽyyyy-MM-dd HH:mm:ss
	private String send_time;
	
	// ����id���
	private String id;

	public String getMdn() {
		return mdn;
	}

	public void setMdn(String mdn) {
		this.mdn = mdn;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
