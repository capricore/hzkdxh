package com.hzkdxh.daoImp;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.hzkdxh.bean.Company;
import com.hzkdxh.bean.User;
import com.hzkdxh.dao.BaseDao;
import com.hzkdxh.dao.UserDao;
import com.hzkdxh.query.UserQuery;

@Repository
public class UserDaoImp extends BaseDao implements UserDao {

	private static final Logger logger = Logger.getLogger(UserDaoImp.class);

	@SuppressWarnings("unchecked")
	public List<User> getUserList() {
		List<User> users = null;
		try {
			users = getSqlMapClientTemplate().queryForList("getUserList");
		} catch (Exception e) {
			logger.error("获取用户信息列表出错！" + ",errMsg=" + e.getMessage());
		}
		return users;
	}

	public User getByUserName(String username) {
		User user = null;
		try {
			user = (User) getSqlMapClientTemplate().queryForObject(
					"getUserByUserName", username);
		} catch (Exception e) {
			logger.error("根据用户姓名获取用户信息出错！" + ",errMsg=" + e.getMessage());
		}
		return user;
	}

	public User getByUserId(String userid) {
		User user = null;
		try {
			user = (User) getSqlMapClientTemplate().queryForObject(
					"getUserByUserId", userid);
		} catch (Exception e) {
			logger.error("根据用户id获取用户信息出错！" + ",errMsg=" + e.getMessage());
		}
		return user;
	}

	public boolean addUser(User user) {
		String object = null;
		boolean flag = false;
		try {
			object = (String) getSqlMapClientTemplate().insert("addUser", user);
		} catch (Exception e) {
			logger.error("添加用户信息出错！" + ",errMsg=" + e.getMessage());
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
			object = (Integer) getSqlMapClientTemplate().update("updateUser",
					user);
		} catch (Exception e) {
			logger.error("更新用户信息出错！" + ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@SuppressWarnings({ "unchecked", "null" })
	public List<User> getMessageListbyUserId(String userid) {
		User user = getByUserId(userid);
		int level = user.getLevel();
		try {
			if (level == 0) {
				return null;
			} else if (level == 1) {
				return getSqlMapClientTemplate().queryForList("getMessageListbyCompId", user.getCompid());
			}else if (level == 2) {
				List<Company> compList = getSqlMapClientTemplate().queryForList("getSubcompanyListByCompId",user.getCompid());
				List<User> userList = null;
				for (Company company : compList) {
					List<User> subList = getSqlMapClientTemplate().queryForList("getMessageListbyCompId",company.getCompid());
					userList.addAll(subList);
				}
				return userList;
			}else if (level == 3) {
				List<User> userList = getSqlMapClientTemplate().queryForList("getUserList");
				return userList;
			}
		} catch (Exception e) {
			logger.error("获取当前userid所对应群发短信用户列表出错！" + ",errMsg="
					+ e.getMessage());
		}
		return null;
	}

	public boolean deleteUser(String userid) {
		Object object = null;
		boolean flag = false;
		try {
			object = getSqlMapClientTemplate().delete("deleteUser", userid);
		} catch (Exception e) {
			logger.error("删除用户信息出错！" + ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	public String getUserIdbyLogin(String username, String passwd) {
		String userid= null;
		UserQuery userQuery = new UserQuery();
		userQuery.setUsername(username);
		userQuery.setPasswd(passwd);
		try {
			userid = (String) getSqlMapClientTemplate().queryForObject("getUserIdbyLogin", userQuery);
		} catch (Exception e) {
			logger.error("根据用户名密码获取userid信息出错！" + ",errMsg=" + e.getMessage());
		}
		return userid;
	}

	@SuppressWarnings("unchecked")
	public List<String> getPhoneByCompId(String compid) {
		List<String> phone = null;
		try {
			phone = getSqlMapClientTemplate().queryForList("getPhoneByCompId",compid);
		} catch (Exception e) {
			logger.error("获取电话列表出错！" + ",errMsg=" + e.getMessage());
		}
		return phone;
	}

	@SuppressWarnings("unchecked")
	public List<String> getAdminCompanyByLevel(int level) {
		List<String> adminCompany = null;
		try {
			adminCompany = getSqlMapClientTemplate().queryForList("getAdminCompanyByLevel",level);
		} catch (Exception e) {
			logger.error("获取管理员company列表出错！" + ",errMsg=" + e.getMessage());
		}
		return adminCompany;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUserListByLevel(int level) {
		List<User> adminCompany = null;
		try {
			adminCompany = getSqlMapClientTemplate().queryForList("getUserListByLevel",level);
		} catch (Exception e) {
			logger.error("根据level获取user列表出错！" + ",errMsg=" + e.getMessage());
		}
		return adminCompany;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserListByCompid(String compid) {
		List<User> user = null;
		try {
			user = getSqlMapClientTemplate().queryForList("getUserListByCompid",compid);
		} catch (Exception e) {
			logger.error("根据compid获取user列表出错！" + ",errMsg=" + e.getMessage());
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getListByLevelAndCategory(int level, int category) {
		List<User> user = null;
		UserQuery query = new UserQuery();
		query.setLevel(level);
		query.setCompany(category);
		try {
			user = getSqlMapClientTemplate().queryForList("getListByLevelAndCategory",query);
		} catch (Exception e) {
			logger.error("根据compid获取user列表出错！" + ",errMsg=" + e.getMessage());
		}
		return user;
	}

}
