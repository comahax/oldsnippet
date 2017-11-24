package com.gmcc.pboss.business.channel.waycompact;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.channel.waycompctlog.WaycompctlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class WaycompactVO extends BaseVO implements Serializable ,BusinessLog{

    /** identifier field */
    private String wayid;

    /** nullable persistent field */
    private String compactno;

    /** nullable persistent field */
    private String compactname;

    /** nullable persistent field */
    private java.util.Date begintime;

    /** nullable persistent field */
    private java.util.Date endtime;

    /** nullable persistent field */
    private java.util.Date signtime;

    /** nullable persistent field */
    private Short coptype;

    /** nullable persistent field */
    private String copbound;

    /** nullable persistent field */
    private String recomrule;

    /** nullable persistent field */
    private String compact;

    /** nullable persistent field */
    private Short compacttype;

    /** nullable persistent field */
    private String compactpath;

    /** nullable persistent field */
    private String licenceno;

    /** nullable persistent field */
    private String licencepath;

    /** nullable persistent field */
    private Short runareatype;

    /** nullable persistent field */
    private String principal;

    /** nullable persistent field */
    private Double bail;

    /** nullable persistent field */
    private Short bailstatus;

    /** nullable persistent field */
    private Byte isb2m;
    
    /** nullable persistent field */
    private Byte isunpb;
    
    //private Short calcumode;这两个字段改到渠道表
    
    //private String uniformtime;
    
    /** full constructor */
    public WaycompactVO(java.lang.String wayid, java.lang.String compactno,
			java.lang.String compactname, java.util.Date begintime,
			java.util.Date endtime, java.util.Date signtime,
			java.lang.Short coptype, java.lang.String copbound,
			java.lang.String recomrule, java.lang.String compact,
			java.lang.Short compacttype, java.lang.String compactpath,
			java.lang.String licenceno, java.lang.String licencepath,
			java.lang.Short runareatype, java.lang.String principal,
			java.lang.Double bail, java.lang.Short bailstatus,
			java.lang.Byte isb2m, java.lang.Byte isunpb) {
    	
        this.wayid = wayid;
        this.compactno = compactno;
        this.compactname = compactname;
        this.begintime = begintime;
        this.endtime = endtime;
        this.signtime = signtime;
        this.coptype = coptype;
        this.copbound = copbound;
        this.recomrule = recomrule;
        this.compact = compact;
        this.compacttype = compacttype;
        this.compactpath = compactpath;
        this.licenceno = licenceno;
        this.licencepath = licencepath;
        this.runareatype = runareatype;
        this.principal = principal;
        this.bail = bail;
        this.bailstatus = bailstatus;
        this.isb2m = isb2m;
        this.isunpb = isunpb;
        //this.calcumode=calcumode;
        //this.uniformtime=uniformtime;
    }

    /** default constructor */
    public WaycompactVO() {
    }

    /** minimal constructor */
    public WaycompactVO(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.lang.String getCompactno() {
        return this.compactno;
    }

    public void setCompactno(java.lang.String compactno) {
        this.compactno = compactno;
    }

    public java.lang.String getCompactname() {
        return this.compactname;
    }

    public void setCompactname(java.lang.String compactname) {
        this.compactname = compactname;
    }

    public java.util.Date getBegintime() {
        return this.begintime;
    }

    public void setBegintime(java.util.Date begintime) {
        this.begintime = begintime;
    }

    public java.util.Date getEndtime() {
        return this.endtime;
    }

    public void setEndtime(java.util.Date endtime) {
        this.endtime = endtime;
    }

    public java.util.Date getSigntime() {
        return this.signtime;
    }

    public void setSigntime(java.util.Date signtime) {
        this.signtime = signtime;
    }

    public java.lang.Short getCoptype() {
        return this.coptype;
    }

    public void setCoptype(java.lang.Short coptype) {
        this.coptype = coptype;
    }

    public java.lang.String getCopbound() {
        return this.copbound;
    }

    public void setCopbound(java.lang.String copbound) {
        this.copbound = copbound;
    }

    public java.lang.String getRecomrule() {
        return this.recomrule;
    }

    public void setRecomrule(java.lang.String recomrule) {
        this.recomrule = recomrule;
    }

    public java.lang.String getCompact() {
        return this.compact;
    }

    public void setCompact(java.lang.String compact) {
        this.compact = compact;
    }

    public java.lang.Short getCompacttype() {
        return this.compacttype;
    }

    public void setCompacttype(java.lang.Short compacttype) {
        this.compacttype = compacttype;
    }

    public java.lang.String getCompactpath() {
        return this.compactpath;
    }

    public void setCompactpath(java.lang.String compactpath) {
        this.compactpath = compactpath;
    }

    public java.lang.String getLicenceno() {
        return this.licenceno;
    }

    public void setLicenceno(java.lang.String licenceno) {
        this.licenceno = licenceno;
    }

    public java.lang.String getLicencepath() {
        return this.licencepath;
    }

    public void setLicencepath(java.lang.String licencepath) {
        this.licencepath = licencepath;
    }

    public java.lang.Short getRunareatype() {
        return this.runareatype;
    }

    public void setRunareatype(java.lang.Short runareatype) {
        this.runareatype = runareatype;
    }

    public java.lang.String getPrincipal() {
        return this.principal;
    }

    public void setPrincipal(java.lang.String principal) {
        this.principal = principal;
    }

    public java.lang.Double getBail() {
        return this.bail;
    }

    public void setBail(java.lang.Double bail) {
        this.bail = bail;
    }

    public java.lang.Short getBailstatus() {
        return this.bailstatus;
    }

    public void setBailstatus(java.lang.Short bailstatus) {
        this.bailstatus = bailstatus;
    }

    public java.lang.Byte getIsb2m() {
        return this.isb2m;
    }

    public void setIsb2m(java.lang.Byte isb2m) {
        this.isb2m = isb2m;
    }

    public Byte getIsunpb() {
		return isunpb;
	}

	public void setIsunpb(Byte isunpb) {
		this.isunpb = isunpb;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("wayid", getWayid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WaycompactVO) ) return false;
        WaycompactVO castOther = (WaycompactVO) other;
        return new EqualsBuilder()
            .append(this.getWayid(), castOther.getWayid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getWayid())
            .toHashCode();
    }
    
    public Class logVOClass(){
    	return WaycompctlogVO.class;
    }

//	public Short getCalcumode() {
//		return calcumode;
//	}
//
//	public void setCalcumode(Short calcumode) {
//		this.calcumode = calcumode;
//	}
//
//	public String getUniformtime() {
//		return uniformtime;
//	}
//
//	public void setUniformtime(String uniformtime) {
//		this.uniformtime = uniformtime;
//	}

}
