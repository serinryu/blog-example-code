package com.spring.core.chap03;

public class ChineseCourse implements Course {
    @Override
    public void combineMenu() {
        System.out.println("-----Menu-----");
        System.out.println("1. Chinese chicken");
        System.out.println("2. Maratang");
    }
}
