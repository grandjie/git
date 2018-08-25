package com.jie.helloservice.test;

public class OuterClass {
    public static class InnerClass {
        InnerClass() {
            System.out.println("============= 我是一个内部类'InnerClass' =============");
        }
    }
}

