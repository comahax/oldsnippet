package com.gmcc.pboss.business.sales.reqcomcate;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class ReqcomcateVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String reqid;

    /** persistent field */
    private String comcategory;

    /** persistent field */
    private Long orderamt;

    /** full constructor */
    public ReqcomcateVO(java.lang.String reqid, java.lang.String comcategory, java.lang.Long orderamt) {
        this.reqid = reqid;
        this.comcategory = comcategory;
        this.orderamt = orderamt;
    }

    /** default constructor */
    public ReqcomcateVO() {
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getReqid() {
        return this.reqid;
    }

    public void setReqid(java.lang.String reqid) {
        this.reqid = reqid;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.Long getOrderamt() {
        return this.orderamt;
    }

    public void setOrderamt(java.lang.Long orderamt) {
        this.orderamt = orderamt;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ReqcomcateVO) ) return false;
        ReqcomcateVO castOther = (ReqcomcateVO) other;
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
