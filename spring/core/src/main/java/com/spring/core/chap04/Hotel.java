package com.spring.core.chap04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Hotel {
    // Field Injection
    @Autowired 
    private Restaurant restaurant; // 현재 스프링빈으로 등록되어 있는 restaurant 가 1개 ("fs") 이므로 바로 자동 주입 완료.
    @Autowired
    private Chef chef; // 스프링빈으로 등록되어있는 Chef type 이 2개라면 Autowired 은 cannot determine -> error

    public Hotel(Restaurant restaurant, Chef chef){
        this.restaurant = restaurant;
        this.chef = chef;
    }
    public void inform(){
        String chefName = chef.getClass().getSimpleName();
        String restaurantName = restaurant.getClass().getSimpleName();
        System.out.println("Our hotel restaurant is " + restaurantName + ", and a chef is " + chefName + ".");
        restaurant.order();
    }
}
