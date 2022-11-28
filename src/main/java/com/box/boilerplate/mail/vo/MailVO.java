package com.box.boilerplate.mail.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MailVO {


    private String address;
    private String title;
    private String message;
    private MultipartFile file;

}
