package com.spring.core.chap02;

public class Hotel {

    private Restaurant restaurant;
    private Chef chef;

    // Hotel constructor 내부에서 restaurant 와 chef 를 결정하지 않도록 수정했다. 외부에서 받아서 옴.
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
