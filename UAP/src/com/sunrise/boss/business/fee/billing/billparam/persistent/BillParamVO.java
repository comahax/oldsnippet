package com.sunrise.boss.business.fee.billing.billparam.persistent;

import com.sunrise.jop.infrastructure.db.BaseVO;



public class BillParamVO extends BaseVO {
	
	private Long dataid;
	
	private String pvalue;
	
	private String memo;

	public Long getDataid() {
		return dataid;
	}

	public void setDataid(Long dataid) {
		this.dataid = dataid;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getPvalue() {
		return pvalue;
	}

	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}

}