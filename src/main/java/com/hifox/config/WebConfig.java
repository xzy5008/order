package com.hifox.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;

import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.hifox.config.filter.CustomSessionListener;

/**
 * 
 * @Description:
 *
 * @Date:2016年9月13日
 * @author:xzy
 */
@Configuration
public class WebConfig {

	private static final String CAS_URL = "https://sso.ch.com/cas";
	private static final String LOCAL_URL = "http://127.0.0.1";
	
	// 用于处理编码问题
    @Bean
    public Filter characterEncodingFilter() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }
	@Bean
	public FilterRegistrationBean casSingleSignOutFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setName("casSingleSignOutFilter");
		org.jasig.cas.client.session.SingleSignOutFilter casSingleSignOutFilter = new org.jasig.cas.client.session.SingleSignOutFilter();
		registrationBean.setFilter(casSingleSignOutFilter);
		registrationBean.setOrder(5);
		List<String> urlList = new ArrayList<String>();
		urlList.add("/*");
		registrationBean.setUrlPatterns(urlList);

		return registrationBean;
	}

	@Bean
	public ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> filterRegistrationBean() {
		ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> listener = new ServletListenerRegistrationBean<SingleSignOutHttpSessionListener>();
		listener.setListener(new org.jasig.cas.client.session.SingleSignOutHttpSessionListener());
		return listener;
	}
	@Bean
	public ServletListenerRegistrationBean<CustomSessionListener> mylistener() {
		ServletListenerRegistrationBean<CustomSessionListener> listener = new ServletListenerRegistrationBean<CustomSessionListener>();
		listener.setListener(new CustomSessionListener());
		return listener;
	}
	
	@Bean
	public FilterRegistrationBean authenticationFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setName("casFilter");
		org.jasig.cas.client.authentication.AuthenticationFilter casFilter = new org.jasig.cas.client.authentication.AuthenticationFilter();
		registrationBean.setFilter(casFilter);
		registrationBean.addInitParameter("casServerLoginUrl", CAS_URL);
		registrationBean.addInitParameter("serverName", LOCAL_URL);
		registrationBean.setOrder(6);
		List<String> urlList = new ArrayList<String>();
		urlList.add("/login");
		registrationBean.setUrlPatterns(urlList);

		return registrationBean;
	}
	
	@Bean
	public FilterRegistrationBean casValidationFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setName("casValidationFilter");
		org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter casValidationFilter = new org.jasig.cas.client.validation.Cas20ProxyReceivingTicketValidationFilter();
		registrationBean.setFilter(casValidationFilter);
		registrationBean.addInitParameter("casServerUrlPrefix", CAS_URL);
		registrationBean.addInitParameter("serverName", LOCAL_URL);
		registrationBean.addInitParameter("renew", "false");
		registrationBean.addInitParameter("gateway", "false");
		registrationBean.setOrder(7);
		List<String> urlList = new ArrayList<String>();
		urlList.add("/*");
		registrationBean.setUrlPatterns(urlList);
		
		return registrationBean;
	}
	
	
	@Bean
	public FilterRegistrationBean casHttpServletRequestWrapperFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setName("casHttpServletRequestWrapperFilter");
		org.jasig.cas.client.util.HttpServletRequestWrapperFilter casHttpServletRequestWrapperFilter = new org.jasig.cas.client.util.HttpServletRequestWrapperFilter();
		registrationBean.setFilter(casHttpServletRequestWrapperFilter);
		registrationBean.setOrder(8);
		List<String> urlList = new ArrayList<String>();
		urlList.add("/*");
		registrationBean.setUrlPatterns(urlList);
		
		return registrationBean;
	}
	
	/**该过滤器使得开发者可以通过org.jasig.cas.client.util.AssertionHolder来获取用户的登录名。
	比如AssertionHolder.getAssertion().getPrincipal().getName()**/
	@Bean
	public FilterRegistrationBean casAssertionThreadLocalFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setName("casAssertionThreadLocalFilter");
		org.jasig.cas.client.util.AssertionThreadLocalFilter casAssertionThreadLocalFilter = new org.jasig.cas.client.util.AssertionThreadLocalFilter();
		registrationBean.setFilter(casAssertionThreadLocalFilter);
		registrationBean.setOrder(9);
		List<String> urlList = new ArrayList<String>();
		urlList.add("/*");
		registrationBean.setUrlPatterns(urlList);
		return registrationBean;
	}

	@Bean
	public FilterRegistrationBean casForInvokeContextFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setName("casForInvokeContextFilter");
		com.hifox.config.filter.CasForInvokeContextFilter casForInvokeContextFilter = new com.hifox.config.filter.CasForInvokeContextFilter();
		registrationBean.setFilter(casForInvokeContextFilter);
		registrationBean.setOrder(10);
		List<String> urlList = new ArrayList<String>();
		urlList.add("/*");
		registrationBean.setUrlPatterns(urlList);
		return registrationBean;
	}
}
