package com.spring.core.chap04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fs") // fusion restaurant 의 경우, chef 와 course 주입이 필요함
public class FusionRestaurant implements Restaurant {
    // Field Injection
    @Autowired 
    private Chef chef; // 스프링 빈으로 등록되어 있는 것 중 Chef type 이 2개이므로 Autowired 는 cannot determine -> error
    @Autowired
    private Course course; // 스프링 빈으로 등록되어 있는 것 중 Course type 이 1개이므로 찾아서 자동 주입

    public FusionRestaurant(Chef chef, Course course){
        this.chef = chef;
        this.course = course;
    }

    //@Qualifier: 여러 개의 빈이 등록되어 있을 때, 어떤 빈을 주입할지 선택하기 위한 아노테이션입니다.
    public FusionRestaurant(@Qualifier("cc") Chef chef, Course course){
        this.chef = chef;
        this.course = course;
    }

    @Override
    public void order() {
        System.out.println("Here is a Fusion Restaurant. Chef will provide the course that is not his/her specialized field.");
        course.combineMenu();
        chef.cook();
    }
}
