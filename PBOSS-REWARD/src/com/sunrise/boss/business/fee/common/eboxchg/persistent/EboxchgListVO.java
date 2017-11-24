package com.sunrise.boss.business.fee.common.eboxchg.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: CompanyListVO
 * </p>
 * <p>
 * Description: Query Params Object for CompanyDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author gy
 * @version 1.0
 */
public class EboxchgListVO extends BaseListVO {
	private static final long serialVersionUID = -3505778414310964630L;
	
	private String _ne_eboxid; // ’ ªß±Í ∂
	
	private String _ne_eboxunitid; 
	
	private String _ne_eboxunitdetid;

	public String get_ne_eboxid() {
		return _ne_eboxid;
	}

	public void set_ne_eboxid(String _ne_eboxid) {
		this._ne_eboxid = _ne_eboxid;
	}

	public String get_ne_eboxunitdetid() {
		return _ne_eboxunitdetid;
	}

	public void set_ne_eboxunitdetid(String _ne_eboxunitdetid) {
		this._ne_eboxunitdetid = _ne_eboxunitdetid;
	}

	public String get_ne_eboxunitid() {
		return _ne_eboxunitid;
	}

	public void set_ne_eboxunitid(String _ne_eboxunitid) {
		this._ne_eboxunitid = _ne_eboxunitid;
	} 
	
}
