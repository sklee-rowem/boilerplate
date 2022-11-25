package com.box.boilerplate.member.repository;

import com.box.boilerplate.member.model.MemberEntity;
import com.box.boilerplate.member.model.mapping.loginMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity , Long> {

    Optional<loginMapping> findFirstByUserId(String userId);


}
