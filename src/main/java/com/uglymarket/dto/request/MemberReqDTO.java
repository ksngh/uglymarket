package com.uglymarket.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberReqDTO {

    private String id;
    private String password;
    private String nickname;
    private String name;
    private String phone;
    private String address;
}
