package com.box.boilerplate.mail.service;

import com.box.boilerplate.common.vo.ResultVO;
import com.box.boilerplate.mail.vo.MailVO;

public interface MailService {

    public ResultVO<?> sendMail(MailVO mailVO);

}
