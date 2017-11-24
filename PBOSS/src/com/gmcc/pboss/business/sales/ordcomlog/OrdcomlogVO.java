package com.gmcc.pboss.business.sales.ordcomlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrdcomlogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String orderid;

    /** nullable persistent field */
    private Long ordcomid;

    /** nullable persistent field */
    private Long amtb;

    /** nullable persistent field */
    private Long amta;

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private String others;

    private Integer id;
    
    /** full constructor */
    public OrdcomlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String orderid, java.lang.Long ordcomid, java.lang.Long amtb, java.lang.Long amta, java.lang.String memo, java.lang.String others) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.orderid = orderid;
        this.ordcomid = ordcomid;
        this.amtb = amtb;
        this.amta = amta;
        this.memo = memo;
        this.others = others;
    }

    /** default constructor */
    public OrdcomlogVO() {
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.Long getOrdcomid() {
        return this.ordcomid;
    }

    public void setOrdcomid(java.lang.Long ordcomid) {
        this.ordcomid = ordcomid;
    }

    public java.lang.Long getAmtb() {
        return this.amtb;
    }

    public void setAmtb(java.lang.Long amtb) {
        this.amtb = amtb;
    }

    public java.lang.Long getAmta() {
        return this.amta;
    }

    public void setAmta(java.lang.Long amta) {
        this.amta = amta;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public java.lang.String getOthers() {
        return this.others;
    }

    public void setOthers(java.lang.String others) {
        this.others = others;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrdcomlogVO) ) return false;
        OrdcomlogVO castOther = (OrdcomlogVO) other;
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
