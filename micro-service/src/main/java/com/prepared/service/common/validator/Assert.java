package com.prepared.service.common.validator;

import com.prepared.service.common.exception.RRException;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 *
 * @author z
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new RRException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new RRException(message);
        }
    }
}
