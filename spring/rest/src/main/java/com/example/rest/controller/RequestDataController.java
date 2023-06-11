package com.example.rest.controller;

import com.example.rest.dto.PersonDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/test")
@CrossOrigin(origins = "http://127.0.0.1:5500/") // live server 주소
public class RequestDataController {

    /*
    Example 1. General POST request (form data)
    name : Chris
    age : 25
    */

    @PostMapping("/giveformdata")
    public String giveformdata(@RequestBody String req) { // @RequestBody 는 request body 의 내용이 모두 다 전달됨
        System.out.println("🔥" + req);
        return "";
    }
    // 🔥name=Chris&age=25

    @PostMapping("/giveformdata2")
    public String testgiveformdata2(@RequestParam String age) {
        System.out.println("🔥" + age);
        return "";
    }
    // 🔥25

    
    
    /*
    Example 2. Asynchronous POST request (JSON data)
     */
    
    @PostMapping("/givejsondata1")
    public String givejsondata1(@RequestParam String name) {
        System.out.println("🔥" + name);
        return "";
    }
    // ❌Error - Required request parameter 'name' for method parameter type String is not present

    @PostMapping("/givejsondata2")
    public String givejsondata2(@RequestBody String req) {  // String 으로 받음
        System.out.println("🔥" + req);
        return "";
    }
    // 🔥{"name":"Chris","age":"25"}

    @PostMapping("/givejsondata3")
    public String givejsondata3(@RequestBody PersonDTO person) { // 커맨드 객체로 받음
        System.out.println("🔥" + person); // person 커맨드 객체 자동 생성
        return "";
    }
    // 🔥PersonDTO(name=Chris, age=25)

    @PostMapping("/givejsondata4")
    public String givejsondata4(@RequestBody Map<String,String> map) { // Map 으로 받음
        System.out.println("🔥" + map.get("name") + " & " + map.get("age"));
        return "";
    }
    // 🔥Chris & 25
}
