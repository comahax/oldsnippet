package com.gmcc.pboss.business.sales.hisactivetol;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class HisactivetolVO extends BaseVO implements Serializable {

    /** identifier field */
    private String brand;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private Long hisactive01;

    /** nullable persistent field */
    private Long hisactive03;

    /** nullable persistent field */
    private Long hisactive06;

    /** nullable persistent field */
    private String memo;
    
    private String activetime;
    
    private String comresid;
    



    public HisactivetolVO(String brand, String wayid, Long hisactive01,
			Long hisactive03, Long hisactive06, String memo, String activetime,
			String comresid) {
		super();
		this.brand = brand;
		this.wayid = wayid;
		this.hisactive01 = hisactive01;
		this.hisactive03 = hisactive03;
		this.hisactive06 = hisactive06;
		this.memo = memo;
		this.activetime = activetime;
		this.comresid = comresid;
	}

	public String getActivetime() {
		return activetime;
	}

	public void setActivetime(String activetime) {
		this.activetime = activetime;
	}

	public String getComresid() {
		return comresid;
	}

	public void setComresid(String comresid) {
		this.comresid = comresid;
	}

	/** default constructor */
    public HisactivetolVO() {
    }

    /** minimal constructor */
    public HisactivetolVO(java.lang.String brand, java.lang.String wayid) {
        this.brand = brand;
        this.wayid = wayid;
    }

    public java.lang.String getBrand() {
        return this.brand;
    }

    public void setBrand(java.lang.String brand) {
        this.brand = brand;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.Long getHisactive01() {
        return this.hisactive01;
    }

    public void setHisactive01(java.lang.Long hisactive01) {
        this.hisactive01 = hisactive01;
    }

    public java.lang.Long getHisactive03() {
        return this.hisactive03;
    }

    public void setHisactive03(java.lang.Long hisactive03) {
        this.hisactive03 = hisactive03;
    }

    public java.lang.Long getHisactive06() {
        return this.hisactive06;
    }

    public void setHisactive06(java.lang.Long hisactive06) {
        this.hisactive06 = hisactive06;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("brand", getBrand())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof HisactivetolVO) ) return false;
        HisactivetolVO castOther = (HisactivetolVO) other;
        return new EqualsBuilder()
            .append(this.getBrand(), castOther.getBrand())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBrand())
            .append(getWayid())
            .toHashCode();
    }

}
