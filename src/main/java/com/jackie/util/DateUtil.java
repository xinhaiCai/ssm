package com.jackie.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by acer on 2016/4/7.
 */
public class DateUtil {

    /**
     * 获取某一个时间段的每一天
     *
     * @param start
     * @param end
     * @return
     */
    public static List<String> everyday(String start, String end) {
        List<String> dates = new ArrayList<String>();
        //待实现
        return dates;
    }

    //获得昨天的日期
    public static String yesterday() {
        return beforeNDay(2);
    }

    //获取N天前的日期,一周前即7天前
    public static String beforeNDay(int n) {
        Date date = new Date();

        int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
        int month = Integer.parseInt(new SimpleDateFormat("MM").format(date));
        int day = Integer.parseInt(new SimpleDateFormat("dd").format(date)) - n + 1;

        if (day < 1) {
            month -= 1;
            if (month == 0) {
                year -= 1;
                month = 12;
            }
            if (month == 4 || month == 6 || month == 9 || month == 11) {
                day = 30 + day;
            } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                day = 31 + day;
            } else if (month == 2) {
                if (year == 0 || (year % 4 == 0 && year != 0)) day = 29 + day;
                else day = 28 + day;
            }
        }
        String y = year + "";
        String m = "";
        String d = "";
        if (month < 10) m = "0" + month;
        else m = month + "";
        if (day < 10) d = "0" + day;
        else d = day + "";

        return y + "-" + m + "-" + d;
    }

    //获得一周前的日期
    public static String lastWeek() {
        return beforeNDay(7);
    }

    public static String today() {
        Date nowTime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String retStrFormatNowDate = sdFormatter.format(nowTime);
        return retStrFormatNowDate;
    }
}
