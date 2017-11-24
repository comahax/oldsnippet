package com.sunrise.boss.business.qsmanage.paramrules.impfielddeta.persistent;

import java.io.Serializable;

public class ImpFieldDetaVO implements Serializable {
	private Long ruleid;
	private String tabcode;	
	private String businame;
	private String fieldcode;
	private String fieldname;
	private Short fieldindex;
	private String defaultvalue;
	private String fieldtype;
	private Short mainfield;
	private String memo;
	public String getBusiname() {
		return businame;
	}
	public void setBusiname(String businame) {
		this.businame = businame;
	}
	public String getDefaultvalue() {
		return defaultvalue;
	}
	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}
	public String getFieldcode() {
		return fieldcode;
	}
	public void setFieldcode(String fieldcode) {
		this.fieldcode = fieldcode;
	}
	public Short getFieldindex() {
		return fieldindex;
	}
	public void setFieldindex(Short fieldindex) {
		this.fieldindex = fieldindex;
	}
	public String getFieldname() {
		return fieldname;
	}
	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}
	public String getFieldtype() {
		return fieldtype;
	}
	public void setFieldtype(String fieldtype) {
		this.fieldtype = fieldtype;
	}
	public Short getMainfield() {
		return mainfield;
	}
	public void setMainfield(Short mainfield) {
		this.mainfield = mainfield;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Long getRuleid() {
		return ruleid;
	}
	public void setRuleid(Long ruleid) {
		this.ruleid = ruleid;
	}
	public String getTabcode() {
		return tabcode;
	}
	public void setTabcode(String tabcode) {
		this.tabcode = tabcode;
	}
	
}
