package com.express.dao;

import java.util.List;

import com.express.bean.Blacklist;

public interface BlacklistDao {
	/* ��ѯ�������б� */
    public List<Blacklist> getBlackList();
    
    /* ����name��ѯ������ */
    public Blacklist getByName(String name);  
    
    /* ���ݹ�˾���ƻ�ȡ�������б� */
    public List<Blacklist> getBlackListByCompanyName(String compname);
    
    /* ����º�������Ա */
    public boolean addBlackList(Blacklist blacklist);
    
    /* ����ָ����������Ա��Ϣ*/
    public boolean updateBlackList(Blacklist blacklist);
}
