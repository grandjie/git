package com.jie.helloservice.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;

public class DateTest2 {

    public static void main(String[] args) {
        //取当前时间
        LocalDate today = LocalDate.now();
        LocalDate crischristmas = LocalDate.of(2018, 8, 16);
        // 严格按照ISO yyyy-MM-dd验证，02写成2都不行，当然也有一个重载方法允许自己定义格式
        LocalDate endOfFeb = LocalDate.parse("2014-02-28");
//        LocalDate.parse("2014-02-29");

        //日期转换
        // 取本月第1天：
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth()); // 2018-08-01
        // 取本月第2天：
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2); // 2018-08-02
        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth()); // 2018-08-31
        // 取下一天：
        LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1); // 变成了2018-09-01
        // 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
        LocalDate firstMondayOf2015 = LocalDate.parse("2019-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // 2019-01-07

        //LocalTime包含毫秒
        LocalTime now = LocalTime.now(); // 11:09:09.240

        //LocalTime清除毫秒数
        LocalTime now2 = LocalTime.now().withNano(0); // 11:09:09

        //构造时间也很简单
        LocalTime zero = LocalTime.of(0, 0, 0); // 00:00:00
        LocalTime zero2 = LocalTime.of(0, 0, 1); // 00:00:00
        LocalTime mid = LocalTime.parse("12:00:00"); // 12:00:00
        LocalTime mid2 = LocalTime.parse("12:01:01"); // 12:00:00
        LocalTime mid3 = LocalTime.parse("12:00:01"); // 12:00:00
    }
}
