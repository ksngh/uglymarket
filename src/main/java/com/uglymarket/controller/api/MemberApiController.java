package com.uglymarket.controller.api;

import com.uglymarket.dto.request.MemberReqDTO;
import com.uglymarket.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("member/api/")
public class MemberApiController {

    private final MemberService memberService;

    //회원 등록
    @PostMapping("create")
    public String memberAdd(MemberReqDTO memberReqDTO) {
        memberService.saveMember(memberReqDTO);
        return "redirect:/";
    }

    //회원 수정
    @PostMapping("update")
    public void memberModify(MemberReqDTO memberReqDTO) {
        memberService.modifyMember(memberReqDTO);
    }
    
    //회원 삭제
    @PostMapping("delete")
    public void memberRemove(String id) {
        memberService.removeMember(id);
    }

}
