
package com.sunrise.boss.ui.commons.morecheck;

import com.sunrise.boss.ui.base.BaseActionForm;


public class MoreCheckForm extends BaseActionForm {
	
	private String code ;	
	private String name ;
	
	private String definition;	
	private String condition ;	
	private String property;	
	private String dbFlag;
	
	private String allname;
	private String allcode;
	
	private String fullname;
	private String fullcode;
	
	private String initcode;
	private String initname;
	
	private String uncheckcode;
	private String uncheckname;
	
	private boolean first; 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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

	

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public String getDbFlag() {
		return dbFlag;
	}

	public void setDbFlag(String dbFlag) {
		this.dbFlag = dbFlag;
	}

	public String getFullcode() {
		return fullcode;
	}

	public void setFullcode(String fullcode) {
		this.fullcode = fullcode;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getInitcode() {
		return initcode;
	}

	public void setInitcode(String initcode) {
		this.initcode = initcode;
	}

	public String getInitname() {
		return initname;
	}

	public void setInitname(String initname) {
		this.initname = initname;
	}

	public String getUncheckcode() {
		return uncheckcode;
	}

	public void setUncheckcode(String uncheckcode) {
		this.uncheckcode = uncheckcode;
	}

	public String getUncheckname() {
		return uncheckname;
	}

	public void setUncheckname(String uncheckname) {
		this.uncheckname = uncheckname;
	}

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
