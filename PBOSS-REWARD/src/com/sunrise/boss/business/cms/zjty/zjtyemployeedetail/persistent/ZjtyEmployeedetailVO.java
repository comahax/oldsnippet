package com.sunrise.boss.business.cms.zjty.zjtyemployeedetail.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ZjtyEmployeedetailVO implements Serializable {
	
	private String employeeid;

	private String wayid;
	
	private String wayname;
	
	private String employeename;
	
	private String cityid;
	
	private String chainhead;
	
	private String oprcode;
	
	private Long station;
	
	private java.util.Date start_using_time;
	
	public ZjtyEmployeedetailVO(java.lang.String employeeid, java.lang.String cityid, java.lang.String wayid, java.lang.String wayname, java.lang.String employeename, java.lang.String chainhead, java.lang.String oprcode, java.lang.Long station, java.util.Date start_using_time) {
        this.employeeid = employeeid;
		this.wayid = wayid;
        this.wayname = wayname;
        this.employeename = employeename;
        this.cityid = cityid;
        this.chainhead = chainhead;
        this.oprcode = oprcode;
        this.station = station;
        this.start_using_time = start_using_time;
    }
	
	/** default constructor */
    public ZjtyEmployeedetailVO() {
    }

    /** minimal constructor */
    public ZjtyEmployeedetailVO(java.lang.String employeeid) {
        this.employeeid = employeeid;
    }

	public String getChainhead() {
		return chainhead;
	}

	public void setChainhead(String chainhead) {
		this.chainhead = chainhead;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}
/*
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}*/



	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getWayname() {
		return wayname;
	}

	public void setWayname(String wayname) {
		this.wayname = wayname;
	}

	
	
	public String getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("employeeid", getEmployeeid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ZjtyEmployeedetailVO) ) return false;
        ZjtyEmployeedetailVO castOther = (ZjtyEmployeedetailVO) other;
        return new EqualsBuilder()
            .append(this.getEmployeeid(), castOther.getEmployeeid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getEmployeeid())
            .toHashCode();
    }

	public java.util.Date getStart_using_time() {
		return start_using_time;
	}

	public void setStart_using_time(java.util.Date start_using_time) {
		this.start_using_time = start_using_time;
	}

	public Long getStation() {
		return station;
	}

	public void setStation(Long station) {
		this.station = station;
	}

	
	
	
	
	

    

    

    





    


    

}
