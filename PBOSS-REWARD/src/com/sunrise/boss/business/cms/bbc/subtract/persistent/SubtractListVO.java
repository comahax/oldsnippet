/**
* auto-generated code
* Fri Apr 20 16:55:21 CST 2012
*/
package com.sunrise.boss.business.cms.bbc.subtract.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: SubtractListVO</p>
 * <p>Description: Query Params Object for SubtractDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class SubtractListVO extends BaseListVO {
	
	private String _sql_subcondition;
	
    private String _sk_onceopnid;
    
    private String _sk_intvopnid;
    
    private String _sk_empmobile;
    
    private String _sk_blackmobile;

	public String get_sql_subcondition() {
		return _sql_subcondition;
	}

	public void set_sql_subcondition(String _sql_subcondition) {
		this._sql_subcondition = _sql_subcondition;
	}

	public String get_sk_onceopnid() {
		return _sk_onceopnid;
	}

	public void set_sk_onceopnid(String _sk_onceopnid) {
		this._sk_onceopnid = _sk_onceopnid;
	}

	public String get_sk_intvopnid() {
		return _sk_intvopnid;
	}

	public void set_sk_intvopnid(String _sk_intvopnid) {
		this._sk_intvopnid = _sk_intvopnid;
	}

	public String get_sk_empmobile() {
		return _sk_empmobile;
	}

	public void set_sk_empmobile(String _sk_empmobile) {
		this._sk_empmobile = _sk_empmobile;
	}

	public String get_sk_blackmobile() {
		return _sk_blackmobile;
	}

	public void set_sk_blackmobile(String _sk_blackmobile) {
		this._sk_blackmobile = _sk_blackmobile;
	}
}
