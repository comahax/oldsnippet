package com.gmcc.pboss.business.base.operatorlog;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OperatorlogVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long logid;

    /** nullable persistent field */
    private java.util.Date optime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String oprtype;

    /** nullable persistent field */
    private String success;

    /** nullable persistent field */
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
    private String releStaffId;

    /** nullable persistent field */
    private Byte checkMac;

    /** nullable persistent field */
    private java.util.Date gprsEndtime;

    /** nullable persistent field */
    private java.util.Date gprsStarttime;

    /** nullable persistent field */
    private Byte enableGprs;

    /** nullable persistent field */
    private Integer restrictTime;

    /** nullable persistent field */
    private Integer startTime;

    /** nullable persistent field */
    private Integer endTime;

    /** nullable persistent field */
    private Integer hrStatus;

    /** nullable persistent field */
    private String assessrec;

    /** nullable persistent field */
    private String starlevel;

    /** full constructor */
    public OperatorlogVO(java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.String operid, java.lang.Integer region, java.lang.String opername, java.lang.String password, java.util.Date passchgdate, java.lang.String opergroup, java.lang.String opertype, java.lang.String operlevel, java.lang.Byte ismanager, java.lang.String contactphone, java.lang.String orgid, java.lang.Byte isrestrict, java.lang.Short starttime, java.lang.Short endtime, java.lang.Byte enablegprs, java.lang.Short gprsstarttime, java.lang.Short gprsendtime, java.lang.Byte ischkmac, java.lang.String mac, java.lang.String notes, java.util.Date createdate, java.lang.Byte status, java.util.Date statusdate, java.lang.String releStaffId, java.lang.Byte checkMac, java.util.Date gprsEndtime, java.util.Date gprsStarttime, java.lang.Byte enableGprs, java.lang.Integer restrictTime, java.lang.Integer startTime, java.lang.Integer endTime, java.lang.Integer hrStatus, java.lang.String assessrec, java.lang.String starlevel) {
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
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
        this.releStaffId = releStaffId;
        this.checkMac = checkMac;
        this.gprsEndtime = gprsEndtime;
        this.gprsStarttime = gprsStarttime;
        this.enableGprs = enableGprs;
        this.restrictTime = restrictTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hrStatus = hrStatus;
        this.assessrec = assessrec;
        this.starlevel = starlevel;
    }

    /** default constructor */
    public OperatorlogVO() {
    }

    public java.lang.Long getLogid() {
        return this.logid;
    }

    public void setLogid(java.lang.Long logid) {
        this.logid = logid;
    }

    public java.util.Date getOptime() {
        return this.optime;
    }

    public void setOptime(java.util.Date optime) {
        this.optime = optime;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getOprtype() {
        return this.oprtype;
    }

    public void setOprtype(java.lang.String oprtype) {
        this.oprtype = oprtype;
    }

    public java.lang.String getSuccess() {
        return this.success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
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

    public java.lang.String getReleStaffId() {
        return this.releStaffId;
    }

    public void setReleStaffId(java.lang.String releStaffId) {
        this.releStaffId = releStaffId;
    }

    public java.lang.Byte getCheckMac() {
        return this.checkMac;
    }

    public void setCheckMac(java.lang.Byte checkMac) {
        this.checkMac = checkMac;
    }

    public java.util.Date getGprsEndtime() {
        return this.gprsEndtime;
    }

    public void setGprsEndtime(java.util.Date gprsEndtime) {
        this.gprsEndtime = gprsEndtime;
    }

    public java.util.Date getGprsStarttime() {
        return this.gprsStarttime;
    }

    public void setGprsStarttime(java.util.Date gprsStarttime) {
        this.gprsStarttime = gprsStarttime;
    }

    public java.lang.Byte getEnableGprs() {
        return this.enableGprs;
    }

    public void setEnableGprs(java.lang.Byte enableGprs) {
        this.enableGprs = enableGprs;
    }

    public java.lang.Integer getRestrictTime() {
        return this.restrictTime;
    }

    public void setRestrictTime(java.lang.Integer restrictTime) {
        this.restrictTime = restrictTime;
    }

    public java.lang.Integer getStartTime() {
        return this.startTime;
    }

    public void setStartTime(java.lang.Integer startTime) {
        this.startTime = startTime;
    }

    public java.lang.Integer getEndTime() {
        return this.endTime;
    }

    public void setEndTime(java.lang.Integer endTime) {
        this.endTime = endTime;
    }

    public java.lang.Integer getHrStatus() {
        return this.hrStatus;
    }

    public void setHrStatus(java.lang.Integer hrStatus) {
        this.hrStatus = hrStatus;
    }

    public java.lang.String getAssessrec() {
        return this.assessrec;
    }

    public void setAssessrec(java.lang.String assessrec) {
        this.assessrec = assessrec;
    }

    public java.lang.String getStarlevel() {
        return this.starlevel;
    }

    public void setStarlevel(java.lang.String starlevel) {
        this.starlevel = starlevel;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OperatorlogVO) ) return false;
        OperatorlogVO castOther = (OperatorlogVO) other;
        return new EqualsBuilder()
            .append(this.getLogid(), castOther.getLogid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getLogid())
            .toHashCode();
    }

}
