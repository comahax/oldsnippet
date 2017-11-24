package com.gmcc.pboss.business.resource.orderresstart;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrderresstartVO extends BaseVO implements Serializable {

    /** identifier field */
    private String comid;

    /** nullable persistent field */
    private Long count;
    
    private Long simtype;

    /** full constructor */
    public OrderresstartVO(java.lang.String comid, java.lang.Long count,java.lang.Long simtype) {
        this.comid = comid;
        this.count = count;
        this.simtype = simtype;
    }

    /** default constructor */
    public OrderresstartVO() {
    }

    /** minimal constructor */
    public OrderresstartVO(java.lang.String comid) {
        this.comid = comid;
    }

    public java.lang.String getComid() {
        return this.comid;
    }

    public void setComid(java.lang.String comid) {
        this.comid = comid;
    }

    public java.lang.Long getCount() {
        return this.count;
    }

    public void setCount(java.lang.Long count) {
        this.count = count;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comid", getComid())
            .toString();
    }

    
    public Long getSimtype() {
		return simtype;
	}

	public void setSimtype(Long simtype) {
		this.simtype = simtype;
	}

	public boolean equals(Object other) {
        if ( !(other instanceof OrderresstartVO) ) return false;
        OrderresstartVO castOther = (OrderresstartVO) other;
        return new EqualsBuilder()
            .append(this.getComid(), castOther.getComid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getComid())
            .toHashCode();
    }

}
