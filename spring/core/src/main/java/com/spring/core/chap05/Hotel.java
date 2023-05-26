package com.spring.core.chap05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Hotel {
    private Restaurant restaurant;
    private Chef chef;

    @Autowired // Constructor Injection
    //현재 스프링 컨테이너에 Chef type 으로 "cc", "jc" 가 두 개 있으므로 지정이 필요하므로 @Qualifier("cc") 으로 지정.
    public Hotel(Restaurant restaurant, @Qualifier("cc") Chef chef){
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
