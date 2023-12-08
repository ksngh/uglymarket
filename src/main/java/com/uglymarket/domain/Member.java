package com.uglymarket.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Member {

    private String id;
    private String password;
    private String nickname;
    private String name;
    private String phone;
    private String address;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
