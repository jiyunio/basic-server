package com.basic.study.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String password;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Todo> todoes;

    @Builder
    private Member(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
