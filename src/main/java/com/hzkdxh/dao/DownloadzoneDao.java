package com.hzkdxh.dao;

import java.util.List;

import com.hzkdxh.bean.Downloadzone;

public interface DownloadzoneDao {

	/* ��ѯ�����ļ��б� */
	public List<Downloadzone> getFileList(int start, int pagesize);

	/* ����id��ѯָ���ļ� */
	public Downloadzone getById(String id);

	/* ����ļ� */
	public boolean addDownloadzone(Downloadzone downloadzone);

	/* �����ļ� */
	public boolean updateDownloadzone(Downloadzone downloadzone);

	/* ɾ���ļ� */
	public boolean deleteDownloadzone(String id);
	
	public int getFileCount();

}
