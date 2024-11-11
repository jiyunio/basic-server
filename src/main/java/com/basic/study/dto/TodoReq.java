package com.basic.study.dto;

import com.basic.study.domain.Member;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TodoReq {
    private Long memberId;

    private String content;

    private LocalDateTime deadLine;

    private Boolean isCompleted;

    private Member member;
}
