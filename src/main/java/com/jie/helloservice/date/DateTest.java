package com.jie.helloservice.date;

import com.jie.helloservice.common.DateHelper;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTest {

    public static void main(String[] args) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date date = DateHelper.convertDate(LocalDate.now().format(formatter));
        System.out.println(date);
        Date date1 = DateHelper.convertDate(LocalDate.now().plusDays(1).format(formatter));
        System.out.println(date1);
        LocalDate parse = LocalDate.parse("2016-10-25", formatter);
        System.out.println(parse.getMonth());
    }
}
