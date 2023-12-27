package com.uglymarket.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class HeartReqDTO {

    private String memberId;
    private Long itemId;
}
