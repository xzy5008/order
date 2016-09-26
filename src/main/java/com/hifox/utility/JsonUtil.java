package com.hifox.utility;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @Description: json 转换
 *
 * @Date:2016年7月29日
 * @author:xzy
 */
public class JsonUtil {
//	private static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();  //添加注解方式
//	private static Gson gson = new Gson(); 
	private static Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	
	/**
	 * 对象转换json字符串
	 * @param obj 
	 * @return String
	 */
	public static String object2Json(Object obj){
		try {
			return gson.toJson(obj);
		} catch (Exception e) {
			throw new RuntimeException("对象:"+obj +"转换json 错误："+e);
		}
	}
	
	
	/**
	 * json字符串转换对象
	 * @param json 
	 * @return obj
	 */
	public static <T> T json2Object(String json,Class<T> c){
		try {
			return gson.fromJson(json, c);
		} catch (Exception e) {
			throw new RuntimeException("字符串json:"+json +"转换"+c+" 错误："+e);
		}
	}
	
}
