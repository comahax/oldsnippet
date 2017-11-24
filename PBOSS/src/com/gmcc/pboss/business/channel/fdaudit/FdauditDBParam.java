/**
 * auto-generated code
 * Wed Oct 07 14:01:03 CST 2009
 */
package com.gmcc.pboss.business.channel.fdaudit;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: FdauditDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Yedaoe
 * @version 1.0
 */
public class FdauditDBParam extends DBQueryParam {
    private String _ne_recno;
    private String _se_tablename;
    private String _se_typename;
    private String _se_pkvalue;
    private String _se_pkvalue2;
    private String _se_field;
    private String _se_fieldvalue;
    private String _ne_auditstatus;

	/**
     * @return Returns the _se_tablename.
     */
    public String get_se_tablename() {
        return this._se_tablename;
    }
    /**
     * @param _sk_companyname The _se_tablename to set.
     */
    public void set_se_tablename(String _se_tablename) {
        this._se_tablename = _se_tablename;
    }

	/**
     * @return Returns the _se_typename.
     */
    public String get_se_typename() {
        return this._se_typename;
    }
    /**
     * @param _sk_companyname The _se_typename to set.
     */
    public void set_se_typename(String _se_typename) {
        this._se_typename = _se_typename;
    }

	/**
     * @return Returns the _se_pkvalue.
     */
    public String get_se_pkvalue() {
        return this._se_pkvalue;
    }
    /**
     * @param _sk_companyname The _se_pkvalue to set.
     */
    public void set_se_pkvalue(String _se_pkvalue) {
        this._se_pkvalue = _se_pkvalue;
    }

	/**
     * @return Returns the _ne_auditstatus.
     */
    public String get_ne_auditstatus() {
        return this._ne_auditstatus;
    }
    /**
     * @param _sk_companyname The _ne_auditstatus to set.
     */
    public void set_ne_auditstatus(String _ne_auditstatus) {
        this._ne_auditstatus = _ne_auditstatus;
    }
	public String get_ne_recno() {
		return _ne_recno;
	}
	public void set_ne_recno(String _ne_recno) {
		this._ne_recno = _ne_recno;
	}
	public String get_se_pkvalue2() {
		return _se_pkvalue2;
	}
	public void set_se_pkvalue2(String _se_pkvalue2) {
		this._se_pkvalue2 = _se_pkvalue2;
	}
	public String get_se_field() {
		return _se_field;
	}
	public void set_se_field(String _se_field) {
		this._se_field = _se_field;
	}
	public String get_se_fieldvalue() {
		return _se_fieldvalue;
	}
	public void set_se_fieldvalue(String _se_fieldvalue) {
		this._se_fieldvalue = _se_fieldvalue;
	}

}
