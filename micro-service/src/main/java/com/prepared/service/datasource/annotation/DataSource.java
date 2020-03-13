package com.prepared.service.datasource.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 *
 * @author z
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {
    String value() default "";
}
