package com.sunrise.boss.business.cms.waystarmonth.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.waystarmonthlog.persistent.WaystarmonthlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class WaystarmonthVO implements OperationLog {

    /** identifier field */
    private String eftmonth;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Short slv;

    /** nullable persistent field */
    private Double busivalue;

    /** nullable persistent field */
    private String opcode;

    /** nullable persistent field */
    private java.util.Date oprtime;
    
    private Short eftmonthtype;
    
    private String src;

    /** full constructor */
    public WaystarmonthVO(java.lang.String eftmonth, java.lang.String wayid, java.lang.Short slv, java.lang.Double busivalue, java.lang.String opcode, java.util.Date oprtime) {
        this.eftmonth = eftmonth;
        this.wayid = wayid;
        this.slv = slv;
        this.busivalue = busivalue;
        this.opcode = opcode;
        this.oprtime = oprtime;
    }

    /** default constructor */
    public WaystarmonthVO() {
    }

    /** minimal constructor */
    public WaystarmonthVO(java.lang.String eftmonth, java.lang.String wayid) {
        this.eftmonth = eftmonth;
        this.wayid = wayid;
    }

    public java.lang.String getEftmonth() {
        return this.eftmonth;
    }

    public void setEftmonth(java.lang.String eftmonth) {
        this.eftmonth = eftmonth;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Short getSlv() {
        return this.slv;
    }

    public void setSlv(java.lang.Short slv) {
        this.slv = slv;
    }

    public java.lang.Double getBusivalue() {
        return this.busivalue;
    }

    public void setBusivalue(java.lang.Double busivalue) {
        this.busivalue = busivalue;
    }

    public java.lang.String getOpcode() {
        return this.opcode;
    }

    public void setOpcode(java.lang.String opcode) {
        this.opcode = opcode;
    }

    public java.util.Date getOprtime() {
        return this.oprtime;
    }

    public void setOprtime(java.util.Date oprtime) {
        this.oprtime = oprtime;
    }
    

    public Short getEftmonthtype() {
		return eftmonthtype;
	}

	public void setEftmonthtype(Short eftmonthtype) {
		this.eftmonthtype = eftmonthtype;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("eftmonth", getEftmonth())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WaystarmonthVO) ) return false;
        WaystarmonthVO castOther = (WaystarmonthVO) other;
        return new EqualsBuilder()
            .append(this.getEftmonth(), castOther.getEftmonth())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getEftmonth())
            .append(getWayid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return WaystarmonthlogVO.class;
	}

}
