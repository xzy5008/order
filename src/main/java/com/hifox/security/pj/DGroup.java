package com.hifox.security.pj;

import java.util.ArrayList;
import java.util.List;



/**
 * @Title: DGroup.java
 * @Description: 组信息
 * @Date:2016年9月27日
 * @author:xiezhongyong
 * @version 1.0
 */
public class DGroup extends DModel{
	private static final long serialVersionUID = -3934546713348479510L;
	private String groupName;	//权限名
	private String description;	//描述
	private String ctime;		//创建时间
	private List<DResource> resources = new ArrayList<DResource>();

	

	public DGroup() {
		super();
	}

	public DGroup(String groupName, String description) {
		super();
		this.groupName = groupName;
		this.description = description;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public List<DResource> getResources() {
		return resources;
	}

	public void setResources(List<DResource> resources) {
		this.resources = resources;
	}

	@Override
	public String toString() {
		return "DGroup [id=" + getId() + ", groupName=" + groupName + ", description=" + description + ", ctime=" + ctime
				+ ", resources=" + resources + "]";
	}

	


}
