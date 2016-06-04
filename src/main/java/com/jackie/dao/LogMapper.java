package com.jackie.dao;

import com.jackie.model.Log;

public interface LogMapper {
    int deleteByPrimaryKey(String resouceId);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(String resouceId);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}