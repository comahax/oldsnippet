package com.gmcc.pboss.business.sales.extraexent;

import com.gmcc.pboss.business.sales.extraexentlog.ExtraexentlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ExtraexentVO extends BaseVO implements BusinessLog {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private String countyid;

    /** persistent field */
    private String extraexent;

    /** full constructor */
    public ExtraexentVO(java.lang.String cityid, java.lang.String countyid, java.lang.String extraexent) {
        this.cityid = cityid;
        this.countyid = countyid;
        this.extraexent = extraexent;
    }

    /** default constructor */
    public ExtraexentVO() {
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getCountyid() {
        return this.countyid;
    }

    public void setCountyid(java.lang.String countyid) {
        this.countyid = countyid;
    }

    public java.lang.String getExtraexent() {
        return this.extraexent;
    }

    public void setExtraexent(java.lang.String extraexent) {
        this.extraexent = extraexent;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("countyid", getCountyid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ExtraexentVO) ) return false;
        ExtraexentVO castOther = (ExtraexentVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getCountyid(), castOther.getCountyid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getCountyid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ExtraexentlogVO.class;
	}

}
