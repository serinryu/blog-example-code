package com.spring.core.chap01;

public class FusionRestaurant implements Restaurant{
    private Chef chef;
    private Course course;

    // fushion restaurant 의 chef 와 course 를 바꾸기 위해서는, FusionRestaurant constructor 내부를 건들여야 한다.
    public FusionRestaurant(){
        chef = new ChineseChef();
        // chef = new JapaneseChef();
        // chef = new KoreanChef();
        course = new ChineseCourse();
        // course = new JapaneseCourse();
        // course = new KoreanCourse();
    }
    @Override
    public void order() {
        System.out.println("Here is a Fusion Restaurant.");
        course.combineMenu();
        chef.cook();
    }
}
