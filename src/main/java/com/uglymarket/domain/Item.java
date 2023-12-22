package com.uglymarket.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Item {

    private Long id;
    private String memberId;
    private Long categoryId;
    private String title;
    private Long price;
    private String content;
    private String img;
    private char saleYn;
    private Long viewCnt;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
