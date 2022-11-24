package com.box.boilerplate.member.service.impl;

import com.box.boilerplate.member.model.MemberEntity;
import com.box.boilerplate.member.repository.MemberRepository;
import com.box.boilerplate.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public MemberEntity joinMember(MemberEntity params) {



        return null;
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
