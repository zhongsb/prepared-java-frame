package com.prepared.service.common.utils;

import java.util.Random;

/**
 * int类型工具类
 *
 * @author: z
 * @Date: 2019/12/21 16:01
 */
public class IntUtil {

    /*
     * 返回长度为strLength的随机数，在前面补0
     * @p
     */

    /**
     * 返回长度为strLength的随机数，在前面补0
     *
     * @param strLength 随机数长度
     * @return 随机数
     */
    public static String getFixLenthString(int strLength) {
        Random rm = new Random();
        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);
        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);
        // 返回固定的长度的随机数
        return fixLenthString.substring(1, strLength + 1);
    }
}
