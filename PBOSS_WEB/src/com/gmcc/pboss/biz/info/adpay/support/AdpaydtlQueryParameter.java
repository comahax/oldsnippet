package com.gmcc.pboss.biz.info.adpay.support;

import com.gmcc.pboss.common.support.QueryAction;
import com.gmcc.pboss.common.support.QueryParameter;

public class AdpaydtlQueryParameter extends QueryParameter {

	public AdpaydtlQueryParameter() {
		setAction(QueryAction.SECTION);
	}

	/**
	 * »ã×ÜºÅ
	 */
	private Long sumid;

	public Long getSumid() {
		return sumid;
	}

	public void setSumid(Long sumid) {
		this.sumid = sumid;
	}
	
}
