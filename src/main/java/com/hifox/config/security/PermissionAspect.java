package com.hifox.config.security;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hifox.config.aspect.RequestSecurity;
import com.hifox.config.security.pj.User;

/**
 * Web层日志切面
 */
// 优化：AOP切面的优先级
@Order(5)
@Aspect
@Component
public class PermissionAspect {

	private Logger logger = Logger.getLogger(getClass());

	ThreadLocal<Long> startTime = new ThreadLocal<>(); // 多个请求不冲突

	@Pointcut("execution(public * com.hifox.web..*.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		startTime.set(System.currentTimeMillis());

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		HttpServletResponse response = attributes.getResponse();

		Method method = getMethod(joinPoint);
		String methodKey = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
		System.out.println("methodKey>>>" + methodKey);
		Object user = null;
		System.out.println("method>>>>>>" + method.getName());
		Annotation annotation = method.getAnnotation(RequestSecurity.class);
		if (null != annotation) {
			HttpSession session = request.getSession();
			user = session.getAttribute("user");
			System.out.println("user>>>" + user);
			if (null == user) {
				System.out.println("没有登录");
				if (isAjax(request)) {
					request.getRequestDispatcher("/nologin").forward(request, response);
				} else {
					//request.getRequestDispatcher("/login").forward(request, response);
					 response.sendRedirect("https://sso.ch.com/cas?service=http%3A%2F%2F127.0.0.1%2Flogin%3Bjsessionid%3D7F2591A26B22B3794A4328708015C476");
				}
				throw new Exception("未登录...");
			} else {
				User thsiUser = (User) user;
				if (!thsiUser.getRsMap().containsKey(methodKey)) {
					request.getRequestDispatcher("/denied").forward(request, response);
					throw new Exception("无权限...");
				}
			}
		}

	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		logger.info("#######RESPONSE : " + ret);
		logger.info("#######SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
	}

	private Method getMethod(JoinPoint pjp) {
		// 获取参数的类型
		Object[] args = pjp.getArgs();
		Class[] argTypes = new Class[pjp.getArgs().length];
		for (int i = 0; i < args.length; i++) {
			argTypes[i] = args[i].getClass();
		}
		Method method = null;
		try {
			method = pjp.getTarget().getClass().getMethod(pjp.getSignature().getName(), argTypes);
		} catch (NoSuchMethodException e) {
			logger.error("annotation no sucheMehtod", e);
		} catch (SecurityException e) {
			logger.error("annotation SecurityException", e);
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
