package com.jie.helloservice.Algorithm;

import java.util.GregorianCalendar;

class Demo<T extends Comparable<? super T>> {
}

public class Generic {
    public static void main(String[] args) {
        Demo<GregorianCalendar> p = null;
    }
}

