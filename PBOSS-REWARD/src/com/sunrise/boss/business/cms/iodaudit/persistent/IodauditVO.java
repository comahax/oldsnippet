package com.sunrise.boss.business.cms.iodaudit.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class IodauditVO implements Serializable {

    /** identifier field */
    private Long seq;

    /** nullable persistent field */
    private String adtcontent;

    /** nullable persistent field */
    private String mobile;

    /** nullable persistent field */
    private java.util.Date iodtime;

    /** nullable persistent field */
    private Byte sucess;

    /** nullable persistent field */
    private String officetel;

    /** nullable persistent field */
    private Byte adtcode;

    /** nullable persistent field */
    private String adtremark;

    /** nullable persistent field */
    private Byte compare;
    
    private String opnid;
    
    private Byte mendflag;
    
    private java.util.Date mendtime;
    
    private java.util.Date addtime;
    
    

    public Byte getMendflag() {
		return mendflag;
	}

	public void setMendflag(Byte mendflag) {
		this.mendflag = mendflag;
	}

	public java.util.Date getMendtime() {
		return mendtime;
	}

	public void setMendtime(java.util.Date mendtime) {
		this.mendtime = mendtime;
	}

	public java.util.Date getAddtime() {
		return addtime;
	}

	public void setAddtime(java.util.Date addtime) {
		this.addtime = addtime;
	}

	public String getOpnid() {
		return opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	/** full constructor */
    public IodauditVO(java.lang.Long seq, java.lang.String adtcontent, java.lang.String mobile, java.util.Date iodtime, java.lang.Byte sucess, java.lang.String officetel, java.lang.Byte adtcode, java.lang.String adtremark, java.lang.Byte compare, java.lang.String opnid
    		, java.lang.Byte mendflag,java.util.Date mendtime,java.util.Date addtime) {
        this.seq = seq;
        this.adtcontent = adtcontent;
        this.mobile = mobile;
        this.iodtime = iodtime;
        this.sucess = sucess;
        this.officetel = officetel;
        this.adtcode = adtcode;
        this.adtremark = adtremark;
        this.compare = compare;
        this.opnid = opnid;
        this.mendflag=mendflag;
        this.mendtime=mendtime;
        this.addtime=addtime;
            }

    /** default constructor */
    public IodauditVO() {
    }

    /** minimal constructor */
    public IodauditVO(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.Long getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Long seq) {
        this.seq = seq;
    }

    public java.lang.String getAdtcontent() {
        return this.adtcontent;
    }

    public void setAdtcontent(java.lang.String adtcontent) {
        this.adtcontent = adtcontent;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public java.util.Date getIodtime() {
        return this.iodtime;
    }

    public void setIodtime(java.util.Date iodtime) {
        this.iodtime = iodtime;
    }

    public java.lang.Byte getSucess() {
        return this.sucess;
    }

    public void setSucess(java.lang.Byte sucess) {
        this.sucess = sucess;
    }

    public java.lang.String getOfficetel() {
        return this.officetel;
    }

    public void setOfficetel(java.lang.String officetel) {
        this.officetel = officetel;
    }

    public java.lang.Byte getAdtcode() {
        return this.adtcode;
    }

    public void setAdtcode(java.lang.Byte adtcode) {
        this.adtcode = adtcode;
    }

    public java.lang.String getAdtremark() {
        return this.adtremark;
    }

    public void setAdtremark(java.lang.String adtremark) {
        this.adtremark = adtremark;
    }

    public java.lang.Byte getCompare() {
        return this.compare;
    }

    public void setCompare(java.lang.Byte compare) {
        this.compare = compare;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof IodauditVO) ) return false;
        IodauditVO castOther = (IodauditVO) other;
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
