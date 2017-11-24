package com.gmcc.pboss.business.cms.examine.mapping.persistent;


import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.cms.examine.mappinglog.persistent.MappinglogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;


/** @author Hibernate CodeGenerator */
public class MappingVO  extends BaseVO implements Serializable ,BusinessLog{

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private Integer exmnid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String mmode;

    /** nullable persistent field */
    private Double markul;

    /** nullable persistent field */
    private Double markll;

    /** nullable persistent field */
    private Double coeforbase;

    /** full constructor */
    public MappingVO(java.lang.Long seqid, java.lang.Integer exmnid, java.lang.String cityid, java.lang.String mmode, java.lang.Double markul, java.lang.Double markll, java.lang.Double coeforbase) {
        this.seqid = seqid;
        this.exmnid = exmnid;
        this.cityid = cityid;
        this.mmode = mmode;
        this.markul = markul;
        this.markll = markll;
        this.coeforbase = coeforbase;
    }

    /** default constructor */
    public MappingVO() {
    }

    /** minimal constructor */
    public MappingVO(java.lang.Long seqid) {
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

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getMmode() {
        return this.mmode;
    }

    public void setMmode(java.lang.String mmode) {
        this.mmode = mmode;
    }

    public java.lang.Double getMarkul() {
        return this.markul;
    }

    public void setMarkul(java.lang.Double markul) {
        this.markul = markul;
    }

    public java.lang.Double getMarkll() {
        return this.markll;
    }

    public void setMarkll(java.lang.Double markll) {
        this.markll = markll;
    }

    public java.lang.Double getCoeforbase() {
        return this.coeforbase;
    }

    public void setCoeforbase(java.lang.Double coeforbase) {
        this.coeforbase = coeforbase;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof MappingVO) ) return false;
        MappingVO castOther = (MappingVO) other;
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
		return MappinglogVO.class;
	}

}
