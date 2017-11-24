package com.sunrise.boss.business.cms.reward.montask.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class MontaskVO implements Serializable {

    /** identifier field */
    private String ownertaskid;

    /** identifier field */
    private String taskid;

    /** nullable persistent field */
    private String taskname;

    /** nullable persistent field */
    private Short tasklevel;

    /** nullable persistent field */
    private Short runorder;

    /** nullable persistent field */
    private String type;

    /** nullable persistent field */
    private Short state;
    
    private Short procstat;
    
    private String starttime;
    private String starttime2;
    
    private String endtime;
    private String endtime2;
    
    
    public Short getProcstat() {
		return procstat;
	}

	public void setProcstat(Short procstat) {
		this.procstat = procstat;
	}

	/** full constructor */
    public MontaskVO(java.lang.String ownertaskid, java.lang.String taskid, java.lang.String taskname, java.lang.Short tasklevel, java.lang.Short runorder, java.lang.String type, java.lang.Short state, java.lang.Short procstat, java.lang.String starttime, java.lang.String endtime) {
        this.ownertaskid = ownertaskid;
        this.taskid = taskid;
        this.taskname = taskname;
        this.tasklevel = tasklevel;
        this.runorder = runorder;
        this.type = type;
        this.state = state;
        this.procstat = procstat;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    /** default constructor */
    public MontaskVO() {
    }

    /** minimal constructor */
    public MontaskVO(java.lang.String ownertaskid, java.lang.String taskid) {
        this.ownertaskid = ownertaskid;
        this.taskid = taskid;
    }

    public java.lang.String getOwnertaskid() {
        return this.ownertaskid;
    }

    public void setOwnertaskid(java.lang.String ownertaskid) {
        this.ownertaskid = ownertaskid;
    }

    public java.lang.String getTaskid() {
        return this.taskid;
    }

    public void setTaskid(java.lang.String taskid) {
        this.taskid = taskid;
    }

    public java.lang.String getTaskname() {
        return this.taskname;
    }

    public void setTaskname(java.lang.String taskname) {
        this.taskname = taskname;
    }

    public java.lang.Short getTasklevel() {
        return this.tasklevel;
    }

    public void setTasklevel(java.lang.Short tasklevel) {
        this.tasklevel = tasklevel;
    }

    public java.lang.Short getRunorder() {
        return this.runorder;
    }

    public void setRunorder(java.lang.Short runorder) {
        this.runorder = runorder;
    }

    public java.lang.String getType() {
        return this.type;
    }

    public void setType(java.lang.String type) {
        this.type = type;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ownertaskid", getOwnertaskid())
            .append("taskid", getTaskid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof MontaskVO) ) return false;
        MontaskVO castOther = (MontaskVO) other;
        return new EqualsBuilder()
            .append(this.getOwnertaskid(), castOther.getOwnertaskid())
            .append(this.getTaskid(), castOther.getTaskid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOwnertaskid())
            .append(getTaskid())
            .toHashCode();
    }

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getStarttime() {
		
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime2() {
		if(getEndtime() != null && getEndtime().length() == 14){
			endtime2 = getEndtime().substring(0,4)+"-"+getEndtime().substring(4,6)+"-"+getEndtime().substring(6,8)+" "+getEndtime().substring(8,10)+":" +
				getEndtime().substring(10,12)+":"+getEndtime().substring(12,14);
		}
		return endtime2;
	}

	public void setEndtime2(String endtime2) {
		this.endtime2 = endtime2;
	}

	public String getStarttime2() {
		if(getStarttime() != null && getStarttime().length() == 14){
			starttime2 = getStarttime().substring(0,4)+"-"+getStarttime().substring(4,6)+"-"+getStarttime().substring(6,8)+" "+getStarttime().substring(8,10)+":" +
				getStarttime().substring(10,12)+":"+getStarttime().substring(12,14);
		}
		return starttime2;
	}

	public void setStarttime2(String starttime2) {
		this.starttime2 = starttime2;
	}

}
