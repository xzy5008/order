package com.hifox.config.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hifox.config.security.pj.DUserRight;
import com.hifox.config.security.pj.User;

/**
 * @Title: SecurityUtils.java
 * @Description: 
 *
 * @Date:2016年9月26日
 * @author:xiezhongyong
 * @version 1.0
 */
public class SecurityUtils {
	/**
	 * 获取当前登录用户
	 * @return
	 */
    public static User getCurrentLogin() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
    	Object object = request.getSession().getAttribute("user");
    	if(null != object)
    		return (User)object;
    	return null;
    }
}
