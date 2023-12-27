package com.uglymarket.service;

import com.uglymarket.domain.Heart;
import com.uglymarket.dto.request.HeartReqDTO;
import com.uglymarket.mapper.HeartMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeartService {

    private final HeartMapper heartMapper;
    private final ModelMapper modelMapper;

    /**
     * 좋아요 등록
     * @param heartReqDTO - 좋아요 요청 DTO
     * @return 성공 여부
     */
    public Long saveHeart(HeartReqDTO heartReqDTO) {
        Heart heart = modelMapper.map(heartReqDTO, Heart.class);
        return heartMapper.insertHeart(heart);
    }
}
