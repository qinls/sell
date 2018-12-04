package com.imooc.utils;

import java.util.Random;

/**
 * Created by Administrator on 2018/11/6.
 */
public class KeyUtil {


    /**
     * 生成主键唯一
     * <p>
     * 格式：时间 + 随机数
     *
     * @return
     */
    public static synchronized String getUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
