package com.basic.study.repository;

import com.basic.study.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select m.id from Member m where m.email = :email")
    Long findByEmail(String email);
}
