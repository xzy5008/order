package com.hifox.security.pj;

import java.io.Serializable;

/**
 * @Title: DModel.java
 * @Description:
 * @Date:2016年9月22日
 * @author:xiezhongyong
 * @version 1.0
 */
public abstract class DModel implements Serializable {
	private static final long serialVersionUID = -6862382394382782660L;

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public abstract void setCtime(String ctime);
}
