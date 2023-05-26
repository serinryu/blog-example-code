package com.spring.core.chap05.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.spring.core.chap05") // component scan 의 범위
public class HotelAutoConfigTwo {

}
