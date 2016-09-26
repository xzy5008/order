package com.hifox.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description: 基础配置
 *
 * @Date:2016年8月18日
 * @author:xzy
 */
@Component
public class HifoxProperties {
	
	/**
	 * 文件保存路径
	 */
    @Value("${hifox.file.path}")
    public String FILEPATH;
    
	/**
	 * 模板保存路径
	 */
    @Value("${hifox.template.path}")
    public String TEMPLATEPATH;
    
    
	/**
	 * CAS 服务器地址
	 */
    @Value("${hifox.cas.url}")
    public String CAS_URL;
    
	/**
	 * CAS 回调地址，当前项目地址
	 */
    @Value("${hifox.cas.local.url}")
    public String LOCAL_URL;
    
    
    
}
