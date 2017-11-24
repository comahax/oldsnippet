/**
* auto-generated code
* Wed Dec 27 14:23:06 CST 2006
*/
package com.sunrise.boss.business.cms.distribute.cpcomsalerl.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: CpcomsalerlListVO</p>
 * <p>Description: Query Params Object for CpcomsalerlDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CpcomsalerlListVO extends BaseListVO {
	/*
	 * list
	 *合作商编号、业务类型、商品标识、最大订货数量<=、最小订货数量>=
	 */
	private String _se_cooperauid;
	private String _ne_fxtype;
	private String _ne_comid;
	private String _nnl_minnum;
	private String _nnm_maxnum;
	public String get_ne_comid() {
		return _ne_comid;
	}
	public void set_ne_comid(String _ne_comid) {
		this._ne_comid = _ne_comid;
	}
	public String get_ne_fxtype() {
		return _ne_fxtype;
	}
	public void set_ne_fxtype(String _ne_fxtype) {
		this._ne_fxtype = _ne_fxtype;
	}
	public String get_nnl_minnum() {
		return _nnl_minnum;
	}
	public void set_nnl_minnum(String _nnl_minnum) {
		this._nnl_minnum = _nnl_minnum;
	}
	public String get_nnm_maxnum() {
		return _nnm_maxnum;
	}
	public void set_nnm_maxnum(String _nnm_maxnum) {
		this._nnm_maxnum = _nnm_maxnum;
	}
	public String get_se_cooperauid() {
		return _se_cooperauid;
	}
	public void set_se_cooperauid(String _se_cooperauid) {
		this._se_cooperauid = _se_cooperauid;
	}

}
