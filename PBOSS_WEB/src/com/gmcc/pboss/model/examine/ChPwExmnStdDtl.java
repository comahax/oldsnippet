package com.gmcc.pboss.model.examine;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * ChKhExmnstddetail entity. @author MyEclipse Persistence Tools
 */
public class ChPwExmnStdDtl implements java.io.Serializable {
	// Fields

	private String wayid;
	private Integer exmnid;
	private Integer exmnstdid;
	private String exmnperiod;
	private String exmnname;
	private String exmnstdname;
	private Double exmnmark;

	// Property accessors

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public Integer getExmnid() {
		return exmnid;
	}

	public void setExmnid(Integer exmnid) {
		this.exmnid = exmnid;
	}

	public Integer getExmnstdid() {
		return exmnstdid;
	}

	public void setExmnstdid(Integer exmnstdid) {
		this.exmnstdid = exmnstdid;
	}

	public String getExmnperiod() {
		return exmnperiod;
	}

	public void setExmnperiod(String exmnperiod) {
		this.exmnperiod = exmnperiod;
	}

	public String getExmnname() {
		return exmnname;
	}

	public void setExmnname(String exmnname) {
		this.exmnname = exmnname;
	}

	public String getExmnstdname() {
		return exmnstdname;
	}

	public void setExmnstdname(String exmnstdname) {
		this.exmnstdname = exmnstdname;
	}

	public Double getExmnmark() {
		return exmnmark;
	}

	public void setExmnmark(Double exmnmark) {
		this.exmnmark = exmnmark;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		ChPwExmnStdDtl ed = (ChPwExmnStdDtl)obj;
		if(ed.wayid.equals(this.wayid) && 
		   ed.exmnid.intValue() == this.exmnid.intValue() && 
		   ed.exmnstdid.intValue() == this.exmnstdid.intValue() &&
		   ed.exmnperiod.equals(this.exmnperiod)){
			return true;
		}
		return false;
		
//		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	
}