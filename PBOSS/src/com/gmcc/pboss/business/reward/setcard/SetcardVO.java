package com.gmcc.pboss.business.reward.setcard;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.gmcc.pboss.business.reward.setcardlog.SetcardlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

/** @author Hibernate CodeGenerator */
public class SetcardVO extends BaseVO implements BusinessLog {

	/** identifier field */
	private Long seq;

	/** not null persistent field */
	private String actvday;

	/** not nul persistent field */
	private String wayid;

	/** not nul persistent field */
	private String mobile;

	/** not nul persistent field */
	private String cityid;

	/** not nul persistent field */
	private String waytype;

	/** nullable persistent field */
	private java.util.Date intime;

	/** nullable persistent field */
	private String filename;

	/** nullable persistent field */
	private String comname;

	/** full constructor */
	public SetcardVO(Long seq, String actvday, String wayid, String mobile,
			String cityid, String waytype, java.util.Date intime, String filename,
			String comname) {
		this.seq = seq;
		this.actvday = actvday;
		this.wayid = wayid;
		this.mobile = mobile;
		this.cityid = cityid;
		this.waytype = waytype;
		this.intime = intime;
		this.filename = filename;
		this.comname = comname;
	}

	/** default constructor */
	public SetcardVO() {
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

	public java.util.Date getIntime() {
		return intime;
	}

	public void setIntime(java.util.Date intime) {
		this.intime = intime;
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

	public String toString() {
		return new ToStringBuilder(this).append("seq", getSeq()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof SetcardVO))
			return false;
		SetcardVO castOther = (SetcardVO) other;
		return new EqualsBuilder().append(this.getSeq(), castOther.getSeq())
				.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getSeq()).toHashCode();
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return SetcardlogVO.class;
	}

}
