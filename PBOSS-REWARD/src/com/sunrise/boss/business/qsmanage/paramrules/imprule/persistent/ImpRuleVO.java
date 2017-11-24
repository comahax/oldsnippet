package com.sunrise.boss.business.qsmanage.paramrules.imprule.persistent;

import java.io.Serializable;
import java.util.Date;

public class ImpRuleVO implements Serializable {
	
	private Long ruleid;
	private Short status;
	private Date statustime;
	private String filehead;
	private String filetail;
	private String sepchar;
	private Short fieldnum;
	private String rulename;
	private Integer filenum;
	private String memo;
	public Short getFieldnum() {
		return fieldnum;
	}
	public void setFieldnum(Short fieldnum) {
		this.fieldnum = fieldnum;
	}
	public String getFilehead() {
		return filehead;
	}
	public void setFilehead(String filehead) {
		this.filehead = filehead;
	}
	public Integer getFilenum() {
		return filenum;
	}
	public void setFilenum(Integer filenum) {
		this.filenum = filenum;
	}
	public String getFiletail() {
		return filetail;
	}
	public void setFiletail(String filetail) {
		this.filetail = filetail;
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
	public String getRulename() {
		return rulename;
	}
	public void setRulename(String rulename) {
		this.rulename = rulename;
	}
	public String getSepchar() {
		return sepchar;
	}
	public void setSepchar(String sepchar) {
		this.sepchar = sepchar;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public Date getStatustime() {
		return statustime;
	}
	public void setStatustime(Date statustime) {
		this.statustime = statustime;
	}

}
