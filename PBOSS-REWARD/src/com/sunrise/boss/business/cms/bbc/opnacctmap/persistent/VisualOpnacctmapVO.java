package com.sunrise.boss.business.cms.bbc.opnacctmap.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VisualOpnacctmapVO implements Serializable {
	
    /** identifier field */
    private String opnid;

    /** identifier field */
    private Long acctid;
	
    private String opnname;
    
    private String acctname;
    
    /** full constructor */
    public VisualOpnacctmapVO(java.lang.Long acctid, java.lang.String opnid) {
        this.opnid = opnid;
        this.acctid = acctid;
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
    public VisualOpnacctmapVO() {
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OpnacctmapVO) ) return false;
        OpnacctmapVO castOther = (OpnacctmapVO) other;
        return new EqualsBuilder()
            .append(this.getOpnid(), castOther.getOpnid())
            .append(this.getAcctid(), castOther.getAcctid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOpnid())
            .append(getAcctid())
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
}
