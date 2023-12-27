package com.uglymarket.mapper;

import com.uglymarket.domain.Heart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HeartMapper {

    /**
     * 좋아요 등록
     * @param heart - 좋아요 도메인
     * @return - 성공 여부
     */
    Long insertHeart(Heart heart);
}
