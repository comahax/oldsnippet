package com.sunrise.boss.business.common.tanstableinfo.persistent;

import java.io.Serializable;
import java.util.Date;

public class TansTableInfoVO implements Serializable {

	private String tablename;
	private String fieldname;
	private String fieldtype;
	private String transcond;
	private String fieldvalue;
	private Date transtime;
	private Date updatetime;
	private String memo;
	
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
	public String getFieldvalue() {
		return fieldvalue;
	}
	public void setFieldvalue(String fieldvalue) {
		this.fieldvalue = fieldvalue;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getTranscond() {
		return transcond;
	}
	public void setTranscond(String transcond) {
		this.transcond = transcond;
	}
	public Date getTranstime() {
		return transtime;
	}
	public void setTranstime(Date transtime) {
		this.transtime = transtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	} 
	
	
	
}
