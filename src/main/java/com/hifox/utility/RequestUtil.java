package com.hifox.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.security.web.util.matcher.ELRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lihao on 2016/7/6.
 */
public class RequestUtil {

    private static final Logger LOGGER = Logger.getLogger(RequestUtil.class.getName());

    private static final RequestMatcher REQUEST_MATCHER = new ELRequestMatcher("hasHeader('X-Requested-With','XMLHttpRequest')");

    public static final String JSON_VALUE = "{\"%s\": %s}";


    public static Boolean isAjaxRequest(HttpServletRequest request) {
        return REQUEST_MATCHER.matches(request);
    }


    public static void sendJsonResponse(HttpServletResponse response, RESTJson json) {
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        try {
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(json));
        } catch (IOException e) {
            LOGGER.error("error writing json to response", e);
        }
    }
}
