package com.uglymarket.common.file;

import com.uglymarket.dto.request.FileReqDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileUtils {

    //파일이 저장될 디스크 경로
    private final String uploadPath = Paths.get("D:", "temp").toString();

    /**
     * 다중 파일 업로드
     * @param multipartFiles - 파일 객체 리스트
     * @return - 파일 요청 DTO 리스트
     */
    public List<FileReqDTO> uploadFiles(List<MultipartFile> multipartFiles) {
        List<FileReqDTO> fileReqDTOs = new ArrayList<>();

        if (!multipartFiles.isEmpty()) {
            for (MultipartFile multipartFile : multipartFiles) {
                if (multipartFile.isEmpty()) {
                    continue;
                }
                fileReqDTOs.add(uploadFile(multipartFile));
            }
            return fileReqDTOs;
        }

        return null;
    }

    /**
     * 단일 파일 업로드
     * @param multipartFile - 파일 객체
     * @return - 파일 요청 DTO
     */
    public FileReqDTO uploadFile(MultipartFile multipartFile) {
        String saveName = generateSaveFilename(multipartFile.getOriginalFilename());
        String uploadPath = getUploadPath() + File.separator + saveName; //D:temp/파일명
        File uploadFile = new File(uploadPath);

        try {
            multipartFile.transferTo(uploadFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return FileReqDTO.builder()
                .originalName(multipartFile.getOriginalFilename())
                .saveName(saveName)
                .size(multipartFile.getSize())
                .build();
    }

    /**
     * 실제로 디스크에 저장될 파일명 생성
     * @param originalFilename - 원본 파일명
     * @return 실제로 디스크에 저장될 파일명
     */
    private String generateSaveFilename(String originalFilename) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String extension = StringUtils.getFilenameExtension(originalFilename);
        return uuid + "." + extension;
    }

    private String getUploadPath() {
        return makeDir(uploadPath + File.separator); //D:temp/
    }

    private String makeDir(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir.getPath();
    }
}
