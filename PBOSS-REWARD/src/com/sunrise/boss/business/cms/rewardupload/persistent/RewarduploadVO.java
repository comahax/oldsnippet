package com.sunrise.boss.business.cms.rewardupload.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RewarduploadVO implements Serializable {

    /** identifier field */
    private Long taskid;

    /** nullable persistent field */
    private String uploadfile;

    /** nullable persistent field */
    private Byte taskstate;

    /** nullable persistent field */
    private String resultfile;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date uploadtime;

    /** nullable persistent field */
    private java.util.Date endtime;

    /** nullable persistent field */
    private Integer totalcount;

    /** nullable persistent field */
    private Integer currentcount;

    /** nullable persistent field */
    private Integer successcount;

    /** nullable persistent field */
    private Integer failcount;

    /** nullable persistent field */
    private String mobile;

    /** full constructor */
    public RewarduploadVO(java.lang.Long taskid, java.lang.String uploadfile, java.lang.Byte taskstate, java.lang.String resultfile, java.lang.String oprcode, java.util.Date uploadtime, java.util.Date endtime, java.lang.Integer totalcount, java.lang.Integer currentcount, java.lang.Integer successcount, java.lang.Integer failcount, java.lang.String mobile) {
        this.taskid = taskid;
        this.uploadfile = uploadfile;
        this.taskstate = taskstate;
        this.resultfile = resultfile;
        this.oprcode = oprcode;
        this.uploadtime = uploadtime;
        this.endtime = endtime;
        this.totalcount = totalcount;
        this.currentcount = currentcount;
        this.successcount = successcount;
        this.failcount = failcount;
        this.mobile = mobile;
    }

    /** default constructor */
    public RewarduploadVO() {
    }

    /** minimal constructor */
    public RewarduploadVO(java.lang.Long taskid) {
        this.taskid = taskid;
    }

    public java.lang.Long getTaskid() {
        return this.taskid;
    }

    public void setTaskid(java.lang.Long taskid) {
        this.taskid = taskid;
    }

    public java.lang.String getUploadfile() {
        return this.uploadfile;
    }

    public void setUploadfile(java.lang.String uploadfile) {
        this.uploadfile = uploadfile;
    }

    public java.lang.Byte getTaskstate() {
        return this.taskstate;
    }

    public void setTaskstate(java.lang.Byte taskstate) {
        this.taskstate = taskstate;
    }

    public java.lang.String getResultfile() {
        return this.resultfile;
    }

    public void setResultfile(java.lang.String resultfile) {
        this.resultfile = resultfile;
    }

    public java.lang.String getOprcode() {
        return this.oprcode;
    }

    public void setOprcode(java.lang.String oprcode) {
        this.oprcode = oprcode;
    }

    public java.util.Date getUploadtime() {
        return this.uploadtime;
    }

    public void setUploadtime(java.util.Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public java.util.Date getEndtime() {
        return this.endtime;
    }

    public void setEndtime(java.util.Date endtime) {
        this.endtime = endtime;
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

    public java.lang.Integer getFailcount() {
        return this.failcount;
    }

    public void setFailcount(java.lang.Integer failcount) {
        this.failcount = failcount;
    }

    public java.lang.String getMobile() {
        return this.mobile;
    }

    public void setMobile(java.lang.String mobile) {
        this.mobile = mobile;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("taskid", getTaskid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewarduploadVO) ) return false;
        RewarduploadVO castOther = (RewarduploadVO) other;
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
