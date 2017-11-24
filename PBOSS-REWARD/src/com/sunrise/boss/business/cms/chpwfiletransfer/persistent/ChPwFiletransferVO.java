package com.sunrise.boss.business.cms.chpwfiletransfer.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChPwFiletransferVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private Byte state;

    /** nullable persistent field */
    private String filepath;

    /** nullable persistent field */
    private String filename;

    /** nullable persistent field */
    private String remark;

    private java.util.Date datadate;
    
    private java.util.Date receivetime;
    /** full constructor */
    public ChPwFiletransferVO(java.lang.Long seq, java.lang.String cityid, java.lang.Byte state, java.lang.String filepath, java.lang.String filename, java.lang.String remark,java.util.Date datadate,java.util.Date receivetime) {
        this.seq = seq;
        this.cityid = cityid;
        this.state = state;
        this.filepath = filepath;
        this.filename = filename;
        this.remark = remark;
        this.datadate = datadate;
        this.receivetime = receivetime;
    }

    /** default constructor */
    public ChPwFiletransferVO() {
    }

    /** minimal constructor */
    public ChPwFiletransferVO(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.Byte getState() {
        return this.state;
    }

    public void setState(java.lang.Byte state) {
        this.state = state;
    }

    public java.lang.String getFilepath() {
        return this.filepath;
    }

    public void setFilepath(java.lang.String filepath) {
        this.filepath = filepath;
    }

    public java.lang.String getFilename() {
        return this.filename;
    }

    public void setFilename(java.lang.String filename) {
        this.filename = filename;
    }

    public java.lang.String getRemark() {
        return this.remark;
    }

    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }
    
    public java.util.Date getDatadate() {
		return datadate;
	}

	public void setDatadate(java.util.Date datadate) {
		this.datadate = datadate;
	}

	public java.util.Date getReceivetime() {
		return receivetime;
	}

	public void setReceivetime(java.util.Date receivetime) {
		this.receivetime = receivetime;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChPwFiletransferVO) ) return false;
        ChPwFiletransferVO castOther = (ChPwFiletransferVO) other;
        return new EqualsBuilder()
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeq())
            .toHashCode();
    }

}
