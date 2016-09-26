package com.hifox.config.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.validation.Assertion;

/**
 * @Title: Auth.java
 * @Description: 
 *
 * @Date:2016年9月26日
 * @author:xiezhongyong
 * @version 1.0
 */
public class Auth {
	public static final String CONST_CAS_ASSERTION = "_const_cas_assertion_";
	public void doExe(HttpServletRequest request, HttpServletResponse response){
        final HttpSession session = request.getSession(false);
        final Assertion assertion = session != null ? (Assertion) session.getAttribute(CONST_CAS_ASSERTION) : null;

//        if (assertion != null) {
//            return;
//        }
//
//        final String serviceUrl = constructServiceUrl(request, response);
//        final String ticket = CommonUtils.safeGetParameter(request,getArtifactParameterName());
//        final boolean wasGatewayed = this.gatewayStorage.hasGatewayedAlready(request, serviceUrl);
//
//        if (CommonUtils.isNotBlank(ticket) || wasGatewayed) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        final String modifiedServiceUrl;
//
//        log.debug("no ticket and no assertion found");
//        if (this.gateway) {
//            log.debug("setting gateway attribute in session");
//            modifiedServiceUrl = this.gatewayStorage.storeGatewayInformation(request, serviceUrl);
//        } else {
//            modifiedServiceUrl = serviceUrl;
//        }
//
//        if (log.isDebugEnabled()) {
//            log.debug("Constructed service url: " + modifiedServiceUrl);
//        }
//
//        final String urlToRedirectTo = CommonUtils.constructRedirectUrl(this.casServerLoginUrl, getServiceParameterName(), modifiedServiceUrl, this.renew, this.gateway);
//
//        if (log.isDebugEnabled()) {
//            log.debug("redirecting to \"" + urlToRedirectTo + "\"");
//        }

//        response.sendRedirect(urlToRedirectTo);
	}
	
//	   protected final String constructServiceUrl(final HttpServletRequest request, final HttpServletResponse response) {
//	        return CommonUtils.constructServiceUrl(request, response, this.service, this.serverName, this.artifactParameterName, this.encodeServiceUrl);
//	    }
}
