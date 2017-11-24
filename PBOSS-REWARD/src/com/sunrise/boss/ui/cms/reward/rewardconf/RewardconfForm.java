/**
* auto-generated code
* Fri Feb 01 18:16:01 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.rewardconf;

import java.util.List;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: RewardpoolrForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RewardconfForm extends BaseActionForm {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//VO
	private String cityid;

    /** identifier field */
    private String rewardkind;

    /** identifier field */
    private String rewardmonth;

    /** nullable persistent field */
    private String state;

    /** nullable persistent field */
    private String oprcode;

    /** nullable persistent field */
    private java.util.Date oprtime;
    
    private String batchno;
    
    //ListVO
    private String _se_cityid;

    /** identifier field */
    private String _se_rewardkind;
    
    private String rewardb2mkind;

    /** identifier field */
    private String _se_rewardmonth;

    /** nullable persistent field */
    private String _se_state;

    /** nullable persistent field */
    private String _se_oprcode;
    
    private List _sin_rewardkind;
    
    private String _se_batchno;

	public String get_se_batchno() {
		return _se_batchno;
	}

	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public List get_sin_rewardkind() {
		return _sin_rewardkind;
	}

	public void set_sin_rewardkind(List _sin_rewardkind) {
		this._sin_rewardkind = _sin_rewardkind;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_oprcode() {
		return _se_oprcode;
	}

	public void set_se_oprcode(String _se_oprcode) {
		this._se_oprcode = _se_oprcode;
	}

	public String get_se_rewardkind() {
		return _se_rewardkind;
	}

	public void set_se_rewardkind(String _se_rewardkind) {
		this._se_rewardkind = _se_rewardkind;
	}

	public String get_se_rewardmonth() {
		return _se_rewardmonth;
	}

	public void set_se_rewardmonth(String _se_rewardmonth) {
		this._se_rewardmonth = _se_rewardmonth;
	}

	public String get_se_state() {
		return _se_state;
	}

	public String getRewardb2mkind() {
		return rewardb2mkind;
	}

	public void setRewardb2mkind(String rewardb2mkind) {
		this.rewardb2mkind = rewardb2mkind;
	}

	public void set_se_state(String _se_state) {
		this._se_state = _se_state;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public java.util.Date getOprtime() {
		return oprtime;
	}

	public void setOprtime(java.util.Date oprtime) {
		this.oprtime = oprtime;
	}

	public String getRewardkind() {
		return rewardkind;
	}

	public void setRewardkind(String rewardkind) {
		this.rewardkind = rewardkind;
	}

	public String getRewardmonth() {
		return rewardmonth;
	}

	public void setRewardmonth(String rewardmonth) {
		this.rewardmonth = rewardmonth;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}




