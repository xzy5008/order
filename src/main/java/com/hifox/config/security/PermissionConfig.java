package com.hifox.config.security;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;


/**
 * @version 1.0 权限配置文件加载
 */
@SuppressWarnings("unchecked")
public class PermissionConfig implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 130345515953775313L;
	private static final Logger log = Logger.getLogger(PermissionConfig.class);
	/**
	 * 配置文件名称
	 */
	static final String propfilename = "permissionConfig";
	static{
		PermissionConfig instance = new PermissionConfig();
		resourceBundle = ResourceBundle.getBundle(propfilename);
	}
	
	static ResourceBundle resourceBundle;
	/**
	 *加载配置文件
	 */
	private PermissionConfig() {
		try {
			log.info("##############PermissionConfig 配置文件 加载了");
			
		} catch(Exception e) {
			log.error("Outside Constant File Read Error.", e);
		}
	}
	
	/**
	 * 配置文件加载
	 * @throws Exception
	 */
	private static String get(String key) throws Exception {
		return resourceBundle.getString(key);
		
	}
	
	/**
	 * 将系统资源同步到用户系统【后期接入接口】
	 * @throws Exception 
	 */
	public static void synResource(){
		try {
			Enumeration<String> keys = resourceBundle.getKeys();
			while(keys.hasMoreElements()){
				String url = keys.nextElement();
				String[] vals = get(url).split("-");
				if(vals.length!=3){
					throw new RuntimeException("系统权限资源配置有误："+ url);
				}
				
				System.out.println(url+"-"+get(url));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) throws Exception {
		synResource();
	}
	/**
	 * 状态 拆分
	 * @param str
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private HashMap splitStatus(String str)throws Exception {
		HashMap<String, String> resultMap = new HashMap<String, String>();
		String[] temp = token(str,",");
		for(int i=0;i<temp.length;i++){
			String[] val = token(temp[i],"=");
			resultMap.put(val[0], val[1]);
		}
		return resultMap;
	}	

	private String[] token(String str,String ceparator)throws Exception {
		StringTokenizer st = new StringTokenizer(str, ceparator);
		String return_arrayStr[] = new String[st.countTokens()];
		int count=0;
		while(st.hasMoreTokens()) {		      
			return_arrayStr[count]=st.nextToken();
		      count++;
	    }
		return return_arrayStr;
	}
	
}
