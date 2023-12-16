package com.uglymarket.controller.api;

import com.uglymarket.domain.Member;
import com.uglymarket.dto.request.ItemReqDTO;
import com.uglymarket.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("item/api/")
public class ItemApiController {

    private final ItemService itemService;

    /* 상품 등록 프로세스 */
    @PostMapping("create")
    public String itemAdd(@AuthenticationPrincipal Member member, ItemReqDTO itemReqDTO) {
        //회원 아이디 등록
        itemReqDTO.setMemberId(member.getId());
        Long id = itemService.saveItem(itemReqDTO);
        return "redirect:/";
    }

    /* 상품 수정 프로세스 */
    @PostMapping("{id}/update")
    public String itemModify(@PathVariable(name = "id") Long id,
                             @AuthenticationPrincipal Member member,
                             ItemReqDTO itemReqDTO) {
        itemService.modifyItem(itemReqDTO);
        return "redirect:/";
    }

    /* 상품 삭제 프로세스 */
    @PostMapping("{id}/delete")
    public String itemRemove(@PathVariable(name = "id") Long id) {
        itemService.removeItem(id);

        return "redirect:/";
    }

}
