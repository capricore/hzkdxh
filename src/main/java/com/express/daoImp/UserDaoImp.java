package com.express.daoImp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.express.bean.User;
import com.express.dao.BaseDao;
import com.express.dao.UserDao;

@Repository
public class UserDaoImp extends BaseDao implements UserDao{
	
	private static final Logger logger = Logger.getLogger(UserDaoImp.class);  
	
	@SuppressWarnings("unchecked")
	public List<User> getUserList() {
		List<User> users = null;
		try {
			users = getSqlMapClientTemplate().queryForList("getUserList");
		} catch (Exception e) {
			logger.error("获取用户信息列表出错！" +  ",errMsg=" + e.getMessage());
		}
		return users;  
	}

	public User getByUserName(String username) {
		User user = null;
		try {
			user = (User) getSqlMapClientTemplate().queryForObject("getUserByUserName",username);
		} catch (Exception e) {
			logger.error("根据用户姓名获取用户信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return user;  
	}

	public User getByUserId(String userid) {
		User user = null;
		try {
			user = (User) getSqlMapClientTemplate().queryForObject("getUserByUserName",userid);
		} catch (Exception e) {
			logger.error("根据用户id获取用户信息出错！" +  ",errMsg=" + e.getMessage());
		}
		return user;   
	}

	public boolean addUser(User user) {
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("addUser", user);
		} catch (Exception e) {
			logger.error("添加用户信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public boolean updateUser(User user) {
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("updateUser", user);
		} catch (Exception e) {
			logger.error("更新用户信息出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}
	
	
}
