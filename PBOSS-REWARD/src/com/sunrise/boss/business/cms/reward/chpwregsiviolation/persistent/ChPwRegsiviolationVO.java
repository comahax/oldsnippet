package com.sunrise.boss.business.cms.reward.chpwregsiviolation.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.chpwregsiviolationlog.persistent.ChPwRegsiviolationlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ChPwRegsiviolationVO implements OperationLog, Serializable {

    /** identifier field */
    private String mobile;

    /** identifier field */
    private String vmonth;

    /** nullable persistent field */
    private String remark;

    /** full constructor */
    public ChPwRegsiviolationVO(java.lang.String mobile, java.lang.String vmonth, java.lang.String remark) {
        this.mobile = mobile;
        this.vmonth = vmonth;
        this.remark = remark;
    }

    /** default constructor */
    public ChPwRegsiviolationVO() {
    }

    /** minimal constructor */
    public ChPwRegsiviolationVO(java.lang.String mobile, java.lang.String vmonth) {
        this.mobile = mobile;
        this.vmonth = vmonth;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.lang.String getVmonth() {
        return this.vmonth;
    }

    public void setVmonth(java.lang.String vmonth) {
        this.vmonth = vmonth;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("mobile", getMobile())
            .append("vmonth", getVmonth())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPwRegsiviolationVO) ) return false;
        ChPwRegsiviolationVO castOther = (ChPwRegsiviolationVO) other;
        return new EqualsBuilder()
            .append(this.getMobile(), castOther.getMobile())
            .append(this.getVmonth(), castOther.getVmonth())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getMobile())
            .append(getVmonth())
            .toHashCode();
    }

	public Class logVOClass() {
		return ChPwRegsiviolationlogVO.class;
	}

}
