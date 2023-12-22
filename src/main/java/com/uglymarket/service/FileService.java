package com.uglymarket.service;

import com.uglymarket.domain.File;
import com.uglymarket.dto.request.FileReqDTO;
import com.uglymarket.dto.response.FileResDTO;
import com.uglymarket.mapper.FileMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileMapper fileMapper;
    private final ModelMapper modelMapper;

    /**
     * 파일 리스트 등록
     * @param fileReqDTOs - 파일 요청 DTO 리스트
     */
    public void saveFiles(Long id, List<FileReqDTO> fileReqDTOs) {
        //어떤 상품에 대한 이미지 파일인지 파악하기 위해 상품 번호 등록
        for (FileReqDTO fileReqDTO : fileReqDTOs) {
            fileReqDTO.setItemId(id);
        }

        List<File> files = fileReqDTOs.stream()
                .map(fileReqDTO -> modelMapper.map(fileReqDTO, File.class))
                .toList();

        fileMapper.insertFiles(files);
    }

    /**
     * 파일 리스트 조회
     * @param itemId - 상품 번호
     * @return - 파일 응답 DTO 리스트
     */
    public List<FileResDTO> findFiles(Long itemId) {
        List<File> files = fileMapper.selectFiles(itemId);

        return files.stream()
                .map(file -> modelMapper.map(file, FileResDTO.class))
                .toList();
    }

    /**
     * 파일 삭제
     * @param id - 파일 번호
     */
    public void fileRemove(Long id) {
        fileMapper.deleteFile(id);
    }
}
