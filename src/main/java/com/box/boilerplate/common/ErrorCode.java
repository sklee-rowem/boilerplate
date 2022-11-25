package com.box.boilerplate.common;

import lombok.Getter;

@Getter
public enum ErrorCode {

    SUCCESS("0000","message.success"),
    UN_DUPLICATED_ID("0001","message.unduplicated_id"),
    INVALID_ID("9997","message.invalid_id"),
    DUPLICATED_ID("9998","message.duplicate_userid"),
    FAIL("9999","message.failed")
        ;

    private String code;
    private String message;

    ErrorCode(String code, String message){
        this.code = code;
        this.message = message;
    }






}
