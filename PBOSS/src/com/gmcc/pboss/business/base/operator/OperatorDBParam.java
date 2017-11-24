/**
 * auto-generated code
 * Thu Jul 09 10:43:47 CST 2009
 */
package com.gmcc.pboss.business.base.operator;

import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OperatorDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class OperatorDBParam extends DBQueryParam {
    private String _se_operid;
    private String _sk_opername;
    private String _se_orgid;
    private boolean isCheck;
    private String _ne_status;
    private String _ne_region;
    
    private String _se_contactphone;
    private String _se_logintype;


	private List<String> _sin_operid;
    
	public boolean getIsCheck() {
		return isCheck;
	}
	public void setIsCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}
	/**
     * @return Returns the _se_operid.
     */
    public String get_se_operid() {
        return this._se_operid;
    }
    /**
     * @param _sk_companyname The _se_operid to set.
     */
    public void set_se_operid(String _se_operid) {
        this._se_operid = _se_operid;
    }


	public String get_sk_opername() {
		return _sk_opername;
	}
	public void set_sk_opername(String _sk_opername) {
		this._sk_opername = _sk_opername;
	}
	public String get_se_orgid() {
		return _se_orgid;
	}
	public void set_se_orgid(String _se_orgid) {
		this._se_orgid = _se_orgid;
	}
	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}
	public List<String> get_sin_operid() {
		return _sin_operid;
	}
	public void set_sin_operid(List<String> _sin_operid) {
		this._sin_operid = _sin_operid;
	}
	public String get_ne_status() {
		return _ne_status;
	}
	public void set_ne_status(String _ne_status) {
		this._ne_status = _ne_status;
	}
	public String get_ne_region() {
		return _ne_region;
	}
	public void set_ne_region(String _ne_region) {
		this._ne_region = _ne_region;
	}
	
	public String get_se_contactphone() {
		return _se_contactphone;
	}
	public void set_se_contactphone(String _se_contactphone) {
		this._se_contactphone = _se_contactphone;
	}
	public String get_se_logintype() {
		return _se_logintype;
	}
	public void set_se_logintype(String _se_logintype) {
		this._se_logintype = _se_logintype;
	}
	
}
