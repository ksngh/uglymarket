package com.uglymarket.controller.api;

import com.uglymarket.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("file/api/")
public class FileApiController {

    private final FileService fileService;

    /* 파일 삭제 처리  */
    @PostMapping("{id}/delete")
    @ResponseBody
    public void fileRemove(@PathVariable Long id) {
        fileService.fileRemove(id);
    }
}
