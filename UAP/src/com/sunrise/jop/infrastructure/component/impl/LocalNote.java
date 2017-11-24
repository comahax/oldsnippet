package com.sunrise.jop.infrastructure.component.impl;

import java.util.Map;

public class LocalNote  {

	String definition;
	Map items;

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
}