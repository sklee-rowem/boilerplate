package com.box.boilerplate.mail.service;

import com.box.boilerplate.common.ErrorCode;
import com.box.boilerplate.common.vo.ResultVO;
import com.box.boilerplate.mail.vo.MailVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Slf4j
@AllArgsConstructor
@Service
public class MailServiceImpl implements MailService{

    private JavaMailSender javaMailSender;


    @Override
    public ResultVO<?> sendMail(MailVO mailVO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailVO.getAddress());
        message.setSubject(mailVO.getTitle());
        message.setText(mailVO.getMessage());
        ResultVO<?> resultVO = new ResultVO<>();
        try{
            javaMailSender.send(message);
            resultVO.setErrorCode(ErrorCode.SUCCESS.getCode());
            resultVO.setErrorMessage(ErrorCode.SUCCESS.getMessage());

        } catch (Exception e){
            log.info("email 실");
            resultVO.setErrorCode(ErrorCode.MAIL_SEND_FAILED.getCode());
            resultVO.setErrorMessage(ErrorCode.MAIL_SEND_FAILED.getMessage());
        } finally {
            return resultVO;
        }

    }
}
