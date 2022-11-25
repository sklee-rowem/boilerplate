package com.box.boilerplate.common.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultVO<T> {

    private String ErrorCode;
    private String ErrorMessage;
    private T Result;
}
