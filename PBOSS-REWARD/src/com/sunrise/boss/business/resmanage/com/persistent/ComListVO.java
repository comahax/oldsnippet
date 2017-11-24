/**
 * auto-generated code
 * Sat Aug 12 14:48:47 CST 2006
 */
package com.sunrise.boss.business.resmanage.com.persistent;

import java.util.List;

import com.sunrise.boss.business.resmanage.common.excelout.persistent.ResExceloutListVO;
import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>
 * Title: ComListVO
 * </p>
 * <p>
 * Description: Query Params Object for ComDAO
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author Rodney
 * @version 1.0
 */
public class ComListVO extends ResExceloutListVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5469449767660518968L;

	private List _sin_cityid;

	private String _ne_comclassid;

	private String _ne_comid;

	private String _ne_comtype;

	private String _sk_comname;

	private List _nnin_comclassid;

	private String _se_cityid;

	private String _sk_comid;
	
	private String _ne_comstate;
	
	public String get_ne_comstate(){
		return _ne_comstate;
	}
	
	public void set_ne_comstate(String _ne_comstate){
		this._ne_comstate = _ne_comstate;
	}

	public String get_sk_comid() {
		return _sk_comid;
	}

	public void set_sk_comid(String _sk_comid) {
		this._sk_comid = _sk_comid;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_sk_comname() {
		return _sk_comname;
	}

	public void set_sk_comname(String _sk_comname) {
		this._sk_comname = _sk_comname;
	}

	public List get_nnin_comclassid() {
		return _nnin_comclassid;
	}

	public void set_nnin_comclassid(List _nnin_comclassid) {
		this._nnin_comclassid = _nnin_comclassid;
	}

	public String get_ne_comid() {
		return _ne_comid;
	}

	public void set_ne_comid(String _ne_comid) {
		this._ne_comid = _ne_comid;
	}

	public String get_ne_comtype() {
		return _ne_comtype;
	}

	public void set_ne_comtype(String _ne_comtype) {
		this._ne_comtype = _ne_comtype;
	}

	public String get_ne_comclassid() {
		return _ne_comclassid;
	}

	public void set_ne_comclassid(String _ne_comclassid) {
		this._ne_comclassid = _ne_comclassid;
	}

	public List get_sin_cityid() {
		return _sin_cityid;
	}

	public void set_sin_cityid(List _sin_cityid) {
		this._sin_cityid = _sin_cityid;
	}

}
