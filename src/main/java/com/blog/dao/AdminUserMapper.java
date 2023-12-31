package com.blog.dao;

import com.blog.entity.AdminUser;
import org.apache.ibatis.annotations.Param;

public interface AdminUserMapper {
    // int deleteByPrimaryKey(Integer adminUserId);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    /**
     * 登录方法
     * @param userName
     * @param password
     * @return
     */
    AdminUser login(@Param("userName") String userName, @Param("password") String password);

    AdminUser selectByPrimaryKey(Integer adminUserId);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
}