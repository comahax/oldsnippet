/**
 * auto-generated code
 * Wed Sep 10 11:22:49 CST 2008
 */
package com.sunrise.boss.ui.cms.reward.rulerel;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.rulerel.persistent.RulerelVO;

/**
 * <p>Title: RulerelForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RulerelForm extends BaseActionForm {
	private String _se_ruleitemid;
	private String _se_ruleid;
	private String _se_cityid;
	private String _ne_state;
	private Long _ne_rulemodeid;

	private String ruleitemid;
	private String ruleitemids[];

	private String ruleid;
	private String cityid;
	private Short state;
	private Short isdefault;
	private Long rulemodeid;
	
	private boolean hasRuleexp;
    private String ruleitemexp;
    private String remark;
    private String paramer;
    private String paramervalue;
    
    

	public String getParamervalue() {
		return paramervalue;
	}

	public void setParamervalue(String paramervalue) {
		this.paramervalue = paramervalue;
	}

	public String getParamer() {
		return paramer;
	}

	public void setParamer(String paramer) {
		this.paramer = paramer;
	}

	public String getRuleitemexp() {
		return ruleitemexp;
	}

	public void setRuleitemexp(String ruleitemexp) {
		this.ruleitemexp = ruleitemexp;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean isHasRuleexp() {
		return hasRuleexp;
	}

	public void setHasRuleexp(boolean hasRuleexp) {
		this.hasRuleexp = hasRuleexp;
	}

	public Long getRulemodeid() {
		return rulemodeid;
	}

	public void setRulemodeid(Long rulemodeid) {
		this.rulemodeid = rulemodeid;
	}

	public String get_se_ruleitemid() {
		return _se_ruleitemid;
	}

	public void set_se_ruleitemid(String _se_ruleitemid) {
		this._se_ruleitemid = _se_ruleitemid;
	}

	public String get_se_ruleid() {
		return _se_ruleid;
	}

	public void set_se_ruleid(String _se_ruleid) {
		this._se_ruleid = _se_ruleid;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_ne_state() {
		return _ne_state;
	}

	public void set_ne_state(String _ne_state) {
		this._ne_state = _ne_state;
	}

	public String getRuleitemid() {
		return ruleitemid;
	}

	public void setRuleitemid(String ruleitemid) {
		this.ruleitemid = ruleitemid;
	}

	public String getRuleid() {
		return ruleid;
	}

	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Short getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(Short isdefault) {
		this.isdefault = isdefault;
	}

	public String[] getRuleitemids() {
		return ruleitemids;
	}

	public void setRuleitemids(String[] ruleitemids) {
		this.ruleitemids = ruleitemids;
	}

	public Long get_ne_rulemodeid() {
		return _ne_rulemodeid;
	}

	public void set_ne_rulemodeid(Long _ne_rulemodeid) {
		this._ne_rulemodeid = _ne_rulemodeid;
	}

}
