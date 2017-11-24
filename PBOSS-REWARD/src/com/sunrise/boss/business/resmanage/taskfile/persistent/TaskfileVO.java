package com.sunrise.boss.business.resmanage.taskfile.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TaskfileVO implements Serializable {

    /** identifier field */
    private Long fileid;

    /** nullable persistent field */
    private Long taskid;

    /** nullable persistent field */
    private String taskfile;

    /** nullable persistent field */
    private Integer fileline;

    /** nullable persistent field */
    private java.util.Date uploadtime;

    /** nullable persistent field */
    private Integer currentcount;

    /** nullable persistent field */
    private Integer successcount;

    /** full constructor */
    public TaskfileVO(java.lang.Long fileid, java.lang.Long taskid, java.lang.String taskfile, java.lang.Integer fileline, java.util.Date uploadtime, java.lang.Integer currentcount, java.lang.Integer successcount) {
        this.fileid = fileid;
        this.taskid = taskid;
        this.taskfile = taskfile;
        this.fileline = fileline;
        this.uploadtime = uploadtime;
        this.currentcount = currentcount;
        this.successcount = successcount;
    }

    /** default constructor */
    public TaskfileVO() {
    }

    /** minimal constructor */
    public TaskfileVO(java.lang.Long fileid) {
        this.fileid = fileid;
    }

    public java.lang.Long getFileid() {
        return this.fileid;
    }

    public void setFileid(java.lang.Long fileid) {
        this.fileid = fileid;
    }

    public java.lang.Long getTaskid() {
        return this.taskid;
    }

    public void setTaskid(java.lang.Long taskid) {
        this.taskid = taskid;
    }

    public java.lang.String getTaskfile() {
        return this.taskfile;
    }

    public void setTaskfile(java.lang.String taskfile) {
        this.taskfile = taskfile;
    }

    public java.lang.Integer getFileline() {
        return this.fileline;
    }

    public void setFileline(java.lang.Integer fileline) {
        this.fileline = fileline;
    }

    public java.util.Date getUploadtime() {
        return this.uploadtime;
    }

    public void setUploadtime(java.util.Date uploadtime) {
        this.uploadtime = uploadtime;
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

    public String toString() {
        return new ToStringBuilder(this)
            .append("fileid", getFileid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TaskfileVO) ) return false;
        TaskfileVO castOther = (TaskfileVO) other;
        return new EqualsBuilder()
            .append(this.getFileid(), castOther.getFileid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getFileid())
            .toHashCode();
    }

}
