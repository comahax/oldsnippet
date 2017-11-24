package com.sunrise.boss.business.cms.distribute.cpbusfeeway.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.ManageLog;

/** @author Hibernate CodeGenerator */
public class CpbusfeewayVO implements Serializable,ManageLog{

    /** identifier field */
    private Long cpbusid;

    /** persistent field */
    private String cooperauid;

    /** persistent field */
    private Short fxtype;

    /** persistent field */
    private String busfeeway;

    /** full constructor */
    public CpbusfeewayVO(java.lang.Long cpbusid, java.lang.String cooperauid, java.lang.Short fxtype, java.lang.String busfeeway) {
        this.cpbusid = cpbusid;
        this.cooperauid = cooperauid;
        this.fxtype = fxtype;
        this.busfeeway = busfeeway;
    }

    /** default constructor */
    public CpbusfeewayVO() {
    }

    public java.lang.Long getCpbusid() {
        return this.cpbusid;
    }

    public void setCpbusid(java.lang.Long cpbusid) {
        this.cpbusid = cpbusid;
    }

    public java.lang.String getCooperauid() {
        return this.cooperauid;
    }

    public void setCooperauid(java.lang.String cooperauid) {
        this.cooperauid = cooperauid;
    }

    public java.lang.Short getFxtype() {
        return this.fxtype;
    }

    public void setFxtype(java.lang.Short fxtype) {
        this.fxtype = fxtype;
    }

    public java.lang.String getBusfeeway() {
        return this.busfeeway;
    }

    public void setBusfeeway(java.lang.String busfeeway) {
        this.busfeeway = busfeeway;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cpbusid", getCpbusid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CpbusfeewayVO) ) return false;
        CpbusfeewayVO castOther = (CpbusfeewayVO) other;
        return new EqualsBuilder()
            .append(this.getCpbusid(), castOther.getCpbusid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCpbusid())
            .toHashCode();
    }

}
