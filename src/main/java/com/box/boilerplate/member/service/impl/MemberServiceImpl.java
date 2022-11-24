package com.box.boilerplate.member.service.impl;

import com.box.boilerplate.member.model.MemberEntity;
import com.box.boilerplate.member.repository.MemberRepository;
import com.box.boilerplate.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public MemberEntity joinMember(MemberEntity params) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String enc_pw = bCryptPasswordEncoder.encode(params.getUser_pw());
        params.setUser_pw(enc_pw);
        MemberEntity saveMember = memberRepository.save(params);


        return saveMember;
    }

    @Override
    public String loginMember(MemberEntity params) {

        // count or isNull로 메서드를 바꿔야함
        MemberEntity result = memberRepository.findByUser_idAndUser_pw(params.getUser_id(), params.getUser_pw());
        if(result == null){
            return "loginFailed";
        }

        return "loginSuccess";
    }
}
