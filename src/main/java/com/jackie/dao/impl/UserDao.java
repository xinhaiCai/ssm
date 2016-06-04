package com.jackie.dao.impl;

import com.jackie.dao.UserMapper;
import com.jackie.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * Created by jackie on 2016/3/23.
 */
@Repository
public class UserDao extends BaseDao<User> implements UserMapper {

    @Override
    public int userCount(String day) {
        SqlSession sqlSession = getSqlSession();
        int count = sqlSession.selectOne("com.jackie.dao.UserMapper.userCount", day);
        return count;
    }

    @Override
    public int activeUserCount(String day) {
        SqlSession sqlSession = getSqlSession();
        int count = sqlSession.selectOne("com.jackie.dao.UserMapper.activeUserCount", day);
        return count;
    }

    @Override
    public User selectByUserName(String user_name) {
        SqlSession sqlSession = getSqlSession();
        return sqlSession.selectOne("com.jackie.dao.UserMapper.selectByUserName", user_name);
    }

    @Override
    public int growUserCount(String day) {
        SqlSession sqlSession = getSqlSession();
        int count = sqlSession.selectOne("com.jackie.dao.UserMapper.growUserCount", day);
        return count;
    }

}
