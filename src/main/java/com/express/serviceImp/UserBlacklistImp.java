package com.express.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.express.bean.UserBlacklist;
import com.express.service.BaseService;
import com.express.service.UserBlacklistService;

@Service
public class UserBlacklistImp extends BaseService implements UserBlacklistService{

	public List<UserBlacklist> getBlackList() {
		return getUserBlacklistDao().getBlackList();
	}

	public UserBlacklist getByName(String name) {
		return getUserBlacklistDao().getByName(name);
	}

	public boolean addBlackList(UserBlacklist blacklist) {
		return getUserBlacklistDao().addBlackList(blacklist);
	}

	public boolean updateBlackList(UserBlacklist blacklist) {
		return getUserBlacklistDao().updateBlackList(blacklist);
	}

	public boolean deleteBlacklist(String userid) {
		return getUserBlacklistDao().deleteBlacklist(userid);
	}

	public UserBlacklist getByUserid(String userid) {
		return getUserBlacklistDao().getByUserid(userid);
	}

}
