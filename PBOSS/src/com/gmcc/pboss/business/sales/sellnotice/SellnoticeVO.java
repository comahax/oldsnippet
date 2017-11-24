package com.gmcc.pboss.business.sales.sellnotice;

import com.gmcc.pboss.business.sales.sellnoticelog.SellnoticelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class SellnoticeVO extends BaseVO implements Serializable, BusinessLog {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String mareacode;

    /** nullable persistent field */
    private String selltime;

    /** nullable persistent field */
    private Long sellcount;

    /** nullable persistent field */
    private Short starlevel;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String waymagcode;

    /** nullable persistent field */
    private Long salesstd;

    /** nullable persistent field */
    private java.lang.Double comrate;
    
    private String wayname;

    /** full constructor */
    public SellnoticeVO(java.lang.Long seqid, java.lang.String countyid, java.lang.String mareacode, java.lang.String selltime, java.lang.Long sellcount, java.lang.Short starlevel, java.lang.String wayid, java.lang.String waymagcode, java.lang.Long salesstd, java.lang.Double comrate) {
        this.seqid = seqid;
        this.countyid = countyid;
        this.mareacode = mareacode;
        this.selltime = selltime;
        this.sellcount = sellcount;
        this.starlevel = starlevel;
        this.wayid = wayid;
        this.waymagcode = waymagcode;
        this.salesstd = salesstd;
        this.comrate = comrate;
    }

    /** default constructor */
    public SellnoticeVO() {
    }

    /** minimal constructor */
    public SellnoticeVO(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getMareacode() {
        return this.mareacode;
    }

    public void setMareacode(java.lang.String mareacode) {
        this.mareacode = mareacode;
    }

    public java.lang.String getSelltime() {
        return this.selltime;
    }

    public void setSelltime(java.lang.String selltime) {
        this.selltime = selltime;
    }

    public java.lang.Long getSellcount() {
        return this.sellcount;
    }

    public void setSellcount(java.lang.Long sellcount) {
        this.sellcount = sellcount;
    }

    public java.lang.Short getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel) {
        this.starlevel = starlevel;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWaymagcode() {
        return this.waymagcode;
    }

    public void setWaymagcode(java.lang.String waymagcode) {
        this.waymagcode = waymagcode;
    }

    public java.lang.Long getSalesstd() {
        return this.salesstd;
    }

    public void setSalesstd(java.lang.Long salesstd) {
        this.salesstd = salesstd;
    }

    public java.lang.Double getComrate() {
        return this.comrate;
    }

    public void setComrate(java.lang.Double comrate) {
        this.comrate = comrate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SellnoticeVO) ) return false;
        SellnoticeVO castOther = (SellnoticeVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return SellnoticelogVO.class;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

}
