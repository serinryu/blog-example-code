package com.spring.core.chap03;

public class FusionRestaurant implements Restaurant {
    private Chef chef;
    private Course course;

    public FusionRestaurant(Chef chef, Course course){
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
