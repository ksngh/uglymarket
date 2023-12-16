package com.uglymarket.mapper;

import com.uglymarket.domain.File;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {

    /**
     * 파일 리스트 저장
     * @param files - 파일 도메인 리스트
     */
    void insertFiles(List<File> files);
}
