package com.hifox.service;

import java.util.List;

import com.hifox.model.common.Order;

/**
 * @Title: OrderService.java
 * @Description: 
 *
 * @Date:2016年9月25日
 * @author:xiezhongyong
 * @version 1.0
 */
public interface OrderService extends BaseService<Order, String>{

	List<Order> findByCuser(String userName);
}
