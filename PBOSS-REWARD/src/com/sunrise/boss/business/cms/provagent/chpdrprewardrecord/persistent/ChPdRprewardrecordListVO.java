/**
* auto-generated code
* Tue Sep 10 14:37:33 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdrprewardrecord.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChPdRprewardrecordListVO</p>
 * <p>Description: Query Params Object for ChPdRprewardrecordDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdRprewardrecordListVO extends BaseListVO {
 
	  /** nullable persistent field */
    private String _se_provagentid;

    /** nullable persistent field */
    private String _se_prodno;

    /** nullable persistent field */
    private String _se_rewardmonth;

    /** nullable persistent field */
    private Short _ne_phase;

    /** nullable persistent field */
    private String _se_cityid;

	public String get_se_provagentid() {
		return _se_provagentid;
	}

	public void set_se_provagentid(String _se_provagentid) {
		this._se_provagentid = _se_provagentid;
	}

	public String get_se_prodno() {
		return _se_prodno;
	}

	public void set_se_prodno(String _se_prodno) {
		this._se_prodno = _se_prodno;
	}

	public String get_se_rewardmonth() {
		return _se_rewardmonth;
	}

	public void set_se_rewardmonth(String _se_rewardmonth) {
		this._se_rewardmonth = _se_rewardmonth;
	}

	public Short get_ne_phase() {
		return _ne_phase;
	}

	public void set_ne_phase(Short _ne_phase) {
		this._ne_phase = _ne_phase;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

    
    
}
