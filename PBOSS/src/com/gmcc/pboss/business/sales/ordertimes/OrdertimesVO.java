package com.gmcc.pboss.business.sales.ordertimes;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrdertimesVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String objtype;

    /** persistent field */
    private String objectcode;

    /** persistent field */
    private Short maxtimes;
    
    /** persistent field */
    private Short isurgent;

    /** full constructor */
    public OrdertimesVO(java.lang.String objtype, java.lang.String objectcode, java.lang.Short maxtimes, java.lang.Short isurgent) {
        this.objtype = objtype;
        this.objectcode = objectcode;
        this.maxtimes = maxtimes;
        this.isurgent=isurgent;
    }

    /** default constructor */
    public OrdertimesVO() {
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getObjtype() {
        return this.objtype;
    }

    public void setObjtype(java.lang.String objtype) {
        this.objtype = objtype;
    }

    public java.lang.String getObjectcode() {
        return this.objectcode;
    }

    public void setObjectcode(java.lang.String objectcode) {
        this.objectcode = objectcode;
    }

    public java.lang.Short getMaxtimes() {
        return this.maxtimes;
    }

    public void setMaxtimes(java.lang.Short maxtimes) {
        this.maxtimes = maxtimes;
    }
    
    public Short getIsurgent() {
		return isurgent;
	}

	public void setIsurgent(Short isurgent) {
		this.isurgent = isurgent;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrdertimesVO) ) return false;
        OrdertimesVO castOther = (OrdertimesVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

}
