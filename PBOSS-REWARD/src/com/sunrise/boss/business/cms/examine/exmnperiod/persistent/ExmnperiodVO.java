package com.sunrise.boss.business.cms.examine.exmnperiod.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.examine.exmnperiodlog.persistent.ExmnperiodlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ExmnperiodVO implements Serializable,OperationLog {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private Integer exmnid;

    /** nullable persistent field */
    private Short beginmonth;

    /** nullable persistent field */
    private Short endmonth;

    /** full constructor */
    public ExmnperiodVO(java.lang.Long seqid, java.lang.Integer exmnid, java.lang.Short beginmonth, java.lang.Short endmonth) {
        this.seqid = seqid;
        this.exmnid = exmnid;
        this.beginmonth = beginmonth;
        this.endmonth = endmonth;
    }

    /** default constructor */
    public ExmnperiodVO() {
    }

    /** minimal constructor */
    public ExmnperiodVO(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.Integer getExmnid() {
        return this.exmnid;
    }

    public void setExmnid(java.lang.Integer exmnid) {
        this.exmnid = exmnid;
    }

    public java.lang.Short getBeginmonth() {
        return this.beginmonth;
    }

    public void setBeginmonth(java.lang.Short beginmonth) {
        this.beginmonth = beginmonth;
    }

    public java.lang.Short getEndmonth() {
        return this.endmonth;
    }

    public void setEndmonth(java.lang.Short endmonth) {
        this.endmonth = endmonth;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ExmnperiodVO) ) return false;
        ExmnperiodVO castOther = (ExmnperiodVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ExmnperiodlogVO.class;
	}

}
