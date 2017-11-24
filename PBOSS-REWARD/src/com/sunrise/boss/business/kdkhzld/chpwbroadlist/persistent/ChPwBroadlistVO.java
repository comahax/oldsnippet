package com.sunrise.boss.business.kdkhzld.chpwbroadlist.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.kdkhzld.chpwbroadlistlog.persistent.ChPwBroadlistlogVO;

/** @author Hibernate CodeGenerator */
public class ChPwBroadlistVO implements Serializable,OperationLog {

    /** identifier field */
    private String mobile;

    /** full constructor */
    public ChPwBroadlistVO(java.lang.String mobile) {
        this.mobile = mobile;
    }

    /** default constructor */
    public ChPwBroadlistVO() {
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("mobile", getMobile())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPwBroadlistVO) ) return false;
        ChPwBroadlistVO castOther = (ChPwBroadlistVO) other;
        return new EqualsBuilder()
            .append(this.getMobile(), castOther.getMobile())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getMobile())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ChPwBroadlistlogVO.class;
	}

}
