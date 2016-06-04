package com.jackie.dao.impl;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by jackie on 2016/3/24.
 */
@Repository
public class BaseDao<T> extends SqlSessionDaoSupport {

    public BaseDao() {

    }

    private static final Logger logger = Logger.getLogger(Thread
            .currentThread().getStackTrace()[1].getClassName());

    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    //    @Resource(name = "sqlSession")
    protected SqlSession sqlSession;

    @PostConstruct
    public void SqlSessionFactory() {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    //
//    public SqlSessionFactory getSqlSessionFactory(){
//        return sqlSessionFactory;
//    }
//
    @Override
    public SqlSession getSqlSession() {
        if (sqlSession == null) {
            //BaseDao是基类，每个子类在被调用时才会初始化一次自己的sqlSession
            logger.warn("sqlSession为空，从sqlSessionFactory获取sqlSession");
            sqlSession = sqlSessionFactory.openSession();
        }
        return sqlSession;
    }

    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int deleteByPrimaryKey(String id) {
        SqlSession sqlSession = getSqlSession();
        T u = sqlSession.selectOne("deleteByPrimaryKey", id);
        return 0;
    }


    public int insert(T record) {
        return 0;
    }


    public int insertSelective(T record) {
        return 0;
    }


    public List<T> selectAll() {
        SqlSession sqlSession = getSqlSession();
        List<T> list = sqlSession.selectList("selectAll");
        return list;
    }

//    public T selectByPrimaryKey(Integer id) {
//        SqlSession sqlSession = getSqlSession();
//        T u =sqlSession.selectOne("selectByPrimaryKey",id);
//        return u;
//    }

    public T selectByPrimaryKey(String id) {
        SqlSession sqlSession = getSqlSession();
        T u = sqlSession.selectOne("selectByPrimaryKey", id);
        return u;
    }


    public int updateByPrimaryKeySelective(T record) {
        return 0;
    }


    public int updateByPrimaryKey(T record) {
        return 0;
    }
}
