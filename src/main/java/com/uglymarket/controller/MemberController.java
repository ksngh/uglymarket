package com.uglymarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member/")
public class MemberController {

    //회원가입 화면
    @GetMapping("/create")
    public String createPage() {
        System.out.println("MemberController.createPage");

        return "member/create";
    }

    //로그인 화면
    @GetMapping("/login")
    public String loginPage() {
        System.out.println("MemberController.loginPage");
        return "member/login";
    }
}
