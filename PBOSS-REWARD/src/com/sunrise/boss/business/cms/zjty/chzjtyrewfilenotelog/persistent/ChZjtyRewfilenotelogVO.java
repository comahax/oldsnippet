package com.sunrise.boss.business.cms.zjty.chzjtyrewfilenotelog.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChZjtyRewfilenotelogVO implements Serializable {

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
    private Long seqid;

    /** nullable persistent field */
    private String filename;

    /** nullable persistent field */
    private String filepath;

    /** nullable persistent field */
    private String uploadcode;

    /** nullable persistent field */
    private java.util.Date uploadtime;

    /** nullable persistent field */
    private String rewardmonth;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public ChZjtyRewfilenotelogVO(java.lang.Long logid, java.util.Date optime, java.lang.String oprcode, java.lang.String oprtype, java.lang.String success, java.lang.Long seqid, java.lang.String filename, java.lang.String filepath, java.lang.String uploadcode, java.util.Date uploadtime, java.lang.String rewardmonth, java.lang.String memo) {
        this.logid = logid;
        this.optime = optime;
        this.oprcode = oprcode;
        this.oprtype = oprtype;
        this.success = success;
        this.seqid = seqid;
        this.filename = filename;
        this.filepath = filepath;
        this.uploadcode = uploadcode;
        this.uploadtime = uploadtime;
        this.rewardmonth = rewardmonth;
        this.memo = memo;
    }

    /** default constructor */
    public ChZjtyRewfilenotelogVO() {
    }

    /** minimal constructor */
    public ChZjtyRewfilenotelogVO(java.lang.Long logid) {
        this.logid = logid;
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

    public java.lang.Long getSeqid() {
        return this.seqid;
    }

    public void setSeqid(java.lang.Long seqid) {
        this.seqid = seqid;
    }

    public java.lang.String getFilename() {
        return this.filename;
    }

    public void setFilename(java.lang.String filename) {
        this.filename = filename;
    }

    public java.lang.String getFilepath() {
        return this.filepath;
    }

    public void setFilepath(java.lang.String filepath) {
        this.filepath = filepath;
    }

    public java.lang.String getUploadcode() {
        return this.uploadcode;
    }

    public void setUploadcode(java.lang.String uploadcode) {
        this.uploadcode = uploadcode;
    }

    public java.util.Date getUploadtime() {
        return this.uploadtime;
    }

    public void setUploadtime(java.util.Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("logid", getLogid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChZjtyRewfilenotelogVO) ) return false;
        ChZjtyRewfilenotelogVO castOther = (ChZjtyRewfilenotelogVO) other;
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
