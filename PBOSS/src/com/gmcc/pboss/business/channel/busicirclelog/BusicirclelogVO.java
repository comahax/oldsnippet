package com.gmcc.pboss.business.channel.busicirclelog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class BusicirclelogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
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
    public BusicirclelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String buscno, java.lang.String buscname, java.lang.String buscelevel, java.lang.String countyid, java.lang.String cityid, java.lang.String buscaddr, java.util.Date createtime) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.buscno = buscno;
        this.buscname = buscname;
        this.buscelevel = buscelevel;
        this.countyid = countyid;
        this.cityid = cityid;
        this.buscaddr = buscaddr;
        this.createtime = createtime;
    }

    /** default constructor */
    public BusicirclelogVO() {
    }

    /** minimal constructor */
    public BusicirclelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprtype) {
        this.logid = logid;
        this.optime = optime;
        this.oprtype = oprtype;
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
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

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
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
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof BusicirclelogVO) ) return false;
        BusicirclelogVO castOther = (BusicirclelogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
