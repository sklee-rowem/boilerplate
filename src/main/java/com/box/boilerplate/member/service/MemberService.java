package com.box.boilerplate.member.service;

import com.box.boilerplate.common.vo.ResultVO;
import com.box.boilerplate.member.model.MemberEntity;

public interface MemberService {

    ResultVO<?> joinMember(MemberEntity params);

    ResultVO<?> loginMember(MemberEntity params) throws Exception;


    ResultVO<?> userIdDuplicateCheck(String userId);
}
