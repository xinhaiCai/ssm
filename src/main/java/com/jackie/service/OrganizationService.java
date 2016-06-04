package com.jackie.service;

import com.jackie.model.Organization;

import java.util.List;

/**
 * Created by jackie on 2016/3/23.
 */

public interface OrganizationService {
    public Organization selectByPrimaryKey(String id);

    public List<Organization> selectByName(String unitName);

    public List<String> selectPrecodeByName(String unitName);

    /**
     * 对每个前缀编码
     * 子查询 使用索引模糊匹配 'precode%' 查找
     * 父查询 返回每个子校名称为输入名称的详细信息
     */
    public List<Organization> selectByNameAndPrecode(String unitName, String precode);

//    public List<Organization> selectAll();
}
