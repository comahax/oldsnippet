package com.gmcc.pboss.business.sales.incqttdtl;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class IncqttdtlVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private java.util.Date creatingtime;

    /** nullable persistent field */
    private Integer pid;

    /** nullable persistent field */
    private Integer ruleid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String prodid;

    /** nullable persistent field */
    private String effectmonth;

    /** nullable persistent field */
    private Integer quantity;

    /** full constructor */
    public IncqttdtlVO(java.lang.Long seqid, java.util.Date creatingtime, java.lang.Integer pid, java.lang.Integer ruleid, java.lang.String wayid, java.lang.String prodid, java.lang.String effectmonth, java.lang.Integer quantity) {
        this.seqid = seqid;
        this.creatingtime = creatingtime;
        this.pid = pid;
        this.ruleid = ruleid;
        this.wayid = wayid;
        this.prodid = prodid;
        this.effectmonth = effectmonth;
        this.quantity = quantity;
    }

    /** default constructor */
    public IncqttdtlVO() {
    }

    /** minimal constructor */
    public IncqttdtlVO(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.util.Date getCreatingtime() {
        return this.creatingtime;
    }

    public void setCreatingtime(java.util.Date creatingtime) {
        this.creatingtime = creatingtime;
    }

    public java.lang.Integer getPid() {
        return this.pid;
    }

    public void setPid(java.lang.Integer pid) {
        this.pid = pid;
    }

    public java.lang.Integer getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.Integer ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getProdid() {
        return this.prodid;
    }

    public void setProdid(java.lang.String prodid) {
        this.prodid = prodid;
    }

    public java.lang.String getEffectmonth() {
        return this.effectmonth;
    }

    public void setEffectmonth(java.lang.String effectmonth) {
        this.effectmonth = effectmonth;
    }

    public java.lang.Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(java.lang.Integer quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof IncqttdtlVO) ) return false;
        IncqttdtlVO castOther = (IncqttdtlVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

}
