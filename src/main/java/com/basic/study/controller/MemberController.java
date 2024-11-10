package com.basic.study.controller;

import com.basic.study.dto.MemberReq;
import com.basic.study.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberReq memberReq) {
        return ResponseEntity.ok(memberService.login(memberReq));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<?> delete(@PathVariable Long memberId) {
        return memberService.deleteMember(memberId)
                ? ResponseEntity.ok("탈퇴 성공")
                : ResponseEntity.ok("탈퇴 실패");
    }
}
