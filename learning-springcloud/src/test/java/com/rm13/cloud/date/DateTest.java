package com.rm13.cloud.date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

public class DateTest {
    public static void main(String[] args) {

    /*
        获取一段日期
        RANGE_WEEK_SUNDAY 从周日开始获取一周日期
        RANGE_WEEK_MONDAY 从周一开始获取一周日期
        RANGE_WEEK_RELATIVE 从当前时间开始获取一周日期
        RANGE_WEEK_CENTER 以当前日期为中心获取一周日期
        RANGE_MONTH_SUNDAY 从周日开始获取一个月日期
        RANGE_MONTH_MONDAY 从周一开始获取一个月日期
        */
        Date date = new Date();
        date = DateUtils.addDays(date, -1);
        Iterator<Calendar> iterator = DateUtils.iterator(date, DateUtils.RANGE_MONTH_SUNDAY);
        while (iterator.hasNext()) {
            Calendar next = iterator.next();
            System.out.println(DateFormatUtils.format(next, "yyyy-MM-dd"));
        }
    }
}
