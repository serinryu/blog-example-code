package com.spring.mvc.MVC03.entity;

import lombok.*;
// @Data 대신 세부적으로 설정 (더 안전)
@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor //모든 멤버변수를 다 요구하는 생성자
public class Score {

    // 성적은 어떻게 구성되어 있는가?
    // entity계층에 score라는 정보가 어떻게 구성되는지 먼저 정의하고 score 객체에 담아와서 처리

    private String name; //학생의 이름
    private int korScore; // 국어 성적
    private int engScore; // 영어 성적
    private int mathScore; // 수학 성적

    private int studentNumber; // 학번
    private int total; // 총점
    private double average; // 평균
}