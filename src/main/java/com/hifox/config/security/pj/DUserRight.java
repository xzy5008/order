package com.hifox.config.security.pj;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;



/**
 * @Title: DUser.java
 * @Description: 用户权限
 * @Date:2016年9月22日
 * @author:xiezhongyong
 * @version 1.0
 */
@Document(collection = "d_user_right")
public class DUserRight extends DModel{

	private List<DResource> resources = new ArrayList<DResource>();	//用户自身权限
	private List<DRole>  roles = new ArrayList<DRole>();				//用户角色
	private List<DGroup> groups = new ArrayList<DGroup>();			//用户组列表
	
	
	private String userId;	//Mysql 用户ID
	private String ctime;	//创建时间
	
	public DUserRight() {
		super();
	}
	
	public DUserRight(String userId) {
		super();
		this.userId = userId;
	}

	public List<DResource> getResources() {
		return resources;
	}
	public void setResources(ArrayList<DResource> resources) {
		this.resources = resources;
	}
	public List<DRole> getRoles() {
		return roles;
	}
	public void setRoles(ArrayList<DRole> roles) {
		this.roles = roles;
	}
	public List<DGroup> getGroups() {
		return groups;
	}
	public void setGroups(ArrayList<DGroup> groups) {
		this.groups = groups;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	@Override
	public String toString() {
		return "DUserRight [resources=" + resources + ", roles=" + roles + ", groups=" + groups + ", userId=" + userId
				+ ", ctime=" + ctime + "]";
	}
	
	
	
	
}
