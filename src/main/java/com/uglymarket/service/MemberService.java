package com.uglymarket.service;

import com.uglymarket.domain.Member;
import com.uglymarket.dto.request.MemberReqDTO;
import com.uglymarket.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberMapper memberMapper;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberMapper.selectMemberById(username);
    }

    /**
     * 회원 등록
     * @param memberReqDTO - 회원 요청 DTO
     */
    public void saveMember(MemberReqDTO memberReqDTO) {
        //비밀번호 암호화 후 다시 저장
        memberReqDTO.setPassword(bCryptPasswordEncoder.encode(memberReqDTO.getPassword()));

        //회원DTO를 회원도메인으로 변환
        Member member = modelMapper.map(memberReqDTO, Member.class);
        memberMapper.insertMember(member);
    }

    /**
     * 회원 수정
     * @param memberReqDTO - 회원 요청 DTO
     */
    public void modifyMember(MemberReqDTO memberReqDTO) {
        Member member = modelMapper.map(memberReqDTO, Member.class);
        memberMapper.updateMember(member);
    }

    /**
     * 회원 삭제
     * @param id - 회원 아이디
     */
    public void removeMember(String id) {
        memberMapper.deleteMember(id);
    }

}
