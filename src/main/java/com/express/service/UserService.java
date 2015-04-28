package com.express.service;

import java.util.List;

import com.express.bean.User;

public interface UserService {
	/* ��ѯ���������û� */
    public List<User> getUserList();  
    
    /* ����username��ѯָ���û� */
    public User getByUserName(String username);  
    
    /* ����userid��ѯָ���û� */
    public User getByUserId(String userid); 
    
    /* ������û� */
    public boolean addUser(User user);

}
