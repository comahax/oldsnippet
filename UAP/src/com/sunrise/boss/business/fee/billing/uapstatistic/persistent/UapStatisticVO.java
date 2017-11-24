package com.sunrise.boss.business.fee.billing.uapstatistic.persistent;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class UapStatisticVO extends BaseVO{

	private Long logid;
	private String key_column;
	private Long validbillcyc;
	private String rule_id;
	private Long amt;
	private java.util.Date uptime;
	private String remark;
	private Integer region;
	private Long cnt;
	public Long getLogid() {
		return logid;
	}
	public void setLogid(Long logid) {
		this.logid = logid;
	}
	public String getKey_column() {
		return key_column;
	}
	public void setKey_column(String keyColumn) {
		key_column = keyColumn;
	}
	public Long getValidbillcyc() {
		return validbillcyc;
	}
	public void setValidbillcyc(Long validbillcyc) {
		this.validbillcyc = validbillcyc;
	}
	public String getRule_id() {
		return rule_id;
	}
	public void setRule_id(String ruleId) {
		rule_id = ruleId;
	}
	public Long getAmt() {
		return amt;
	}
	public void setAmt(Long amt) {
		this.amt = amt;
	}
	public java.util.Date getUptime() {
		return uptime;
	}
	public void setUptime(java.util.Date uptime) {
		this.uptime = uptime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getRegion() {
		return region;
	}
	public void setRegion(Integer region) {
		this.region = region;
	}
	public Long getCnt() {
		return cnt;
	}
	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
	
}
