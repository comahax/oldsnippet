/**
 * auto-generated code
 * Fri Sep 25 15:08:38 CST 2009
 */
package com.gmcc.pboss.business.resource.compack;

import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: CompackDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class CompackDBParam extends DBQueryParam {
    private String _se_batchno;
    private String _se_boxnum;
    private String _se_comcategory;
    private String _se_resuse;
    private String _se_storarea;
    private String _se_nosect;
    private String _se_wayid;
    private String _se_discomcode;
    private String _se_packstate;
    private Short _ne_amount;
    private List<String> _nin_packstate;
    private String _se_countyid;//·Ö¹«Ë¾
    

	public List<String> get_nin_packstate() {
		return _nin_packstate;
	}
	public void set_nin_packstate(List<String> ninPackstate) {
		_nin_packstate = ninPackstate;
	}
	/**
     * @return Returns the _se_batchno.
     */
    public String get_se_batchno() {
        return this._se_batchno;
    }
    /**
     * @param _sk_companyname The _se_batchno to set.
     */
    public void set_se_batchno(String _se_batchno) {
        this._se_batchno = _se_batchno;
    }

	/**
     * @return Returns the _se_boxnum.
     */
    public String get_se_boxnum() {
        return this._se_boxnum;
    }
    /**
     * @param _sk_companyname The _se_boxnum to set.
     */
    public void set_se_boxnum(String _se_boxnum) {
        this._se_boxnum = _se_boxnum;
    }

	/**
     * @return Returns the _se_comcategory.
     */
    public String get_se_comcategory() {
        return this._se_comcategory;
    }
    /**
     * @param _sk_companyname The _se_comcategory to set.
     */
    public void set_se_comcategory(String _se_comcategory) {
        this._se_comcategory = _se_comcategory;
    }

	/**
     * @return Returns the _se_resuse.
     */
    public String get_se_resuse() {
        return this._se_resuse;
    }
    /**
     * @param _sk_companyname The _se_resuse to set.
     */
    public void set_se_resuse(String _se_resuse) {
        this._se_resuse = _se_resuse;
    }

	/**
     * @return Returns the _se_storarea.
     */
    public String get_se_storarea() {
        return this._se_storarea;
    }
    /**
     * @param _sk_companyname The _se_storarea to set.
     */
    public void set_se_storarea(String _se_storarea) {
        this._se_storarea = _se_storarea;
    }

	/**
     * @return Returns the _se_nosect.
     */
    public String get_se_nosect() {
        return this._se_nosect;
    }
    /**
     * @param _sk_companyname The _se_nosect to set.
     */
    public void set_se_nosect(String _se_nosect) {
        this._se_nosect = _se_nosect;
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
	public String get_se_packstate() {
		return _se_packstate;
	}
	public void set_se_packstate(String _se_packstate) {
		this._se_packstate = _se_packstate;
	}
	public Short get_ne_amount() {
		return _ne_amount;
	}
	public void set_ne_amount(Short _ne_amount) {
		this._ne_amount = _ne_amount;
	}
	public String get_se_countyid() {
		return _se_countyid;
	}
	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

}
