/**
* auto-generated code
* Sat Aug 26 11:34:28 CST 2006
*/
package com.sunrise.boss.business.cms.wayentitybch.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: WayentitybchListVO</p>
 * <p>Description: Query Params Object for WayentitybchDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayentitybchListVO extends BaseListVO {

	private String _se_wayid;
	
	private String _se_bchtype;

	public String get_se_bchtype() {
		return _se_bchtype;
	}

	public void set_se_bchtype(String _se_bchtype) {
		this._se_bchtype = _se_bchtype;
	}

	/**
	 * @return Returns the _se_wayid.
	 */
	public String get_se_wayid() {
		return _se_wayid;
	}

	/**
	 * @param _se_wayid The _se_wayid to set.
	 */
	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}
}
