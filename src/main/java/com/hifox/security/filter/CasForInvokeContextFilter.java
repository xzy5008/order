package com.hifox.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;

import com.hifox.security.core.CurrentUserService;
import com.hifox.security.pj.CurrentUser;
import com.hifox.security.pj.DGroup;
import com.hifox.security.pj.DResource;
import com.hifox.security.pj.DRole;
import com.hifox.security.pj.DUserRight;

/**
 * @Title: CasForInvokeContextFilter.java
 * @Description:该过滤器用户从CAS认证服务器中获取登录用户用户名，并填充必要的Session.
 * @Date:2016年9月26日
 * @author:xiezhongyong
 * @version 1.0
 */
public class CasForInvokeContextFilter implements Filter {

	private static final Logger LOG = Logger.getLogger(CasForInvokeContextFilter.class);

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		Assertion assertion = AssertionHolder.getAssertion();
		CurrentUser user = null;
		if (null != assertion) {
			String userName = AssertionHolder.getAssertion().getPrincipal().getName();
			// 如果session中没有用户信息，则填充用户信息
			if (session.getAttribute("user") == null) {
				try {
					if (null != userName) {
						user = CurrentUserService.getUser(userName);
						DUserRight dUserRight = user.getUserRight();
						// 转换map

						// 用户自身权限资源
						for (DResource r : dUserRight.getResources()) {
							user.getRsMap().put(r.getUrl()+"-"+r.getType(), r);
						}
						// 用户角色权限资源
						for (DRole role : user.getUserRight().getRoles()) {
							for (DResource r : role.getResources()) {
								user.getRsMap().put(r.getUrl()+"-"+r.getType(), r);
							}
						}
						// 用户组权限资源
						for (DGroup group : user.getUserRight().getGroups()) {
							for (DResource r : group.getResources()) {
								user.getRsMap().put(r.getUrl()+"-"+r.getType(), r);
							}
						}
						LOG.info("#####权限资源转换完成##############");
					}
					session.setAttribute("user", user);
					LOG.info("#####session 设置用户信息成功##############");
					System.out.println(user);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			LOG.info("#####用户未登录##############");
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}
}