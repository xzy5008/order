package com.hifox.repositories;

import java.util.List;
import java.util.Optional;

import com.hifox.model.common.Order;

/**
 * @Title: OrderRepository.java
 * @Description: 
 *
 * @Date:2016年9月25日
 * @author:xiezhongyong
 * @version 1.0
 */
public interface OrderRepository extends BaseRepository<Order, String>{

	List<Order> findByCuser(String userName);
}
