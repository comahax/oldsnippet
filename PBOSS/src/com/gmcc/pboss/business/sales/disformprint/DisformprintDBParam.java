/**
 * auto-generated code
 * Sat Aug 13 12:50:41 CST 2011
 */
package com.gmcc.pboss.business.sales.disformprint;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: DisformprintDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class DisformprintDBParam extends DBQueryParam {
    private String _dnm_createtime;
    private String _dnl_createtime;
    private String _se_recewayid;
    private String _se_discomcode;
    private String _se_disstate;
    private String _dnm_ordcreatetime;
    private String _dnl_ordcreatetime;
    private String _se_countyid;
    
    public DisformprintDBParam(){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String nowDate = format.format(new Date());
    	_dnm_ordcreatetime = nowDate + " 23:59:59";
    	_dnl_ordcreatetime = nowDate + " 00:00:00";
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
     * @param _sk_companyname The _dnl_discreatetime to set.
     */
    public void set_dnl_createtime(String _dnl_createtime) {
        this._dnl_createtime = _dnl_createtime;
    }

	/**
     * @return Returns the _se_recewayid.
     */
    public String get_se_recewayid() {
        return this._se_recewayid;
    }
    /**
     * @param _sk_companyname The _se_recewayid to set.
     */
    public void set_se_recewayid(String _se_recewayid) {
        this._se_recewayid = _se_recewayid;
    }

	/**
     * @return Returns the _se_discomcode.
     */
    public String get_se_discomcode() {
        return this._se_discomcode;
    }
    /**
     * @param _sk_companyname The _se_discomcode to set.
     */
    public void set_se_discomcode(String _se_discomcode) {
        this._se_discomcode = _se_discomcode;
    }

	/**
     * @return Returns the _se_disstate.
     */
    public String get_se_disstate() {
        return this._se_disstate;
    }
    /**
     * @param _sk_companyname The _se_disstate to set.
     */
    public void set_se_disstate(String _se_disstate) {
        this._se_disstate = _se_disstate;
    }

	/**
     * @return Returns the _dnm_ordcreatetime.
     */
    public String get_dnm_ordcreatetime() {
        return this._dnm_ordcreatetime;
    }
    /**
     * @param _sk_companyname The _dnm_ordcreatetime to set.
     */
    public void set_dnm_ordcreatetime(String _dnm_ordcreatetime) {
        this._dnm_ordcreatetime = _dnm_ordcreatetime;
    }

	/**
     * @return Returns the _dnl_ordcreatetime.
     */
    public String get_dnl_ordcreatetime() {
        return this._dnl_ordcreatetime;
    }
    /**
     * @param _sk_companyname The _dnl_ordcreatetime to set.
     */
    public void set_dnl_ordcreatetime(String _dnl_ordcreatetime) {
        this._dnl_ordcreatetime = _dnl_ordcreatetime;
    }

	/**
     * @return Returns the _se_countyid.
     */
    public String get_se_countyid() {
        return this._se_countyid;
    }
    /**
     * @param _sk_companyname The _se_countyid to set.
     */
    public void set_se_countyid(String _se_countyid) {
        this._se_countyid = _se_countyid;
    }

}
