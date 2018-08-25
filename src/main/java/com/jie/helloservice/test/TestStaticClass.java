package com.jie.helloservice.test;


public class TestStaticClass {
    public static void main(String[] args) {
        // 不需要new一个InnerClass
        new OuterClass.InnerClass();
    }
}
