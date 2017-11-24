package com.sunrise.boss.business.qsmanage.paramrules.tabdefine.persistent;

import java.io.Serializable;

public class TabDefineVO implements Serializable {

	private String tabcode;
	private String tabname;
	private String fieldnamestr;
	private String mainfieldnamestr;
	private String translate;
	public String getTranslate() {
		return translate;
	}
	public void setTranslate(String translate) {
		this.translate = translate;
	}
	public String getFieldnamestr() {
		return fieldnamestr;
	}
	public void setFieldnamestr(String fieldnamestr) {
		this.fieldnamestr = fieldnamestr;
	}
	public String getMainfieldnamestr() {
		return mainfieldnamestr;
	}
	public void setMainfieldnamestr(String mainfieldnamestr) {
		this.mainfieldnamestr = mainfieldnamestr;
	}
	public String getTabcode() {
		return tabcode;
	}
	public void setTabcode(String tabcode) {
		this.tabcode = tabcode;
	}
	public String getTabname() {
		return tabname;
	}
	public void setTabname(String tabname) {
		this.tabname = tabname;
	}

}
