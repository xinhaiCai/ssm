package com.jackie.dao.impl;

import com.jackie.dao.OrganizationMapper;
import com.jackie.model.Organization;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jackie on 2016/3/23.
 */
@Repository
public class OrganizationDao extends BaseDao<Organization> implements OrganizationMapper {
    @Override
    public int deleteByPrimaryKey(Integer uId) {
        return 0;
    }


    public List<String> selectPrecodeByName(String unitName) {
        SqlSession sqlSession = getSqlSession();
        List<String> uList = sqlSession.selectList("com.jackie.dao.OrganizationMapper.selectPrecodeByName", unitName);
        return uList;
    }

    public List<Organization> selectByNameAndPrecode(String unitName, String precode) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", unitName);
        map.put("code", precode);
        SqlSession sqlSession = getSqlSession();
        List<Organization> uList = sqlSession.selectList("com.jackie.dao.OrganizationMapper.selectByNameAndPrecode", map);
        return uList;
    }

    @Override
    public List<Organization> selectByName(String unitName) {
        SqlSession sqlSession = getSqlSession();
        List<Organization> uList = sqlSession.selectList("com.jackie.dao.OrganizationMapper.selectByName", unitName);
        return uList;
    }

    @Override
    public int insert(Organization record) {
        return 0;
    }

    @Override
    public int insertSelective(Organization record) {
        return 0;
    }

    @Override
    public Organization selectByPrimaryKey(String id) {
        SqlSession sqlSession = getSqlSession();
        Organization u = sqlSession.selectOne("com.jackie.dao.OrganizationMapper.selectByPrimaryKey", id);
        return u;
    }

    @Override
    public int updateByPrimaryKeySelective(Organization record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Organization record) {
        return 0;
    }
}
