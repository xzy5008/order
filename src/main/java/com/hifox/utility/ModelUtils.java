package com.hifox.utility;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.beans.BeanUtils;



/**
 * 
 * @Description:   对象属性复制
 *
 * @Date:2016年8月2日
 * @author:xzy
 */
/**
 * @author xzy
 *
 */
public class ModelUtils {

	/**
	 * 将  source 内容拷贝到 target  [用于后台开发]
	 * @param source
	 * @param target
	 */
	public static void copyProperties(Object source,Object target) {

		Field[] fs = target.getClass().getDeclaredFields();

		for (Field field : fs) {
				PropertyDescriptor pd1 = null;
				try {
					pd1 = new PropertyDescriptor(field.getName(), source.getClass());
				} catch (IntrospectionException e) {
					continue;
				}
				Method md = pd1.getReadMethod();
				Object va = null;
				try {
					va = md.invoke(source, null);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				if(null != va) {
					PropertyDescriptor pd2 = null;
					try {
						pd2 = new PropertyDescriptor(field.getName(), target.getClass());
					} catch (IntrospectionException e) {
						e.printStackTrace();
					}
					Method md2 = pd2.getWriteMethod();
					try {
						md2.invoke(target, va);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
		}

	}

}
