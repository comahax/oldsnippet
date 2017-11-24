package com.sunrise.boss.business.cms.mpsaudit.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class MpsauditVO implements Serializable {

    /** identifier field */
    private String adtdate;

    /** nullable persistent field */
    private Long iodnum;

    /** nullable persistent field */
    private Long mpsnum;

    /** nullable persistent field */
    private Long mpsvalid;

    /** nullable persistent field */
    private Double percent;

    private String successFlag;
    
    /** full constructor */
    public MpsauditVO(java.lang.String adtdate, java.lang.Long iodnum, java.lang.Long mpsnum, java.lang.Long mpsvalid, java.lang.Double percent) {
        this.adtdate = adtdate;
        this.iodnum = iodnum;
        this.mpsnum = mpsnum;
        this.mpsvalid = mpsvalid;
        this.percent = percent;
    }

    /** default constructor */
    public MpsauditVO() {
    }

    /** minimal constructor */
    public MpsauditVO(java.lang.String adtdate) {
        this.adtdate = adtdate;
    }

    public java.lang.String getAdtdate() {
        return this.adtdate;
    }

    public void setAdtdate(java.lang.String adtdate) {
        this.adtdate = adtdate;
    }

    public java.lang.Long getIodnum() {
        return this.iodnum;
    }

    public void setIodnum(java.lang.Long iodnum) {
        this.iodnum = iodnum;
    }

    public java.lang.Long getMpsnum() {
        return this.mpsnum;
    }

    public void setMpsnum(java.lang.Long mpsnum) {
        this.mpsnum = mpsnum;
    }

    public java.lang.Long getMpsvalid() {
        return this.mpsvalid;
    }

    public void setMpsvalid(java.lang.Long mpsvalid) {
        this.mpsvalid = mpsvalid;
    }

    public java.lang.Double getPercent() {
        return this.percent;
    }

    public void setPercent(java.lang.Double percent) {
        this.percent = percent;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("adtdate", getAdtdate())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof MpsauditVO) ) return false;
        MpsauditVO castOther = (MpsauditVO) other;
        return new EqualsBuilder()
            .append(this.getAdtdate(), castOther.getAdtdate())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getAdtdate())
            .toHashCode();
    }

	public String getSuccessFlag() {
		return successFlag;
	}

	public void setSuccessFlag(String successFlag) {
		this.successFlag = successFlag;
	}

}
