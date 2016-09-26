package com.hifox.config.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Description: session 获取用户信息
 *
 * @Date:2016年8月17日
 * @author:xzy
 */
@Target({ ElementType.PARAMETER,ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SessionScope {
    String value();
}
