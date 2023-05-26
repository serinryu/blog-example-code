package com.spring.core.chap02.config;

import com.spring.core.chap02.*;

// 구현 객체를 생성하고 연결하는 책임은 AppConfig(HotelManager)가 담당한다.(구성영역)
// 클라이언트 객체는 오직 실행하는 책임만 담당한다.(사용영역)
public class HotelManager {
    public Chef chef(){
        return new KoreanChef();
        //return new JapaneseChef();
        //return new ChineseChef();
    }
    public Course course(){
        return new KoreanCourse();
        //return new JapaneseCourse();
        //return new ChineseCourse();
    }
    public Restaurant restaurant(){
        return new FusionRestaurant(chef(), course());
    }
    public Hotel hotel(){
        return new Hotel(restaurant(), chef());
    }
}