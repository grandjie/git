package com.jie.helloservice.controller;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest {
    public static void main(String[] args) {
        System.out.println("111");
        List<String> list = new ArrayList<>();
        list.add("222");
        new Thread(() -> test(list)).start();
        System.out.println("333");
    }

    public static void test(List<String> list) {
        System.out.println(list.get(0));
    }
}
