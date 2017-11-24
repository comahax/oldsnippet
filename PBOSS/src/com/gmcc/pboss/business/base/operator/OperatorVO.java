package com.gmcc.pboss.business.base.operator;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class OperatorVO extends BaseVO implements Serializable {

    /** identifier field */
    private String operid;

    /** nullable persistent field */
    private Integer region;

    /** nullable persistent field */
    private String opername;

    /** nullable persistent field */
    private String password;

    /** nullable persistent field */
    private java.util.Date passchgdate;

    /** nullable persistent field */
    private String opergroup;

    /** nullable persistent field */
    private String opertype;

    /** nullable persistent field */
    private String operlevel;

    /** nullable persistent field */
    private Byte ismanager;

    /** nullable persistent field */
    private String contactphone;

    /** nullable persistent field */
    private String orgid;

    /** nullable persistent field */
    private Byte isrestrict;

    /** nullable persistent field */
    private Short starttime;

    /** nullable persistent field */
    private Short endtime;

    /** nullable persistent field */
    private Byte enablegprs;

    /** nullable persistent field */
    private Short gprsstarttime;

    /** nullable persistent field */
    private Short gprsendtime;

    /** nullable persistent field */
    private Byte ischkmac;

    /** nullable persistent field */
    private String mac;

    /** nullable persistent field */
    private String notes;

    /** nullable persistent field */
    private java.util.Date createdate;

    /** nullable persistent field */
    private Byte status;

    /** nullable persistent field */
    private java.util.Date statusdate;

    /** nullable persistent field */
    private String rele_Staff_Id;

    /** nullable persistent field */
    private Byte smnotityflag;

    /** nullable persistent field */
    private String csp_Staff_No;

    /** nullable persistent field */
    private String systemtype;

    /** nullable persistent field */
    private java.util.Date start_Using_Time;

    /** nullable persistent field */
    private java.util.Date end_Using_Time;

    /** nullable persistent field */
    private String logintype;

    //用来保存审批步骤的值
    private String lastStepid;
    
    /** full constructor */
    public OperatorVO(java.lang.String operid, java.lang.Integer region, java.lang.String opername, java.lang.String password, java.util.Date passchgdate, java.lang.String opergroup, java.lang.String opertype, java.lang.String operlevel, java.lang.Byte ismanager, java.lang.String contactphone, java.lang.String orgid, java.lang.Byte isrestrict, java.lang.Short starttime, java.lang.Short endtime, java.lang.Byte enablegprs, java.lang.Short gprsstarttime, java.lang.Short gprsendtime, java.lang.Byte ischkmac, java.lang.String mac, java.lang.String notes, java.util.Date createdate, java.lang.Byte status, java.util.Date statusdate, java.lang.String rele_Staff_Id,  java.lang.Byte smnotityflag, java.lang.String csp_Staff_No, java.lang.String systemtype, java.util.Date start_Using_Time, java.util.Date end_Using_Time, java.lang.String logintype) {
        this.operid = operid;
        this.region = region;
        this.opername = opername;
        this.password = password;
        this.passchgdate = passchgdate;
        this.opergroup = opergroup;
        this.opertype = opertype;
        this.operlevel = operlevel;
        this.ismanager = ismanager;
        this.contactphone = contactphone;
        this.orgid = orgid;
        this.isrestrict = isrestrict;
        this.starttime = starttime;
        this.endtime = endtime;
        this.enablegprs = enablegprs;
        this.gprsstarttime = gprsstarttime;
        this.gprsendtime = gprsendtime;
        this.ischkmac = ischkmac;
        this.mac = mac;
        this.notes = notes;
        this.createdate = createdate;
        this.status = status;
        this.statusdate = statusdate;
        this.rele_Staff_Id = rele_Staff_Id;
        this.smnotityflag = smnotityflag;
        this.csp_Staff_No = csp_Staff_No;
        this.systemtype = systemtype;
        this.start_Using_Time = start_Using_Time;
        this.end_Using_Time = end_Using_Time;
        this.logintype = logintype;
    }

    /** default constructor */
    public OperatorVO() {
    }

    /** minimal constructor */
    public OperatorVO(java.lang.String operid) {
        this.operid = operid;
    }
    
    /** minimal constructor */
    public OperatorVO(java.lang.String operid, java.lang.String password) {
        this.operid = operid;
        this.password = password;
    }

    public java.lang.String getOperid() {
        return this.operid;
    }

    public void setOperid(java.lang.String operid) {
        this.operid = operid;
    }

    public java.lang.Integer getRegion() {
        return this.region;
    }

    public void setRegion(java.lang.Integer region) {
        this.region = region;
    }

    public java.lang.String getOpername() {
        return this.opername;
    }

    public void setOpername(java.lang.String opername) {
        this.opername = opername;
    }

    public java.lang.String getPassword() {
        return this.password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    public java.util.Date getPasschgdate() {
        return this.passchgdate;
    }

    public void setPasschgdate(java.util.Date passchgdate) {
        this.passchgdate = passchgdate;
    }

    public java.lang.String getOpergroup() {
        return this.opergroup;
    }

    public void setOpergroup(java.lang.String opergroup) {
        this.opergroup = opergroup;
    }

    public java.lang.String getOpertype() {
        return this.opertype;
    }

    public void setOpertype(java.lang.String opertype) {
        this.opertype = opertype;
    }

    public java.lang.String getOperlevel() {
        return this.operlevel;
    }

    public void setOperlevel(java.lang.String operlevel) {
        this.operlevel = operlevel;
    }

    public java.lang.Byte getIsmanager() {
        return this.ismanager;
    }

    public void setIsmanager(java.lang.Byte ismanager) {
        this.ismanager = ismanager;
    }

    public java.lang.String getContactphone() {
        return this.contactphone;
    }

    public void setContactphone(java.lang.String contactphone) {
        this.contactphone = contactphone;
    }

    public java.lang.String getOrgid() {
        return this.orgid;
    }

    public void setOrgid(java.lang.String orgid) {
        this.orgid = orgid;
    }

    public java.lang.Byte getIsrestrict() {
        return this.isrestrict;
    }

    public void setIsrestrict(java.lang.Byte isrestrict) {
        this.isrestrict = isrestrict;
    }

    public java.lang.Short getStarttime() {
        return this.starttime;
    }

    public void setStarttime(java.lang.Short starttime) {
        this.starttime = starttime;
    }

    public java.lang.Short getEndtime() {
        return this.endtime;
    }

    public void setEndtime(java.lang.Short endtime) {
        this.endtime = endtime;
    }

    public java.lang.Byte getEnablegprs() {
        return this.enablegprs;
    }

    public void setEnablegprs(java.lang.Byte enablegprs) {
        this.enablegprs = enablegprs;
    }

    public java.lang.Short getGprsstarttime() {
        return this.gprsstarttime;
    }

    public void setGprsstarttime(java.lang.Short gprsstarttime) {
        this.gprsstarttime = gprsstarttime;
    }

    public java.lang.Short getGprsendtime() {
        return this.gprsendtime;
    }

    public void setGprsendtime(java.lang.Short gprsendtime) {
        this.gprsendtime = gprsendtime;
    }

    public java.lang.Byte getIschkmac() {
        return this.ischkmac;
    }

    public void setIschkmac(java.lang.Byte ischkmac) {
        this.ischkmac = ischkmac;
    }

    public java.lang.String getMac() {
        return this.mac;
    }

    public void setMac(java.lang.String mac) {
        this.mac = mac;
    }

    public java.lang.String getNotes() {
        return this.notes;
    }

    public void setNotes(java.lang.String notes) {
        this.notes = notes;
    }

    public java.util.Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(java.util.Date createdate) {
        this.createdate = createdate;
    }

    public java.lang.Byte getStatus() {
        return this.status;
    }

    public void setStatus(java.lang.Byte status) {
        this.status = status;
    }

    public java.util.Date getStatusdate() {
        return this.statusdate;
    }

    public void setStatusdate(java.util.Date statusdate) {
        this.statusdate = statusdate;
    }

    public java.lang.String getRele_Staff_Id() {
        return this.rele_Staff_Id;
    }

    public void setRele_Staff_Id(java.lang.String rele_Staff_Id) {
        this.rele_Staff_Id = rele_Staff_Id;
    }


    public java.lang.Byte getSmnotityflag() {
        return this.smnotityflag;
    }

    public void setSmnotityflag(java.lang.Byte smnotityflag) {
        this.smnotityflag = smnotityflag;
    }

    public java.lang.String getCsp_Staff_No() {
        return this.csp_Staff_No;
    }

    public void setCsp_Staff_No(java.lang.String csp_Staff_No) {
        this.csp_Staff_No = csp_Staff_No;
    }

    public java.lang.String getSystemtype() {
        return this.systemtype;
    }

    public void setSystemtype(java.lang.String systemtype) {
        this.systemtype = systemtype;
    }

    public java.util.Date getStart_Using_Time() {
        return this.start_Using_Time;
    }

    public void setStart_Using_Time(java.util.Date start_Using_Time) {
        this.start_Using_Time = start_Using_Time;
    }

    public java.util.Date getEnd_Using_Time() {
        return this.end_Using_Time;
    }

    public void setEnd_Using_Time(java.util.Date end_Using_Time) {
        this.end_Using_Time = end_Using_Time;
    }

    public java.lang.String getLogintype() {
        return this.logintype;
    }

    public void setLogintype(java.lang.String logintype) {
        this.logintype = logintype;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("operid", getOperid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OperatorVO) ) return false;
        OperatorVO castOther = (OperatorVO) other;
        return new EqualsBuilder()
            .append(this.getOperid(), castOther.getOperid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOperid())
            .toHashCode();
    }

	public String getLastStepid() {
		return lastStepid;
	}

	public void setLastStepid(String lastStepid) {
		this.lastStepid = lastStepid;
	}

}
