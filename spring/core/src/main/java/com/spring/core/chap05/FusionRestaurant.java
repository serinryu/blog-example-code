package com.spring.core.chap05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fs")
public class FusionRestaurant implements Restaurant {
    private Chef chef;
    private Course course;

    // Setter Injection
    // 주입받을 파라미터 왼쪽에 @Qualifier("빈이름") 을 입력하면, 지정 주입이 가능합니다.
    @Autowired
    public void setChef(@Qualifier("cc") Chef chef){
        this.chef = chef;
    }
    @Autowired
    public void setCourse(@Qualifier("cco") Course course){
        this.course = course;
    }
    public FusionRestaurant(){}; // Setter주입시 @Qualifier를 사용하는 경우, 디폴트 생성자가 오버로딩 되어있어야 합니다.

    @Override
    public void order() {
        System.out.println("Here is a Fusion Restaurant. Chef will provide the course that is not his/her specialized field.");
        course.combineMenu();
        chef.cook();
    }
}
