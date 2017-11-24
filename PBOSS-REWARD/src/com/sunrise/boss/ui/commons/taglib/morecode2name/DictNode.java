package com.sunrise.boss.ui.commons.taglib.morecode2name;

import java.util.Map;

public class DictNode  {

	Map dictItems;
	String code;

	
	public String getValue(Object obj) throws Exception {

		if (dictItems.containsKey(obj)) {
			return (String) dictItems.get(obj);
		}
		
		return null;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Map getDictItems() {
		return dictItems;
	}


	public void setDictItems(Map dictItems) {
		this.dictItems = dictItems;
	}
	

	
	
}