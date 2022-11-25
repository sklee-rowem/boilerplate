package com.box.boilerplate.member.service.impl;

import com.box.boilerplate.member.model.MemberEntity;
import com.box.boilerplate.member.model.mapping.loginMapping;
import com.box.boilerplate.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.box.boilerplate.common.util.EncryptUtil.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MemberServiceImplTest {


    @Autowired
    MemberRepository memberRepository;

//    @Before()
//    void


//    private BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();

    @Test
    void saveAndLogin(){
//        MemberEntity memberEntity = new MemberEntity();
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserId("lsk7337");
        memberEntity.setUserPw(bCryptPasswordEncoder.encode("1234"));
        memberEntity.setUserName("lsk");
        memberEntity.setEmail("lsk7337@naver.com");
        memberEntity.setRole("USER");

        MemberEntity save = memberRepository.save(memberEntity);
//        System.out.println("save : "+save.toString());

        loginMapping byUser_id = memberRepository.findFirstByUserId(memberEntity.getUserId());
//        System.out.println("user_id : "+byUser_id.getUserId()+"/"+byUser_id.getUserPw());
        assertTrue(bCryptPasswordEncoder.matches("1234",byUser_id.getUserPw()));



    }




}