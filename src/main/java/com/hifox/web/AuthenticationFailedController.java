package com.hifox.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hifox.utility.RESTJson;
import com.hifox.utility.ResponseStatus;

/**
 * 
 * @Description: 权限验证失败
 *
 * @Date:2016年8月2日
 * @author:xzy
 */
@RestController
@RequestMapping
public class AuthenticationFailedController {

	private static final Logger LOG = Logger.getLogger(AuthenticationFailedController.class);
    
	@RequestMapping(method = RequestMethod.GET, value = "/nologin")
	public RESTJson nologin() {
		RESTJson json = RESTJson.done(null, null);
		try {
			json.setData("https://sso.ch.com/cas/login");
			json.setMessage("没有登录.");
			json.setStatus(ResponseStatus.ERROR);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			json.setMessage(e.getMessage());
			json.setStatus(ResponseStatus.ERROR);
		}
		return json;
		
	}
	@RequestMapping(method = RequestMethod.GET, value = "/denied")
	public RESTJson denied() {
		RESTJson json = RESTJson.done(null, null);
		try {
			json.setData("https://sso.ch.com/cas/login");
			json.setMessage("无权限.");
			json.setStatus(ResponseStatus.ERROR);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			json.setMessage(e.getMessage());
			json.setStatus(ResponseStatus.ERROR);
		}
		return json;
		
	}
	
	@Autowired
	HttpServletRequest request;
	@Autowired
    HttpServletResponse response; 
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public RESTJson login() {
    	try {
    		response.sendRedirect("/index.html");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
    

}
