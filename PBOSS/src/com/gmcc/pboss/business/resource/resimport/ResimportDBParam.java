/**
 * auto-generated code
 * Fri Sep 25 15:01:17 CST 2009
 */
package com.gmcc.pboss.business.resource.resimport;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: ResimportDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class ResimportDBParam extends DBQueryParam {
    private String _sk_filename;
    private String _dnm_begintime;
    private String _dnl_begintime;

    
    public ResimportDBParam(){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String nowDate = format.format(new Date());
    	_dnm_begintime = nowDate+" 23:59:59";
    	_dnl_begintime = nowDate+" 00:00:00";
    }
	/**
     * @return Returns the _sk_filename.
     */
    public String get_sk_filename() {
        return this._sk_filename;
    }
    /**
     * @param _sk_companyname The _sk_filename to set.
     */
    public void set_sk_filename(String _sk_filename) {
        this._sk_filename = _sk_filename;
    }

	/**
     * @return Returns the _dnm_begintime.
     */
    public String get_dnm_begintime() {
        return this._dnm_begintime;
    }
    /**
     * @param _sk_companyname The _dnm_begintime to set.
     */
    public void set_dnm_begintime(String _dnm_begintime) {
        this._dnm_begintime = _dnm_begintime;
    }

	/**
     * @return Returns the _dnl_begintime.
     */
    public String get_dnl_begintime() {
        return this._dnl_begintime;
    }
    /**
     * @param _sk_companyname The _dnl_begintime to set.
     */
    public void set_dnl_begintime(String _dnl_begintime) {
        this._dnl_begintime = _dnl_begintime;
    }

}
