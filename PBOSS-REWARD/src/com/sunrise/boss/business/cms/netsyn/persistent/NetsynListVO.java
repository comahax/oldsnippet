/**
 * auto-generated code
 * Tue Jan 08 15:44:14 CST 2008
 */
package com.sunrise.boss.business.cms.netsyn.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: NetsynListVO
 * </p>
 * <p>
 * Description: Query Params Object for NetsynDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author Cai Jianhui
 * @version 1.0
 */
public class NetsynListVO extends BaseListVO {
	private String _se_mobile;
	private String _ne_opract;

	public String get_se_mobile() {
		return _se_mobile;
	}

	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}

	public String get_ne_opract() {
		return _ne_opract;
	}

	public void set_ne_opract(String _ne_opract) {
		this._ne_opract = _ne_opract;
	}

}
