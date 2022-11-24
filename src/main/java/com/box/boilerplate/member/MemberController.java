package com.box.boilerplate.member;


import com.box.boilerplate.member.model.MemberEntity;
import com.box.boilerplate.member.service.MemberService;
import com.box.boilerplate.member.vo.JoinParamVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.util.HashMap;

@Slf4j
@Controller
public class MemberController {

    private MemberService memberService;

    @GetMapping("/login")
    public String loginPage(){
        return "member/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public HashMap<String,Object> login(HttpSession session, @RequestBody HashMap<String,String> params){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUser_id(params.get("user_id"));
        memberEntity.setUser_pw(params.get("user_pw"));
        String result = memberService.loginMember(memberEntity);
        HashMap<String, Object> map = new HashMap<>();
        map.put("result",result);
        if(result.equals("loginSuccess")){
            session.setAttribute("loginId",params.get("user_id"));
        }

        return map;
    }

    @GetMapping("/join")
    public String joinPage(){


        return "member/join";
    }

    @PostMapping("/join")
    @ResponseBody
    public HashMap<String,Object> join(@RequestBody JoinParamVO param){

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUser_id(param.getUser_id());
        memberEntity.setUser_pw(param.getUser_pw());
        memberEntity.setEmail(param.getEmail());
        memberEntity.setUser_name(param.getName());
        memberEntity.setRole("USER");

        memberService.joinMember(memberEntity);


        return null;
    }

}
