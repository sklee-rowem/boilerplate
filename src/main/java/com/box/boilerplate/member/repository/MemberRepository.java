package com.box.boilerplate.member.repository;

import com.box.boilerplate.member.model.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity , Long> {

    MemberEntity findByUser_idAndUser_pw(String user_id, String user_pw);


}
