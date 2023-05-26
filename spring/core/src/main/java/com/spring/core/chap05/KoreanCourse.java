package com.spring.core.chap05;

public class KoreanCourse implements Course {
    @Override
    public void combineMenu() {
        System.out.println("-----Menu-----");
        System.out.println("1. tteokbokki");
        System.out.println("2. korean pancake");
    }
}
