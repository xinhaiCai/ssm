package com.jackie.service.impl;

import com.jackie.dao.StatisticsMapper;
import com.jackie.model.Statistics;
import com.jackie.service.StatisticsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jackie on 2016/4/7.
 */
@Service("statisticsService")
public class StatisticsServiceImpl implements StatisticsService {

    @Resource
    private StatisticsMapper statisticsDao;

    @Override
    public Statistics selectByCreateTime(String day) {
        return statisticsDao.selectByCreateTime(day);
    }

    @Override
    public int userCount(String day) {
        return statisticsDao.userCount(day);
    }

    @Override
    public int activeUserCount(String day) {
        return statisticsDao.activeUserCount(day);
    }

    @Override
    public int growUserCount(String day) {
        return statisticsDao.growUserCount(day);
    }
}
