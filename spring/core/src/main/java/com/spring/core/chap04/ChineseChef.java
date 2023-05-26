package com.spring.core.chap04;

import org.springframework.stereotype.Component;

@Component("cc") // 해당 클래스의 객체를 스프링 컨테이너에 자동으로 등록, 별칭은 "cc"
public class ChineseChef implements Chef {
    @Override
    public void cook() {
        System.out.println("I'm Chinese Chef!");
    }
}
