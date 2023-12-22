package com.uglymarket.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FileReqDTO {

    private Long itemId;
    private String originalName;
    private String saveName;
    private Long size;
}
