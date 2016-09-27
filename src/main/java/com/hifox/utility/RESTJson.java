package com.hifox.utility;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: RESTJson.java
 * @Description: 响应状态
 * @Date:2016年9月27日
 * @author:xiezhongyong
 * @version 1.0
 */
public class RESTJson implements Serializable {

	private static final long serialVersionUID = 6397095367817216307L;
	private Object data;
	private String message;
	private int status;
	private Date timestamp = new Date();

	public RESTJson(Object data, String message, int status) {
		this.data = data;
		this.message = message;
		this.status = status;
	}

	public Object getData() {
		if (0 != this.status)
			return null;
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int error) {
		this.status = error;
	}

	public Date getTimeStamp() {
		return timestamp;
	}

	public static RESTJson done() {
		return new RESTJson(null, "", ResponseStatus.OK);
	}
}
