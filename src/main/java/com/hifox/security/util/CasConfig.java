package com.hifox.security.util;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * @Title: CasConfig.java
 * @Description: cas 对接配置文件加载
 * @Date:2016年9月27日
 * @author:xiezhongyong
 * @version 1.0
 */
public class CasConfig {
	/**
	 * csa 服务地址
	 */
	public static String CAS_URL;
	
	/**
	 * 当前项目 服务地址
	 */
	public static String LOCAL_URL;
	
	/**
	 * 当前项目注销返回地址
	 */
	public static String LOCAL_LOGOUT_URL;
	
	/**
	 * 用户系统获取用户信息接口
	 */
	public static String GETUSER_URL;
	
	
	
	private static final Logger log = Logger.getLogger(CasConfig.class);
	/**
	 * 配置文件名称
	 */
	static final String propfilename = "casConfig"; //文件名称
	static{
		resourceBundle = ResourceBundle.getBundle(propfilename);
		new CasConfig();
	}
	static ResourceBundle resourceBundle;
	
	/**
	 *加载配置文件
	 */
	private CasConfig() {
		try {
			load();
			log.info("##############casConfig 配置文件 加载了");
		} catch(Exception e) {
			log.error("Outside Constant File Read Error.", e);
		}
	}
	/**
	 * 配置加载
	 */
	private void load(){
		CAS_URL = resourceBundle.getString("cas_url");
		LOCAL_URL = resourceBundle.getString("local_url");
		LOCAL_LOGOUT_URL = resourceBundle.getString("local_logout_url");
		GETUSER_URL = resourceBundle.getString("getuser_url");
	}
	
	
}
