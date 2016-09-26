package com.hifox.config.resolver;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import com.hifox.config.annotation.SessionScope;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
/**
 * 
 * @Description: 获取登录用户信息 
 *
 * @Date:2016年8月17日
 * @author:xzy
 */
public class SessionScopeResolver implements HandlerMethodArgumentResolver{
	private static final Logger LOG = Logger.getLogger(SessionScopeResolver.class);
	@Override
    public boolean supportsParameter(MethodParameter parameter) {
        //让方法和参数，两种target通过
        if(parameter.hasParameterAnnotation(SessionScope.class))return true;
        else if (parameter.getMethodAnnotation(SessionScope.class) != null)return true;
        return false;
    }

    @Override 
    public Object resolveArgument(MethodParameter parameter,
            ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) throws Exception {
        String annoVal = null;
        System.out.println("parameterparameterparameter@@@@@@@@@@@@"+parameter);
        if(parameter.getParameterAnnotation(SessionScope.class)!=null){
        	LOG.debug("param anno val::::"+parameter.getParameterAnnotation(SessionScope.class).value());
            annoVal = parameter.getParameterAnnotation(SessionScope.class).value();
        }else if(parameter.getMethodAnnotation(SessionScope.class)!=null){
        	LOG.debug("method anno val::::"+parameter.getMethodAnnotation(SessionScope.class).value());
            annoVal = parameter.getMethodAnnotation(SessionScope.class)!=null?
            		StringUtils.defaultString(parameter.getMethodAnnotation(SessionScope.class).value()):StringUtils.EMPTY;
        }
                                                                                                                              
        if (webRequest.getAttribute(annoVal,RequestAttributes.SCOPE_SESSION) != null){
            return webRequest.getAttribute(annoVal,RequestAttributes.SCOPE_SESSION);
        }
        else
            return null;
    }
    
}
