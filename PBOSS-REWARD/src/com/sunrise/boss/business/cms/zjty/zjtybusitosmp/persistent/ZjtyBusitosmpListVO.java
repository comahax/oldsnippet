/**
* auto-generated code
* Thu Dec 24 16:13:49 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.zjtybusitosmp.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ZjtyBusitosmpListVO</p>
 * <p>Description: Query Params Object for ZjtyBusitosmpDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyBusitosmpListVO extends BaseListVO {
	
	private String _se_opnid;
	
	private String _ne_comid;

	private String _se_sort;
	
	private String _se_cityid;

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_sort() {
		return _se_sort;
	}

	public void set_se_sort(String _se_sort) {
		this._se_sort = _se_sort;
	}

	public String get_ne_comid() {
		return _ne_comid;
	}

	public void set_ne_comid(String _ne_comid) {
		this._ne_comid = _ne_comid;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}
}
