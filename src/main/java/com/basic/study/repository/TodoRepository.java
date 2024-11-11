package com.basic.study.repository;

import com.basic.study.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByMemberId(Long memberId);
}
