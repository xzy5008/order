package com.hifox.utility;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Description: 不拷贝属性 标记时间转换
 *
 * @Date:2016年8月24日
 * @author:xzy
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DateConvert {
	/**
	 * 设置时间格式 默认yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public String value() default "yyyy-MM-dd HH:mm:ss";
}
