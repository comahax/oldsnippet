package com.gmcc.pboss.business.channel.waystoreinfo;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: WaystoreinfoDBParam </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class WaystoreinfoDBParam extends DBQueryParam {
    private String _se_wayid;
    private String _sk_wayid;
    private String _se_cityid;
    private String _ne_zqtype;
    private String _ne_doortype;
    private String _dnm_createtime;
    private String _dnl_createtime;

    private boolean isExcel;
    private boolean APPSTATUS_MULTI;
	public boolean isExcel() {
		return isExcel;
	}

	public void setExcel(boolean isExcel) {
		this.isExcel = isExcel;
	}
	
	public boolean isAPPSTATUS_MULTI() {
		return APPSTATUS_MULTI;
	}

	public void setAPPSTATUS_MULTI(boolean aPPSTATUSMULTI) {
		APPSTATUS_MULTI = aPPSTATUSMULTI;
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
     * @return Returns the _ne_zqtype.
     */
    public String get_ne_zqtype() {
        return this._ne_zqtype;
    }
    /**
     * @param _sk_companyname The _ne_zqtype to set.
     */
    public void set_ne_zqtype(String _ne_zqtype) {
        this._ne_zqtype = _ne_zqtype;
    }

	/**
     * @return Returns the _ne_doortype.
     */
    public String get_ne_doortype() {
        return this._ne_doortype;
    }
    /**
     * @param _sk_companyname The _ne_doortype to set.
     */
    public void set_ne_doortype(String _ne_doortype) {
        this._ne_doortype = _ne_doortype;
    }

	/**
     * @return Returns the _dnm_createtime.
     */
    public String get_dnm_createtime() {
        return this._dnm_createtime;
    }
    /**
     * @param _sk_companyname The _dnm_createtime to set.
     */
    public void set_dnm_createtime(String _dnm_createtime) {
        this._dnm_createtime = _dnm_createtime;
    }

	/**
     * @return Returns the _dnl_createtime.
     */
    public String get_dnl_createtime() {
        return this._dnl_createtime;
    }
    /**
     * @param _sk_companyname The _dnl_createtime to set.
     */
    public void set_dnl_createtime(String _dnl_createtime) {
        this._dnl_createtime = _dnl_createtime;
    }

	public String get_sk_wayid() {
		return _sk_wayid;
	}

	public void set_sk_wayid(String skWayid) {
		_sk_wayid = skWayid;
	}

}
