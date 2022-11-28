package com.box.boilerplate.mail.controller;

import com.box.boilerplate.common.vo.ResultVO;
import com.box.boilerplate.mail.service.MailService;
import com.box.boilerplate.mail.vo.MailVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value="/mail")
@Controller
@RequiredArgsConstructor
@Slf4j
public class MailController {


    @GetMapping(value="")
    public String mailPage(){
        log.info("mailPage");
        return "mail/mailSendPage";
    }

    private final MailService mailService;

    @PostMapping("/send")
    @ResponseBody
    public ResultVO<?> execMail(@RequestBody MailVO mailVO){
        log.info("MailVO : {}",mailVO);
        return mailService.sendMail(mailVO);


    }



}
