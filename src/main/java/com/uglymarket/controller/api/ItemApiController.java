package com.uglymarket.controller.api;

import com.uglymarket.domain.Member;
import com.uglymarket.dto.request.ItemReqDTO;
import com.uglymarket.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("item/api/")
public class ItemApiController {

    private final ItemService itemService;

    @PostMapping("create")
    public String itemAdd(@AuthenticationPrincipal Member member, ItemReqDTO itemReqDTO) {

        //회원 아이디 등록
        itemReqDTO.setMemberId(member.getId());
        Long id = itemService.saveItem(itemReqDTO);
        return "redirect:/";
    }
}
