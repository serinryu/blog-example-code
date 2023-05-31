package com.spring.mvc.MVC03.repository;

/*
    역할 명세(추상화)
    1. 전체 성적 조회
    2. 개별 성적 조회
    3. 성적 삭제
    4. 성적 등록
 */

import com.spring.mvc.MVC03.entity.Score;

import java.util.List;

public interface ScoreRepository {

    // 전체 성적 가져오기
    public List<Score> findAll();

    // 성적 정보 등록
    boolean save(Score score); // 입력할 테이블 정보를 넘겨줘야함. 리턴자료는 boolean인데 등록 성공시 true, 실패시 false를 리턴

    // 성적 정보 한 개 삭제
    boolean deleteByStudentNumber(int studentNumber);

    // 성적 개별 조회
    Score findByStudentNumber(int studentNumber);

}