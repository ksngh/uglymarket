package com.uglymarket.mapper;

import com.uglymarket.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    /**
     * 회원 등록
     * @param member - 회원 도메인
     */
    void insertMember(Member member);
}
