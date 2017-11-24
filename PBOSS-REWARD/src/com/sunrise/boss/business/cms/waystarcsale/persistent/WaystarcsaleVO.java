package com.sunrise.boss.business.cms.waystarcsale.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.waystarcsalelog.persistent.WaystarcsalelogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class WaystarcsaleVO implements OperationLog {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private Short slv;

    /** nullable persistent field */
    private String busitype;

    /** nullable persistent field */
    private Double busivalue;

    /** full constructor */
    public WaystarcsaleVO(java.lang.String cityid, java.lang.Short slv, java.lang.String busitype, java.lang.Double busivalue) {
        this.cityid = cityid;
        this.slv = slv;
        this.busitype = busitype;
        this.busivalue = busivalue;
    }

    /** default constructor */
    public WaystarcsaleVO() {
    }

    /** minimal constructor */
    public WaystarcsaleVO(java.lang.String cityid, java.lang.Short slv) {
        this.cityid = cityid;
        this.slv = slv;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Short getSlv() {
        return this.slv;
    }

    public void setSlv(java.lang.Short slv) {
        this.slv = slv;
    }

    public java.lang.String getBusitype() {
        return this.busitype;
    }

    public void setBusitype(java.lang.String busitype) {
        this.busitype = busitype;
    }

    public java.lang.Double getBusivalue() {
        return this.busivalue;
    }

    public void setBusivalue(java.lang.Double busivalue) {
        this.busivalue = busivalue;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("slv", getSlv())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WaystarcsaleVO) ) return false;
        WaystarcsaleVO castOther = (WaystarcsaleVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getSlv(), castOther.getSlv())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getSlv())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return WaystarcsalelogVO.class;
	}

}
