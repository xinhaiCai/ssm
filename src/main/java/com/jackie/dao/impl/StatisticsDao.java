package com.jackie.dao.impl;

import com.jackie.dao.StatisticsMapper;
import com.jackie.model.Statistics;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * Created by jackie on 2016/3/23.
 */
@Repository
public class StatisticsDao extends BaseDao<Statistics> implements StatisticsMapper {


    @Override
    public Statistics selectByCreateTime(String day) {
        SqlSession sqlSession = getSqlSession();
        Statistics s = sqlSession.selectOne("com.jackie.dao.StatisticsMapper.selectByCreateTime", day);
        return s;
    }

    @Override
    public Statistics selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int userCount(String day) {
        SqlSession sqlSession = getSqlSession();
        int count = sqlSession.selectOne("com.jackie.dao.StatisticsMapper.userCount", day);
        return count;
    }

    @Override
    public int activeUserCount(String day) {
        SqlSession sqlSession = getSqlSession();
        int count = sqlSession.selectOne("com.jackie.dao.StatisticsMapper.activeUserCount", day);
        return count;
    }

    @Override
    public int growUserCount(String day) {
        SqlSession sqlSession = getSqlSession();
        int count = sqlSession.selectOne("com.jackie.dao.StatisticsMapper.growUserCount", day);
        return count;
    }
}
