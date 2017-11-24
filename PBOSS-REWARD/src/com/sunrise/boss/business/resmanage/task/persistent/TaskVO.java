package com.sunrise.boss.business.resmanage.task.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TaskVO implements Serializable {

    /** identifier field */
    private Long taskid;

    /** nullable persistent field */
    private String filecode;

    /** persistent field */
    private String subsystem;

    /** nullable persistent field */
    private Integer taskstate;

    /** nullable persistent field */
    private java.util.Date createtime;

    /** nullable persistent field */
    private java.util.Date exectime;

    /** nullable persistent field */
    private java.util.Date endtime;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private String wayid;

    /** nullable persistent field */
    private Short taskfilecount;

    /** nullable persistent field */
    private Integer totalcount;

    /** nullable persistent field */
    private Integer currentcount;

    /** nullable persistent field */
    private Integer successcount;

    /** nullable persistent field */
    private String resultfile;

    /** nullable persistent field */
    private String memo;

    /** nullable persistent field */
    private String logfile;
    
    private Integer sysflag;

	/** full constructor */
    public TaskVO(java.lang.Long taskid, java.lang.String filecode, java.lang.String subsystem, java.lang.Integer taskstate, java.util.Date createtime, java.util.Date exectime, java.util.Date endtime, java.lang.String oprcode, java.lang.String wayid, java.lang.Short taskfilecount, java.lang.Integer totalcount, java.lang.Integer currentcount, java.lang.Integer successcount, java.lang.String resultfile, java.lang.String memo, java.lang.String logfile, java.lang.Integer sysflag) {
        this.taskid = taskid;
        this.filecode = filecode;
        this.subsystem = subsystem;
        this.taskstate = taskstate;
        this.createtime = createtime;
        this.exectime = exectime;
        this.endtime = endtime;
        this.oprcode = oprcode;
        this.wayid = wayid;
        this.taskfilecount = taskfilecount;
        this.totalcount = totalcount;
        this.currentcount = currentcount;
        this.successcount = successcount;
        this.resultfile = resultfile;
        this.memo = memo;
        this.logfile = logfile;
        this.sysflag = sysflag;
    }

    /** default constructor */
    public TaskVO() {
    }

    /** minimal constructor */
    public TaskVO(java.lang.Long taskid, java.lang.String subsystem) {
        this.taskid = taskid;
        this.subsystem = subsystem;
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

    public java.lang.String getSubsystem() {
        return this.subsystem;
    }

    public void setSubsystem(java.lang.String subsystem) {
        this.subsystem = subsystem;
    }

    public java.lang.Integer getTaskstate() {
        return this.taskstate;
    }

    public void setTaskstate(java.lang.Integer taskstate) {
        this.taskstate = taskstate;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.util.Date getExectime() {
        return this.exectime;
    }

    public void setExectime(java.util.Date exectime) {
        this.exectime = exectime;
    }

    public java.util.Date getEndtime() {
        return this.endtime;
    }

    public void setEndtime(java.util.Date endtime) {
        this.endtime = endtime;
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

    public java.lang.Short getTaskfilecount() {
        return this.taskfilecount;
    }

    public void setTaskfilecount(java.lang.Short taskfilecount) {
        this.taskfilecount = taskfilecount;
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

    public java.lang.String getLogfile() {
        return this.logfile;
    }

    public void setLogfile(java.lang.String logfile) {
        this.logfile = logfile;
    }

    public Integer getSysflag() {
		return sysflag;
	}

	public void setSysflag(Integer sysflag) {
		this.sysflag = sysflag;
	}
	
    public String toString() {
        return new ToStringBuilder(this)
            .append("taskid", getTaskid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TaskVO) ) return false;
        TaskVO castOther = (TaskVO) other;
        return new EqualsBuilder()
            .append(this.getTaskid(), castOther.getTaskid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getTaskid())
            .toHashCode();
    }

}
