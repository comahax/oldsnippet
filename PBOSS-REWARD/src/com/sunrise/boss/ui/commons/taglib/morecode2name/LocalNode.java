package com.sunrise.boss.ui.commons.taglib.morecode2name;

import java.util.Map;

public class LocalNode  {

	String definition;
	Map items;

	String allname;
	String allcode;
	
	
	public String getValue(Object obj) throws Exception {
		
		
		if (items.containsKey(obj)) {
			return (String) items.get(obj);
			
		}
		return null;
	}
	
	public Map getItems() {
		return items;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public void setItems(Map items) {
		this.items = items;
	}

	public String getAllcode() {
		return allcode;
	}

	public void setAllcode(String allcode) {
		this.allcode = allcode;
	}

	public String getAllname() {
		return allname;
	}

	public void setAllname(String allname) {
		this.allname = allname;
	}
	
	
}