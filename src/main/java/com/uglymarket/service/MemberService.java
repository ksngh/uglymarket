package com.uglymarket.service;

import com.uglymarket.domain.Member;
import com.uglymarket.dto.request.MemberReqDTO;
import com.uglymarket.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final ModelMapper modelMapper;

    /**
     * 회원 등록
     * @param memberReqDTO - 회원 요청 DTO
     */
    public void saveMember(MemberReqDTO memberReqDTO) {
        //회원DTO를 회원도메인으로 변환
        Member member = modelMapper.map(memberReqDTO, Member.class);
        memberMapper.insertMember(member);
    }
}
