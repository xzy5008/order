package com.hifox.config.security;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hifox.config.security.pj.User;
import com.hifox.config.security.util.HttpClient;
import com.hifox.utility.JsonUtil;

/**
 * @Title: UserService.java
 * @Description:  和用户系统交换信息
 * @Date:2016年9月26日
 * @author:xiezhongyong
 * @version 1.0
 */
public class UserService {

	/**
	 * 查询登录用户信息
	 * @param auth
	 * @return
	 */
	public static User getUser(String auth){
		String url = "http://192.168.1.112:8282/usermanger/users/"+auth;
		String sendGet = HttpClient.sendGet(url, null);
		JsonObject jsonObject = new JsonParser().parse(sendGet).getAsJsonObject();
		String user = jsonObject.get("data").toString();
		System.out.println("返回用户json：》》》》》"+user);
		User rUser = JsonUtil.json2Object(user, User.class);
		System.out.println("返回用户rUser：》》》》》"+rUser);
		return rUser;
	}
	
}
