package com.basic.study.controller;

import com.basic.study.dto.MemberReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/members")
public class MemberController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberReq memberReq) {
        return ResponseEntity.ok("로그인됐습니다.");

    }

    @DeleteMapping()
    public ResponseEntity<?> delete(@RequestBody MemberReq memberReq) {
        return ResponseEntity.ok("탈퇴됐습니다.");
    }
}
