package com.gmcc.pboss.business.resource.discomres;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class DiscomresVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String disid;

    /** persistent field */
    private String discomcode;

    /** nullable persistent field */
    private String batchno;

    /** nullable persistent field */
    private String boxnum;

    /** full constructor */
    public DiscomresVO(java.lang.String disid, java.lang.String discomcode, java.lang.String batchno, java.lang.String boxnum) {
        this.disid = disid;
        this.discomcode = discomcode;
        this.batchno = batchno;
        this.boxnum = boxnum;
    }

    /** default constructor */
    public DiscomresVO() {
    }

    /** minimal constructor */
    public DiscomresVO(java.lang.String disid, java.lang.String discomcode) {
        this.disid = disid;
        this.discomcode = discomcode;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getDisid() {
        return this.disid;
    }

    public void setDisid(java.lang.String disid) {
        this.disid = disid;
    }

    public java.lang.String getDiscomcode() {
        return this.discomcode;
    }

    public void setDiscomcode(java.lang.String discomcode) {
        this.discomcode = discomcode;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.String getBoxnum() {
        return this.boxnum;
    }

    public void setBoxnum(java.lang.String boxnum) {
        this.boxnum = boxnum;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof DiscomresVO) ) return false;
        DiscomresVO castOther = (DiscomresVO) other;
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
