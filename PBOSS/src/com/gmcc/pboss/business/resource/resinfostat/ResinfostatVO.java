package com.gmcc.pboss.business.resource.resinfostat;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ResinfostatVO extends BaseVO implements Serializable {

    /** identifier field */
    private String brand;

    /** identifier field */
    private java.util.Date statdate;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Long kcamount;

    /** nullable persistent field */
    private Long lhamount;

    /** nullable persistent field */
    private Long jhamount;
    
    private Long maxstock;
    
    private Long redvalue;
    
    private Long yelvalue;
    
    private String alarmlevel;
    

    /** full constructor */
    public ResinfostatVO(java.lang.String brand, java.util.Date statdate, java.lang.String wayid, java.lang.Long kcamount, java.lang.Long lhamount, java.lang.Long jhamount) {
        this.brand = brand;
        this.statdate = statdate;
        this.wayid = wayid;
        this.kcamount = kcamount;
        this.lhamount = lhamount;
        this.jhamount = jhamount;
    }

    /** default constructor */
    public ResinfostatVO() {
    }

    /** minimal constructor */
    public ResinfostatVO(java.lang.String brand, java.util.Date statdate, java.lang.String wayid) {
        this.brand = brand;
        this.statdate = statdate;
        this.wayid = wayid;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.util.Date getStatdate() {
        return this.statdate;
    }

    public void setStatdate(java.util.Date statdate) {
        this.statdate = statdate;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Long getKcamount() {
        return this.kcamount;
    }

    public void setKcamount(java.lang.Long kcamount) {
        this.kcamount = kcamount;
    }

    public java.lang.Long getLhamount() {
        return this.lhamount;
    }

    public void setLhamount(java.lang.Long lhamount) {
        this.lhamount = lhamount;
    }

    public java.lang.Long getJhamount() {
        return this.jhamount;
    }

    public void setJhamount(java.lang.Long jhamount) {
        this.jhamount = jhamount;
    }

    public Long getMaxstock() {
		return maxstock;
	}

	public void setMaxstock(Long maxstock) {
		this.maxstock = maxstock;
	}

	public Long getRedvalue() {
		return redvalue;
	}

	public void setRedvalue(Long redvalue) {
		this.redvalue = redvalue;
	}

	public Long getYelvalue() {
		return yelvalue;
	}

	public void setYelvalue(Long yelvalue) {
		this.yelvalue = yelvalue;
	}

	public String getAlarmlevel() {
		return alarmlevel;
	}

	public void setAlarmlevel(String alarmlevel) {
		this.alarmlevel = alarmlevel;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("brand", getBrand())
            .append("statdate", getStatdate())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ResinfostatVO) ) return false;
        ResinfostatVO castOther = (ResinfostatVO) other;
        return new EqualsBuilder()
            .append(this.getBrand(), castOther.getBrand())
            .append(this.getStatdate(), castOther.getStatdate())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBrand())
            .append(getStatdate())
            .append(getWayid())
            .toHashCode();
    }

}
