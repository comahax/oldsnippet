package com.gmcc.pboss.business.base.batchsmsrc;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BatchsmsrcVO extends BaseVO implements Serializable {

    /** identifier field */
    private String mobile;

    /** identifier field */
    private String smscode;

    /** nullable persistent field */
    private String sdt;

    /** full constructor */
    public BatchsmsrcVO(java.lang.String mobile, java.lang.String smscode, java.lang.String sdt) {
        this.mobile = mobile;
        this.smscode = smscode;
        this.sdt = sdt;
    }

    /** default constructor */
    public BatchsmsrcVO() {
    }

    /** minimal constructor */
    public BatchsmsrcVO(java.lang.String mobile, java.lang.String smscode) {
        this.mobile = mobile;
        this.smscode = smscode;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.String getSmscode() {
        return this.smscode;
    }

    public void setSmscode(java.lang.String smscode) {
        this.smscode = smscode;
    }

    public java.lang.String getSdt() {
        return this.sdt;
    }

    public void setSdt(java.lang.String sdt) {
        this.sdt = sdt;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("mobile", getMobile())
            .append("smscode", getSmscode())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BatchsmsrcVO) ) return false;
        BatchsmsrcVO castOther = (BatchsmsrcVO) other;
        return new EqualsBuilder()
            .append(this.getMobile(), castOther.getMobile())
            .append(this.getSmscode(), castOther.getSmscode())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getMobile())
            .append(getSmscode())
            .toHashCode();
    }

}
