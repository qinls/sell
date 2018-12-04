package com.imooc.enums;

import lombok.Getter;

/**
 * 商品状态
 * Created by Administrator on 2018/11/5.
 */
@Getter
public enum ProductsStatusEnum {
    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;
    private String message;

    ProductsStatusEnum(Integer code, String message) {
        this.code = code;

        this.message = message;
    }
}
