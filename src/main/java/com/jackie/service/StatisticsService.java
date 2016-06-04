package com.jackie.service;

import com.jackie.model.Statistics;

/**
 * Created by jackie on 2016/3/23.
 */

public interface StatisticsService {
    /**
     * 统计某天的累计用户数
     *
     * @param day 指定某一天
     * @return
     */
    int userCount(String day);

    /**
     * 统计某天的活跃用户数
     *
     * @param day 指定某一天
     * @return
     */
    int activeUserCount(String day);

    /**
     * 统计某天的用户增长数
     *
     * @param day 指定某一天
     * @return
     */
    int growUserCount(String day);

    Statistics selectByCreateTime(String day);
}
