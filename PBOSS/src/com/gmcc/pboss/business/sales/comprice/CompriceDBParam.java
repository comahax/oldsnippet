/**
 * auto-generated code
 * Tue Oct 13 09:30:24 CST 2009
 */
package com.gmcc.pboss.business.sales.comprice;

import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: CompriceDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CompriceDBParam extends DBQueryParam {
	private String _se_cityid;
	private String _se_countyid;
	private String _se_cooptype;
	private String _se_comcategory;
	private String _nne_recid;
	private String _se_pricediftype;
	
	private Short _ne_starlevel;
	
	private List<String> _sin_cooptype;
	private List<Short> _nin_starlevel;
	
	public String get_se_cityid() {
		return _se_cityid;
	}
	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}
	public String get_se_countyid() {
		return _se_countyid;
	}
	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}
	public String get_se_cooptype() {
		return _se_cooptype;
	}
	public void set_se_cooptype(String _se_cooptype) {
		this._se_cooptype = _se_cooptype;
	}
	public String get_se_comcategory() {
		return _se_comcategory;
	}
	public void set_se_comcategory(String _se_comcategory) {
		this._se_comcategory = _se_comcategory;
	}
	public String get_nne_recid() {
		return _nne_recid;
	}
	public void set_nne_recid(String _nne_recid) {
		this._nne_recid = _nne_recid;
	}
	public String get_se_pricediftype() {
		return _se_pricediftype;
	}
	public void set_se_pricediftype(String _se_pricediftype) {
		this._se_pricediftype = _se_pricediftype;
	}
	public Short get_ne_starlevel() {
		return _ne_starlevel;
	}
	public void set_ne_starlevel(Short _ne_starlevel) {
		this._ne_starlevel = _ne_starlevel;
	}
	public List<String> get_sin_cooptype() {
		return _sin_cooptype;
	}
	public void set_sin_cooptype(List<String> _sin_cooptype) {
		this._sin_cooptype = _sin_cooptype;
	}
	public List<Short> get_nin_starlevel() {
		return _nin_starlevel;
	}
	public void set_nin_starlevel(List<Short> _nin_starlevel) {
		this._nin_starlevel = _nin_starlevel;
	}
	
}
