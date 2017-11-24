/**
 * auto-generated code
 * Mon Oct 12 14:56:43 CST 2009
 */
package com.gmcc.pboss.business.sales.order;

import java.util.ArrayList;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OrderDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderDBParam extends DBQueryParam {
    private String _se_orderid;
    private String _se_wayid;
    private String _se_orderave;
    private String _dnm_createtime;
    private String _dnl_createtime;
    private String _dne_createtime;
    private String _se_orderstate;
    private String _sne_orderstate;
    private String _se_paytype;
    private String _se_bossworkfid;
    private String _dnm_paytime;
    private String _dnl_paytime;
    private String _se_discomcode;
    private String _se_deductstate;
    private String _se_signstate;
    private String _se_countyid;
    private String _se_alarmlevel;//预警级别
    private String _ne_confirmflag;//是否确认
    private String _nne_confirmflag;//是否确认
    private String _se_mareacode;//微区域
    private String _dnm_statechgtime;
    private String _dnl_statechgtime;
    private String _ne_starlevel;
    private String _dnm_recordtime;
    private String _dnl_recordtime;
    private String _se_comcategory;
    private ArrayList<String> _sin_orderid;
    
    private ArrayList<String> _sin_bossworkfid;
    
    private String _dl_paytime;
    
    private Integer t1Start;
	private Integer t1End;
	private Integer t2Start;
    
	public String get_se_countyid() {
		return _se_countyid;
	}
	public void set_se_countyid(String seCountyid) {
		_se_countyid = seCountyid;
	}
	public String get_se_bossworkfid() {
		return _se_bossworkfid;
	}
	public void set_se_bossworkfid(String seBossworkfid) {
		_se_bossworkfid = seBossworkfid;
	}
	/**
     * @return Returns the _se_orderid.
     */
    public String get_se_orderid() {
        return this._se_orderid;
    }
    /**
     * @param _sk_companyname The _se_orderid to set.
     */
    public void set_se_orderid(String _se_orderid) {
        this._se_orderid = _se_orderid;
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
     * @return Returns the _se_orderave.
     */
    public String get_se_orderave() {
        return this._se_orderave;
    }
    /**
     * @param _sk_companyname The _se_orderave to set.
     */
    public void set_se_orderave(String _se_orderave) {
        this._se_orderave = _se_orderave;
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

	public String get_dne_createtime() {
		return _dne_createtime;
	}
	public void set_dne_createtime(String _dne_createtime) {
		this._dne_createtime = _dne_createtime;
	}
	/**
     * @return Returns the _se_orderstate.
     */
    public String get_se_orderstate() {
        return this._se_orderstate;
    }
    /**
     * @param _sk_companyname The _se_orderstate to set.
     */
    public void set_se_orderstate(String _se_orderstate) {
        this._se_orderstate = _se_orderstate;
    }
	public String get_sne_orderstate() {
		return _sne_orderstate;
	}
	public void set_sne_orderstate(String _sne_orderstate) {
		this._sne_orderstate = _sne_orderstate;
	}
	public String get_se_paytype() {
		return _se_paytype;
	}
	public void set_se_paytype(String sePaytype) {
		_se_paytype = sePaytype;
	}
	public String get_dnm_paytime() {
		return _dnm_paytime;
	}
	public void set_dnm_paytime(String dnmPaytime) {
		_dnm_paytime = dnmPaytime;
	}
	public String get_dnl_paytime() {
		return _dnl_paytime;
	}
	public void set_dnl_paytime(String dnlPaytime) {
		_dnl_paytime = dnlPaytime;
	}
	public String get_se_discomcode() {
		return _se_discomcode;
	}
	public void set_se_discomcode(String seDiscomcode) {
		_se_discomcode = seDiscomcode;
	}
	public String get_se_deductstate() {
		return _se_deductstate;
	}
	public void set_se_deductstate(String seDeductstate) {
		_se_deductstate = seDeductstate;
	}
	public String get_se_signstate() {
		return _se_signstate;
	}
	public void set_se_signstate(String seSignstate) {
		_se_signstate = seSignstate;
	}
	public String get_se_alarmlevel() {
		return _se_alarmlevel;
	}
	public void set_se_alarmlevel(String _se_alarmlevel) {
		this._se_alarmlevel = _se_alarmlevel;
	}
	public String get_ne_confirmflag() {
		return _ne_confirmflag;
	}
	public void set_ne_confirmflag(String _ne_confirmflag) {
		this._ne_confirmflag = _ne_confirmflag;
	}
	public String get_se_mareacode() {
		return _se_mareacode;
	}
	public void set_se_mareacode(String _se_mareacode) {
		this._se_mareacode = _se_mareacode;
	}
	public String get_dnm_statechgtime() {
		return _dnm_statechgtime;
	}
	public void set_dnm_statechgtime(String _dnm_statechgtime) {
		this._dnm_statechgtime = _dnm_statechgtime;
	}
	public String get_dnl_statechgtime() {
		return _dnl_statechgtime;
	}
	public void set_dnl_statechgtime(String _dnl_statechgtime) {
		this._dnl_statechgtime = _dnl_statechgtime;
	}
	public String get_ne_starlevel() {
		return _ne_starlevel;
	}
	public void set_ne_starlevel(String _ne_starlevel) {
		this._ne_starlevel = _ne_starlevel;
	}
	public String get_dnm_recordtime() {
		return _dnm_recordtime;
	}
	public void set_dnm_recordtime(String _dnm_recordtime) {
		this._dnm_recordtime = _dnm_recordtime;
	}
	public String get_dnl_recordtime() {
		return _dnl_recordtime;
	}
	public void set_dnl_recordtime(String _dnl_recordtime) {
		this._dnl_recordtime = _dnl_recordtime;
	}
	public String get_se_comcategory() {
		return _se_comcategory;
	}
	public void set_se_comcategory(String _se_comcategory) {
		this._se_comcategory = _se_comcategory;
	}
	public ArrayList<String> get_sin_orderid() {
		return _sin_orderid;
	}
	public void set_sin_orderid(ArrayList<String> _sin_orderid) {
		this._sin_orderid = _sin_orderid;
	}
	public Integer getT1Start() {
		return t1Start;
	}
	public void setT1Start(Integer start) {
		t1Start = start;
	}
	public Integer getT1End() {
		return t1End;
	}
	public void setT1End(Integer end) {
		t1End = end;
	}
	public Integer getT2Start() {
		return t2Start;
	}
	public void setT2Start(Integer start) {
		t2Start = start;
	}
	public String get_nne_confirmflag() {
		return _nne_confirmflag;
	}
	public void set_nne_confirmflag(String _nne_confirmflag) {
		this._nne_confirmflag = _nne_confirmflag;
	}
	public String get_dl_paytime() {
		return _dl_paytime;
	}
	public void set_dl_paytime(String _dl_paytime) {
		this._dl_paytime = _dl_paytime;
	}
	public ArrayList<String> get_sin_bossworkfid() {
		return _sin_bossworkfid;
	}
	public void set_sin_bossworkfid(ArrayList<String> _sin_bossworkfid) {
		this._sin_bossworkfid = _sin_bossworkfid;
	}

}
