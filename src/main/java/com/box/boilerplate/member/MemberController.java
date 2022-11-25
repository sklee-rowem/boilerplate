package com.box.boilerplate.member;


import com.box.boilerplate.common.ErrorCode;
import com.box.boilerplate.common.vo.ResultVO;
import com.box.boilerplate.member.model.MemberEntity;
import com.box.boilerplate.member.service.MemberService;
import com.box.boilerplate.member.vo.JoinParamVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.util.HashMap;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public String loginPage(){
        return "member/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultVO<?> login(HttpSession session, @RequestBody HashMap<String,String> params) throws Exception{
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserId(params.get("user_id"));
        memberEntity.setUserPw(params.get("user_pw"));
        ResultVO<?> result = memberService.loginMember(memberEntity);

        if(result.getErrorCode().equals(ErrorCode.SUCCESS.getCode())){
            session.setAttribute("loginId",params.get("user_id"));
        }
        return result;
    }

    @GetMapping("/join")
    public String joinPage(){


        return "member/join";
    }

    @PostMapping("/join")
    @ResponseBody
    public ResultVO<?> join(@RequestBody JoinParamVO param){
        log.info("param : {}",param.toString());
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserId(param.getUser_id());
        memberEntity.setUserPw(param.getUser_pw());
        memberEntity.setEmail(param.getEmail());
        memberEntity.setUserName(param.getName());
        memberEntity.setRole("USER");


        return memberService.joinMember(memberEntity);
    }



    @GetMapping("/duplicate-check")
    @ResponseBody
    public ResultVO<?> userIdDuplicateCheck(@RequestParam String userId){
        log.info("duplicate-check : {}",userId);
        return memberService.userIdDuplicateCheck(userId);
    }
}
