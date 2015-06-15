package com.hzkdxh.dao;

import java.util.List;

import com.hzkdxh.bean.Company;

public interface CompanyDao {
	/* ��ѯ��˾�б� */
    public List<Company> getCompanyList();
    
    /* ��������˾id��ѯ��Ӧ�ӹ�˾�б� */
    public List<Company> getSubcompanyListByCompId(String compid);
    
    /* ��ѯ�ӹ�˾�б� */
    public List<Company> getSubcompanyList();
    
    /* ����compname��ѯָ���û� */
    public Company getByCompanyName(String compname);  
    
    /* ����compid��ѯָ���û� */
    public Company getByCompanyId(String compid); 
    
    /* �����¹�˾ */
    public boolean addCompany(Company company);
    
    /* ���¹�˾��Ϣ*/
    public boolean updateCompany(Company company);
    
    /* ���¹�˾��Ϣ*/
    public List<Company> getMainCompanyList();
    
    /* ɾ����˾��Ϣ*/
    public boolean deleteComp(String compid);

}