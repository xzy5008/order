package com.hifox.model.common;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Order entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order", catalog = "orders")
public class Order extends Model {

	// Fields

	private String orderName;
	private Float orderPrice;
	private String describe;
	private Date ctime;
	private String cuser;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(String orderName, Float orderPrice, String describe,
			Date ctime, String cuser) {
		this.orderName = orderName;
		this.orderPrice = orderPrice;
		this.describe = describe;
		this.ctime = ctime;
		this.cuser = cuser;
	}

	@Column(name = "order_name", length = 50)
	public String getOrderName() {
		return this.orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Column(name = "order_price")
	public Float getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(Float orderPrice) {
		this.orderPrice = orderPrice;
	}

	@Column(name = "describesss", length = 200)
	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ctime", length = 19)
	public Date getCtime() {
		return this.ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	@Column(name = "cuser", length = 50)
	public String getCuser() {
		return this.cuser;
	}

	public void setCuser(String cuser) {
		this.cuser = cuser;
	}

	@Override
	public String toString() {
		return "Order [orderName=" + orderName + ", orderPrice=" + orderPrice + ", describe=" + describe + ", ctime="
				+ ctime + ", cuser=" + cuser + "]";
	}

	
}