package com.jie.helloservice.autowiredtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testing {

    @GetMapping("/test")
    public void test() {
        AutoTest autoTest = new AutoTest();
    }
}
