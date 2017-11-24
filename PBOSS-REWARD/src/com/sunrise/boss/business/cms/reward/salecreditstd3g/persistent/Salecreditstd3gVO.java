package com.sunrise.boss.business.cms.reward.salecreditstd3g.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.salecreditstd3glog.persistent.Salecreditstd3glogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class Salecreditstd3gVO implements OperationLog,Serializable {

    /** identifier field */
    private Long busitype;

    /** identifier field */
    private Short cityid;

    /** nullable persistent field */
    private Double creditstd;

    /** full constructor */
    public Salecreditstd3gVO(java.lang.Long busitype, java.lang.Short cityid, java.lang.Double creditstd) {
        this.busitype = busitype;
        this.cityid = cityid;
        this.creditstd = creditstd;
    }

    /** default constructor */
    public Salecreditstd3gVO() {
    }

    /** minimal constructor */
    public Salecreditstd3gVO(java.lang.Long busitype, java.lang.Short cityid) {
        this.busitype = busitype;
        this.cityid = cityid;
    }

    public java.lang.Long getBusitype() {
        return this.busitype;
    }

    public void setBusitype(java.lang.Long busitype) {
        this.busitype = busitype;
    }

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public java.lang.Double getCreditstd() {
        return this.creditstd;
    }

    public void setCreditstd(java.lang.Double creditstd) {
        this.creditstd = creditstd;
    }
    
    public Class logVOClass() {
		// TODO Auto-generated method stub
    	return Salecreditstd3glogVO.class;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("busitype", getBusitype())
            .append("cityid", getCityid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof Salecreditstd3gVO) ) return false;
        Salecreditstd3gVO castOther = (Salecreditstd3gVO) other;
        return new EqualsBuilder()
            .append(this.getBusitype(), castOther.getBusitype())
            .append(this.getCityid(), castOther.getCityid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getBusitype())
            .append(getCityid())
            .toHashCode();
    }

}
