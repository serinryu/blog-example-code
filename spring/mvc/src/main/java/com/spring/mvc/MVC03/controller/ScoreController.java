package com.spring.mvc.MVC03.controller;

import com.spring.mvc.MVC03.entity.Score;
import com.spring.mvc.MVC03.repository.ScoreRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/*
    학생의 성적정보를 조회하고
    등록하고, 삭제할 수 있는 시스템을 만들어보겠습니다.

    요청 URL 종류

    1. 학생 성적정보 등록화면을 보여주고, 성적정보 목록조회 처리
    /score/list : GET방식 (-> DB변경 없기 때문)
    2. 성적정보 등록 처리 요청
    /score/register : POST방식 (-> DB변경 있기 때문)
    3. 성적정보 삭제 요청
    /score/remove : POST방식 (-> DB변경 있기 때문)
    4. 성적정보 상세 요청
    /score/detail : GET방식 (-> DB변경 없기 때문)
 */

@Controller
@RequestMapping("/score")
//@AllArgsConstructor // 모든 필드에 대해서 초기화하는 생성자 (롬복 애노테이션)
@RequiredArgsConstructor // final 필드에 대해서만 초기화하는 생성자 (롬복 애노테이션)
public class ScoreController { // @Controller 어노테이션 붙었으므로 자동으로 빈으로 생성됨

    // Repository 의 기능을 이용해 데이터를 가져와야 화면에 요청 데이터를 양식에 맞춰 전달

    @Autowired
    private final ScoreRepository repository;
    // DB 연동이 풀리지 않도록 안정적으로 final 필드로 지정
    // final 필드이면 선언과 동시에 반드시 초기화해야함. 40줄 코드 한 줄만 보면 초기화를 안해준 것처럼 보이나, 사실은 초기화가 되어 있는것이 맞음.
    // Why? ScoreRepository 는 Bean 으로 configure 되었고(@Repository), @Autowired 가 이 Bean 을 ScoreController에 주입했음.
    // 즉, Injection 을 통해 자료를 대입해주었으므로 결국 초기화된 것
    // 추가 : 스프링 4.0 이후로는 이처럼 생성자가 1개인 경우(이 경우에는 @RequiredArgsConstructor)에는 @Autowired 을 생략해도 자동 주입

    // 1. 성적등록화면 띄우기 + 정보목록조회
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model){
        System.out.println("/score/list : GET방식");
        List<Score> scoreList = repository.findAll();
        model.addAttribute("scoreList", scoreList);
        return "MVC03/score-list"; // /WEB-INF/views/MVC03/score-list.jsp
    }

    // 2. 성적 정보 등록 처리 요청
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute Score score){
        System.out.println("/score/register : POST방식");
        repository.save(score);
        return "redirect:/score/list";
    }

    // 3. 성적정보 삭제 요청
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(int studentNumber){
        System.out.println("/score/remove : POST방식");
        repository.deleteByStudentNumber(studentNumber);
        return "redirect:/score/list";
    }

    // 4. 성적정보 상세 요청
    @RequestMapping(value = "/detail", method = RequestMethod.GET) // detail?studentNumber=1
    public String detail(@RequestParam int studentNumber, Model model){
        System.out.println("/score/detail : GET방식");
        Score score = repository.findByStudentNumber(studentNumber);
        System.out.println(score);
        // 데이터 전달하여 뷰에 뿌려주기
        model.addAttribute("score", score);
        return "MVC03/detail";
    }

}