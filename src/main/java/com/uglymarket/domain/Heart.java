package com.uglymarket.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Heart {

    private Long id;
    private String memberId;
    private Long itemId;
}
