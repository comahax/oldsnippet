/**
 * 
 */
package com.sunrise.boss.business.admin.operator.persistent;

import java.sql.Timestamp;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: GDIBOSS
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Hanny Yeung
 * @version 1.0
 */
public class OperatorListVO extends BaseListVO {
	private String _se_operid;

	private String _se_orgid;
	
	private String _sql_waycondition;
	
	private String isSubWay;
	
	private String _sne_operid;
	
	private String _se_opername;
	
	private String _sk_opername;
	
	private String _ne_status;
	

	public String get_ne_status() {
		return _ne_status;
	}


	public void set_ne_status(String _ne_status) {
		this._ne_status = _ne_status;
	}


	public String get_se_opername() {
		return _se_opername;
	}


	public void set_se_opername(String _se_opername) {
		this._se_opername = _se_opername;
	}


	public String get_sql_waycondition() {
		return _sql_waycondition;
	}


	public String get_sne_operid() {
		return _sne_operid;
	}


	public void set_sne_operid(String _sne_operid) {
		this._sne_operid = _sne_operid;
	}


	public void set_sql_waycondition(String _sql_waycondition) {
		this._sql_waycondition = _sql_waycondition;
	}

	public String get_se_operid() {
		return _se_operid;
	}

	public void set_se_operid(String _se_operid) {
		this._se_operid = _se_operid;
	}

	public String get_se_orgid() {
		return _se_orgid;
	}

	public void set_se_orgid(String _se_orgid) {
		this._se_orgid = _se_orgid;
	}

	public String getIsSubWay() {
		return isSubWay;
	}

	public void setIsSubWay(String isSubWay) {
		this.isSubWay = isSubWay;
	}


	public String get_sk_opername() {
		return _sk_opername;
	}


	public void set_sk_opername(String _sk_opername) {
		this._sk_opername = _sk_opername;
	}

}
