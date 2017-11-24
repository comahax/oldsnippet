/**
* auto-generated code
* Mon Aug 02 10:12:57 CST 2010
*/
package com.sunrise.boss.business.cms.bbc.bbcwaylevel.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: BbcWaylevelListVO</p>
 * <p>Description: Query Params Object for BbcWaylevelDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BbcWaylevelListVO extends BaseListVO {
	private String _se_wayid;
	
	private String _se_waylevel;

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_se_waylevel() {
		return _se_waylevel;
	}

	public void set_se_waylevel(String _se_waylevel) {
		this._se_waylevel = _se_waylevel;
	}
}
