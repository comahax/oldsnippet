package com.sunrise.boss.business.fee.billing.uapanalyse.persistent;

import com.sunrise.jop.infrastructure.db.BaseVO;

public class UapAnalyseVO extends BaseVO{

	private Long logid;
	private String key_column;
	private Long validbillcyc;
	private String rule_id;
	private String table_name;
	private Long cmp_month;
	private Long cmpcnt;
	private Long cmpamt;
	private Long curcnt;
	private Long curamt;
	private Double chgrate_count;
	private Double chgrate_amt;
	private Integer is_normal;
	private java.util.Date uptime;
	private String remark;
	private Integer region;
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
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String tableName) {
		table_name = tableName;
	}
	public Long getCmp_month() {
		return cmp_month;
	}
	public void setCmp_month(Long cmpMonth) {
		cmp_month = cmpMonth;
	}
	public Long getCmpcnt() {
		return cmpcnt;
	}
	public void setCmpcnt(Long cmpcnt) {
		this.cmpcnt = cmpcnt;
	}
	public Long getCmpamt() {
		return cmpamt;
	}
	public void setCmpamt(Long cmpamt) {
		this.cmpamt = cmpamt;
	}
	public Long getCurcnt() {
		return curcnt;
	}
	public void setCurcnt(Long curcnt) {
		this.curcnt = curcnt;
	}
	public Long getCuramt() {
		return curamt;
	}
	public void setCuramt(Long curamt) {
		this.curamt = curamt;
	}
	public Double getChgrate_count() {
		return chgrate_count;
	}
	public void setChgrate_count(Double chgrateCount) {
		chgrate_count = chgrateCount;
	}
	public Double getChgrate_amt() {
		return chgrate_amt;
	}
	public void setChgrate_amt(Double chgrateAmt) {
		chgrate_amt = chgrateAmt;
	}
	public Integer getIs_normal() {
		return is_normal;
	}
	public void setIs_normal(Integer isNormal) {
		is_normal = isNormal;
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
	
	
	
}
