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
        return "member/create";
    }
}
