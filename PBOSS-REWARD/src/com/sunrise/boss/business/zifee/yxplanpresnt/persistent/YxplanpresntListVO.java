/**
 * auto-generated code
 * Tue Sep 18 15:52:13 CST 2007
 */
package com.sunrise.boss.business.zifee.yxplanpresnt.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: YxplanpresntListVO
 * </p>
 * <p>
 * Description: Query Params Object for YxplanpresntDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class YxplanpresntListVO extends BaseListVO {
	private String _ne_yxplanid;

	private String _ne_acctid;

	private String _ne_presentinterval;

	private String _ne_presentcycles;

	private String _ne_presentrate;

	private String _ne_eboxunitid;
	
	private String [] _orderbys;
	
	private String [] _descs;
	
	public String get_ne_acctid() {
		return _ne_acctid;
	}

	public void set_ne_acctid(String _ne_acctid) {
		this._ne_acctid = _ne_acctid;
	}

	public String get_ne_eboxunitid() {
		return _ne_eboxunitid;
	}

	public void set_ne_eboxunitid(String _ne_eboxunitid) {
		this._ne_eboxunitid = _ne_eboxunitid;
	}

	public String get_ne_presentcycles() {
		return _ne_presentcycles;
	}

	public void set_ne_presentcycles(String _ne_presentcycles) {
		this._ne_presentcycles = _ne_presentcycles;
	}

	public String get_ne_presentinterval() {
		return _ne_presentinterval;
	}

	public void set_ne_presentinterval(String _ne_presentinterval) {
		this._ne_presentinterval = _ne_presentinterval;
	}

	public String get_ne_presentrate() {
		return _ne_presentrate;
	}

	public void set_ne_presentrate(String _ne_presentrate) {
		this._ne_presentrate = _ne_presentrate;
	}

	public String get_ne_yxplanid() {
		return _ne_yxplanid;
	}

	public void set_ne_yxplanid(String _ne_yxplanid) {
		this._ne_yxplanid = _ne_yxplanid;
	}

	public String[] get_orderbys() {
		return _orderbys;
	}

	public void set_orderbys(String[] _orderbys) {
		this._orderbys = _orderbys;
	}

	public String[] get_descs() {
		return _descs;
	}

	public void set_descs(String[] _descs) {
		this._descs = _descs;
	}

}
