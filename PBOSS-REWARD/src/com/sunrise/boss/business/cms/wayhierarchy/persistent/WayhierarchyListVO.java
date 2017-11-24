/**
* auto-generated code
* Tue Sep 12 17:06:58 CST 2006
*/
package com.sunrise.boss.business.cms.wayhierarchy.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: WayhierarchyListVO</p>
 * <p>Description: Query Params Object for WayhierarchyDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayhierarchyListVO extends BaseListVO {

	private String _se_parwayid;
	private String _se_subwayid;
	private Short _ne_hichyoffset;
	
	public Short get_ne_hichyoffset() {
		return _ne_hichyoffset;
	}
	public void set_ne_hichyoffset(Short _ne_hichyoffset) {
		this._ne_hichyoffset = _ne_hichyoffset;
	}
	public String get_se_parwayid() {
		return _se_parwayid;
	}
	public void set_se_parwayid(String _se_parwayid) {
		this._se_parwayid = _se_parwayid;
	}
	public String get_se_subwayid() {
		return _se_subwayid;
	}
	public void set_se_subwayid(String _se_subwayid) {
		this._se_subwayid = _se_subwayid;
	}
}
