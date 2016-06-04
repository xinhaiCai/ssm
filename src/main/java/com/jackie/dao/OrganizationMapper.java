package com.jackie.dao;

import com.jackie.model.Organization;

import java.util.List;

public interface OrganizationMapper {
    int deleteByPrimaryKey(String resourceId);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(String resourceId);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);

    List<Organization> selectByName(String unitName);

    List<String> selectPrecodeByName(String unitName);

    List<Organization> selectByNameAndPrecode(String unitName, String precode);

}