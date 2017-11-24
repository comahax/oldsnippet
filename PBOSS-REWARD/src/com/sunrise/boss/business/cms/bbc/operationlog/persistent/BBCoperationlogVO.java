package com.sunrise.boss.business.cms.bbc.operationlog.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/** @author Hibernate CodeGenerator */
public class BBCoperationlogVO implements Serializable {
    /** identifier field */
	private Long logid;
	private Date optime;
	private String oprcode;
	private String oprtype;
	private String success;
	private String opnid;
	private String name;
	private String parentid;
	private String remark;
	private Short state;
	private Date startdate;
	private Date enddate;
	private Short isbusi;
	private Short opnlevel;
	private Short busikind;
	private String busibelong;
	public String getBusibelong() {
		return busibelong;
	}
	public void setBusibelong(String busibelong) {
		this.busibelong = busibelong;
	}
	public Short getBusikind() {
		return busikind;
	}
	public void setBusikind(Short busikind) {
		this.busikind = busikind;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public Short getIsbusi() {
		return isbusi;
	}
	public void setIsbusi(Short isbusi) {
		this.isbusi = isbusi;
	}
	public Long getLogid() {
		return logid;
	}
	public void setLogid(Long logid) {
		this.logid = logid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpnid() {
		return opnid;
	}
	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}
	public String getOprcode() {
		return oprcode;
	}
	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}
	public Date getOptime() {
		return optime;
	}
	public void setOptime(Date optime) {
		this.optime = optime;
	}
	public String getOprtype() {
		return oprtype;
	}
	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Short getState() {
		return state;
	}
	public void setState(Short state) {
		this.state = state;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public Short getOpnlevel() {
		return opnlevel;
	}
	public void setOpnlevel(Short opnlevel) {
		this.opnlevel = opnlevel;
	}
    public boolean equals(Object other) {
        if ( !(other instanceof BBCoperationlogVO) ) return false;
        BBCoperationlogVO castOther = (BBCoperationlogVO) other;
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
