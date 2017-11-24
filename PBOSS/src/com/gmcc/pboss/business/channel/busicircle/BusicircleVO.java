package com.gmcc.pboss.business.channel.busicircle;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.channel.busicirclelog.BusicirclelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class BusicircleVO extends BaseVO implements Serializable,BusinessLog {

    /** identifier field */
    private String buscno;

    /** nullable persistent field */
    private String buscname;

    /** nullable persistent field */
    private String buscelevel;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String buscaddr;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** full constructor */
    public BusicircleVO(java.lang.String buscno, java.lang.String buscname, java.lang.String buscelevel, java.lang.String countyid, java.lang.String cityid, java.lang.String buscaddr, java.util.Date createtime) {
        this.buscno = buscno;
        this.buscname = buscname;
        this.buscelevel = buscelevel;
        this.countyid = countyid;
        this.cityid = cityid;
        this.buscaddr = buscaddr;
        this.createtime = createtime;
    }

    /** default constructor */
    public BusicircleVO() {
    }

    /** minimal constructor */
    public BusicircleVO(java.lang.String buscno) {
        this.buscno = buscno;
    }

    public java.lang.String getBuscno() {
        return this.buscno;
    }

    public void setBuscno(java.lang.String buscno) {
        this.buscno = buscno;
    }

    public java.lang.String getBuscname() {
        return this.buscname;
    }

    public void setBuscname(java.lang.String buscname) {
        this.buscname = buscname;
    }

    public java.lang.String getBuscelevel() {
        return this.buscelevel;
    }

    public void setBuscelevel(java.lang.String buscelevel) {
        this.buscelevel = buscelevel;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getBuscaddr() {
        return this.buscaddr;
    }

    public void setBuscaddr(java.lang.String buscaddr) {
        this.buscaddr = buscaddr;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("buscno", getBuscno())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BusicircleVO) ) return false;
        BusicircleVO castOther = (BusicircleVO) other;
        return new EqualsBuilder()
            .append(this.getBuscno(), castOther.getBuscno())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBuscno())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return BusicirclelogVO.class;
	}

}
