package com.hifox.config;

import com.hifox.utility.RESTJson;
import com.hifox.utility.ResponseStatus;

import org.apache.log4j.Logger;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常捕获
 * Created by lihao on 2016/7/6.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOG = Logger.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RESTJson handler(HttpServletRequest req , Exception e){
        LOG.error(e.getMessage());
        e.printStackTrace();
        return RESTJson.fail(ResponseStatus.EXCEPTION,e.getMessage());
    }
    
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    public RESTJson handlerRead(HttpServletRequest req , Exception e){
    	LOG.error(e.getMessage());
    	return RESTJson.fail(ResponseStatus.EXCEPTION,"请求参数不合法");
    }
}
