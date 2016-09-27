package com.hifox.security.controller;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hifox.security.util.CasConfig;
import com.hifox.utility.RESTJson;
import com.hifox.utility.ResponseStatus;

/**
 * @Title: AuthenticationController.java
 * @Description: 权限验证
 * @Date:2016年9月27日
 * @author:xiezhongyong
 * @version 1.0
 */
@RestController
@RequestMapping
public class AuthenticationController {
	private static final Logger LOG = Logger.getLogger(AuthenticationController.class);
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;

	/**
	 * 未登录返回
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/nologin")
	public RESTJson nologin() {
		RESTJson json = RESTJson.done();
		try {
			json.setData(CasConfig.CAS_URL);  //单点登录地址
			json.setMessage("not logged in");
			json.setStatus(ResponseStatus.NOTLOGGEDIN);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			json.setMessage(e.getMessage());
			json.setStatus(ResponseStatus.ERROR);
		}
		return json;

	}

	/**
	 * 无权限操作返回
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/denied")
	public RESTJson denied() {
		RESTJson json = RESTJson.done();
		try {
			json.setMessage("permission denied");
			json.setStatus(ResponseStatus.PERMISSIONDENIED);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			json.setMessage(e.getMessage());
			json.setStatus(ResponseStatus.ERROR);
		}
		return json;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/logout")
	public RESTJson logout() {
		RESTJson json = RESTJson.done();
		try {
			response.sendRedirect(
					CasConfig.CAS_URL + "/logout?service=" + URLEncoder.encode(CasConfig.LOCAL_LOGOUT_URL));
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			json.setMessage(e.getMessage());
			json.setStatus(ResponseStatus.ERROR);
		}
		return json;
	}

}
