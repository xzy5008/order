package com.hifox.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hifox.config.aspect.RequestSecurity;
import com.hifox.config.security.SecurityUtils;
import com.hifox.config.security.pj.User;
import com.hifox.model.common.Order;
import com.hifox.service.OrderService;
import com.hifox.utility.RESTJson;
import com.hifox.utility.ResponseStatus;

import io.swagger.annotations.Api;

/**
 * 
 * @Description: 订单管理
 *
 * @Date:2016年8月2日
 * @author:xzy
 */
@Api("订单管理")
@RestController
@RequestMapping
public class OrderController {

	private static final Logger LOG = Logger.getLogger(OrderController.class);
    
	@Autowired
	OrderService orderService;
	
	@RequestSecurity
	@RequestMapping(method = RequestMethod.POST, value = "/order")
	public RESTJson save(@RequestBody Order order) {
		RESTJson json = RESTJson.done(null, null);
		try {
			Assert.notNull(order,"订单信息不能为空");
			//############绑定当前登录用户
			order.setCuser(SecurityUtils.getCurrentLogin().getUserName());
			order.setCtime(new Date());
			System.out.println(order);
			Order save = orderService.save(order);
			json.setData(save);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			json.setMessage(e.getMessage());
			json.setStatus(ResponseStatus.ERROR);
		}
		return json;
		
	}
	
	@RequestSecurity
	@RequestMapping(method = RequestMethod.GET, value = "/order/{id}")
	public RESTJson get(@PathVariable String id) {
		RESTJson json = RESTJson.done(null, null);
		try {
			Assert.notNull(id,"订单ID不能为空");
			Order order = orderService.findOne(id);
			if(SecurityUtils.getCurrentLogin().getUserName().equals(order.getCuser())){
				json.setData(order);
			}
			Assert.notNull(order,"订单不存在");
			//############判断订单是否可以查询
			
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			json.setMessage(e.getMessage());
			json.setStatus(ResponseStatus.ERROR);
		}
		return json;
	}
	@RequestSecurity
	@RequestMapping(method = RequestMethod.GET, value = "/orders")
	public RESTJson list() {
		RESTJson json = RESTJson.done(null, null);
		try {
			String userName = SecurityUtils.getCurrentLogin().getUserName();
			List<Order> findByCuser = orderService.findByCuser(userName);
			//############判断订单是否可以查询
			json.setData(findByCuser);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			json.setMessage(e.getMessage());
			json.setStatus(ResponseStatus.ERROR);
		}
		return json;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public RESTJson getUser() {
		User currentLogin = SecurityUtils.getCurrentLogin();
		RESTJson json = RESTJson.done(null, null);
		try {
			json.setData(currentLogin);
			//############判断订单是否可以查询
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			json.setMessage(e.getMessage());
			json.setStatus(ResponseStatus.ERROR);
		}
		return json;
	}

}
