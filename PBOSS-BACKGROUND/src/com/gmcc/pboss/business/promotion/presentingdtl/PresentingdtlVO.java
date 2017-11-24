package com.gmcc.pboss.business.promotion.presentingdtl;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class PresentingdtlVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private java.util.Date creatingtime;

    /** nullable persistent field */
    private Long pid;

    /** nullable persistent field */
    private Long ruleid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String comcategory;

    /** nullable persistent field */
    private Short quantity;

    /** full constructor */
    public PresentingdtlVO(java.util.Date creatingtime, java.lang.Long pid, java.lang.Long ruleid, java.lang.String wayid, java.lang.String comcategory, java.lang.Short quantity) {
        this.creatingtime = creatingtime;
        this.pid = pid;
        this.ruleid = ruleid;
        this.wayid = wayid;
        this.comcategory = comcategory;
        this.quantity = quantity;
    }

    /** default constructor */
    public PresentingdtlVO() {
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

    public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getRuleid() {
		return ruleid;
	}

	public void setRuleid(Long ruleid) {
		this.ruleid = ruleid;
	}

	public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.Short getQuantity() {
        return this.quantity;
    }

    public void setQuantity(java.lang.Short quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PresentingdtlVO) ) return false;
        PresentingdtlVO castOther = (PresentingdtlVO) other;
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
