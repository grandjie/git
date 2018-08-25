package com.jie.helloservice.test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;

public class Test1 {
//    public static void main(String[] args) throws UnsupportedEncodingException {
//        String str = "中国";
//        byte[] bts = str.getBytes("GBK");
////        String b = new String(bts,"iso-8859-1");
//        for (byte bt : bts) {
//            System.out.println(bt);
//        }
//    }

//    public static void main(String[] args) {
//        String str = "12.000";
//        double b = Double.parseDouble(str);
//        System.out.println((int)b);
//        System.out.println(Integer.valueOf(b));
//    }

//    public static void main(String[] args) {
//        String str = "09";
//        System.out.println(Integer.parseInt(str));
//    }

//    public static void main(String[] args) {
//        String month = "201802";
//        String s1 = month.substring(0, 6);
//        int i1 = Integer.parseInt(s1);
//        String s2 = month.substring(6);
//        int i2 = Integer.parseInt(s2);
//        int days = getDaysByYearMonth(i1, i2) + 1;
//        System.out.println(days);
//    }
//
//    /**
//     * 根据年 月 获取对应的月份 天数
//     *
//     * @param year
//     * @param month
//     * @return
//     */
//    public static int getDaysByYearMonth(int year, int month) {
//        Calendar a = Calendar.getInstance();
//        a.set(Calendar.YEAR, year);
//        a.set(Calendar.MONTH, month - 1);
//        a.set(Calendar.DATE, 1);
//        a.roll(Calendar.DATE, -1);
//        int maxDate = a.get(Calendar.DATE);
//        return maxDate;
//    }

//    public static void main(String[] args) {
//        String str = "20180629";
//        System.out.println(str.substring(6));
//        for (int i = 0; i < 31; i++) {
//            if (Integer.parseInt(str.substring(6)) - i == 0) {
//                System.out.println(i);
//            }
//        }
//    }

//    public static void main(String[] args) {
//        Calendar a = Calendar.getInstance();
//        a.set(Calendar.YEAR, 2018);
//        a.set(Calendar.MONTH, 1);
//        a.set(Calendar.DATE, 1);
//        a.roll(Calendar.DATE, -1);
//        int maxDate = a.get(Calendar.DATE);
//        System.out.println(maxDate);
//    }

//    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.YEAR, 2018 - 1);
//        calendar.set(Calendar.MONTH, 1);
//        System.out.println(calendar.getActualMaximum(Calendar.DATE));
//    }

//    public static void main(String[] args) {
//        test();
//        System.out.println("print");
//    }

//    public static void test() {
//        new Thread(() -> {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("one");
//        }).start();
//    }

//    public static void main(String[] args) {
//        double psSum = 0;
//        double psTotal = 13.1;
//        BigDecimal bigDecimal = psSum == 0 ? BigDecimal.ZERO.setScale(3) : BigDecimal.valueOf(psTotal).divide(BigDecimal.valueOf(psSum), 3, BigDecimal.ROUND_HALF_UP);
////        bigDecimal.setScale(3, BigDecimal.ROUND_HALF_UP);
////        BigDecimal bigDecimal = BigDecimal.ZERO.setScale(3, BigDecimal.ROUND_HALF_UP);
//        System.out.println(psSum == 0);
//        System.out.println(bigDecimal);
//    }

//    public static void main(String[] args) {
//        Stu stu = new Stu();
//        stu.setB1(BigDecimal.ZERO.setScale(3));
//        System.out.println(stu);
//        List<Object> list = new ArrayList<>();
//        list.add(stu);
//        System.out.println(list);
//        System.out.println(stu.getB1());
//    }

//    public static void main(String[] args) {
//        //2147483647
////        System.out.println(Integer.MIN_VALUE);
//        if (1 == 1 && 2 == 2 || 3 == 34) {
//            System.out.println("yes");
//        }
//    }


    public static void main(String[] args) {
        List<String> first = Arrays.asList("1", "2", "3");
        first = new ArrayList<>(first);
        List<String> second = Arrays.asList("4", "2", "3");
        first.removeAll(second);
        for (String s : first) {
            System.out.println(s);
        }
    }

}

class Stu {
    private BigDecimal b1;
    private BigDecimal b2;

    public BigDecimal getB1() {
        return b1;
    }

    public void setB1(BigDecimal b1) {
        this.b1 = b1;
    }

    public BigDecimal getB2() {
        return b2;
    }

    public void setB2(BigDecimal b2) {
        this.b2 = b2;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "b1=" + b1 +
                ", b2=" + b2 +
                '}';
    }
}
