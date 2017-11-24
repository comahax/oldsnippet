package com.sunrise.boss.business.cms.waitaudit.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class WaitauditVO implements Serializable {

    /** identifier field */
    private Long taskid;

    /** nullable persistent field */
    private String filecode;

    /** nullable persistent field */
    private Short subsystem;

    /** nullable persistent field */
    private String logfile;

    /** nullable persistent field */
    private Byte taskstate;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private String auditoprcode;

    /** nullable persistent field */
    private String auditwayid;

    /** nullable persistent field */
    private java.util.Date audittime;

    /** nullable persistent field */
    private Integer totalcount;

    /** nullable persistent field */
    private Integer currentcount;

    /** nullable persistent field */
    private Integer successcount;

    /** nullable persistent field */
    private String resultfile;
    
    private String errorfile;
    
    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public WaitauditVO(java.lang.Long taskid, java.lang.String filecode, java.lang.Short subsystem, java.lang.String logfile, java.lang.Byte taskstate, java.lang.String oprcode, java.lang.String wayid, java.util.Date createtime, java.lang.String auditoprcode, java.lang.String auditwayid, java.util.Date audittime, java.lang.Integer totalcount, java.lang.Integer currentcount, java.lang.Integer successcount, java.lang.String resultfile, java.lang.String memo) {
        this.taskid = taskid;
        this.filecode = filecode;
        this.subsystem = subsystem;
        this.logfile = logfile;
        this.taskstate = taskstate;
        this.oprcode = oprcode;
        this.wayid = wayid;
        this.createtime = createtime;
        this.auditoprcode = auditoprcode;
        this.auditwayid = auditwayid;
        this.audittime = audittime;
        this.totalcount = totalcount;
        this.currentcount = currentcount;
        this.successcount = successcount;
        this.resultfile = resultfile;
        this.memo = memo;
    }

    /** default constructor */
    public WaitauditVO() {
    }

    /** minimal constructor */
    public WaitauditVO(java.lang.Long taskid) {
        this.taskid = taskid;
    }

    public java.lang.Long getTaskid() {
        return this.taskid;
    }

    public void setTaskid(java.lang.Long taskid) {
        this.taskid = taskid;
    }

    public java.lang.String getFilecode() {
        return this.filecode;
    }

    public void setFilecode(java.lang.String filecode) {
        this.filecode = filecode;
    }

    public java.lang.Short getSubsystem() {
        return this.subsystem;
    }

    public void setSubsystem(java.lang.Short subsystem) {
        this.subsystem = subsystem;
    }

    public java.lang.String getLogfile() {
        return this.logfile;
    }

    public void setLogfile(java.lang.String logfile) {
        this.logfile = logfile;
    }

    public java.lang.Byte getTaskstate() {
        return this.taskstate;
    }

    public void setTaskstate(java.lang.Byte taskstate) {
        this.taskstate = taskstate;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.lang.String getWayid() {
        return this.wayid;
    }

    public void setWayid(java.lang.String wayid) {
        this.wayid = wayid;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.lang.String getAuditoprcode() {
        return this.auditoprcode;
    }

    public void setAuditoprcode(java.lang.String auditoprcode) {
        this.auditoprcode = auditoprcode;
    }

    public java.lang.String getAuditwayid() {
        return this.auditwayid;
    }

    public void setAuditwayid(java.lang.String auditwayid) {
        this.auditwayid = auditwayid;
    }

    public java.util.Date getAudittime() {
        return this.audittime;
    }

    public void setAudittime(java.util.Date audittime) {
        this.audittime = audittime;
    }

    public java.lang.Integer getTotalcount() {
        return this.totalcount;
    }

    public void setTotalcount(java.lang.Integer totalcount) {
        this.totalcount = totalcount;
    }

    public java.lang.Integer getCurrentcount() {
        return this.currentcount;
    }

    public void setCurrentcount(java.lang.Integer currentcount) {
        this.currentcount = currentcount;
    }

    public java.lang.Integer getSuccesscount() {
        return this.successcount;
    }

    public void setSuccesscount(java.lang.Integer successcount) {
        this.successcount = successcount;
    }

    public java.lang.String getResultfile() {
        return this.resultfile;
    }

    public void setResultfile(java.lang.String resultfile) {
        this.resultfile = resultfile;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("taskid", getTaskid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof WaitauditVO) ) return false;
        WaitauditVO castOther = (WaitauditVO) other;
        return new EqualsBuilder()
            .append(this.getTaskid(), castOther.getTaskid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getTaskid())
            .toHashCode();
    }

	public String getErrorfile() {
		return errorfile;
	}

	public void setErrorfile(String errorfile) {
		this.errorfile = errorfile;
	}

}
