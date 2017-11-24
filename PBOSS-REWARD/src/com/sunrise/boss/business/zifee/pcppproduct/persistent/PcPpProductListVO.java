/**
* auto-generated code
* Wed Aug 16 15:21:29 CST 2006
*/
package com.sunrise.boss.business.zifee.pcppproduct.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: PcPpProductListVO</p>
 * <p>Description: Query Params Object for PcPpProductDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class PcPpProductListVO extends BaseListVO {
	
	private String _ne_mainprod;
	
	private String _se_status;

	public String get_ne_mainprod() {
		return _ne_mainprod;
	}

	public void set_ne_mainprod(String _ne_mainprod) {
		this._ne_mainprod = _ne_mainprod;
	}

	public String get_se_status() {
		return _se_status;
	}

	public void set_se_status(String _se_status) {
		this._se_status = _se_status;
	}

	
}
