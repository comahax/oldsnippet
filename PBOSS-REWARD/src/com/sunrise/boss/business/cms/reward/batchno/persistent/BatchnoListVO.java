/**
* auto-generated code
* Wed Nov 11 16:19:50 CST 2009
*/
package com.sunrise.boss.business.cms.reward.batchno.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: BatchnoListVO</p>
 * <p>Description: Query Params Object for BatchnoDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class BatchnoListVO extends BaseListVO {
	
	private String _se_batchno;
	
	private String _se_batchtype;
	
	private String _sk_name;
	
	private String _rewardmonth;

	public String get_sk_name() {
		return _sk_name;
	}

	public void set_sk_name(String _sk_name) {
		this._sk_name = _sk_name;
	}

	public String get_se_batchno() {
		return _se_batchno;
	}

	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}

	public String get_se_batchtype() {
		return _se_batchtype;
	}

	public void set_se_batchtype(String _se_batchtype) {
		this._se_batchtype = _se_batchtype;
	}

	public String get_rewardmonth() {
		return _rewardmonth;
	}

	public void set_rewardmonth(String _rewardmonth) {
		this._rewardmonth = _rewardmonth;
	}



}
