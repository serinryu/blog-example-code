package com.spring.core.chap01;

public class Hotel {
    private Restaurant restaurant;
    private Chef chef;

    // 호텔의 restaurant 과 chef 를 바꾸기 위해서는, Hotel constructor 내부를 건들여야 한다.
    public Hotel(){
        restaurant = new FusionRestaurant();
        chef = new KoreanChef();
        // chef = new JapaneseChef();
        // chef = new KoreanChef();
    }
    public void inform(){
        String chefName = chef.getClass().getSimpleName();
        String restaurantName = restaurant.getClass().getSimpleName();
        System.out.println("Our hotel restaurant is " + restaurantName + ", and a chef is " + chefName + ".");
        restaurant.order();
    }
}
