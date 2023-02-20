package com.example.jwtpractice.repository;

import com.example.jwtpractice.entity.NZMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NZMemberRepo extends JpaRepository<NZMember, Long> {
}
