package com.spring.core.chap04;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.core.chap04.config.HotelAutoConfig;

public class HotelAutoConfigTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(HotelAutoConfig.class);

    @Test
    void autoDITest(){
        Hotel hotel = ac.getBean(Hotel.class);
        hotel.inform();
    }
}
