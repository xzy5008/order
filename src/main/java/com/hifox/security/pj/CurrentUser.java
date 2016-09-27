package com.hifox.security.pj;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: User.java
 * @Description: 用户信息封装
 * @Date:2016年9月26日
 * @author:xiezhongyong
 * @version 1.0
 */
public class CurrentUser implements Serializable{
	
	private static final long serialVersionUID = 4068530930059266464L;

	public CurrentUser() {
	}

	public CurrentUser(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}

	public CurrentUser(String userName, String passWord, String email, String phone) {
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.phone = phone;
	}

	private String id;
	
	private String userName;

	private String passWord;

	private String email;

	private String phone;

	private DUserRight userRight;

	private Map<String, DResource> rsMap = new HashMap<String ,DResource>();
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public DUserRight getUserRight() {
		return userRight;
	}

	public void setUserRight(DUserRight userRight) {
		this.userRight = userRight;
	}

	public Map<String, DResource> getRsMap() {
		return rsMap;
	}

	public void setRsMap(Map<String, DResource> rsMap) {
		this.rsMap = rsMap;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", email=" + email + ", phone="
				+ phone + ", userRight=" + userRight + ", rsMap=" + rsMap + "]";
	}

	
}
