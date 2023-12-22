package com.uglymarket.service;

import com.uglymarket.dto.response.FileResDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FileServiceTest {

    @Autowired
    private FileService fileService;

    @DisplayName("파일 리스트 조회")
    @Test
    void findFilesTest() {
        Long itemId = 15L;
        List<FileResDTO> fileResDTOs = fileService.findFiles(itemId);

        for (FileResDTO fileResDTO : fileResDTOs) {
            System.out.println("fileResDTO = " + fileResDTO);
        }
    }

}