package com.hifox.service;


import java.util.List;

import javax.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hifox.HifoxlabApplication;
import com.hifox.model.common.Order;

/**
 * @Title: RightServiceImplTest.java
 * @Description: 
 * @Date:2016年9月22日
 * @author:xiezhongyong
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HifoxlabApplication.class)
@WebAppConfiguration
@Rollback(false)
@Transactional
public class OrderServiceImplTest {
	
	@Autowired
	OrderService orderService;
	@Test
	public void saveTest() throws Exception {
		Order o = new Order();
		o.setOrderName("123");
		orderService.save(o);
	}
	
	@Test
	public void updateTest() throws Exception {
	}
	

}
