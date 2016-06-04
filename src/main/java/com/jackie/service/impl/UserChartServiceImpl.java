package com.jackie.service.impl;

import com.jackie.dao.UserMapper;
import com.jackie.service.UserChartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jackie on 2016/4/7.
 */
@Service("userChartService")
public class UserChartServiceImpl implements UserChartService {
    @Resource
    private UserMapper userDao;

    @Override
    public int userCount(String day) {
        return userDao.userCount(day);
    }

    @Override
    public int activeUserCount(String day) {
        return userDao.activeUserCount(day);
    }

    @Override
    public int growUserCount(String day) {
        return userDao.growUserCount(day);
    }
}
