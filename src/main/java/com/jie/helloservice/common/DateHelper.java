package com.jie.helloservice.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 门店订货帮助类
 */
public class DateHelper {

    // 通用转换时间
    public static Date convertTimestamp(String date, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(date);
    }

    // 字符串转日期 例如date=2018-07-13
    public static Date convertDate(String date) throws ParseException {
        return convertTimestamp(date, "yyyy-MM-dd");
    }

    // 字符串转日期+时间 例如date=2018-07-13 12:00
    public static Date convertDateTime(String date) throws ParseException {
        return convertTimestamp(date, "yyyy-MM-dd HH:mm");
    }


}
