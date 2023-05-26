package com.spring.core.chap04;

import org.springframework.stereotype.Component;

@Component("jc")
public class JapaneseChef implements Chef {
    @Override
    public void cook() {
        System.out.println("I'm Japanese Chef!");
    }
}
