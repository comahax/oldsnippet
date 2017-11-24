/**
 * auto-generated code
 * Tue Sep 01 14:28:15 CST 2009
 */
package com.gmcc.pboss.business.resource.comressmp;

import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ComressmpDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ComressmpDBParam extends DBQueryParam {
    private String _se_wayid;
    private String _se_brand;
    private String _se_comcategory;//商品种类
    private String _se_countyid;//分公司标识
    private Long _ne_comid;
    private Long _nnm_comresid;
    private Long _nnl_comresid;
    private String _se_comresid;
    private List _sin_comresid;
    private Short _ne_comstate;
    private String _se_batchno;
//    private String _se_resuse;
    private String _se_numbertype;
    private String _se_boxnum;
    private String _ssw_boxnum;
    private String _ne_insideseq;
    private String _dnm_saletime;
	private String _dnl_saletime;

	public String get_dnm_saletime() {
		return _dnm_saletime;
	}
	public void set_dnm_saletime(String _dnm_saletime) {
		this._dnm_saletime = _dnm_saletime;
	}
	public String get_dnl_saletime() {
		return _dnl_saletime;
	}
	public void set_dnl_saletime(String _dnl_saletime) {
		this._dnl_saletime = _dnl_saletime;
	}
	public String get_ssw_boxnum() {
		return _ssw_boxnum;
	}
	public void set_ssw_boxnum(String sswBoxnum) {
		_ssw_boxnum = sswBoxnum;
	}
	public String get_se_boxnum() {
		return _se_boxnum;
	}
	public void set_se_boxnum(String _se_boxnum) {
		this._se_boxnum = _se_boxnum;
	}
	public String get_se_comcategory() {
		return _se_comcategory;
	}
	public void set_se_comcategory(String _se_comcategory) {
		this._se_comcategory = _se_comcategory;
	}
	public String get_se_countyid() {
		return _se_countyid;
	}
	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}
	/**
     * @return Returns the _se_wayid.
     */
    public String get_se_wayid() {
        return this._se_wayid;
    }
    /**
     * @param _sk_companyname The _se_wayid to set.
     */
    public void set_se_wayid(String _se_wayid) {
        this._se_wayid = _se_wayid;
    }

	/**
     * @return Returns the _se_brand.
     */
    public String get_se_brand() {
        return this._se_brand;
    }
    /**
     * @param _sk_companyname The _se_brand to set.
     */
    public void set_se_brand(String _se_brand) {
        this._se_brand = _se_brand;
    }
	
	
	public Long get_nnm_comresid() {
		return _nnm_comresid;
	}
	public void set_nnm_comresid(Long _nnm_comresid) {
		this._nnm_comresid = _nnm_comresid;
	}
	public Long get_nnl_comresid() {
		return _nnl_comresid;
	}
	public void set_nnl_comresid(Long _nnl_comresid) {
		this._nnl_comresid = _nnl_comresid;
	}
	public Short get_ne_comstate() {
		return _ne_comstate;
	}
	public void set_ne_comstate(Short _ne_comstate) {
		this._ne_comstate = _ne_comstate;
	}
	public String get_se_batchno() {
		return _se_batchno;
	}
	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}
//	public String get_se_resuse() {
//		return _se_resuse;
//	}
//	public void set_se_resuse(String _se_resuse) {
//		this._se_resuse = _se_resuse;
//	}
	public String get_se_numbertype() {
		return _se_numbertype;
	}
	public void set_se_numbertype(String _se_numbertype) {
		this._se_numbertype = _se_numbertype;
	}
	public String get_se_comresid() {
		return _se_comresid;
	}
	public void set_se_comresid(String _se_comresid) {
		this._se_comresid = _se_comresid;
	}
	public List get_sin_comresid() {
		return _sin_comresid;
	}
	public void set_sin_comresid(List _sin_comresid) {
		this._sin_comresid = _sin_comresid;
	}
	public Long get_ne_comid() {
		return _ne_comid;
	}
	public void set_ne_comid(Long _ne_comid) {
		this._ne_comid = _ne_comid;
	}
	public String get_ne_insideseq() {
		return _ne_insideseq;
	}
	public void set_ne_insideseq(String _ne_insideseq) {
		this._ne_insideseq = _ne_insideseq;
	}
	
    
}
