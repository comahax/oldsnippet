/**
* auto-generated code
* Tue May 17 18:38:00 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.credittotal;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.credittotal.persistent.CredittotalVO;

/**
 * <p>Title: CredittotalForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class CredittotalForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.String wayid;
    private java.lang.String calcmonth;
    private java.lang.Long slv;
    private java.lang.Double creditaccount;
    private java.lang.Long adtypecode;
    private java.lang.Double creditlev;
    private java.lang.Double cardsale;
    private java.lang.Double salelev;
    private java.lang.String iscreditlev;
    private java.lang.String issalelev;
    private java.lang.Double manageassess;
    private java.lang.Double assess;
    private java.lang.Double assegrade;
    private java.lang.Double saleassess;
    
    private String _se_wayid;
    
    private String ruleitemids[];
    private String paramervalues[];
    
    private String rewardmonth;
    private String rewardtype;

    private String ruleitemids0[];
    
    public String[] getRuleitemids0() {
		return ruleitemids0;
	}

	public void setRuleitemids0(String[] ruleitemids0) {
		this.ruleitemids0 = ruleitemids0;
	}

	public String getRewardmonth() {
		return rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}

	public String getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(String rewardtype) {
		this.rewardtype = rewardtype;
	}

	public String[] getRuleitemids() {
		return ruleitemids;
	}

	public void setRuleitemids(String[] ruleitemids) {
		this.ruleitemids = ruleitemids;
	}

	public String[] getParamervalues() {
		return paramervalues;
	}

	public void setParamervalues(String[] paramervalues) {
		this.paramervalues = paramervalues;
	}

	public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.String getCalcmonth(){
        return calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth){
        this.calcmonth = calcmonth;
    }
    public java.lang.Long getSlv(){
        return slv;
    }

    public void setSlv(java.lang.Long slv){
        this.slv = slv;
    }
    public java.lang.Double getCreditaccount(){
        return creditaccount;
    }

    public void setCreditaccount(java.lang.Double creditaccount){
        this.creditaccount = creditaccount;
    }
    public java.lang.Long getAdtypecode(){
        return adtypecode;
    }

    public void setAdtypecode(java.lang.Long adtypecode){
        this.adtypecode = adtypecode;
    }
    public java.lang.Double getCreditlev(){
        return creditlev;
    }

    public void setCreditlev(java.lang.Double creditlev){
        this.creditlev = creditlev;
    }
    public java.lang.Double getCardsale(){
        return cardsale;
    }

    public void setCardsale(java.lang.Double cardsale){
        this.cardsale = cardsale;
    }
    public java.lang.Double getSalelev(){
        return salelev;
    }

    public void setSalelev(java.lang.Double salelev){
        this.salelev = salelev;
    }
    public java.lang.String getIscreditlev(){
        return iscreditlev;
    }

    public void setIscreditlev(java.lang.String iscreditlev){
        this.iscreditlev = iscreditlev;
    }
    public java.lang.String getIssalelev(){
        return issalelev;
    }

    public void setIssalelev(java.lang.String issalelev){
        this.issalelev = issalelev;
    }

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }

	public java.lang.Double getManageassess() {
		return manageassess;
	}

	public void setManageassess(java.lang.Double manageassess) {
		this.manageassess = manageassess;
	}

	public java.lang.Double getAssess() {
		return assess;
	}

	public void setAssess(java.lang.Double assess) {
		this.assess = assess;
	}

	public java.lang.Double getAssegrade() {
		return assegrade;
	}

	public void setAssegrade(java.lang.Double assegrade) {
		this.assegrade = assegrade;
	}

	public java.lang.Double getSaleassess() {
		return saleassess;
	}

	public void setSaleassess(java.lang.Double saleassess) {
		this.saleassess = saleassess;
	}

    
}
