package com.box.boilerplate.common.util;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

public class EncryptUtil {

    public static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


}
