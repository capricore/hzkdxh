package com.hzkdxh.query;

public class MessageQuery {
	// �ֻ�����
		private String mdn;
		
		// ��������
		private String content;
		
		// ����ʱ�䣬��ʽyyyy-MM-dd HH:mm:ss
		private String send_time;
		
		// ����id���
		private String id;
		
		private int start;			//��ѯ��ʼҳ
		
		private int pagesize;		//ÿ�β�ѯ���ص�����


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
