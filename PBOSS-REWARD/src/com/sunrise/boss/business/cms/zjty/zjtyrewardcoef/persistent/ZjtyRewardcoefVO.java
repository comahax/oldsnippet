package com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.zjty.zjtyrewardcoef.persistent.ZjtyRewardcoefVO;
import com.sunrise.boss.business.cms.zjty.zjtyrewardcoeflog.persistent.ZjtyRewardcoeflogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ZjtyRewardcoefVO implements OperationLog {

    /** identifier field */
    private Short coefid;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private String effectiblemonth;

    /** nullable persistent field */
    private String cityid;
    
    /** nullable persistent field */
    private Double providecoef;

    /** nullable persistent field */
    private String result;
    
    /** nullable persistent field */
    private Short ispass;
    
    /** full constructor */
    public ZjtyRewardcoefVO(Short coefid, String wayid, java.lang.String effectiblemonth, java.lang.String cityid,
    						Double providecoef, String result,Short ispass) {
        this.coefid = coefid;
        this.wayid = wayid;
        this.effectiblemonth = effectiblemonth;
        this.cityid = cityid;
        this.providecoef = providecoef;
        this.result = result;
        this.ispass = ispass;
        
    }

    /** default constructor */
    public ZjtyRewardcoefVO() {
    }

    /** minimal constructor */
    public ZjtyRewardcoefVO(java.lang.Short coefid, java.lang.String wayid) {
        this.coefid = coefid;
        this.wayid = wayid;
    }

    public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public Short getCoefid() {
		return coefid;
	}

	public void setCoefid(Short coefid) {
		this.coefid = coefid;
	}

	public String getEffectiblemonth() {
		return effectiblemonth;
	}

	public void setEffectiblemonth(String effectiblemonth) {
		this.effectiblemonth = effectiblemonth;
	}

	public Short getIspass() {
		return ispass;
	}

	public void setIspass(Short ispass) {
		this.ispass = ispass;
	}

	public Double getProvidecoef() {
		return providecoef;
	}

	public void setProvidecoef(Double providecoef) {
		this.providecoef = providecoef;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("coefid", this.getCoefid())
            .append("wayid", this.getWayid())
            .append("effectiblemonth", this.getEffectiblemonth())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyRewardcoefVO) ) return false;
        ZjtyRewardcoefVO castOther = (ZjtyRewardcoefVO) other;
        return new EqualsBuilder()
            .append(this.getCoefid(), castOther.getCoefid())
            .append(this.getWayid(), castOther.getWayid())
            .append(this.getEffectiblemonth(), castOther.getEffectiblemonth())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCoefid())
            .append(getWayid())
            .append(getEffectiblemonth())
            .toHashCode();
    }
    public Class logVOClass() {
		// TODO Auto-generated method stub
		return ZjtyRewardcoeflogVO.class;
	}
    
}
