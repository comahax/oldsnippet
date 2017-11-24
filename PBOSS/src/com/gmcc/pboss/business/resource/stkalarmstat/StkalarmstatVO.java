package com.gmcc.pboss.business.resource.stkalarmstat;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class StkalarmstatVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private java.util.Date alarmdate;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String brand;

    /** nullable persistent field */
    private String alarmlevel;

    /** nullable persistent field */
    private Long crtstock;

    /** nullable persistent field */
    private String orderid;
    
    private String isgiveup;

    /** full constructor */
    public StkalarmstatVO(java.util.Date alarmdate, java.lang.String wayid, java.lang.String brand, java.lang.String alarmlevel, java.lang.Long crtstock, java.lang.String orderid, java.lang.String isgiveup) {
        this.alarmdate = alarmdate;
        this.wayid = wayid;
        this.brand = brand;
        this.alarmlevel = alarmlevel;
        this.crtstock = crtstock;
        this.orderid = orderid;
        this.isgiveup = isgiveup;
    }

    /** default constructor */
    public StkalarmstatVO() {
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.util.Date getAlarmdate() {
        return this.alarmdate;
    }

    public void setAlarmdate(java.util.Date alarmdate) {
        this.alarmdate = alarmdate;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.String getAlarmlevel() {
        return this.alarmlevel;
    }

    public void setAlarmlevel(java.lang.String alarmlevel) {
        this.alarmlevel = alarmlevel;
    }

    public java.lang.Long getCrtstock() {
        return this.crtstock;
    }

    public void setCrtstock(java.lang.Long crtstock) {
        this.crtstock = crtstock;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public String getIsgiveup() {
		return isgiveup;
	}

	public void setIsgiveup(String isgiveup) {
		this.isgiveup = isgiveup;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StkalarmstatVO) ) return false;
        StkalarmstatVO castOther = (StkalarmstatVO) other;
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
