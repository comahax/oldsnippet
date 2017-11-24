package com.sunrise.boss.business.cms.stdreward.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.stdrewardlog.persistent.StdrewardlogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class StdrewardVO implements OperationLog {

    /** identifier field */
    private Long rewardid;

    /** nullable persistent field */
    private String rewardname;

    /** nullable persistent field */
    private Short rewardproj;

    /** nullable persistent field */
    private Short rewardtype;

    /** nullable persistent field */
    private java.util.Date startdate;

    /** nullable persistent field */
    private java.util.Date stopdate;

    /** nullable persistent field */
    private String memo;

    /** full constructor */
    public StdrewardVO(java.lang.Long rewardid, java.lang.String rewardname, java.lang.Short rewardproj, java.lang.Short rewardtype, java.util.Date startdate, java.util.Date stopdate, java.lang.String memo) {
        this.rewardid = rewardid;
        this.rewardname = rewardname;
        this.rewardproj = rewardproj;
        this.rewardtype = rewardtype;
        this.startdate = startdate;
        this.stopdate = stopdate;
        this.memo = memo;
    }

    /** default constructor */
    public StdrewardVO() {
    }

    /** minimal constructor */
    public StdrewardVO(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.Long getRewardid() {
        return this.rewardid;
    }

    public void setRewardid(java.lang.Long rewardid) {
        this.rewardid = rewardid;
    }

    public java.lang.String getRewardname() {
        return this.rewardname;
    }

    public void setRewardname(java.lang.String rewardname) {
        this.rewardname = rewardname;
    }

    public java.lang.Short getRewardproj() {
        return this.rewardproj;
    }

    public void setRewardproj(java.lang.Short rewardproj) {
        this.rewardproj = rewardproj;
    }

    public java.lang.Short getRewardtype() {
        return this.rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype) {
        this.rewardtype = rewardtype;
    }

    public java.util.Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(java.util.Date startdate) {
        this.startdate = startdate;
    }

    public java.util.Date getStopdate() {
        return this.stopdate;
    }

    public void setStopdate(java.util.Date stopdate) {
        this.stopdate = stopdate;
    }

    public java.lang.String getMemo() {
        return this.memo;
    }

    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("rewardid", getRewardid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof StdrewardVO) ) return false;
        StdrewardVO castOther = (StdrewardVO) other;
        return new EqualsBuilder()
            .append(this.getRewardid(), castOther.getRewardid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRewardid())
            .toHashCode();
    }

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return StdrewardlogVO.class;
	}

}
