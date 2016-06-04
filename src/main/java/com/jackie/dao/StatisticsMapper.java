package com.jackie.dao;

import com.jackie.model.Statistics;

public interface StatisticsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Statistics record);

    int insertSelective(Statistics record);

    Statistics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Statistics record);

    int updateByPrimaryKey(Statistics record);

    int userCount(String day);//某天的累计用户数

    int activeUserCount(String day);//某天的活跃用户数

    int growUserCount(String day);//某天的用户增长数

    Statistics selectByCreateTime(String day);
}