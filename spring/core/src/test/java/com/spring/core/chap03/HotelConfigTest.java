package com.spring.core.chap03;

import com.spring.core.chap03.config.HotelConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HotelConfigTest {
    // Create Spring Container, ac
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(HotelConfig.class);

    // Get Bean from Spring Container
    @Test
    void springDITest(){
        Hotel hotel = ac.getBean(Hotel.class);
        hotel.inform();
        //Chef chef = ac.getBean(Chef.class);
        //chef.cook();
    }
}
