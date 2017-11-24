/**
* auto-generated code
* Tue Jul 14 09:24:12 CST 2009
*/
package com.sunrise.boss.ui.cms.reward.rulemode;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.rulemode.persistent.RulemodeVO;

/**
 * <p>Title: RulemodeForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class RulemodeForm extends BaseActionForm {

    private java.lang.Integer rulemodeid;
    private java.lang.String ruleid;
    private java.lang.String cityid;
    private java.lang.String rulemodename;
    private java.util.Date startdate;
    private java.util.Date enddate;
    private java.lang.String remark;

    private String _se_ruleid;
    private String _se_cityid;
    private String _sk_rulemodename;
    
    //×÷ÎªRulerelFormµÄ¼æÈÝ
    private String _se_ruleitemid;
    private String _ne_state;
    
	private String ruleitemid;
	private String ruleitemids[];	
	
	private Short state;
	private Short isdefault;

    public java.lang.Integer getRulemodeid(){
        return rulemodeid;
    }

    public void setRulemodeid(java.lang.Integer rulemodeid){
        this.rulemodeid = rulemodeid;
    }
    public java.lang.String getRuleid(){
        return ruleid;
    }

    public void setRuleid(java.lang.String ruleid){
        this.ruleid = ruleid;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.String getRulemodename(){
        return rulemodename;
    }

    public void setRulemodename(java.lang.String rulemodename){
        this.rulemodename = rulemodename;
    }
    public java.util.Date getStartdate(){
        return startdate;
    }

    public void setStartdate(java.util.Date startdate){
        this.startdate = startdate;
    }
    public java.util.Date getEnddate(){
        return enddate;
    }

    public void setEnddate(java.util.Date enddate){
        this.enddate = enddate;
    }
    public java.lang.String getRemark(){
        return remark;
    }

    public void setRemark(java.lang.String remark){
        this.remark = remark;
    }

    public String get_se_ruleid(){
        return _se_ruleid;
    }

    public void set_se_ruleid(String _se_ruleid){
        this._se_ruleid = _se_ruleid;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }
    public String get_sk_rulemodename(){
        return _sk_rulemodename;
    }

    public void set_sk_rulemodename(String _sk_rulemodename){
        this._sk_rulemodename = _sk_rulemodename;
    }

	public String get_se_ruleitemid() {
		return _se_ruleitemid;
	}

	public void set_se_ruleitemid(String _se_ruleitemid) {
		this._se_ruleitemid = _se_ruleitemid;
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

	public String[] getRuleitemids() {
		return ruleitemids;
	}

	public void setRuleitemids(String[] ruleitemids) {
		this.ruleitemids = ruleitemids;
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

}
