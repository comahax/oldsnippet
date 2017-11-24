package com.gmcc.pboss.business.reward.rate;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.reward.ratelog.RatelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class RateVO extends BaseVO implements BusinessLog {

    /** identifier field */
    private String cityid;

    /** nullable persistent field */
    private Float rate;

    /** full constructor */
    public RateVO(java.lang.String cityid, java.lang.Float rate) {
        this.cityid = cityid;
        this.rate = rate;
    }

    /** default constructor */
    public RateVO() {
    }

    /** minimal constructor */
    public RateVO(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Float getRate() {
        return this.rate;
    }

    public void setRate(java.lang.Float rate) {
        this.rate = rate;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RateVO) ) return false;
        RateVO castOther = (RateVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return RatelogVO.class;
	}

}
