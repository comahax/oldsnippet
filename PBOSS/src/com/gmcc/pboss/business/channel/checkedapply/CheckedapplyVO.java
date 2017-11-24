package com.gmcc.pboss.business.channel.checkedapply;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CheckedapplyVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long applyno;

    /** nullable persistent field */
    private String cityid;

    /** nullable persistent field */
    private java.util.Date aptime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String mobileno;

    /** nullable persistent field */
    private String appath;

    /** nullable persistent field */
    private String applytype;

    /** nullable persistent field */
    private String status;

    /** nullable persistent field */
    private String oprcode2;

    /** nullable persistent field */
    private String memo;

     /** nullable persistent field */
    private String chkmemo;
    
    /** nullable persistent field */
    private String pptpath;

	private String chkmemo2;
	
    /** full constructor */
    public CheckedapplyVO(java.lang.String cityid, java.util.Date aptime, java.lang.String oprcode, java.lang.String mobileno, java.lang.String appath, java.lang.String applytype, java.lang.String status, java.lang.String oprcode2, java.lang.String memo, java.lang.String chkmemo, java.lang.String pptpath) {
        this.cityid = cityid;
        this.aptime = aptime;
        this.oprcode = oprcode;
        this.mobileno = mobileno;
        this.appath = appath;
        this.applytype = applytype;
        this.status = status;
        this.oprcode2 = oprcode2;
        this.memo = memo;
        this.chkmemo = chkmemo;
        this.pptpath = pptpath;
    }

    /** default constructor */
    public CheckedapplyVO() {
    }

    /** minimal constructor */
    public CheckedapplyVO(java.lang.Long applyno) {
        this.applyno = applyno;
    }

    public java.lang.Long getApplyno() {
        return this.applyno;
    }

    public void setApplyno(java.lang.Long applyno) {
        this.applyno = applyno;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.util.Date getAptime() {
        return this.aptime;
    }

    public void setAptime(java.util.Date aptime) {
        this.aptime = aptime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getMobileno() {
        return this.mobileno;
    }

    public void setMobileno(java.lang.String mobileno) {
        this.mobileno = mobileno;
    }

    public java.lang.String getAppath() {
        return this.appath;
    }

    public void setAppath(java.lang.String appath) {
        this.appath = appath;
    }

    public java.lang.String getApplytype() {
        return this.applytype;
    }

    public void setApplytype(java.lang.String applytype) {
        this.applytype = applytype;
    }

    public java.lang.String getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public java.lang.String getOprcode2() {
        return this.oprcode2;
    }

    public void setOprcode2(java.lang.String oprcode2) {
        this.oprcode2 = oprcode2;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }
	
	public java.lang.String getChkmemo() {
        return this.chkmemo;
    }

    public void setChkmemo(java.lang.String chkmemo) {
        this.chkmemo = chkmemo;
    }
	
    public java.lang.String getPptpath() {
        return this.pptpath;
    }

    public void setPptpath(java.lang.String pptpath) {
        this.pptpath = pptpath;
    }

	public String getChkmemo2() {
		if(this.getStatus() != null && this.getStatus().equals("0")){			
			this.chkmemo2 = "";
		}else{
			if(this.getChkmemo() == null || this.chkmemo.equals("")){
			}else{
				this.chkmemo2 = this.getChkmemo() != null?(this.getChkmemo().length() >= 3?this.getChkmemo().substring(0, 3) :this.getChkmemo()):"";
				this.chkmemo2 = chkmemo2+" ...";
			}
		}
		return chkmemo2;
	}

	public void setChkmemo2(String chkmemo2) {
		this.chkmemo2 = chkmemo2;
	}

    
    public String toString() {
        return new ToStringBuilder(this)
            .append("applyno", getApplyno())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof CheckedapplyVO) ) return false;
        CheckedapplyVO castOther = (CheckedapplyVO) other;
        return new EqualsBuilder()
            .append(this.getApplyno(), castOther.getApplyno())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getApplyno())
            .toHashCode();
    }

}
