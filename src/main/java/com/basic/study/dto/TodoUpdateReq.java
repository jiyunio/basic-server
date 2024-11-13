package com.basic.study.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TodoUpdateReq {
    private String content;

    private LocalDate deadLine;

    private Boolean isCompleted;
}
