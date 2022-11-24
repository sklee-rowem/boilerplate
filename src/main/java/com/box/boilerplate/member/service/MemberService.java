package com.box.boilerplate.member.service;

import com.box.boilerplate.member.model.MemberEntity;

public interface MemberService {

    MemberEntity joinMember(MemberEntity params);

    String loginMember(MemberEntity params);


}
