package com.box.boilerplate.member;


import com.box.boilerplate.member.model.MemberEntity;
import com.box.boilerplate.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
        if(result.equals("loginSeccess")){
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
    public HashMap<String,Object> join(){

        return null;
    }

}
