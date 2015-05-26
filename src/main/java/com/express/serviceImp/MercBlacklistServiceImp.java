package com.express.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.express.bean.MercBlacklist;
import com.express.service.BaseService;
import com.express.service.MercBlacklistService;

@Service
public class MercBlacklistServiceImp extends BaseService implements MercBlacklistService{

	public List<MercBlacklist> getBlackList() {
		return getMercBlacklistDao().getBlackList();
	}

	public MercBlacklist getByMercName(String mercname) {
		return getMercBlacklistDao().getByMercName(mercname);
	}

	public MercBlacklist getByMercId(String mercid) {
		return getMercBlacklistDao().getByMercId(mercid);
	}

	public boolean addBlackList(MercBlacklist blacklist) {
		return getMercBlacklistDao().addBlackList(blacklist);
	}

	public boolean updateBlackList(MercBlacklist blacklist) {
		return getMercBlacklistDao().updateBlackList(blacklist);
	}

	public boolean deleteBlacklist(String mercid) {
		return getMercBlacklistDao().deleteBlacklist(mercid);
	}

}
