package com.sunrise.boss.business.fee.qsmanage.billacctnew.persistent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class BillAcctNewBakVO implements java.io.Serializable {

	// Fields

	private Long billitemid;

	private Long acctid;

	private Long accttype;

	// Constructors

	/** default constructor */
	public BillAcctNewBakVO() {
	}

	/** minimal constructor */

	// Property accessors

	public Long getAccttype() {
		return this.accttype;
	}

	public void setAccttype(Long accttype) {
		this.accttype = accttype;
	}

	public Long getAcctid() {
		return acctid;
	}

	public void setAcctid(Long acctid) {
		this.acctid = acctid;
	}

	public Long getBillitemid() {
		return billitemid;
	}

	public void setBillitemid(Long billitemid) {
		this.billitemid = billitemid;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(this.getBillitemid().toString()).append("~").append(this.getAcctid().toString()).append("~").append(this.getAccttype().toString()).append("~");
		return buf.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof BillAcctNewBakVO))
			return false;
		BillAcctNewBakVO castOther = (BillAcctNewBakVO) other;
		return (new EqualsBuilder().append(this.getBillitemid(), castOther
				.getBillitemid()).isEquals())
				&& (new EqualsBuilder().append(this.getAcctid(), castOther
						.getAcctid()).isEquals());
	}

	public int hashCode() {
		return new HashCodeBuilder().append(acctid).append(billitemid)
				.toHashCode();
	}

}