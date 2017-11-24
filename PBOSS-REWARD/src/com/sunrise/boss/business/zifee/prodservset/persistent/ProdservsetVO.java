package com.sunrise.boss.business.zifee.prodservset.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.common.dblog.OperationLog;
import com.sunrise.boss.business.zifee.prodservsetlog.persistent.ProdservsetlogVO;

/** @author Hibernate CodeGenerator */
public class ProdservsetVO implements Serializable, OperationLog {

	/** identifier field */
	private Long yxplanid;

	/** nullable persistent field */
	private Short modeltype;

	/** nullable persistent field */
	private Short servelevel;

	/** nullable persistent field */
	private String servername;

	/** nullable persistent field */
	private Long flowcontrol;

	/** nullable persistent field */
	private Long lowflow;

	/** nullable persistent field */
	private Short busitype;

	/** nullable persistent field */
	private Double feeamt;

	/** nullable persistent field */
	private String acctid;

	/** nullable persistent field */
	private String memo;

	/** full constructor */
	public ProdservsetVO(java.lang.Long yxplanid, java.lang.Short modeltype,
			java.lang.Short servelevel, java.lang.String servername,
			java.lang.Long flowcontrol, java.lang.Long lowflow,
			java.lang.Short busitype, java.lang.Double feeamt,
			java.lang.String acctid, java.lang.String memo) {
		this.yxplanid = yxplanid;
		this.modeltype = modeltype;
		this.servelevel = servelevel;
		this.servername = servername;
		this.flowcontrol = flowcontrol;
		this.lowflow = lowflow;
		this.busitype = busitype;
		this.feeamt = feeamt;
		this.acctid = acctid;
		this.memo = memo;
	}

	/** default constructor */
	public ProdservsetVO() {
	}

	/** minimal constructor */
	public ProdservsetVO(java.lang.Long yxplanid) {
		this.yxplanid = yxplanid;
	}

	public java.lang.Long getYxplanid() {
		return this.yxplanid;
	}

	public void setYxplanid(java.lang.Long yxplanid) {
		this.yxplanid = yxplanid;
	}

	public java.lang.Short getModeltype() {
		return this.modeltype;
	}

	public void setModeltype(java.lang.Short modeltype) {
		this.modeltype = modeltype;
	}

	public java.lang.Short getServelevel() {
		return this.servelevel;
	}

	public void setServelevel(java.lang.Short servelevel) {
		this.servelevel = servelevel;
	}

	public java.lang.String getServername() {
		return this.servername;
	}

	public void setServername(java.lang.String servername) {
		this.servername = servername;
	}

	public java.lang.Long getFlowcontrol() {
		return this.flowcontrol;
	}

	public void setFlowcontrol(java.lang.Long flowcontrol) {
		this.flowcontrol = flowcontrol;
	}

	public java.lang.Long getLowflow() {
		return this.lowflow;
	}

	public void setLowflow(java.lang.Long lowflow) {
		this.lowflow = lowflow;
	}

	public java.lang.Short getBusitype() {
		return this.busitype;
	}

	public void setBusitype(java.lang.Short busitype) {
		this.busitype = busitype;
	}

	public java.lang.Double getFeeamt() {
		return this.feeamt;
	}

	public void setFeeamt(java.lang.Double feeamt) {
		this.feeamt = feeamt;
	}

	public java.lang.String getAcctid() {
		return this.acctid;
	}

	public void setAcctid(java.lang.String acctid) {
		this.acctid = acctid;
	}

	public java.lang.String getMemo() {
		return this.memo;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}

	public String toString() {
		return new ToStringBuilder(this).append("yxplanid", getYxplanid())
				.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof ProdservsetVO))
			return false;
		ProdservsetVO castOther = (ProdservsetVO) other;
		return new EqualsBuilder().append(this.getYxplanid(),
				castOther.getYxplanid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getYxplanid()).toHashCode();
	}

	public Class logVOClass() {
		// TODO Auto-generated method stub
		return ProdservsetlogVO.class;
	}

}
