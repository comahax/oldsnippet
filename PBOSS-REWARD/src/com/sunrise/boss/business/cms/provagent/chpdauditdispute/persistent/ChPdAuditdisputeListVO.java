/**
* auto-generated code
* Tue Sep 03 20:54:50 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdauditdispute.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChPdAuditdisputeListVO</p>
 * <p>Description: Query Params Object for ChPdAuditdisputeDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPdAuditdisputeListVO extends BaseListVO {
	private String _se_cityid;
	private String _se_provagentid;
	private String _se_prodid;
	private String _se_rewardmonth;

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_provagentid() {
		return _se_provagentid;
	}

	public void set_se_provagentid(String _se_provagentid) {
		this._se_provagentid = _se_provagentid;
	}

	public String get_se_prodid() {
		return _se_prodid;
	}

	public void set_se_prodid(String _se_prodid) {
		this._se_prodid = _se_prodid;
	}

	public String get_se_rewardmonth() {
		return _se_rewardmonth;
	}

	public void set_se_rewardmonth(String _se_rewardmonth) {
		this._se_rewardmonth = _se_rewardmonth;
	}

}
