package com.uglymarket.controller;

import com.uglymarket.dto.request.MemberReqDTO;
import com.uglymarket.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("member/api/")
public class MemberApiController {

    private final MemberService memberService;

    //회원 등록
    @PostMapping("create")
    public void memberAdd(MemberReqDTO memberReqDTO) {
        memberService.saveMember(memberReqDTO);
    }

    //회원 수정
    @PostMapping("update")
    public void memberModify(MemberReqDTO memberReqDTO) {
        memberService.modifyMember(memberReqDTO);
    }

}
