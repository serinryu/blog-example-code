package com.spring.core.chap05;

import com.spring.core.chap05.config.HotelAutoConfigTwo;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HotelAutoConfigTestTwo {
    // 스프링 컨테이너 생성
    // 아래 코드에서 ac 를 스프링 컨테이너라 한다.
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(HotelAutoConfigTwo.class);

    // 스프링 컨테이너에 등록된 빈 조회
    @Test
    void autoDITest(){
        Hotel hotel = ac.getBean(Hotel.class);
        hotel.inform();
    }
}
