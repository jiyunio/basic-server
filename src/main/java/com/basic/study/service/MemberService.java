package com.basic.study.service;

import com.basic.study.domain.Member;
import com.basic.study.dto.MemberReq;
import com.basic.study.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long login(MemberReq memberReq) {
        memberRepository.save(Member.builder()
                .email(memberReq.getEmail())
                .password(memberReq.getPassword())
                .build());
        return memberRepository.findByEmail(memberReq.getEmail());
    }

    public boolean deleteMember(Long memberId) {
        if (!memberRepository.existsById(memberId)) return false;
        Member member = memberRepository.findById(memberId).get();
        memberRepository.delete(member);
        return true;
    }

}