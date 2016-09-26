package com.hifox.config.security.pj;



/**
 * @Title: DResource.java
 * @Description: 资源
 * @Date:2016年9月22日
 * @author:xiezhongyong
 * @version 1.0
 */
public class DResource extends DModel{

	private String resourcetName;	//资源名
	private String type;			//权限类型(POST/GET...)
	private String url;				// 路径
	private String description;		//描述
	private String ctime;			//创建时间
	private String sysKey;			//所属系统
	
	
	public DResource() {
		super();
	}
	
	public DResource(String resourcetName, String type, String url, String description, String sysKey) {
		super();
		this.resourcetName = resourcetName;
		this.type = type;
		this.url = url;
		this.description = description;
		this.sysKey = sysKey;
	}
	public String getResourcetName() {
		return resourcetName;
	}
	public void setResourcetName(String resourcetName) {
		this.resourcetName = resourcetName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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

	public String getSysKey() {
		return sysKey;
	}

	public void setSysKey(String sysKey) {
		this.sysKey = sysKey;
	}

	@Override
	public String toString() {
		return "DResource [id=" + getId() + ", resourcetName=" + resourcetName + ", type=" + type + ", url=" + url
				+ ", description=" + description + ", ctime=" + ctime + ", sysKey=" + sysKey + "]";
	}

	


	
	
	
	
	



}
