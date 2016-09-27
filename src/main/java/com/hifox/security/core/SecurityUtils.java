package com.hifox.security.core;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hifox.security.pj.CurrentUser;
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
    public static CurrentUser getCurrentLogin() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
    	Object object = request.getSession().getAttribute("user");
    	if(null != object)
    		return (CurrentUser)object;
    	return null;
    }
}
