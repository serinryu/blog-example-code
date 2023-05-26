package com.spring.core.chap02;

public class FusionRestaurant implements Restaurant {
    private Chef chef;
    private Course course;

    // FusionRestaurant constructor 내부에서 chef 와 course 를 결정하지 않도록 수정했다. 외부에서 받아서 옴.
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
