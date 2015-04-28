package com.express.dao;

import java.util.List;

import com.express.bean.Blacklist;

public interface BlacklistDao {
	/* 查询黑名单列表 */
    public List<Blacklist> getBlackList();
    
    /* 根据name查询黑名单 */
    public Blacklist getByName(String name);  
    
    /* 根据公司名称获取黑名单列表 */
    public List<Blacklist> getBlackListByCompanyName(String compname);
    
    /* 添加新黑名单人员 */
    public boolean addBlackList(Blacklist blacklist);
    
    /* 更新指定黑名单人员信息*/
    public boolean updateBlackList(Blacklist blacklist);
}
