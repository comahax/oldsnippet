package com.sunrise.boss.web.fee.billing.uapreq;

import com.sunrise.boss.business.fee.billing.uapreq.persistent.UapReqVO;


public class UapReqForm extends UapReqVO {

	private String statisticmark;
	private String analysemark;
	private String compvalidbillcyc;
	private String [] _selectitem;
	private String [] _selectitem2;

	public String getAnalysemark() {
		return analysemark;
	}
	public void setAnalysemark(String analysemark) {
		this.analysemark = analysemark;
	}
	public String getStatisticmark() {
		return statisticmark;
	}
	public void setStatisticmark(String statisticmark) {
		this.statisticmark = statisticmark;
	}
	public String getCompvalidbillcyc() {
		return compvalidbillcyc;
	}
	public void setCompvalidbillcyc(String compvalidbillcyc) {
		this.compvalidbillcyc = compvalidbillcyc;
	}
	public String[] get_selectitem() {
		return _selectitem;
	}
	public void set_selectitem(String[] selectitem) {
		_selectitem = selectitem;
	}
	public String[] get_selectitem2() {
		return _selectitem2;
	}
	public void set_selectitem2(String[] selectitem2) {
		_selectitem2 = selectitem2;
	}
	
	
	
}
