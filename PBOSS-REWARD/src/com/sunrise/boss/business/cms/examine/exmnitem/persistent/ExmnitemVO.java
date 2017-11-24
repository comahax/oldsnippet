package com.sunrise.boss.business.cms.examine.exmnitem.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.examine.exmnitemlog.persistent.ExmnitemlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ExmnitemVO implements Serializable ,OperationLog{

    /** identifier field */
    private Integer exmnid;

    /** identifier field */
    private Integer exmnstdid;

    /** nullable persistent field */
    private String isvoted;

    /** nullable persistent field */
    private Double exmnscore;

    /** full constructor */
    public ExmnitemVO(java.lang.Integer exmnid, java.lang.Integer exmnstdid, java.lang.String isvoted, java.lang.Double exmnscore) {
        this.exmnid = exmnid;
        this.exmnstdid = exmnstdid;
        this.isvoted = isvoted;
        this.exmnscore = exmnscore;
    }

    /** default constructor */
    public ExmnitemVO() {
    }

    /** minimal constructor */
    public ExmnitemVO(java.lang.Integer exmnid, java.lang.Integer exmnstdid) {
        this.exmnid = exmnid;
        this.exmnstdid = exmnstdid;
    }

    public java.lang.Integer getExmnid() {
        return this.exmnid;
    }

    public void setExmnid(java.lang.Integer exmnid) {
        this.exmnid = exmnid;
    }

    public java.lang.Integer getExmnstdid() {
        return this.exmnstdid;
    }

    public void setExmnstdid(java.lang.Integer exmnstdid) {
        this.exmnstdid = exmnstdid;
    }

    public java.lang.String getIsvoted() {
        return this.isvoted;
    }

    public void setIsvoted(java.lang.String isvoted) {
        this.isvoted = isvoted;
    }

    public java.lang.Double getExmnscore() {
        return this.exmnscore;
    }

    public void setExmnscore(java.lang.Double exmnscore) {
        this.exmnscore = exmnscore;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("exmnid", getExmnid())
            .append("exmnstdid", getExmnstdid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ExmnitemVO) ) return false;
        ExmnitemVO castOther = (ExmnitemVO) other;
        return new EqualsBuilder()
            .append(this.getExmnid(), castOther.getExmnid())
            .append(this.getExmnstdid(), castOther.getExmnstdid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getExmnid())
            .append(getExmnstdid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ExmnitemlogVO.class;
	}

}
