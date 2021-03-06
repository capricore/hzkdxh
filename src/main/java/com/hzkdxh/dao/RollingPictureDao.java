package com.hzkdxh.dao;

import java.util.List;

import com.hzkdxh.bean.RollingPicture;

public interface RollingPictureDao {
	
	/* 查询表中文件列表 */
    public List<RollingPicture> getListBySequence();
    
    /* 根据objectid查询指定文件*/
    public RollingPicture getById(String id); 
    
    /* 添加文件*/
    public boolean addRollingPicture(RollingPicture rollingPicture);
    
    /* 更新文件*/
    public boolean updateRollingPicture(RollingPicture rollingPicture);
    
    /* 删除文件*/
    public boolean deleteRollingPicture(String id);

}
