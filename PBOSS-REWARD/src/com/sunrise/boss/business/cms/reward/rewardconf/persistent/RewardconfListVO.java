/**
* auto-generated code
* Fri Mar 06 14:15:03 CST 2009
*/
package com.sunrise.boss.business.cms.reward.rewardconf.persistent;

import java.util.List;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RewardconfListVO</p>
 * <p>Description: Query Params Object for RewardconfDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class RewardconfListVO extends BaseListVO {
	private String _se_cityid;

    /** identifier field */
    private String _se_rewardkind;

    /** identifier field */
    private String _se_rewardmonth;
    
    private List _sin_rewardkind;

    /** nullable persistent field */
    private String _se_state;

    /** nullable persistent field */
    private String _se_oprcode;
    
    private String _se_batchno;

	public String get_se_batchno() {
		return _se_batchno;
	}

	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
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

	public void set_se_state(String _se_state) {
		this._se_state = _se_state;
	}

	public List get_sin_rewardkind() {
		return _sin_rewardkind;
	}

	public void set_sin_rewardkind(List _sin_rewardkind) {
		this._sin_rewardkind = _sin_rewardkind;
	}

}
