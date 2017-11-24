package com.gmcc.pboss.business.reward.setcardlog;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class SetcardlogVO extends BaseVO implements Serializable {

	private Long logid;

	/** nullable persistent field */
	private java.util.Date optime;

	/** nullable persistent field */
	private String oprcode;

	/** nullable persistent field */
	private String oprtype;

	/** nullable persistent field */
	private String success;

	private Long seq;
	
	private String actvday;
	
	private String wayid;
	
	private String mobile;
	
	private String cityid;
	
	private String waytype;
	
	private String filename;
	
	private String comname;
	
	private java.util.Date intime;

	/** full constructor */
	public SetcardlogVO(Long logid, java.util.Date optime, String oprcode,
			String oprtype, String success, Long seq, String actvday,
			String wayid, String mobile , String cityid,String waytype,
			String filename,String comname,java.util.Date intime) {
		this.logid = logid;
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
		this.success = success;
		this.seq = seq;
		this.actvday = actvday;
		this.wayid = wayid;
		this.cityid = cityid;
		this.mobile=mobile;
		this.waytype=waytype;
		this.filename=filename;
		this.comname=comname;
		this.intime=intime;
	}

	/** default constructor */
	public SetcardlogVO() {
	}

	/** minimal constructor */
	public SetcardlogVO(Long seq) {
		this.seq = seq;
	}

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public java.util.Date getOptime() {
		return optime;
	}

	public void setOptime(java.util.Date optime) {
		this.optime = optime;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getOprtype() {
		return oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getActvday() {
		return actvday;
	}

	public void setActvday(String actvday) {
		this.actvday = actvday;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getWaytype() {
		return waytype;
	}

	public void setWaytype(String waytype) {
		this.waytype = waytype;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public java.util.Date getIntime() {
		return intime;
	}

	public void setIntime(java.util.Date intime) {
		this.intime = intime;
	}

	public String toString() {
		return new ToStringBuilder(this).append("logid", getLogid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof SetcardlogVO))
			return false;
		SetcardlogVO castOther = (SetcardlogVO) other;
		return new EqualsBuilder()
				.append(this.getLogid(), castOther.getLogid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getLogid()).toHashCode();
	}

}
