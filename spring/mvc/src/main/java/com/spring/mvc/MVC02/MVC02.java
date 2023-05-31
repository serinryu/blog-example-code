package com.spring.mvc.MVC02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/MVC02")
public class MVC02 {

    /*
    TOPIC : Response Handling
    Spring MVC에서 JSP로 데이터를 전달하는 방법으로는 Model과 ModelAndView가 있습니다.
    */

    // 1. Model 객체를 사용해 뷰(view) 로 데이터 전달하기
    // Model은 컨트롤러에서 View로 데이터를 전달하기 위한 객체입니다.
    // View에서는 Model에 저장된 데이터를 참조하여 출력할 수 있습니다.
    @RequestMapping("/hobbies") // /MVC02/hobbies
    public String hobbies(Model model){ // .jsp로 자바 변수를 보내려면 Model을 선언부에 선언합니다.
        String name = "룰루";
        List<String> hobbies = List.of("밥먹기", "낮잠자기", "쥐잡기");// List 자료형 생성 및 자료저장

        // .jsp 파일로 보낼 자료들을 적재
        // addAttribute() 메소드를 사용하여 key-value 형태로 데이터를 추가합니다.
        model.addAttribute("n", name);
        model.addAttribute("hList", hobbies);

        // /WEB-INF/views/chap02/hobbies.jsp
        return "/chap02/hobbies";
    }

    // 2. ModelAndView 객체를 사용해 뷰(view) 로 데이터 전달하기
    @GetMapping("/hobbies2") // /MVC02/hobbies2
    public ModelAndView hobbies2(){
        // .jsp파일(view단) 으로 보내고 싶은 자료 설정
        String name = "참참이";
        List<String> hList = List.of("전깃줄에서 꾸벅꾸벅 졸기", "쌀주워먹기", "짹짹소리내기");

        // 목적지 뷰 이름 적기(포워딩 방식)
        // /WEB-INF/views/chap02/hobbies.jsp
        String viewName = "chap02/hobbies";

        // ModelAndView 객체 생성 및 세팅하기
        ModelAndView mv = new ModelAndView();
        // 목적지 뷰 이름 입력
        mv.setViewName(viewName);
        // 목적지로 보낼 데이터 입력
        mv.addObject("n",  name);
        mv.addObject("hList", hList);
        // 설정 완료된 ModelAndView 리턴
        return mv; // ModelAndView 방식 컨트롤러 메서드는 리턴자료형이 ModelAndView 객체
    }



    /*
    ModelAndView 예시 : POST 방식으로 들어온 데이터 response 하기
    */

    @RequestMapping(value="/foodform", method= RequestMethod.GET)
    public String foodForm(){
        return "chap02/foodform";
    }

    // 폼에서 날려준 데이터를 view단으로 보내주는 메서드
    @RequestMapping(value="/foodorder", method=RequestMethod.POST)
    public ModelAndView foodOrder(String customerName,
                                  int tableNumber,
                                  String orderFoodName){
        // ModelAndView 객체 준비
        ModelAndView mv = new ModelAndView();
        // 데이터 적재
        mv.addObject("customerName", customerName);
        mv.addObject("tableNumber", tableNumber);
        mv.addObject("orderFoodName", orderFoodName);
        // 결과 view 파일 지정
        mv.setViewName("chap02/foodresult");

        return mv;
    }

}