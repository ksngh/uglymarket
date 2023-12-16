package com.uglymarket.controller;

import com.uglymarket.dto.response.ItemResDTO;
import com.uglymarket.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("item/")
public class ItemController {

    private final ItemService itemService;

    /* 상품 등록 화면 */
    @GetMapping("create")
    public String itemCreate() {
        return "item/create";
    }

    /* 상품 조회 화면 */
    @GetMapping("{id}")
    public String itemDetail(@PathVariable(name = "id") Long id, Model model) {
        ItemResDTO itemResDTO = itemService.findItem(id);
        model.addAttribute("item", itemResDTO);

        return "item/detail";
    }

    /* 상품 수정 화면 */
    @GetMapping("{id}/update")
    public String itemUpdate(@PathVariable(name = "id") Long id, Model model) {
        ItemResDTO itemResDTO = itemService.findItem(id);
        model.addAttribute("item", itemResDTO);

        return "item/update";
    }
}
