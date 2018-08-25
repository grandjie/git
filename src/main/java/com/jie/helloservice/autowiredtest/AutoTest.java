package com.jie.helloservice.autowiredtest;

import org.springframework.beans.factory.annotation.Autowired;

public class AutoTest {

    @Autowired
    private User user;

    private String school;

    public AutoTest() {
        this.school = user.getName();
    }
}
