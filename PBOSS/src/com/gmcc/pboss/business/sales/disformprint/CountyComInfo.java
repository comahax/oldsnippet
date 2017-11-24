package com.gmcc.pboss.business.sales.disformprint;

import java.io.Serializable;

public class CountyComInfo implements Serializable {
	private String countyid;
	private String comid;
	private Long num;
	
	public CountyComInfo(){
		;
	}	
	
	public CountyComInfo(String countyid, String comid, Long num) {
		super();
		this.countyid = countyid;
		this.comid = comid;
		this.num = num;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getComid() {
		return comid;
	}

	public void setComid(String comid) {
		this.comid = comid;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comid == null) ? 0 : comid.hashCode());
		result = prime * result
				+ ((countyid == null) ? 0 : countyid.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountyComInfo other = (CountyComInfo) obj;
		if (comid == null) {
			if (other.comid != null)
				return false;
		} else if (!comid.equals(other.comid))
			return false;
		if (countyid == null) {
			if (other.countyid != null)
				return false;
		} else if (!countyid.equals(other.countyid))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		return true;
	}
}
