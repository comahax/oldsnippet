package com.sunrise.boss.business.cms.reward.cbopnacctmap.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class VisualCbopnacctmapVO implements Serializable {
	
    /** identifier field */
    private String opnid;

    /** identifier field */
    private Long acctid;
	
    /** identifier field */
    private String cityid;
    
    private String opnname;
    
    private String acctname;
    

    
    /** full constructor */
    public VisualCbopnacctmapVO(java.lang.Long acctid, java.lang.String opnid, java.lang.String cityid) {
        this.opnid = opnid;
        this.acctid = acctid;
        this.cityid = cityid;
    }

    public Long getAcctid() {
		return acctid;
	}

	public void setAcctid(Long acctid) {
		this.acctid = acctid;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	/** default constructor */
    public VisualCbopnacctmapVO() {
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CbopnacctmapVO) ) return false;
        CbopnacctmapVO castOther = (CbopnacctmapVO) other;
        return new EqualsBuilder()
            .append(this.getOpnid(), castOther.getOpnid())
            .append(this.getAcctid(), castOther.getAcctid())
            .append(this.getCityid(), castOther.getCityid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOpnid())
            .append(getAcctid())
            .append(getCityid())
            .toHashCode();
    }

	public String getAcctname() {
		return acctname;
	}

	public void setAcctname(String acctname) {
		this.acctname = acctname;
	}

	public String getOpnname() {
		return opnname;
	}

	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
}
