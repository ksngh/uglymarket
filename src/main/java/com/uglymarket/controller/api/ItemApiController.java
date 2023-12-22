package com.uglymarket.controller.api;

import com.uglymarket.common.file.FileUtils;
import com.uglymarket.domain.Member;
import com.uglymarket.dto.request.FileReqDTO;
import com.uglymarket.dto.request.ItemReqDTO;
import com.uglymarket.service.FileService;
import com.uglymarket.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("item/api/")
public class ItemApiController {

    private final ItemService itemService;
    private final FileService fileService;
    private final FileUtils fileUtils;

    /* 상품 등록 프로세스 */
    @PostMapping("create")
    public String itemAdd(@AuthenticationPrincipal Member member,
                          ItemReqDTO itemReqDTO,
                          List<MultipartFile> files) {

        List<FileReqDTO> fileReqDTOs = fileUtils.uploadFiles(files); //파일 요청 DTO 리스트 생성
        itemReqDTO.setMemberId(member.getId()); //어떤 회원의 상품인지 구분하기 위해 상품 정보에 회원 아이디 등록

        itemReqDTO.setImg(fileReqDTOs.get(0).getSaveName()); //상품의 대표이미지 등록
        Long id = itemService.saveItem(itemReqDTO); //등록된 상품의 상품 번호
        fileService.saveFiles(id, fileReqDTOs); //어떤 상품의 파일인지 구분하기 위해 상품 번호를 등록

        return "redirect:/item/list";
    }

    /* 상품 수정 프로세스 */
    @PostMapping("{id}/update")
    public String itemModify(@PathVariable(name = "id") Long id,
                             @AuthenticationPrincipal Member member,
                             ItemReqDTO itemReqDTO) {
        itemService.modifyItem(itemReqDTO);
        return "redirect:/item/list";
    }

    /* 상품 삭제 프로세스 */
    @PostMapping("{id}/delete")
    public String itemRemove(@PathVariable(name = "id") Long id) {
        itemService.removeItem(id);

        return "redirect:/item/list";
    }

}
