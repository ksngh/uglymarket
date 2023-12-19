package com.uglymarket.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class File {

    private Long id;
    private Long itemId;
    private String originalName;
    private String saveName;
    private Long size;
    private LocalDateTime createDate;
}
