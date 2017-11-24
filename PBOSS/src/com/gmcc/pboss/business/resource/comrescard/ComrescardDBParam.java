/**
 * auto-generated code
 * Tue Sep 01 14:54:44 CST 2009
 */
package com.gmcc.pboss.business.resource.comrescard;

import java.util.Map;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ComrescardDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ComrescardDBParam extends DBQueryParam {
    private String _se_wayid;
    private Long _ne_comid;
    private Long _nnm_comresid;
    private Long _nnl_comresid;
    private Short _ne_comstate;
    private String _se_batchno;
    private String _se_countyid;//分公司标识
    private String _se_comresid;
    private String _se_comcategory;
    
    private Map drawPara;//用于充值卡指定号段
    
	public String get_se_comresid() {
		return _se_comresid;
	}
	public void set_se_comresid(String _se_comresid) {
		this._se_comresid = _se_comresid;
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
	public Long get_ne_comid() {
		return _ne_comid;
	}
	public void set_ne_comid(Long _ne_comid) {
		this._ne_comid = _ne_comid;
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
	public String get_se_comcategory() {
		return _se_comcategory;
	}
	public void set_se_comcategory(String seComcategory) {
		_se_comcategory = seComcategory;
	}
	public Map getDrawPara() {
		return drawPara;
	}
	public void setDrawPara(Map drawPara) {
		this.drawPara = drawPara;
	}
    
}
