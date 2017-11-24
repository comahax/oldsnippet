package com.sunrise.boss.business.cms.reward.taskstate.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class TaskstateVO implements Serializable {

    /** identifier field */
    private String cityid;

    /** identifier field */
    private String ownertaskid;

    /** identifier field */
    private String rewardmonth;

    /** identifier field */
    private String taskid;

    /** nullable persistent field */
    private java.util.Date starttime;

    /** nullable persistent field */
    private java.util.Date endtime;

    /** nullable persistent field */
    private Short state;

    /** full constructor */
    public TaskstateVO(java.lang.String cityid, java.lang.String ownertaskid, java.lang.String rewardmonth, java.lang.String taskid, java.util.Date starttime, java.util.Date endtime, java.lang.Short state) {
        this.cityid = cityid;
        this.ownertaskid = ownertaskid;
        this.rewardmonth = rewardmonth;
        this.taskid = taskid;
        this.starttime = starttime;
        this.endtime = endtime;
        this.state = state;
    }

    /** default constructor */
    public TaskstateVO() {
    }

    /** minimal constructor */
    public TaskstateVO(java.lang.String cityid, java.lang.String ownertaskid, java.lang.String rewardmonth, java.lang.String taskid) {
        this.cityid = cityid;
        this.ownertaskid = ownertaskid;
        this.rewardmonth = rewardmonth;
        this.taskid = taskid;
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getRewardmonth() {
        return this.rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth) {
        this.rewardmonth = rewardmonth;
    }


    public String getOwnertaskid() {
		return ownertaskid;
	}

	public void setOwnertaskid(String ownertaskid) {
		this.ownertaskid = ownertaskid;
	}

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public java.util.Date getStarttime() {
        return this.starttime;
    }

    public void setStarttime(java.util.Date starttime) {
        this.starttime = starttime;
    }

    public java.util.Date getEndtime() {
        return this.endtime;
    }

    public void setEndtime(java.util.Date endtime) {
        this.endtime = endtime;
    }


    public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("ownertaskid", getOwnertaskid())
            .append("rewardmonth", getRewardmonth())
            .append("taskid", getTaskid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof TaskstateVO) ) return false;
        TaskstateVO castOther = (TaskstateVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getOwnertaskid(), castOther.getOwnertaskid())
            .append(this.getRewardmonth(), castOther.getRewardmonth())
            .append(this.getTaskid(), castOther.getTaskid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getOwnertaskid())
            .append(getRewardmonth())
            .append(getTaskid())
            .toHashCode();
    }

}
