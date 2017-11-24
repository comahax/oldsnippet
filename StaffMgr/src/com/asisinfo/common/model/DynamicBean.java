package com.asisinfo.common.model;

import java.util.HashMap;
import java.util.Map;

public class DynamicBean extends HashMap{
	private Map beanConfig;
	
	public DynamicBean(){
		this.beanConfig = new HashMap();
	}
	
	public Map getConfig(){
		return beanConfig;
	}
	
	public DynamicBean(Map config){
		if(config==null)
			throw new IllegalArgumentException("DynamicBean配置参数不能为空!");
		this.beanConfig = config;
	}
	
	public String[] getDeclaredFieldNames(){
		return  (String[])beanConfig.keySet().toArray();
	}
	
	public String[] getDeclaredFieldTypes(){
		return (String[]) beanConfig.values().toArray();
	}
	
	public String[] getFieldNames(){
		return (String[])this.keySet().toArray();
	}
	
	public Object[] getsFieldValues(){
		return this.values().toArray();
	}
}
