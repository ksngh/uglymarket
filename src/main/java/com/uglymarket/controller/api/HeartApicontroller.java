package com.uglymarket.controller.api;

import com.uglymarket.dto.request.HeartReqDTO;
import com.uglymarket.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("heart/api/")
public class HeartApicontroller {

    private final HeartService heartService;

    @PostMapping("save")
    @ResponseBody
    public Long heartSave(HeartReqDTO heartReqDTO) {
        return heartService.saveHeart(heartReqDTO);
    }
}
