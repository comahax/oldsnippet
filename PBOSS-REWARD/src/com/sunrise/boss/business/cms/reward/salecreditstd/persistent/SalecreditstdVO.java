package com.sunrise.boss.business.cms.reward.salecreditstd.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.salecreditstdlog.persistent.SalecreditstdlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class SalecreditstdVO implements OperationLog {

	public Class logVOClass() {
		return SalecreditstdlogVO.class;
	}
    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private Short cityid;

    /** nullable persistent field */
    private Long busitype;

    /** nullable persistent field */
    private Double creditstd;

    /** nullable persistent field */
    private Double limited;

    /** nullable persistent field */
    private java.util.Date updatetime;

    /** full constructor */
    public SalecreditstdVO(java.lang.Long seq, java.lang.Short cityid, java.lang.Long busitype, java.lang.Double creditstd, java.lang.Double limited, java.util.Date updatetime) {
        this.seq = seq;
        this.cityid = cityid;
        this.busitype = busitype;
        this.creditstd = creditstd;
        this.limited = limited;
        this.updatetime = updatetime;
    }

    /** default constructor */
    public SalecreditstdVO() {
    }

    /** minimal constructor */
    public SalecreditstdVO(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Short getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.Short cityid) {
        this.cityid = cityid;
    }

    public java.lang.Long getBusitype() {
        return this.busitype;
    }

    public void setBusitype(java.lang.Long busitype) {
        this.busitype = busitype;
    }

    public java.lang.Double getCreditstd() {
        return this.creditstd;
    }

    public void setCreditstd(java.lang.Double creditstd) {
        this.creditstd = creditstd;
    }

    public java.lang.Double getLimited() {
        return this.limited;
    }

    public void setLimited(java.lang.Double limited) {
        this.limited = limited;
    }

    public java.util.Date getUpdatetime() {
        return this.updatetime;
    }

    public void setUpdatetime(java.util.Date updatetime) {
        this.updatetime = updatetime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof SalecreditstdVO) ) return false;
        SalecreditstdVO castOther = (SalecreditstdVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

}
