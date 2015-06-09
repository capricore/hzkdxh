package com.hzkdxh.query;

public class MessageQuery {
	// 手机号码
		private String mdn;
		
		// 发送内容
		private String content;
		
		// 发送时间，格式yyyy-MM-dd HH:mm:ss
		private String send_time;
		
		// 发送id编号
		private String id;
		
		private int start;			//查询起始页
		
		private int pagesize;		//每次查询返回的数量


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
