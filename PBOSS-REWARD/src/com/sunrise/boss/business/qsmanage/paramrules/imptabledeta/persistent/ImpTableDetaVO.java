package com.sunrise.boss.business.qsmanage.paramrules.imptabledeta.persistent;

import java.io.Serializable;

public class ImpTableDetaVO implements Serializable {
	
	private Long ruleid;
	private String tabcode;
	private String tabfoml;
	private String entparam;
	private String daoparam;
	private String listparam;
	private String deleparam;
	private String methodparam;
	private String entfoml;
	private String daofoml;
	private String listfoml;
	private String delefoml;
	private String methodfoml;
	private String mainfield;
	public String getEntparam() {
		return entparam;
	}
	public void setEntparam(String entparam) {
		this.entparam = entparam;
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
	public String getDaofoml() {
		return daofoml;
	}
	public void setDaofoml(String daofoml) {
		this.daofoml = daofoml;
	}
	public String getDaoparam() {
		return daoparam;
	}
	public void setDaoparam(String daoparam) {
		this.daoparam = daoparam;
	}
	public String getDelefoml() {
		return delefoml;
	}
	public void setDelefoml(String delefoml) {
		this.delefoml = delefoml;
	}
	public String getDeleparam() {
		return deleparam;
	}
	public void setDeleparam(String deleparam) {
		this.deleparam = deleparam;
	}
	public String getEntfoml() {
		return entfoml;
	}
	public void setEntfoml(String entfoml) {
		this.entfoml = entfoml;
	}
	public String getListfoml() {
		return listfoml;
	}
	public void setListfoml(String listfoml) {
		this.listfoml = listfoml;
	}
	public String getListparam() {
		return listparam;
	}
	public void setListparam(String listparam) {
		this.listparam = listparam;
	}
	public String getMainfield() {
		return mainfield;
	}
	public void setMainfield(String mainfield) {
		this.mainfield = mainfield;
	}
	public String getMethodfoml() {
		return methodfoml;
	}
	public void setMethodfoml(String methodfoml) {
		this.methodfoml = methodfoml;
	}
	public String getMethodparam() {
		return methodparam;
	}
	public void setMethodparam(String methodparam) {
		this.methodparam = methodparam;
	}
	public String getTabfoml() {
		return tabfoml;
	}
	public void setTabfoml(String tabfoml) {
		this.tabfoml = tabfoml;
	}
	
}
