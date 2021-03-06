package com.sunrise.boss.business.fee.billing.billlogdeta.persistent;


import com.sunrise.jop.infrastructure.db.BaseVO;
import com.sunrise.jop.infrastructure.sysadmin.ManageLog;

/**
 * IbWlBilllogdeta generated by MyEclipse - Hibernate Tools
 */

public class VBillLogDetaVO extends BaseVO implements ManageLog {
	
	private String id;
	
	private Long validbillcyc;

	private String subphase;

	private Double sumAmt;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Double getSumAmt() {
		return sumAmt;
	}

	public void setSumAmt(Double sumAmt) {
		this.sumAmt = sumAmt;
	}

	
}