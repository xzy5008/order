package com.hifox.utility;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *  时间工具类
 * @author:XZY
 */
public class DateUtil {
	
	
	private static final String DateForm_001= "yyyy-MM-dd";
	private static final String DateForm_002= "yyyy-MM-dd HH:mm:ss";
	private static final String DateForm_003= "yyyyMMddHHmmss";
	
	
	/**
	 * 格式化日期
	 * @param date
	 * @return
	 */
	public static String date2String(Date date){
     if(date==null) date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat(DateForm_002);
     return sdf.format(date).toString();
	}
	
	/**
	 * 格式化日期
	 * @param date
	 * @return
	 */
	public static String date2String(){
		SimpleDateFormat sdf=new SimpleDateFormat(DateForm_002);
		return sdf.format(new Date()).toString();
	}
	
	/**
	 * 格式化日期
	 * @param date
	 * @return
	 */
	public static String date2String(Date date,String form){
		if(date==null) date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat(form);
		return sdf.format(date).toString();
	}
	
	
	/**
	 * 格式化日期字符串
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date string2Date(String str){
	     try {
	    	 if(str==null) return null;
		        SimpleDateFormat sdf=new SimpleDateFormat(DateForm_002);
		     return sdf.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return null;
	}
	/**
	 * 格式化日期字符串
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static Date string2Date(String str,String form){
		try {
			if(str==null) return null;
			SimpleDateFormat sdf=new SimpleDateFormat(form);
			return sdf.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** date +月
	 * @param num
	 * @return
	 */
	public static Date addMonth(Date date , int num) {
		Calendar cal= Calendar.getInstance();
	    if(null == date){
	    	cal.setTime(new Date());
	    }else{
	    	cal.setTime(date);
	    }
	    cal.add(Calendar.MONTH, num);
	    return  cal.getTime();
	}
	
	/** date +天
	 * @param num
	 * @return
	 */
	public static Date addDATE(Date date , int num) {
		Calendar cal= Calendar.getInstance();
		if(null == date){
			cal.setTime(new Date());
		}else{
			cal.setTime(date);
		}
		cal.add(Calendar.DATE, num);
		return  cal.getTime();
	}
	/** date +小时
	 * @param num
	 * @return
	 */
	public static Date addHOUR(Date date , int num) {
		Calendar cal= Calendar.getInstance();
		if(null == date){
			cal.setTime(new Date());
		}else{
			cal.setTime(date);
		}
		cal.add(Calendar.HOUR, num);
		return  cal.getTime();
	}
	/** date +分钟
	 * @param num
	 * @return
	 */
	public static Date addMINUTE(Date date , int num) {
		Calendar cal= Calendar.getInstance();
		if(null == date){
			cal.setTime(new Date());
		}else{
			cal.setTime(date);
		}
		cal.add(Calendar.MINUTE, num);
		return  cal.getTime();
	}
	
	/** date +秒
	 * @param num
	 * @return
	 */
	public static Date addSECOND(Date date , int num) {
		Calendar cal= Calendar.getInstance();
		if(null == date){
			cal.setTime(new Date());
		}else{
			cal.setTime(date);
		}
		cal.add(Calendar.SECOND, num);
		return  cal.getTime();
	}
	
	/**
	 * 获取当前时间 字符串  yyyyMMddHHmmssSSSS
	 * @param str
	 * @return
	 * @throws ParseException
	 */
	public static String getDateStr(){
		try {
			  SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSSS");
			     return sdf.format(new Date()).toString();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
