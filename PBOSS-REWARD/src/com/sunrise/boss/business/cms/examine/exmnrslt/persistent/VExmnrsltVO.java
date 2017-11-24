package com.sunrise.boss.business.cms.examine.exmnrslt.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VExmnrsltVO implements Serializable {

    /** identifier field */
    private Integer exmnid;

    /** identifier field */
    private String exmnperiod;

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private String isvoted;
    private Double exmnscore;
    private Double penalmark;
    private String marktype;
    private String stcrtcl;
    private Double score;
    
    
    public VExmnrsltVO(Integer exmnid, String exmnperiod, String wayid,
			 String isvoted, Double exmnscore,
			Double penalmark, String marktype, String stcrtcl, Double score) {
		super();
		this.exmnid = exmnid;
		this.exmnperiod = exmnperiod;
		this.wayid = wayid;
		this.isvoted = isvoted;
		this.exmnscore = exmnscore;
		this.penalmark = penalmark;
		this.marktype = marktype;
		this.stcrtcl = stcrtcl;
		this.score = score;
	}

	public String getIsvoted() {
		return isvoted;
	}

	public void setIsvoted(String isvoted) {
		this.isvoted = isvoted;
	}

	public Double getExmnscore() {
		return exmnscore;
	}

	public void setExmnscore(Double exmnscore) {
		this.exmnscore = exmnscore;
	}

	public Double getPenalmark() {
		return penalmark;
	}

	public void setPenalmark(Double penalmark) {
		this.penalmark = penalmark;
	}

	public String getMarktype() {
		return marktype;
	}

	public void setMarktype(String marktype) {
		this.marktype = marktype;
	}

	
	public String getStcrtcl() {
		return stcrtcl;
	}

	public void setStcrtcl(String stcrtcl) {
		this.stcrtcl = stcrtcl;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	/** default constructor */
    public VExmnrsltVO() {
    }

    /** minimal constructor */
    public VExmnrsltVO(java.lang.Integer exmnid, java.lang.String exmnperiod, java.lang.String wayid) {
        this.exmnid = exmnid;
        this.exmnperiod = exmnperiod;
        this.wayid = wayid;
    }

    public java.lang.Integer getExmnid() {
        return this.exmnid;
    }

    public void setExmnid(java.lang.Integer exmnid) {
        this.exmnid = exmnid;
    }

    public java.lang.String getExmnperiod() {
        return this.exmnperiod;
    }

    public void setExmnperiod(java.lang.String exmnperiod) {
        this.exmnperiod = exmnperiod;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    

    public String toString() {
        return new ToStringBuilder(this)
            .append("exmnid", getExmnid())
            .append("exmnperiod", getExmnperiod())
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VExmnrsltVO) ) return false;
        VExmnrsltVO castOther = (VExmnrsltVO) other;
        return new EqualsBuilder()
            .append(this.getExmnid(), castOther.getExmnid())
            .append(this.getExmnperiod(), castOther.getExmnperiod())
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getExmnid())
            .append(getExmnperiod())
            .append(getWayid())
            .toHashCode();
    }

}
