package com.basic.study.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.el.lang.ELArithmetic;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private LocalDateTime deadLine;

    private Boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    private Todo(String content, LocalDateTime deadLine, Member member){
        this.content = content;
        this.deadLine = deadLine;
        this.isCompleted = false;
        this.member = member;
    }
}

