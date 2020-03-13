package com.prepared.service.common.annotation;

import java.lang.annotation.*;

/**
 * app登录效验
 *
 * @author z
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
