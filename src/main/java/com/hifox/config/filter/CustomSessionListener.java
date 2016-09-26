package com.hifox.config.filter;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.springframework.security.core.context.SecurityContext;



/**
 * 
 * @Description:
 *
 * @Date:2016年9月1日
 * @author:xzy
 */
public class CustomSessionListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent e) {
			System.err.println("session 变动。。。。。");
	}

	/**
	 * 也同时删除
	 */
	public void attributeRemoved(HttpSessionBindingEvent e) {
		if (e.getName().equals("SPRING_SECURITY_CONTEXT")) {
			e.getSession().removeAttribute("user");
		}
	}

	/**
	 * 记得还要同时替换呀
	 */
	public void attributeReplaced(HttpSessionBindingEvent e) {
	}

}
