package com.gmcc.pboss.business.resource.stkalarmct;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class StkalarmctVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private java.util.Date statdate;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String brand;

    /** nullable persistent field */
    private Long kcamount;

    /** nullable persistent field */
   // private Long stocklimit;

    /** nullable persistent field */
    private Long realstock;

    /** nullable persistent field */
    private String isalarm;
    
    private String isnotice;

    
    /** nullable persistent field */
    private Long greenstock;

    /** nullable persistent field */
    private Long yellowstock;

    /** nullable persistent field */
    private Long redstock;

    /** nullable persistent field */
    private Long greengap;

    /** nullable persistent field */
    private Long yellowgap;

    /** nullable persistent field */
    private Long redgap;

    /** nullable persistent field */
    private Long saleamt;

    /** nullable persistent field */
    private Long supportday;


    public StkalarmctVO(Long seqid, Date statdate, String countyid,
			String brand, Long kcamount, Long realstock, String isalarm,
			String isnotice, Long greenstock, Long yellowstock, Long redstock,
			Long greengap, Long yellowgap, Long redgap, Long saleamt,
			Long supportday) {
		super();
		this.seqid = seqid;
		this.statdate = statdate;
		this.countyid = countyid;
		this.brand = brand;
		this.kcamount = kcamount;
		this.realstock = realstock;
		this.isalarm = isalarm;
		this.isnotice = isnotice;
		this.greenstock = greenstock;
		this.yellowstock = yellowstock;
		this.redstock = redstock;
		this.greengap = greengap;
		this.yellowgap = yellowgap;
		this.redgap = redgap;
		this.saleamt = saleamt;
		this.supportday = supportday;
	}

	public Long getGreenstock() {
		return greenstock;
	}

	public void setGreenstock(Long greenstock) {
		this.greenstock = greenstock;
	}

	public Long getYellowstock() {
		return yellowstock;
	}

	public void setYellowstock(Long yellowstock) {
		this.yellowstock = yellowstock;
	}

	public Long getRedstock() {
		return redstock;
	}

	public void setRedstock(Long redstock) {
		this.redstock = redstock;
	}

	public Long getGreengap() {
		return greengap;
	}

	public void setGreengap(Long greengap) {
		this.greengap = greengap;
	}

	public Long getYellowgap() {
		return yellowgap;
	}

	public void setYellowgap(Long yellowgap) {
		this.yellowgap = yellowgap;
	}

	public Long getRedgap() {
		return redgap;
	}

	public void setRedgap(Long redgap) {
		this.redgap = redgap;
	}

	public Long getSaleamt() {
		return saleamt;
	}

	public void setSaleamt(Long saleamt) {
		this.saleamt = saleamt;
	}

	public Long getSupportday() {
		return supportday;
	}

	public void setSupportday(Long supportday) {
		this.supportday = supportday;
	}

	/** default constructor */
    public StkalarmctVO() {
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.util.Date getStatdate() {
        return this.statdate;
    }

    public void setStatdate(java.util.Date statdate) {
        this.statdate = statdate;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.Long getKcamount() {
        return this.kcamount;
    }

    public void setKcamount(java.lang.Long kcamount) {
        this.kcamount = kcamount;
    }

   

    public java.lang.Long getRealstock() {
        return this.realstock;
    }

    public void setRealstock(java.lang.Long realstock) {
        this.realstock = realstock;
    }

    public java.lang.String getIsalarm() {
        return this.isalarm;
    }

    public void setIsalarm(java.lang.String isalarm) {
        this.isalarm = isalarm;
    }

    public java.lang.String getIsnotice() {
		return isnotice;
	}

	public void setIsnotice(java.lang.String isnotice) {
		this.isnotice = isnotice;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StkalarmctVO) ) return false;
        StkalarmctVO castOther = (StkalarmctVO) other;
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
