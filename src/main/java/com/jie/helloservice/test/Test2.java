package com.jie.helloservice.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class Test2 {

    public static void main(String[] args) throws ParseException {
        BigDecimal subtract = BigDecimal.valueOf(18.8).divide(BigDecimal.valueOf(56.4), 7, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(20));
        System.out.println(BigDecimal.valueOf(18.8).subtract(subtract).setScale(2, RoundingMode.HALF_DOWN));
        System.out.println(subtract);
        //master edit3
        //test edit2
    }
}
