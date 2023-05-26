package com.spring.core.chap03.config;

import com.spring.core.chap03.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 구현 객체를 생성하고 연결하는 책임은 AppConfig(HotelConfig)가 담당한다.(구성영역)
// 클라이언트 객체는 오직 실행하는 책임만 담당한다.(사용영역)

@Configuration
public class HotelConfig {

    @Bean
    public Chef chef(){
        return new KoreanChef();
        //return new JapaneseChef();
        //return new ChineseChef();
    }

    @Bean
    public Course course(){
        return new KoreanCourse();
        //return new JapaneseCourse();
        //return new ChineseCourse();
    }

    @Bean
    public Restaurant restaurant(){
        return new FusionRestaurant(chef(), course());
    }

    @Bean
    public Hotel hotel(){
        return new Hotel(restaurant(), chef());
    }
}
