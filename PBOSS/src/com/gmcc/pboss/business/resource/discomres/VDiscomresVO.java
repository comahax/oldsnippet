package com.gmcc.pboss.business.resource.discomres;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class VDiscomresVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String disid;

    /** persistent field */
    private String discomcode;

    /** nullable persistent field */
    private String batchno;

    /** nullable persistent field */
    private String boxnum;
    private Timestamp issutime;
    private Long comid;

    private String comresid;


    private Short comstate;

    /** full constructor */
    public VDiscomresVO(java.lang.String disid, java.lang.String discomcode, java.lang.String batchno, java.lang.String boxnum,Timestamp issutime,Long comid,String comresid,Short comstate) {
        this.disid = disid;
        this.discomcode = discomcode;
        this.batchno = batchno;
        this.boxnum = boxnum;
        this.issutime=issutime;
        this.comid=comid;
        this.comresid=comresid;
        this.comstate=comstate;
    }

    /** default constructor */
    public VDiscomresVO() {
    }

    /** minimal constructor */
    public VDiscomresVO(java.lang.String disid, java.lang.String discomcode) {
        this.disid = disid;
        this.discomcode = discomcode;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getDisid() {
        return this.disid;
    }

    public void setDisid(java.lang.String disid) {
        this.disid = disid;
    }

    public java.lang.String getDiscomcode() {
        return this.discomcode;
    }

    public void setDiscomcode(java.lang.String discomcode) {
        this.discomcode = discomcode;
    }

    public java.lang.String getBatchno() {
        return this.batchno;
    }

    public void setBatchno(java.lang.String batchno) {
        this.batchno = batchno;
    }

    public java.lang.String getBoxnum() {
        return this.boxnum;
    }

    public void setBoxnum(java.lang.String boxnum) {
        this.boxnum = boxnum;
    }
    
    public Timestamp getIssutime() {
		return issutime;
	}

	public void setIssutime(Timestamp issutime) {
		this.issutime = issutime;
	}

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public String getComresid() {
		return comresid;
	}

	public void setComresid(String comresid) {
		this.comresid = comresid;
	}

	public Short getComstate() {
		return comstate;
	}

	public void setComstate(Short comstate) {
		this.comstate = comstate;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VDiscomresVO) ) return false;
        VDiscomresVO castOther = (VDiscomresVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

}
