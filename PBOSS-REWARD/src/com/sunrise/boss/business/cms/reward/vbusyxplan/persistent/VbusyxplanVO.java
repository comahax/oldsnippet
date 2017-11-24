package com.sunrise.boss.business.cms.reward.vbusyxplan.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VbusyxplanVO implements Serializable {

    /** identifier field */
    private String opnid;

    /** identifier field */
    private Long yxplanid;

    /** nullable persistent field */
    private Double wrapfee;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String planbusitype;

    /** nullable persistent field */
    private String wayid;
    private Long noncyc ; //客户维系酬金发放期数
  private String prodid;
    
    private Long seq;
    
    /** full constructor */
    public VbusyxplanVO(java.lang.String opnid, java.lang.Long yxplanid, java.lang.Double wrapfee, java.lang.String cityid, java.lang.String planbusitype,java.lang.Long noncyc, 
    		java.lang.String wayid,java.lang.String prodid,java.lang.Long seq) {
        this.opnid = opnid;
        this.yxplanid = yxplanid;
        this.wrapfee = wrapfee;
        this.cityid = cityid;
        this.planbusitype = planbusitype;
        this.wayid = wayid;
        this.noncyc = noncyc;
        this.prodid = prodid;
        this.seq = seq;
    }

    /** default constructor */
    public VbusyxplanVO() {
    }

    /** minimal constructor */
    public VbusyxplanVO(java.lang.String opnid, java.lang.Long yxplanid) {
        this.opnid = opnid;
        this.yxplanid = yxplanid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.Double getWrapfee() {
        return this.wrapfee;
    }

    public void setWrapfee(java.lang.Double wrapfee) {
        this.wrapfee = wrapfee;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getPlanbusitype() {
        return this.planbusitype;
    }

    public void setPlanbusitype(java.lang.String planbusitype) {
        this.planbusitype = planbusitype;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("opnid", getOpnid())
            .append("yxplanid", getYxplanid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VbusyxplanVO) ) return false;
        VbusyxplanVO castOther = (VbusyxplanVO) other;
        return new EqualsBuilder()
            .append(this.getOpnid(), castOther.getOpnid())
            .append(this.getYxplanid(), castOther.getYxplanid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOpnid())
            .append(getYxplanid())
            .toHashCode();
    }

	public Long getNoncyc() {
		return noncyc;
	}

	public void setNoncyc(Long noncyc) {
		this.noncyc = noncyc;
	}

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

}
