package com.box.boilerplate.member.service.impl;

import com.box.boilerplate.common.ErrorCode;
import com.box.boilerplate.common.vo.ResultVO;
import com.box.boilerplate.member.model.MemberEntity;
import com.box.boilerplate.member.model.mapping.loginMapping;
import com.box.boilerplate.member.repository.MemberRepository;
import com.box.boilerplate.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.box.boilerplate.common.util.EncryptUtil.*;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public ResultVO<?> joinMember(MemberEntity params) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String enc_pw = bCryptPasswordEncoder.encode(params.getUserPw());
        params.setUserPw(enc_pw);
        MemberEntity saveMember = memberRepository.save(params);

        ResultVO<MemberEntity> rv = new ResultVO<>();
        rv.setErrorCode(ErrorCode.SUCCESS.getCode());
        rv.setErrorMessage(ErrorCode.SUCCESS.getMessage());
        rv.setResult(saveMember);

        return rv;
    }

    @Override
    public ResultVO<?> loginMember(MemberEntity params) throws Exception{

        ResultVO<loginMapping> resultVO = new ResultVO<>();
        // count or isNull로 메서드를 바꿔야함
//        MemberEntity result = null;
        Optional<loginMapping> firstByUserId = memberRepository
                                                .findFirstByUserId(params.getUserId())
                ;
//        loginMapping userIdResult = firstByUserId.get();

        if(!firstByUserId.isPresent()) {
            resultVO.setErrorCode(ErrorCode.INVALID_ID.getCode());
            resultVO.setErrorMessage(ErrorCode.INVALID_ID.getMessage());
        }

        //memberRepository.findByUser_idAndUser_pw(params.getUser_id(), params.getUser_pw());
        boolean matches = bCryptPasswordEncoder.matches(params.getUserPw(), firstByUserId.get().getUserPw());
        if(matches){
            resultVO.setErrorCode(ErrorCode.SUCCESS.getCode());
            resultVO.setErrorMessage(ErrorCode.SUCCESS.getMessage());
//            resultVO.setResult(firstByUserId.get());
        } else {
            resultVO.setErrorCode(ErrorCode.FAIL.getCode());
            resultVO.setErrorMessage(ErrorCode.FAIL.getMessage());
        }

        return resultVO;
    }

    @Override
    public ResultVO<?> userIdDuplicateCheck(String userId) {

        Optional<loginMapping> firstByUserId = memberRepository.findFirstByUserId(userId);

        ResultVO<Boolean> resultVO = new ResultVO<>();
        if(firstByUserId.isEmpty()){
            resultVO.setErrorCode(ErrorCode.UN_DUPLICATED_ID.getCode());
            resultVO.setErrorMessage(ErrorCode.UN_DUPLICATED_ID.getMessage());
            resultVO.setResult(true);
        } else {
            resultVO.setErrorCode(ErrorCode.DUPLICATED_ID.getCode());
            resultVO.setErrorMessage(ErrorCode.DUPLICATED_ID.getMessage());
            resultVO.setResult(false);
        }

        return resultVO;
    }
}
