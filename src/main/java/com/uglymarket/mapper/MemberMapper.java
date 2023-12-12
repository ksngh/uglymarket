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

    /**
     * 회원 수정
     * @param member - 회원 도메인
     */
    void updateMember(Member member);

    /**
     * 회원 삭제
     * @param id - 회원 아이디
     */
    void deleteMember(String id);

    /**
     * 회원 조회
     * @param id - 회원 아이디
     * @return - 회원 도메인
     */
    Member selectMemberById(String id);
}
