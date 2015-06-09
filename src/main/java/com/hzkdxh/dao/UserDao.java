package com.hzkdxh.dao;

import java.util.List;

import com.hzkdxh.bean.User;

public interface UserDao {
	
	/* ��ѯ���������û� */
    public List<User> getUserList();  
    
    /* ����username��ѯָ���û� */
    public User getByUserName(String username);  
    
    /* ����userid��ѯָ���û� */
    public User getByUserId(String userid); 
    
    /* ������û� */
    public boolean addUser(User user);
    
    /* �����û�*/
    public boolean updateUser(User user);    
    
    /* ɾ���û�*/
    public boolean deleteUser(String userid);  
    
    /* ����userid��ȡ��ǰ�û�Ⱥ�������û��б�*/
    public List<User> getMessageListbyUserId(String userid);
    
	public String getUserIdbyLogin(String username, String passwd);
	
	public List<String> getPhoneByCompId(String compid);
}
