package com.gmcc.pboss.biz.info.servcent.support;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class ServcentQueryParameter extends QueryParameter {

	public ServcentQueryParameter() {
		setAction(QueryAction.SECTION);// ≤ª∑÷“≥
	}
	
	private String countyid;
	private String svccode;
	private String svcname;

	public String getSvccode() {
		return svccode;
	}

	public void setSvccode(String svccode) {
		this.svccode = svccode;
	}

	public String getSvcname() {
		return svcname;
	}

	public void setSvcname(String svcname) {
		this.svcname = svcname;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}
}
