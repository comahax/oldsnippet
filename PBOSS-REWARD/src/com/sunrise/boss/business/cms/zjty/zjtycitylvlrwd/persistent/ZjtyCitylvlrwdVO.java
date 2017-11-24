package com.sunrise.boss.business.cms.zjty.zjtycitylvlrwd.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ZjtyCitylvlrwdVO implements Serializable {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private Double rwdupper;

    /** full constructor */
    public ZjtyCitylvlrwdVO(String cityid, Double rwdupper){
        this.cityid = cityid;
        this.rwdupper = rwdupper;
    }

    /** default constructor */
    public ZjtyCitylvlrwdVO() {
    }

    /** minimal constructor */
    public ZjtyCitylvlrwdVO(String cityid) {
        this.cityid = cityid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyCitylvlrwdVO) ) return false;
        ZjtyCitylvlrwdVO castOther = (ZjtyCitylvlrwdVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .toHashCode();
    }

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public Double getRwdupper() {
		return rwdupper;
	}

	public void setRwdupper(Double rwdupper) {
		this.rwdupper = rwdupper;
	}


}
