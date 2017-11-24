package com.sunrise.boss.business.cms.examine.coefrevision.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.examine.coefrevisionlog.persistent.CoefrevisionlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class CoefrevisionVO implements Serializable,OperationLog {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private Integer exmnid;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private String exmnperiod;

    /** nullable persistent field */
    private Double coefficient;

    /** full constructor */
    public CoefrevisionVO(java.lang.Long seqid, java.lang.Integer exmnid, java.lang.String wayid, java.lang.String exmnperiod, java.lang.Double coefficient) {
        this.seqid = seqid;
        this.exmnid = exmnid;
        this.wayid = wayid;
        this.exmnperiod = exmnperiod;
        this.coefficient = coefficient;
    }

    /** default constructor */
    public CoefrevisionVO() {
    }

    /** minimal constructor */
    public CoefrevisionVO(java.lang.Long seqid) {
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

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getExmnperiod() {
        return this.exmnperiod;
    }

    public void setExmnperiod(java.lang.String exmnperiod) {
        this.exmnperiod = exmnperiod;
    }

    public java.lang.Double getCoefficient() {
        return this.coefficient;
    }

    public void setCoefficient(java.lang.Double coefficient) {
        this.coefficient = coefficient;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CoefrevisionVO) ) return false;
        CoefrevisionVO castOther = (CoefrevisionVO) other;
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
		return CoefrevisionlogVO.class;
	}

}
