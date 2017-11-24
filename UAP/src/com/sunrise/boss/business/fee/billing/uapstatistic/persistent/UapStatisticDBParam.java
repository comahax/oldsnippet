package com.sunrise.boss.business.fee.billing.uapstatistic.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

public class UapStatisticDBParam extends DBQueryParam
{
	private String _ne_logid;
	private String _ne_rule_id;
	
	private String startindex;
	private String endindex;

	public String get_ne_logid() {
		return _ne_logid;
	}

	public void set_ne_logid(String neLogid) {
		_ne_logid = neLogid;
	}

	public String get_ne_rule_id() {
		return _ne_rule_id;
	}

	public void set_ne_rule_id(String neRuleId) {
		_ne_rule_id = neRuleId;
	}

	public String getStartindex() {
		return startindex;
	}

	public void setStartindex(String startindex) {
		this.startindex = startindex;
	}

	public String getEndindex() {
		return endindex;
	}

	public void setEndindex(String endindex) {
		this.endindex = endindex;
	}


	
	
}
