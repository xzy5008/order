package com.hifox.config.security.util;

import java.util.ArrayList;

import com.hifox.config.security.pj.DModel;


/**
 * @Title: SetList.java
 * @Description: 用于mongoRef 去重复 
 * @Date:2016年9月22日
 * @author:xiezhongyong
 * @version 1.0
 */
public class RefList<T extends DModel> extends ArrayList<T> {  
    private static final long serialVersionUID = 1434324234L;  
  
    @Override  
    public boolean add(T object) {
    	if(null == object || null == object.getId())
    		return false;
        if (size() == 0) {  
            return super.add(object);  
        } else {  
            int count = 0;  
            for (T t : this) {
                if (t.getId().equals(object.getId())) {  
                    count++;  
                    break;  
                }
            }  
            if (count == 0) {  
                return super.add(object);  
            } else {  
                return false;  
            }  
        }  
    }  
}  