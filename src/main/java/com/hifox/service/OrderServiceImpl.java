package com.hifox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hifox.model.common.Order;
import com.hifox.repositories.OrderRepository;

/**
 * @Title: OrderServiceImpl.java
 * @Description: 
 *
 * @Date:2016年9月25日
 * @author:xiezhongyong
 * @version 1.0
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, String> implements OrderService{

	@Autowired
	OrderRepository orderRepository;
	@Override
	public List<Order> findByCuser(String userName) {
		
		return orderRepository.findByCuser(userName);
	}

	
}
