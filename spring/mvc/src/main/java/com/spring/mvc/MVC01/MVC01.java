package com.spring.mvc.MVC01;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // 해당 어노테이션이 있어야, 스프링 코어가 관리하는 컨트롤러가 됨.
public class MVC01 {

    /*
    HTTP Request Method에는 다양한 방식이 있지만, 그 중 가장 많이 사용되는 GET 방식과 POST 방식에 대해 알아보겠습니다.
    GET 방식에서는 Query String 로 Request 를 전달한다.
    POST 방식에서는 Request Body 를 통해 Request 를 전달한다.
     */

    @RequestMapping("/open-hello")
    public String hello(){
        System.out.println("🌐🌐접속 감지 🌐🌐");
        // prefix - /WEB-INF/views
        // suffix - .jsp
        // Result : /WEB-INF/views/hello.jsp
        return "MVC01/hello"; // Forward 방식 : 같은 Request-Response 사이클을 유지한다.
    }

    @GetMapping("/example")
    public String example() {
        // redirect:/URL 형태로 URL을 지정하면, 해당 URL로 Redirect합니다.
        return "redirect:/open-hello"; // Redirect 방식 : 새로운 Request-Response 사이클이 시작된다.
    }

    @RequestMapping("/loginform")
    public String loginform(){
        return "MVC01/loginform"; // 아이디, 비밀번호를 각각 id, pw라는 name에 실어서 전달해주는 폼을 보여줌.
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public String login(String id, String pw){
        System.out.println("아이디 : " + id);
        System.out.println("비밀번호 : " + pw);
        return "";
    }


    /*
    Request Handling 4가지 방법 정리
     */

    // 1. HttpServletRequest 객체 사용
    // 원시적인 JSP 에서 쓰는 방법
    // HttpServletRequest의 핵심 기능은 Http Servlet의 Request를 받아서 꺼내서 쓸 수 있다는 것이다.
    // 따라서, HttpServletRequest 객체를 사용하여 Query String의 값을 읽어올 수도 있다.
    @GetMapping("/personone") // /personone?name=ryu&age=20
    public String getReqParm1(HttpServletRequest request) {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println(name);
        System.out.println(age);
        return "";
    }

    // 2. @RequestParam 사용하기
    // @RequestParam 은 생략 가능
    @GetMapping("/persontwo") // /persontwo?name=ryu&age=20
    public String getReqParm2(String name, int age) {
        System.out.println(name);
        System.out.println(age);
        return "";
    }

    // 메서드 선언부에 파라미터와 자료형을 입력하고, 왼쪽에 @RequestParam("가져올변수명") 입력하면 자료형을 자동으로 바꿔줌
    // 스프링에서 지원해주는 편리한 기능으로, 스프링에서 최소 이 방법부터 사용한다.
    @GetMapping("/personthree") // /persontwo?name=ryu&age=
    public String getReqParm3(String name, @RequestParam(defaultValue = "20") int age) {
        System.out.println(name);
        System.out.println(age);
        return "";
    }

    // 3. 커맨드 객체 이용하기
    // 연관된 자료를 한 번에 처리해야 하는 경우 외부에 class를 하나 만들고 그 클래스를 파라미터로주면, 외부 클래스의 내부 멤버변수명이 전부 매핑되어 주입됨
    // 위 두 방식 보다 훨씬 간편하게 사용
    @RequestMapping("/notebook")   // NotebookDTO의 멤버변수명칭으로 들어오는 파라미터를 자동대입
    public String notebook(NotebookDTO notebook){
        System.out.println(notebook.getName());
        return "";
    }

    // 4. URL Path로 경로문자 데이터 읽기
    // @PathVariable 어노테이션을 사용하여 URL의 경로에서 값을 추출하여 매개변수로 전달합니다.
    @GetMapping("/member/{mName}/{mNumber}")
    public String member(@PathVariable String mName, @PathVariable long mNumber) {
        System.out.println("This member is " + mName + " / " + mNumber);
        return "";
    }


}
