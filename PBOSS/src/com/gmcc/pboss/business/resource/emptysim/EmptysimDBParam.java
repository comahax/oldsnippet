/**
 * auto-generated code
 * Wed Sep 02 13:59:58 CST 2009
 */
package com.gmcc.pboss.business.resource.emptysim;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: EmptysimDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class EmptysimDBParam extends DBQueryParam {
    private Long _nnm_emptyno;
    private Long _ne_emptyno;
    private Long _nnl_emptyno;
    private String _se_wayid;
    private String _ne_simtype;
    private String _ne_usestate;
    private String _se_countyid;//分公司
    private Long _ne_comid;; // 套卡商品标识 

	
	public Long get_nnm_emptyno() {
		return _nnm_emptyno;
	}
	public void set_nnm_emptyno(Long _nnm_emptyno) {
		this._nnm_emptyno = _nnm_emptyno;
	}
	public Long get_ne_emptyno() {
		return _ne_emptyno;
	}
	public void set_ne_emptyno(Long _ne_emptyno) {
		this._ne_emptyno = _ne_emptyno;
	}
	public Long get_nnl_emptyno() {
		return _nnl_emptyno;
	}
	public void set_nnl_emptyno(Long _nnl_emptyno) {
		this._nnl_emptyno = _nnl_emptyno;
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
     * @return Returns the _ne_simtype.
     */
    public String get_ne_simtype() {
        return this._ne_simtype;
    }
    /**
     * @param _sk_companyname The _ne_simtype to set.
     */
    public void set_ne_simtype(String _ne_simtype) {
        this._ne_simtype = _ne_simtype;
    }

	/**
     * @return Returns the _ne_usestate.
     */
    public String get_ne_usestate() {
        return this._ne_usestate;
    }
    /**
     * @param _sk_companyname The _ne_usestate to set.
     */
    public void set_ne_usestate(String _ne_usestate) {
        this._ne_usestate = _ne_usestate;
    }
    
    public String get_se_countyid() {
		return _se_countyid;
	}
	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}
	public Long get_ne_comid() {
		return _ne_comid;
	}
	public void set_ne_comid(Long _ne_comid) {
		this._ne_comid = _ne_comid;
	}
	
}
