package com.prepared.service.common.utils;

/**
 * Redis所有Keys
 *
 * @author z
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }
}
