package com.spring.core.chap01;

public class JapaneseCourse implements Course{
    @Override
    public void combineMenu() {
        System.out.println("-----Menu-----");
        System.out.println("1. Sushi");
        System.out.println("2. Udon");
    }
}
