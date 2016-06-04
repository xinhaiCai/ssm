package com.jackie.dao;

import com.jackie.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String resourceId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String resourceId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUserName(String user_name);

    int userCount(String day);//某天的累计用户数

    int activeUserCount(String day);//某天的活跃用户数

    int growUserCount(String day);//某天的用户增长数
}