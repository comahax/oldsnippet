package com.sunrise.boss.business.cms.examine.exmnitemdtl.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.examine.exmnitemdtllog.persistent.ExmnitemdtllogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ExmnitemdtlVO implements Serializable,OperationLog {

    /** identifier field */
    private Long seqid;

    /** nullable persistent field */
    private Integer exmnid;

    /** nullable persistent field */
    private Integer exmnstdid;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private String marktype;

    /** nullable persistent field */
    private Double basemk;

    /** nullable persistent field */
    private Double dynamicmk;

    /** nullable persistent field */
    private Double leastcrtcl;

    /** nullable persistent field */
    private Double largestcrtcl;

    /** nullable persistent field */
    private Long pseqid;

    /** full constructor */
    public ExmnitemdtlVO(java.lang.Long seqid, java.lang.Integer exmnid, java.lang.Integer exmnstdid, java.lang.String cityid, java.lang.String marktype, java.lang.Double basemk, java.lang.Double dynamicmk, java.lang.Double leastcrtcl, java.lang.Double largestcrtcl, java.lang.Long pseqid) {
        this.seqid = seqid;
        this.exmnid = exmnid;
        this.exmnstdid = exmnstdid;
        this.cityid = cityid;
        this.marktype = marktype;
        this.basemk = basemk;
        this.dynamicmk = dynamicmk;
        this.leastcrtcl = leastcrtcl;
        this.largestcrtcl = largestcrtcl;
        this.pseqid = pseqid;
    }

    /** default constructor */
    public ExmnitemdtlVO() {
    }

    /** minimal constructor */
    public ExmnitemdtlVO(java.lang.Long seqid) {
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

    public java.lang.Integer getExmnstdid() {
        return this.exmnstdid;
    }

    public void setExmnstdid(java.lang.Integer exmnstdid) {
        this.exmnstdid = exmnstdid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getMarktype() {
        return this.marktype;
    }

    public void setMarktype(java.lang.String marktype) {
        this.marktype = marktype;
    }

   
    public Double getBasemk() {
		return basemk;
	}

	public void setBasemk(Double basemk) {
		this.basemk = basemk;
	}

	public Double getDynamicmk() {
		return dynamicmk;
	}

	public void setDynamicmk(Double dynamicmk) {
		this.dynamicmk = dynamicmk;
	}

	public Double getLeastcrtcl() {
		return leastcrtcl;
	}

	public void setLeastcrtcl(Double leastcrtcl) {
		this.leastcrtcl = leastcrtcl;
	}

	public Double getLargestcrtcl() {
		return largestcrtcl;
	}

	public void setLargestcrtcl(Double largestcrtcl) {
		this.largestcrtcl = largestcrtcl;
	}

	public java.lang.Long getPseqid() {
        return this.pseqid;
    }

    public void setPseqid(java.lang.Long pseqid) {
        this.pseqid = pseqid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ExmnitemdtlVO) ) return false;
        ExmnitemdtlVO castOther = (ExmnitemdtlVO) other;
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
		return ExmnitemdtllogVO.class;
	}

}
