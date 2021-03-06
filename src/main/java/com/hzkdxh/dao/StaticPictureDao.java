package com.hzkdxh.dao;

import java.util.List;

import com.hzkdxh.bean.StaticPicture;

public interface StaticPictureDao {
	
	/* 查询表中图片列表 */
    public List<StaticPicture> getPicturetList();
    
    /* 根据id查询指定图片*/
    public StaticPicture getById(String id); 
    
    /* 添加文件*/
    public boolean addStaticPicture(StaticPicture staticPicture);
    
    /* 更新文件*/
    public boolean updateStaticPicture(StaticPicture staticPicture);
    
    /* 删除文件*/
    public boolean deleteStaticPicture(String id);

}
