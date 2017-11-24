/**
 * auto-generated code
 * Thu Dec 01 02:07:15 GMT 2011
 */
package com.gmcc.pboss.business.channel.ctilog;

import java.util.ArrayList;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: CtilogDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class CtilogDBParam extends DBQueryParam {
    private String _snn_cityid;
    private String _se_cityid;
    private String _se_scontent;
    private String _ne_smstype;
    
    private ArrayList _nin_smstype;
    
    private ArrayList _sin_cityid;

	/**
     * @return Returns the _snn_cityid.
     */
    public String get_snn_cityid() {
        return this._snn_cityid;
    }
    /**
     * @param _sk_companyname The _snn_cityid to set.
     */
    public void set_snn_cityid(String _snn_cityid) {
        this._snn_cityid = _snn_cityid;
    }

	/**
     * @return Returns the _se_cityid.
     */
    public String get_se_cityid() {
        return this._se_cityid;
    }
    /**
     * @param _sk_companyname The _se_cityid to set.
     */
    public void set_se_cityid(String _se_cityid) {
        this._se_cityid = _se_cityid;
    }

	/**
     * @return Returns the _se_scontent.
     */
    public String get_se_scontent() {
        return this._se_scontent;
    }
    /**
     * @param _sk_companyname The _se_scontent to set.
     */
    public void set_se_scontent(String _se_scontent) {
        this._se_scontent = _se_scontent;
    }

	/**
     * @return Returns the _ne_smstype.
     */
    public String get_ne_smstype() {
        return this._ne_smstype;
    }
    /**
     * @param _sk_companyname The _ne_smstype to set.
     */
    public void set_ne_smstype(String _ne_smstype) {
        this._ne_smstype = _ne_smstype;
    }
	public ArrayList get_nin_smstype() {
		return _nin_smstype;
	}
	public void set_nin_smstype(ArrayList _nin_smstype) {
		this._nin_smstype = _nin_smstype;
	}
	public ArrayList get_sin_cityid() {
		return _sin_cityid;
	}
	public void set_sin_cityid(ArrayList _sin_cityid) {
		this._sin_cityid = _sin_cityid;
	}

}
