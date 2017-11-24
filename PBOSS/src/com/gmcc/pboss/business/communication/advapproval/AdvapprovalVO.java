package com.gmcc.pboss.business.communication.advapproval;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AdvapprovalVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long approvalid;

    /** nullable persistent field */
    private Long advinfoid;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String content;

    /** nullable persistent field */
    private Short state;

    /** full constructor */
    public AdvapprovalVO(java.lang.Long advinfoid, java.lang.String oprcode, java.lang.String content, java.lang.Short state) {
        this.advinfoid = advinfoid;
        this.oprcode = oprcode;
        this.content = content;
        this.state = state;
    }

    /** default constructor */
    public AdvapprovalVO() {
    }

    public java.lang.Long getApprovalid() {
        return this.approvalid;
    }

    public void setApprovalid(java.lang.Long approvalid) {
        this.approvalid = approvalid;
    }

    public java.lang.Long getAdvinfoid() {
        return this.advinfoid;
    }

    public void setAdvinfoid(java.lang.Long advinfoid) {
        this.advinfoid = advinfoid;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public void setContent(java.lang.String content) {
        this.content = content;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("approvalid", getApprovalid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AdvapprovalVO) ) return false;
        AdvapprovalVO castOther = (AdvapprovalVO) other;
        return new EqualsBuilder()
            .append(this.getApprovalid(), castOther.getApprovalid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getApprovalid())
            .toHashCode();
    }

}
