package com.sunrise.boss.business.fee.billing.billlogdeta.persistent;

import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.ManageLog;

/**
 * IbWlBilllogdeta generated by MyEclipse - Hibernate Tools
 */

public class BillLogDetaVO extends BaseVO implements ManageLog {

	private static final long serialVersionUID = 1L;

	private Long logid;

	private Long validbillcyc;

	private String subphase;

	private Long acctid;

	private Double acctamt;

	private Long acctcount;

	// Constructors

	/** default constructor */
	public BillLogDetaVO() {
	}

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public Long getValidbillcyc() {
		return validbillcyc;
	}

	public void setValidbillcyc(Long validbillcyc) {
		this.validbillcyc = validbillcyc;
	}

	public String getSubphase() {
		return subphase;
	}

	public void setSubphase(String subphase) {
		this.subphase = subphase;
	}

	public Long getAcctid() {
		return acctid;
	}

	public void setAcctid(Long acctid) {
		this.acctid = acctid;
	}

	public Double getAcctamt() {
		return acctamt;
	}

	public void setAcctamt(Double acctamt) {
		this.acctamt = acctamt;
	}

	public Long getAcctcount() {
		return acctcount;
	}

	public void setAcctcount(Long acctcount) {
		this.acctcount = acctcount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}