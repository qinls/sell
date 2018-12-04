package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * 异常
 * Created by Administrator on 2018/11/6.
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();

    }
}
