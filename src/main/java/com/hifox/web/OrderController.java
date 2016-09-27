package com.hifox.web;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hifox.model.common.Order;
import com.hifox.security.aspect.RequestSecurity;
import com.hifox.security.core.SecurityUtils;
import com.hifox.security.pj.CurrentUser;
import com.hifox.service.OrderService;
import com.hifox.utility.RESTJson;
import com.hifox.utility.ResponseStatus;
import io.swagger.annotations.Api;

/**
 * @Description: 订单管理
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
	
	@RequestSecurity("order")
	@RequestMapping(method = RequestMethod.POST, value = "/order")
	public RESTJson save(@RequestBody Order order) {
		RESTJson json = RESTJson.done();
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
	
	@RequestSecurity("order/ID")
	@RequestMapping(method = RequestMethod.GET, value = "/order/{id}")
	public RESTJson get(@PathVariable String id) {
		RESTJson json = RESTJson.done();
		try {
			Assert.notNull(id,"订单ID不能为空");
			Order order = orderService.findOne(id);
			Assert.notNull(order,"订单不存在");
			if(SecurityUtils.getCurrentLogin().getUserName().equals(order.getCuser())){
				json.setData(order);
			}
			//############判断订单是否可以查询
			
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			json.setMessage(e.getMessage());
			json.setStatus(ResponseStatus.ERROR);
		}
		return json;
	}
	
	@RequestSecurity("orders")
	@RequestMapping(method = RequestMethod.GET, value = "/orders")
	public RESTJson list() {
		RESTJson json = RESTJson.done();
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
	@RequestSecurity
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public RESTJson getUser() {
		CurrentUser currentLogin = SecurityUtils.getCurrentLogin();
		RESTJson json = RESTJson.done();
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
