package com.hifox.security.aspect;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Description: 用于判断用户是否登录或者是否有操作权限
 * 	如果没有指定value 即为只要用户登录就可以操作
 * 
 * @Date:2016年8月24日
 * @author:xzy
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestSecurity {

	public String value() default "";
}
