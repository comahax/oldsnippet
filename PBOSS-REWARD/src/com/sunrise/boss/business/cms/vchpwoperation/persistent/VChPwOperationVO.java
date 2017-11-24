package com.sunrise.boss.business.cms.vchpwoperation.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class VChPwOperationVO implements Serializable {

    /** identifier field */
    private String opnid5;

    /** nullable persistent field */
    private String opnid;

    /** nullable persistent field */
    private String name;

    /** nullable persistent field */
    private String opnid2;

    /** nullable persistent field */
    private java.util.Date startdate;

    /** nullable persistent field */
    private java.util.Date enddate;

    /** nullable persistent field */
    private String busibelong;
    private String name2;
    private String name5;

    /** full constructor */
    public VChPwOperationVO(java.lang.String opnid, java.lang.String name, java.lang.String opnid2,java.lang.String opnid5, java.util.Date startdate, java.util.Date enddate, java.lang.String busibelong
    		,java.lang.String name2,java.lang.String name5) {
        this.opnid = opnid;
        this.name = name;
        this.opnid2 = opnid2;
        this.opnid5= opnid5;
        this.startdate = startdate;
        this.enddate = enddate;
        this.busibelong = busibelong;
        this.name2 = name2;
        this.name5 = name5;
    }

    /** default constructor */
    public VChPwOperationVO() {
    } 

    public java.lang.String getOpnid() {
        return this.opnid;
    }

    public void setOpnid(java.lang.String opnid) {
        this.opnid = opnid;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getOpnid2() {
        return this.opnid2;
    }

    public void setOpnid2(java.lang.String opnid2) {
        this.opnid2 = opnid2;
    }

    public java.util.Date getStartdate() {
        return this.startdate;
    }

    public void setStartdate(java.util.Date startdate) {
        this.startdate = startdate;
    }

    public java.util.Date getEnddate() {
        return this.enddate;
    }

    public void setEnddate(java.util.Date enddate) {
        this.enddate = enddate;
    }

    public java.lang.String getBusibelong() {
        return this.busibelong;
    }

    public void setBusibelong(java.lang.String busibelong) {
        this.busibelong = busibelong;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("opnid5", getOpnid5())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof VChPwOperationVO) ) return false;
        VChPwOperationVO castOther = (VChPwOperationVO) other;
        return new EqualsBuilder()
            .append(this.getOpnid5(), castOther.getOpnid5())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOpnid5())
            .toHashCode();
    }

	public String getOpnid5() {
		return opnid5;
	}

	public void setOpnid5(String opnid5) {
		this.opnid5 = opnid5;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getName5() {
		return name5;
	}

	public void setName5(String name5) {
		this.name5 = name5;
	}

}
