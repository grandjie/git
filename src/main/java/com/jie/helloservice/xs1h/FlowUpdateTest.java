package com.jie.helloservice.xs1h;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FlowUpdateTest {

    public static void main(String[] args) {
        String str = "1200";
        double b1 = 1000;
        int b2 = 21;
        System.out.println(b1 / b2);
        System.out.println(str.substring(0, 2));
        System.out.println(str.substring(2, 4));
//        SimpleDateFormat sdf = new SimpleDateFormat();
//        System.out.println(date);
//        String s = autoGenericCode("17", 2);
//        System.out.println(s);
    }

    @Test
    public void test() {
//        this.printToConsole(autoGenericCode("10011"));
//        this.printToConsole(autoGenericCode("000",3));
    }

    /**
     * 不够位数的在前面补0，保留code的长度位数字
     *
     * @param code
     * @return
     */
    private String autoGenericCode(String code) {
        String result = "";
        // 保留code的位数
        result = String.format("%0" + code.length() + "d", Integer.parseInt(code) + 1);

        return result;
    }

    /**
     * 不够位数的在前面补0，保留num的长度位数字
     *
     * @param code
     * @return
     */
    private static String autoGenericCode(String code, int num) {
        String result = "";
//        保留num的位数
//    　　 0 代表前面补充0
//        num 代表长度为4
//        d 代表参数为正数型
        result = String.format("%0" + num + "d", Integer.parseInt(code));

        return result;
    }

}