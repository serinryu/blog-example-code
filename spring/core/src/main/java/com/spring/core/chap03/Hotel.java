package com.spring.core.chap03;

public class Hotel {

    private Restaurant restaurant;
    private Chef chef;

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
