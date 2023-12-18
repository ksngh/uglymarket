package com.uglymarket.controller;

import com.uglymarket.dto.response.FileResDTO;
import com.uglymarket.dto.response.ItemResDTO;
import com.uglymarket.service.FileService;
import com.uglymarket.service.ItemService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("item/")
public class ItemController {

    private final ItemService itemService;
    private final FileService fileService;

    /* 상품 목록 화면 */
    @GetMapping("list")
    public String itemList(Model model) {
        List<ItemResDTO> itemResDTOs =itemService.findItems();
        model.addAttribute("items", itemResDTOs);

        return "item/list";
    }

    /* 상품 등록 화면 */
    @GetMapping("create")
    public String itemCreate() {
        return "item/create";
    }

    /* 상품 조회 화면 */
    @GetMapping("{id}")
    public String itemDetail(HttpServletRequest request,
                             HttpServletResponse response,
                             @PathVariable(name = "id") Long id,
                             Model model) {
        ItemResDTO itemResDTO = itemService.findItem(id);
        List<FileResDTO> fileResDTOs = fileService.findFiles(id);

        model.addAttribute("item", itemResDTO);
        model.addAttribute("files", fileResDTOs);

        //조회수 처리
        Cookie[] cookies = request.getCookies();
        int hasVCookie = 0;

        for (Cookie cookie : cookies) {
            //이미 쿠키가 존재하면
            if (cookie.getName().equals("v_cookie")) {
                hasVCookie = 1;

                //이미 조회한 상품이면 패스
                if (cookie.getValue().contains(id.toString()))
                    continue;

                cookie.setValue(cookie.getValue() + "_" + id.toString());
                response.addCookie(cookie);
                itemService.addViewCnt(id);
            }
        }

        //쿠키가 존재하지 않으면 생성
        if (hasVCookie == 0) {
            Cookie newCookie = new Cookie("v_cookie", id.toString());
            response.addCookie(newCookie);
            itemService.addViewCnt(id);
        }

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
