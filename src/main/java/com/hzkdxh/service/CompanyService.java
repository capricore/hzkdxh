package com.hzkdxh.service;

import java.util.List;

import com.hzkdxh.bean.Company;

public interface CompanyService {
	/* 查询公司列表 */
    public List<Company> getCompanyList();
    
    /* 根据主公司id查询对应子公司列表 */
    public List<Company> getSubcompanyListByCompId(String compid);
    
    /* 查询子公司列表 */
    public List<Company> getSubcompanyList();
    
    /* 根据compname查询指定用户 */
    public Company getByCompanyName(String compname);  
    
    /* 根据compid查询指定用户 */
    public Company getByCompanyId(String compid); 
    
    /* 添加新公司 */
    public boolean addCompany(Company company);
    
    /* 更新公司信息*/
    public boolean updateCompany(Company company);
    
    /* 获得主公司信息列表*/
    public List<Company> getMainCompanyList();
    
    /* 根据公司等级公司信息列表*/
    public List<Company> getCompanyListByLevel(int level);
    
    /* 删除公司信息*/
    public boolean deleteComp(String compid);
    
    

}
