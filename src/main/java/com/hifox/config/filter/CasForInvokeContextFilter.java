package com.hifox.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;

import com.hifox.config.security.UserService;
import com.hifox.config.security.pj.DGroup;
import com.hifox.config.security.pj.DResource;
import com.hifox.config.security.pj.DRole;
import com.hifox.config.security.pj.DUserRight;
import com.hifox.config.security.pj.User;


/**
 * @Title: CasForInvokeContextFilter.java
 * @Description: 
 *该过滤器用户从CAS认证服务器中获取登录用户用户名，并填充必要的Session. 
 * @Date:2016年9月26日
 * @author:xiezhongyong
 * @version 1.0
 */
public class CasForInvokeContextFilter implements Filter {  
  
    @Override  
    public void destroy() {  
    }  
  
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException {  
        HttpSession session = ((HttpServletRequest) request).getSession();  
        Assertion assertion = AssertionHolder.getAssertion();
        User user = null;
        if(null != assertion) {
             String userName = AssertionHolder.getAssertion().getPrincipal().getName();
             //如果session中没有用户信息，则填充用户信息  
			if (session.getAttribute("user") == null) {
				try {
				      // 模拟数据
					if (null != userName) {
						
						user = UserService.getUser(userName);
						DUserRight dUserRight = user.getUserRight();
						//转换map
						
						//用户自身权限资源
						for (DResource r : dUserRight.getResources()) {
							user.getRsMap().put(r.getUrl(), r);
						}
						//用户角色权限资源
						for (DRole role : user.getUserRight().getRoles()) {
							for (DResource r : role.getResources()) {
								user.getRsMap().put(r.getUrl(), r);
							}
						}
						//用户组权限资源
						for (DGroup group : user.getUserRight().getGroups()) {
							for (DResource r : group.getResources()) {
								user.getRsMap().put(r.getUrl(), r);
							}
						}
						System.out.println("权限资源转换完成。。。。");
						for (String key : user.getRsMap().keySet()) {
							System.out.println("权限资源：key:"+ key +">>>>"+user.getRsMap().get(key));
						}
					}
					// 根据单点登录的账户的用户名，从数据库用户表查找用户信息， 填充到session中  
//                     User user = UserDao.getUserByName(userName);  
                    session.setAttribute("user", user);  
                    System.out.println("session 设置用户信息成功");
                    System.out.println(user);
                 } catch (Exception e) {  
                     e.printStackTrace();  
                 }  
             }  
        }else{
        	System.out.println("用户没有登录。。。。。。。。。");
        }
        chain.doFilter(request, response);  
    }  
  
    @Override  
    public void init(FilterConfig config) throws ServletException {  
    }  
}  