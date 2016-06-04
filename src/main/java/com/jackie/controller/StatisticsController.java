package com.jackie.controller;

import com.jackie.model.Statistics;
import com.jackie.service.StatisticsService;
import com.jackie.util.DateUtil;
import com.jackie.util.RedisManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jackie on 2016/5/23.
 */
@Controller
@RequestMapping("/user/chart")
public class StatisticsController {
    private Logger logger = Logger.getLogger(StatisticsController.class);
    @Autowired
    public StatisticsService statisticsService;

    /**
     * 返回对比某一天的用户累计、活跃、新增数量的统计图表
     *
     * @param date  某一天
     * @param model
     * @return
     */
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public
    @ResponseBody
    HashMap<String, Statistics> QueryUserChart(@RequestParam(value = "date") String date, Model model) {
        Statistics today = statisticsService.selectByCreateTime(DateUtil.today());
        Statistics anotherDay = statisticsService.selectByCreateTime(date);
        HashMap<String, Statistics> map = new HashMap<String, Statistics>();
        map.put("today", today);
        map.put("anotherDay", anotherDay);

        return map;
    }

    /**
     * 返回过去一周活跃用户数统计图表
     *
     * @param model
     * @return
     */
    @RequestMapping("/active")
    public String QueryActiveUserChart(Model model) {
        List<String> dates = new ArrayList<String>();

        RedisManager redisManager = new RedisManager();
        redisManager.uniqueCount("register", DateUtil.today());
        int activeUserCount = redisManager.uniqueCount("login", DateUtil.today());
        redisManager.uniqueCount("register", DateUtil.today());

        redisManager.uniqueCount("register", DateUtil.lastWeek());
        int lastWeekActiveUserCount = redisManager.uniqueCount("login", DateUtil.lastWeek());
        redisManager.uniqueCount("register", DateUtil.lastWeek());
//        System.out.println(activeUserCount+":"+lastWeekActiveUserCount);

        StringBuilder dateBuilder = new StringBuilder();
        StringBuilder countBuilder = new StringBuilder();
        for (int i = 7; i >= 1; i--) {
            dateBuilder.append(DateUtil.beforeNDay(i));
            dateBuilder.append(' ');
            countBuilder.append(redisManager.uniqueCount("login", DateUtil.beforeNDay(i)));
            countBuilder.append(' ');
        }

//        System.out.println(dateBuilder.toString().trim());
//        System.out.println(countBuilder.toString());
        model.addAttribute("counts", countBuilder.toString().trim());
        model.addAttribute("dates", dateBuilder.toString().trim());
        return "active_user_chart";
    }


    @RequestMapping("")
    public String defaultResult() {
        return "user_chart";
    }
}
