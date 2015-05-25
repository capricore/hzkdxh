package com.express.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.express.bean.OrganizationBlacklist;
import com.express.service.BaseService;
import com.express.service.OrganizationBlacklistService;

@Service
public class OrganizationBlacklistServiceImp extends BaseService implements OrganizationBlacklistService{

	public List<OrganizationBlacklist> getBlackList() {
		return getOrganizationBlacklistDao().getBlackList();
	}

	public OrganizationBlacklist getByOrganizationName(String organizationname) {
		return getOrganizationBlacklistDao().getByOrganizationName(organizationname);
	}

	public OrganizationBlacklist getByOrganizationId(String organizationid) {
		return getOrganizationBlacklistDao().getByOrganizationId(organizationid);
	}

	public boolean addBlackList(OrganizationBlacklist blacklist) {
		return getOrganizationBlacklistDao().addBlackList(blacklist);
	}

	public boolean updateBlackList(OrganizationBlacklist blacklist) {
		return getOrganizationBlacklistDao().updateBlackList(blacklist);
	}

	public boolean deleteBlacklist(String organizationid) {
		return getOrganizationBlacklistDao().deleteBlacklist(organizationid);
	}

}
