package com.spring.core.chap05;

import org.springframework.stereotype.Component;

@Component("cc")
public class ChineseChef implements Chef {
    @Override
    public void cook() {
        System.out.println("I'm Chinese Chef!");
    }
}
