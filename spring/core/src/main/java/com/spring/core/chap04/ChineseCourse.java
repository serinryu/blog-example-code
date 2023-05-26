package com.spring.core.chap04;

import org.springframework.stereotype.Component;

@Component("cco")
public class ChineseCourse implements Course {
    @Override
    public void combineMenu() {
        System.out.println("-----Menu-----");
        System.out.println("1. Chinese chicken");
        System.out.println("2. Maratang");
    }
}
