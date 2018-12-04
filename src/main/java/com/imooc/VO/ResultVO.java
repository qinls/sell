package com.imooc.VO;

import lombok.Data;

/**
 * HTTP 请求的返回 给前端的对象
 * Created by Administrator on 2018/11/5.
 */
@Data
public class ResultVO<T> {
    // 错误码
    private Integer code;
    // 提示信息
    private String msg;
    // 返回具体内容
    private T data;
}
