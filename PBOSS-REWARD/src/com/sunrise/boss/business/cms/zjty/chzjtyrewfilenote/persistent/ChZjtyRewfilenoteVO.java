package com.sunrise.boss.business.cms.zjty.chzjtyrewfilenote.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.zjty.chzjtyrewfilenotelog.persistent.ChZjtyRewfilenotelogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class ChZjtyRewfilenoteVO implements Serializable,OperationLog {

    /** identifier field */
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
    
    private String cityid;
    
    private String oldfilename;

    /** full constructor */
    public ChZjtyRewfilenoteVO(java.lang.Long seqid, java.lang.String filename, java.lang.String filepath, java.lang.String uploadcode, java.util.Date uploadtime, java.lang.String rewardmonth, java.lang.String memo) {
        this.seqid = seqid;
        this.filename = filename;
        this.filepath = filepath;
        this.uploadcode = uploadcode;
        this.uploadtime = uploadtime;
        this.rewardmonth = rewardmonth;
        this.memo = memo;
    }

    /** default constructor */
    public ChZjtyRewfilenoteVO() {
    }

    /** minimal constructor */
    public ChZjtyRewfilenoteVO(java.lang.Long seqid) {
        this.seqid = seqid;
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
            .append("seqid", getSeqid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChZjtyRewfilenoteVO) ) return false;
        ChZjtyRewfilenoteVO castOther = (ChZjtyRewfilenoteVO) other;
        return new EqualsBuilder()
            .append(this.getSeqid(), castOther.getSeqid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqid())
            .toHashCode();
    }

	public Class logVOClass() {
		return ChZjtyRewfilenotelogVO.class;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getOldfilename() {
		return oldfilename;
	}

	public void setOldfilename(String oldfilename) {
		this.oldfilename = oldfilename;
	}

}
