
package com.sunrise.boss.ui.commons.zoom;

import com.sunrise.boss.ui.base.BaseActionForm;


public class ZoomForm extends BaseActionForm {
	
	private String code ;
	
	private String name ;
	
	private String definition;
	
	private String condition ;
	
	private String property;
	
	private String  dbFlag;
	
	public String getCondition() {
		return condition;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public String getDefinition() {
		return definition;
	}
	
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
	
}
