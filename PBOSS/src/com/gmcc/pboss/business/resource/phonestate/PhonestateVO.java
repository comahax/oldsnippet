package com.gmcc.pboss.business.resource.phonestate;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class PhonestateVO extends BaseVO implements Serializable {

    /** identifier field */
    private String comresid;

    /** nullable persistent field */
    private Short comstate;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Short isactive;

    /** nullable persistent field */
    private java.util.Date acttime;

    /** nullable persistent field */
    private String orderid;
    
    private java.util.Date saletime;
    
    private String reswayid;

    /** full constructor */
    public PhonestateVO(java.lang.String comresid, java.lang.Short comstate, java.lang.String wayid, java.lang.Short isactive, java.util.Date acttime, java.lang.String orderid,java.util.Date saletime,
    		java.lang.String reswayid) {
        this.comresid = comresid;
        this.comstate = comstate;
        this.wayid = wayid;
        this.isactive = isactive;
        this.acttime = acttime;
        this.orderid = orderid;
        this.saletime = saletime;
        this.reswayid = reswayid;
    }
    public PhonestateVO(java.lang.String orderid,java.lang.String wayid) {
        this.wayid = wayid;
        this.orderid = orderid;
       
    }

    /** default constructor */
    public PhonestateVO() {
    }

    /** minimal constructor */
    public PhonestateVO(java.lang.String comresid) {
        this.comresid = comresid;
    }

    public java.lang.String getComresid() {
        return this.comresid;
    }

    public void setComresid(java.lang.String comresid) {
        this.comresid = comresid;
    }

    public java.lang.Short getComstate() {
        return this.comstate;
    }

    public void setComstate(java.lang.Short comstate) {
        this.comstate = comstate;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Short getIsactive() {
        return this.isactive;
    }

    public void setIsactive(java.lang.Short isactive) {
        this.isactive = isactive;
    }

    public java.util.Date getActtime() {
        return this.acttime;
    }

    public void setActtime(java.util.Date acttime) {
        this.acttime = acttime;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comresid", getComresid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof PhonestateVO) ) return false;
        PhonestateVO castOther = (PhonestateVO) other;
        return new EqualsBuilder()
            .append(this.getComresid(), castOther.getComresid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getComresid())
            .toHashCode();
    }

	public java.util.Date getSaletime() {
		return saletime;
	}

	public void setSaletime(java.util.Date saletime) {
		this.saletime = saletime;
	}

	public String getReswayid() {
		return reswayid;
	}

	public void setReswayid(String reswayid) {
		this.reswayid = reswayid;
	}

}
