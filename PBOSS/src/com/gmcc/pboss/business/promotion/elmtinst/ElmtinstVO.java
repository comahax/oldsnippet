package com.gmcc.pboss.business.promotion.elmtinst;

import com.gmcc.pboss.business.promotion.elmtinstlog.ElmtinstlogVO;
import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.BusinessLog;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ElmtinstVO extends BaseVO implements BusinessLog, Serializable {

	/** identifier field */
	private String instid;

	/** persistent field */
	private String instname;

	/** persistent field */
	private Long tmplid;

	/** nullable persistent field */
	private String params;

	/** nullable persistent field */
	private String memo;

	/** full constructor */
	public ElmtinstVO(java.lang.String instid, java.lang.String instname,
			java.lang.Long tmplid, java.lang.String params,
			java.lang.String memo) {
		this.instid = instid;
		this.instname = instname;
		this.tmplid = tmplid;
		this.params = params;
		this.memo = memo;
	}

	/** default constructor */
	public ElmtinstVO() {
	}

	/** minimal constructor */
	public ElmtinstVO(java.lang.String instid, java.lang.String instname,
			java.lang.Long tmplid) {
		this.instid = instid;
		this.instname = instname;
		this.tmplid = tmplid;
	}

	public java.lang.String getInstid() {
		return this.instid;
	}

	public void setInstid(java.lang.String instid) {
		this.instid = instid;
	}

	public java.lang.String getInstname() {
		return this.instname;
	}

	public void setInstname(java.lang.String instname) {
		this.instname = instname;
	}

	public java.lang.Long getTmplid() {
		return this.tmplid;
	}

	public void setTmplid(java.lang.Long tmplid) {
		this.tmplid = tmplid;
	}

	public java.lang.String getParams() {
		return this.params;
	}

	public void setParams(java.lang.String params) {
		this.params = params;
	}

	public java.lang.String getMemo() {
		return this.memo;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}

	public String toString() {
		return new ToStringBuilder(this).append("instid", getInstid())
				.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof ElmtinstVO))
			return false;
		ElmtinstVO castOther = (ElmtinstVO) other;
		return new EqualsBuilder().append(this.getInstid(),
				castOther.getInstid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getInstid()).toHashCode();
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ElmtinstlogVO.class;
	}

}
