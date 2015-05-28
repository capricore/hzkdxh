package com.express.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.express.bean.Company;
import com.express.service.BaseService;
import com.express.service.CompanyService;


@Service
public class CompanyServiceImp extends BaseService implements CompanyService {

	public List<Company> getCompanyList() {
		return getCompanyDao().getCompanyList();
	}

	public List<Company> getSubcompanyListByCompId(String compid) {
		return getCompanyDao().getSubcompanyListByCompId(compid);
	}

	public Company getByCompanyName(String compname) {
		return getCompanyDao().getByCompanyName(compname);
	}

	public Company getByCompanyId(String compid) {
		return getCompanyDao().getByCompanyId(compid);
	}

	public boolean addCompany(Company company) {
		return getCompanyDao().addCompany(company);
	}

	public boolean updateCompany(Company company) {
		return getCompanyDao().updateCompany(company);
	}
	
	public List<Company> getMainCompanyList() {
		return getCompanyDao().getMainCompanyList();
	}

	public boolean deleteComp(String compid) {
		return getCompanyDao().deleteComp(compid);
	}

}