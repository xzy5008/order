package com.hifox.config.security.pj;

import java.util.ArrayList;
import java.util.List;



/**
 * @Title: TRole.java
 * @Description: 角色
 * @Date:2016年9月22日
 * @author:xiezhongyong
 * @version 1.0
 */
public class DRole extends DModel{

	private String codeName;		//代码角色名 如：ROLE_USER
	private String roleName;		//角色名称
	private String description;		//描述
	private String ctime;			//创建时间
	private List<DResource> resources = new ArrayList<DResource>();

	
	public DRole() {
		super();
	}

	public DRole(String codeName, String roleName, String description) {
		super();
		this.codeName = codeName;
		this.roleName = roleName;
		this.description = description;
	}


	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
		return "DRole [id=" + getId() + ", codeName=" + codeName + ", roleName=" + roleName + ", description=" + description
				+ ", ctime=" + ctime + ", resources=" + resources + "]";
	}

	
	

	
	
}
