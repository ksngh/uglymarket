package com.uglymarket.service;

import com.uglymarket.dto.request.HeartReqDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HeartServiceTest {

    @Autowired
    private HeartService heartService;

    @DisplayName("좋아요 등록 테스트")
    @Test
    void saveHearttest() {
        HeartReqDTO heartReqDTO = new HeartReqDTO();

        heartReqDTO.setMemberid("test");
        heartReqDTO.setItemId(1L);

        heartService.saveHeart(heartReqDTO);
    }
}