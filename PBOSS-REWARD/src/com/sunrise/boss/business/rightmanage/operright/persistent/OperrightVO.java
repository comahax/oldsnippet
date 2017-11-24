package com.sunrise.boss.business.rightmanage.operright.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OperrightVO implements Serializable {

	/** identifier field */
	private java.util.Date createdate;

	/** identifier field */
	private String operid;

	/** identifier field */
	private String rightid;

	/** identifier field */
	private Byte status;

	/** nullable persistent field */
	private Short sortorder;

	/** nullable persistent field */
	private Byte flag;

	/** nullable persistent field */
	private java.util.Date statusdate;

	/** full constructor */
	public OperrightVO(java.util.Date createdate, java.lang.String operid,
			java.lang.String rightid, Byte status, Short sortorder, Byte flag,
			java.util.Date statusdate) {
		this.createdate = createdate;
		this.operid = operid;
		this.rightid = rightid;
		this.status = status;
		this.sortorder = sortorder;
		this.flag = flag;
		this.statusdate = statusdate;
	}

	/** default constructor */
	public OperrightVO() {
	}

	/** minimal constructor */
	public OperrightVO(java.util.Date createdate, java.lang.String operid,
			java.lang.String rightid, Byte status) {
		this.createdate = createdate;
		this.operid = operid;
		this.rightid = rightid;
		this.status = status;
	}

	public java.util.Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(java.util.Date createdate) {
		this.createdate = createdate;
	}

	public java.lang.String getOperid() {
		return this.operid;
	}

	public void setOperid(java.lang.String operid) {
		this.operid = operid;
	}

	public java.lang.String getRightid() {
		return this.rightid;
	}

	public void setRightid(java.lang.String rightid) {
		this.rightid = rightid;
	}

	public java.util.Date getStatusdate() {
		return this.statusdate;
	}

	public void setStatusdate(java.util.Date statusdate) {
		this.statusdate = statusdate;
	}

	public String toString() {
		return new ToStringBuilder(this).append("createdate", getCreatedate())
				.append("operid", getOperid()).append("rightid", getRightid())
				.append("status", getStatus()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof OperrightVO))
			return false;
		OperrightVO castOther = (OperrightVO) other;
		return new EqualsBuilder().append(this.getCreatedate(),
				castOther.getCreatedate()).append(this.getOperid(),
				castOther.getOperid()).append(this.getRightid(),
				castOther.getRightid()).append(this.getStatus(),
				castOther.getStatus()).isEquals();
	}

	public Byte getFlag() {
		return flag;
	}

	public void setFlag(Byte flag) {
		this.flag = flag;
	}

	public Short getSortorder() {
		return sortorder;
	}

	public void setSortorder(Short sortorder) {
		this.sortorder = sortorder;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getCreatedate())
				.append(getOperid()).append(getRightid()).append(getStatus())
				.toHashCode();
	}

}
