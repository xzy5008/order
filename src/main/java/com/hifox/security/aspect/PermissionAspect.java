package com.hifox.security.aspect;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hifox.security.pj.CurrentUser;
import com.hifox.security.util.CasConfig;

/**
 * @Title: PermissionAspect.java
 * @Description: 权限验证拦截
 * @Date:2016年9月27日
 * @author:xiezhongyong
 * @version 1.0
 */
@Order(1)
@Aspect
@Component
public class PermissionAspect {

	private static final Logger LOG = Logger.getLogger(PermissionAspect.class);
	
	@Pointcut("execution(public * com..web..*.*(..))")
	public void verification() {}

	@Before("verification()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		HttpServletResponse response = attributes.getResponse();

		//---------------------
		String   url  = request.getScheme()+"://"; //请求协议 http 或 https    
		url+=request.getHeader("host");  // 请求服务器    
		url+=request.getRequestURI();     // 工程名      
		if(request.getQueryString()!=null) //判断请求参数是否为空  
		url+="?"+request.getQueryString();   // 参数   
		LOG.debug("############用户访问#######"+url);  
		
		//---------------------
		
		Method method = getMethod(joinPoint);
		Object user = null;
		RequestSecurity annotation = method.getAnnotation(RequestSecurity.class);
		if (null != annotation) {
			HttpSession session = request.getSession();
			user = session.getAttribute("user");
			if (null == user) {
				LOG.info("########未登录的用户#########");
				if (isAjax(request)) {
					request.getRequestDispatcher("/nologin").forward(request, response);
				} else {
					response.sendRedirect(CasConfig.CAS_URL+"?service="+java.net.URLEncoder.encode(url));
				}
				throw new Exception("########未登录的用户#########");
			} else {
				CurrentUser thsiUser = (CurrentUser) user;
				LOG.info("########当前登录用户#########"+user);
				if (!"".equals(annotation.value()) && !thsiUser.getRsMap().containsKey(annotation.value()+"-"+(request.getMethod().toUpperCase()))) {
					request.getRequestDispatcher("/denied").forward(request, response);
					throw new Exception("#######当前登录用户无权限访问######");
				}
			}
		}

	}

	/**
	 * 获取方法
	 * @param pjp
	 * @return
	 */
	private Method getMethod(JoinPoint pjp) {
		// 获取参数的类型
		Object[] args = pjp.getArgs();
		@SuppressWarnings("rawtypes")
		Class[] argTypes = new Class[pjp.getArgs().length];
		for (int i = 0; i < args.length; i++) {
			argTypes[i] = args[i].getClass();
		}
		Method method = null;
		try {
			method = pjp.getTarget().getClass().getMethod(pjp.getSignature().getName(), argTypes);
		} catch (NoSuchMethodException e) {
			LOG.error("annotation no sucheMehtod", e);
		} catch (SecurityException e) {
			LOG.error("annotation SecurityException", e);
		}
		return method;

	}

	/**
	 * 判断ajax请求
	 * 
	 * @param request
	 * @return
	 */
	boolean isAjax(HttpServletRequest request) {
		return (request.getHeader("X-Requested-With") != null
				&& "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
	}
}
