package com.hzkdxh.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hzkdxh.bean.Downloadzone;
import com.hzkdxh.service.BaseService;
import com.hzkdxh.service.DownloadzoneService;

@Service
public class DownloadzoneServiceImp extends BaseService implements DownloadzoneService{

	public List<Downloadzone> getFileList(int start, int pagesize) {
		return getDownloadzoneDao().getFileList(start, pagesize);
	}
	
	public Downloadzone getById(String id) {
		return getDownloadzoneDao().getById(id);
	}

	public boolean addDownloadzone(Downloadzone downloadzone) {
		return getDownloadzoneDao().addDownloadzone(downloadzone);
	}

	public boolean updateDownloadzone(Downloadzone downloadzone) {
		return getDownloadzoneDao().updateDownloadzone(downloadzone);
	}

	public boolean deleteDownloadzone(String id) {
		return getDownloadzoneDao().deleteDownloadzone(id);
	}
	public int getFileCount() {
		return getDownloadzoneDao().getFileCount();
	}

}
