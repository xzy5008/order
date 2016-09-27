package com.hifox.security.core;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hifox.security.pj.CurrentUser;
import com.hifox.security.util.CasConfig;
import com.hifox.security.util.HttpClient;
import com.hifox.utility.JsonUtil;

/**
 * @Title: UserService.java
 * @Description: 和用户系统交换信息
 * @Date:2016年9月26日
 * @author:xiezhongyong
 * @version 1.0
 */
public class CurrentUserService {

	private static final Logger LOG = Logger.getLogger(CurrentUserService.class);

	/**
	 * 获取当前登录用户基本信息+权限信息
	 * @param identification id/username/email/phone
	 * @return
	 * @throws Exception
	 */
	public synchronized static CurrentUser getUser(String identification) throws Exception {
		String url = CasConfig.GETUSER_URL + identification;
		String sendGet = HttpClient.sendGet(url, null);
		JsonObject jsonObject = new JsonParser().parse(sendGet).getAsJsonObject();
		String user = jsonObject.get("data").toString();
		LOG.info("###用户系统返回用户 json###" + user);
		CurrentUser rUser = JsonUtil.json2Object(user, CurrentUser.class);
		LOG.info("###用户json 转换 CurrentUser ###" + user);
		return rUser;
	}

}
