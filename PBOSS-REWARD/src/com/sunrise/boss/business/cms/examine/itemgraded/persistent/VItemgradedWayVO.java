package com.sunrise.boss.business.cms.examine.itemgraded.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class VItemgradedWayVO implements Serializable{

    private String wayid;
    
    private String wayname;
    
    private String adtypecode;

    private String starlevel;
    
    private Integer exmnid;
    
    private String exmnname;

    private Integer exmnstdid;

    private String exmnstdname;
    
    private String isvoted;

    private Double exmnscore;
    
   
    
	public VItemgradedWayVO() {
		super();
	}

	public VItemgradedWayVO(String wayid, String wayname, String adtypecode, String starlevel, Integer exmnid, String exmnname, Integer exmnstdid, String exmnstdname,
			String isvoted, Double exmnscore) {
		super();
		this.wayid = wayid;
		this.wayname = wayname;
		this.adtypecode = adtypecode;
		this.starlevel = starlevel;
		this.exmnid = exmnid;
		this.exmnname = exmnname;
		this.exmnstdid = exmnstdid;
		this.exmnstdname = exmnstdname;
		this.isvoted = isvoted;
		this.exmnscore = exmnscore;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	public Integer getExmnid() {
		return exmnid;
	}

	public void setExmnid(Integer exmnid) {
		this.exmnid = exmnid;
	}

	public String getExmnname() {
		return exmnname;
	}

	public void setExmnname(String exmnname) {
		this.exmnname = exmnname;
	}

	public Integer getExmnstdid() {
		return exmnstdid;
	}

	public void setExmnstdid(Integer exmnstdid) {
		this.exmnstdid = exmnstdid;
	}

	public String getExmnstdname() {
		return exmnstdname;
	}

	public void setExmnstdname(String exmnstdname) {
		this.exmnstdname = exmnstdname;
	}

	public String getIsvoted() {
		return isvoted;
	}

	public void setIsvoted(String isvoted) {
		this.isvoted = isvoted;
	}

	public Double getExmnscore() {
		return exmnscore;
	}

	public void setExmnscore(Double exmnscore) {
		this.exmnscore = exmnscore;
	}

	public String getAdtypecode() {
		return adtypecode;
	}

	public void setAdtypecode(String adtypecode) {
		this.adtypecode = adtypecode;
	}

	public String getStarlevel() {
		return starlevel;
	}

	public void setStarlevel(String starlevel) {
		this.starlevel = starlevel;
	}

	

	    public boolean equals(Object other) {
	        if ( !(other instanceof VItemgradedWayVO) ) return false;
	        VItemgradedWayVO castOther = (VItemgradedWayVO) other;
	        return new EqualsBuilder()
	            .append(this.getWayid(), castOther.getWayid())
	            .append(this.getExmnid(), castOther.getExmnid())
	            .append(this.getExmnstdid(), castOther.getExmnstdid())
	            .isEquals();
	    }

	    public int hashCode() {
	        return new HashCodeBuilder()
	            .append(getWayid())
	            .toHashCode();
	    }
    
	
}
