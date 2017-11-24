package com.sunrise.boss.business.resmanage.oprresmanage.auditlog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class AuditlogVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** persistent field */
    private String sheetid;

    /** persistent field */
    private String reqoprcode;

    /** persistent field */
    private String inoprcode;
    
    private String outoprcode;
    
    private String auditoprcode;

    /** persistent field */
    private java.util.Date createtime;

    /** persistent field */
    private java.util.Date audittime;

    /** persistent field */
    private Short oprtype;
    
    private String wayid;//20081106ÐÂÔö
    

    /** full constructor */
    public AuditlogVO(java.lang.Long logid, java.lang.String sheetid, String inoprcode,String outoprcode,java.lang.String reqoprcode, java.lang.String auditoprcode, java.util.Date createtime, java.util.Date audittime, java.lang.Short oprtype,java.lang.String wayid) {
        this.logid = logid;
        this.sheetid = sheetid;
        this.reqoprcode = reqoprcode;
        this.inoprcode = inoprcode;
        this.outoprcode = outoprcode;
        this.auditoprcode = auditoprcode;
        this.createtime = createtime;
        this.audittime = audittime;
        this.oprtype = oprtype;
        this.wayid = wayid;
    }

    /** default constructor */
    public AuditlogVO() {
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.lang.String getSheetid() {
        return this.sheetid;
    }

    public void setSheetid(java.lang.String sheetid) {
        this.sheetid = sheetid;
    }

    public java.lang.String getReqoprcode() {
        return this.reqoprcode;
    }

    public void setReqoprcode(java.lang.String reqoprcode) {
        this.reqoprcode = reqoprcode;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.util.Date getAudittime() {
        return this.audittime;
    }

    public void setAudittime(java.util.Date audittime) {
        this.audittime = audittime;
    }

    public java.lang.Short getOprtype() {
        return this.oprtype;
    }

	public String getInoprcode() {
		return inoprcode;
	}

	public void setInoprcode(String inoprcode) {
		this.inoprcode = inoprcode;
	}

	public String getOutoprcode() {
		return outoprcode;
	}

	public void setOutoprcode(String outoprcode) {
		this.outoprcode = outoprcode;
	}

	public void setOprtype(java.lang.Short oprtype) {
        this.oprtype = oprtype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof AuditlogVO) ) return false;
        AuditlogVO castOther = (AuditlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

	public String getAuditoprcode() {
		return auditoprcode;
	}

	public void setAuditoprcode(String auditoprcode) {
		this.auditoprcode = auditoprcode;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

}
