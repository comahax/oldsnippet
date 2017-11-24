package com.gmcc.pboss.business.reward.stype;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.reward.stypelog.StypelogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class StypeVO extends BaseVO implements BusinessLog {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String stype;

    /** nullable persistent field */
    private String ltype;

    /** nullable persistent field */
    private String cityid;

    /** full constructor */
    public StypeVO(java.lang.Long seq, java.lang.String stype, java.lang.String ltype, java.lang.String cityid) {
        this.seq = seq;
        this.stype = stype;
        this.ltype = ltype;
        this.cityid = cityid;
    }

    /** default constructor */
    public StypeVO() {
    }

    /** minimal constructor */
    public StypeVO(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getStype() {
        return this.stype;
    }

    public void setStype(java.lang.String stype) {
        this.stype = stype;
    }

    public java.lang.String getLtype() {
        return this.ltype;
    }

    public void setLtype(java.lang.String ltype) {
        this.ltype = ltype;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StypeVO) ) return false;
        StypeVO castOther = (StypeVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }
	public Class logVOClass() {
		// TODO Auto-generated method stub
		return StypelogVO.class;
	}

}
