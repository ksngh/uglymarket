package com.uglymarket.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ItemReqDTO {

    private Long id;
    private String memberId;
    private Long categoryId;
    private String title;
    private Long price;
    private String content;
    private String img;
}
