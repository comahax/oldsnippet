package com.sunrise.boss.ui.resmanage.common;

import java.util.HashMap;
import java.util.Map;

public class Context {
	private Map map = new HashMap();
	
	public void assign(String oprName,Object value){
		if (value != null && !"".equals(value.toString()))
			map.put(oprName, new Double(value.toString()));
	}
	
	public Double lookup(String oprName) throws IllegalArgumentException{
		Double value = (Double)map.get(oprName);
		if (value == null){
			throw new IllegalArgumentException("变量"+oprName+"未被赋值");
		}
		return value;
	}
}
