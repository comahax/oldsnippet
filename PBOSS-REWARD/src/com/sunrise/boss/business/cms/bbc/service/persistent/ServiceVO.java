package com.sunrise.boss.business.cms.bbc.service.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.bbc.servicelog.persistent.ServicelogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ServiceVO implements OperationLog {

    /** identifier field */
    private String opnid;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private Float baserewardstd;

    /** nullable persistent field */
    private Float bonusrewardstd;

    /** full constructor */
    public ServiceVO(java.lang.String opnid, java.lang.String name, java.lang.Float baserewardstd, java.lang.Float bonusrewardstd) {
        this.opnid = opnid;
        this.name = name;
        this.baserewardstd = baserewardstd;
        this.bonusrewardstd = bonusrewardstd;
    }

    /** default constructor */
    public ServiceVO() {
    }

    /** minimal constructor */
    public ServiceVO(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.Float getBaserewardstd() {
        return this.baserewardstd;
    }

    public void setBaserewardstd(java.lang.Float baserewardstd) {
        this.baserewardstd = baserewardstd;
    }

    public java.lang.Float getBonusrewardstd() {
        return this.bonusrewardstd;
    }

    public void setBonusrewardstd(java.lang.Float bonusrewardstd) {
        this.bonusrewardstd = bonusrewardstd;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("opnid", getOpnid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ServiceVO) ) return false;
        ServiceVO castOther = (ServiceVO) other;
        return new EqualsBuilder()
            .append(this.getOpnid(), castOther.getOpnid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOpnid())
            .toHashCode();
    }

    public Class logVOClass() {
		return ServicelogVO.class;
	}
    
}
