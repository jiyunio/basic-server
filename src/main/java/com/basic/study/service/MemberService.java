package com.basic.study.service;

import com.basic.study.domain.Member;
import com.basic.study.dto.MemberReq;
import com.basic.study.dto.MemberRes;
import com.basic.study.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberRes login(MemberReq memberReq) {
        Member member = Member.builder()
                .email(memberReq.getEmail())
                .password(memberReq.getPassword())
                .build();
        memberRepository.save(member);
        return MemberRes.builder()
                .memberId(member.getId())
                .email(memberReq.getEmail())
                .build();
    }

    public MemberRes getMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NoSuchElementException("해당 회원을 찾을 수 없습니다."));

        return MemberRes.builder()
                .memberId(member.getId())
                .email(member.getEmail())
                .build();
    }

    public boolean deleteMember(Long memberId) {
        if (!memberRepository.existsById(memberId)) return false;
        Member member = memberRepository.findById(memberId).get();
        memberRepository.delete(member);
        return true;
    }

}