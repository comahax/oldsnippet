/**
 * auto-generated code
 * Wed Jul 01 17:30:39 CST 2009
 */
package com.gmcc.pboss.business.channel.wayaccount;

import java.util.ArrayList;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>
 * Title: WayaccountDBParam
 * </p>;
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Linli
 * @version 1.0
 */
public class WayaccountDBParam extends DBQueryParam {
	private String _ne_accid;
	private String _se_wayid;
	private String _ne_mainlayer;

	private String _ne_starlevel;

	private String basewayid;// 自营渠道的根

	private String _se_upperwayid;

	private String _sk_wayid;

	private String _sk_wayname;

	private String _se_waytype;

	private String _se_waysubtype;

	private String _se_countyid;

	private String _se_cityid;

	private String _se_centerid;

	private String _se_custtype;

	private String _sql_waycondition;

	private String _sql_waystate;

	private Short _ne_waystate;

	private Short _nne_waystate;

	private String _se_svbrchcode;

	private String _se_bchlevel;

	private String _se_mareacode;

	private String _se_svccode;

	private String _ne_cooperator;// 竞争对手类型

	private String _se_cooperator;// 竞争对手类型

	private ArrayList _sin_waysubtype; // 渠道子类别

	private String _se_logiscode;

	private String _se_latitude;

	private String _se_longtitude;

	private String _sne_waytype;

	private String _se_waymagcode;

	private String _se_chainhead;

	private String _ne_sublayer;

	private String _ne_runmode;
	
	private String _se_rewardkind;//社会渠道类型
	
	private String _se_officetel;
	
	private String _se_creditlevel; //信用等级
	
	private String _sql_starlevel;
	
	private String _ne_taxcertificate;//税务资质

	public String get_se_rewardkind() {
		return _se_rewardkind;
	}

	public void set_se_rewardkind(String _se_rewardkind) {
		this._se_rewardkind = _se_rewardkind;
	}

	public String get_se_officetel() {
		return _se_officetel;
	}

	public void set_se_officetel(String _se_officetel) {
		this._se_officetel = _se_officetel;
	}

	/**
	 * @return Returns the _ne_accid.
	 */
	public String get_ne_accid() {
		return this._ne_accid;
	}

	/**
	 * @param _sk_companyname
	 *            The _ne_accid to set.
	 */
	public void set_ne_accid(String _ne_accid) {
		this._ne_accid = _ne_accid;
	}

	/**
	 * @return Returns the _se_wayid.
	 */
	public String get_se_wayid() {
		return this._se_wayid;
	}

	/**
	 * @param _sk_companyname
	 *            The _se_wayid to set.
	 */
	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_ne_mainlayer() {
		return _ne_mainlayer;
	}

	public void set_ne_mainlayer(String _ne_mainlayer) {
		this._ne_mainlayer = _ne_mainlayer;
	}

	public String get_ne_starlevel() {
		return _ne_starlevel;
	}

	public void set_ne_starlevel(String _ne_starlevel) {
		this._ne_starlevel = _ne_starlevel;
	}

	public String getBasewayid() {
		return basewayid;
	}

	public void setBasewayid(String basewayid) {
		this.basewayid = basewayid;
	}

	public String get_se_upperwayid() {
		return _se_upperwayid;
	}

	public void set_se_upperwayid(String _se_upperwayid) {
		this._se_upperwayid = _se_upperwayid;
	}

	public String get_sk_wayid() {
		return _sk_wayid;
	}

	public void set_sk_wayid(String _sk_wayid) {
		this._sk_wayid = _sk_wayid;
	}

	public String get_sk_wayname() {
		return _sk_wayname;
	}

	public void set_sk_wayname(String _sk_wayname) {
		this._sk_wayname = _sk_wayname;
	}

	public String get_se_waytype() {
		return _se_waytype;
	}

	public void set_se_waytype(String _se_waytype) {
		this._se_waytype = _se_waytype;
	}

	public String get_se_waysubtype() {
		return _se_waysubtype;
	}

	public void set_se_waysubtype(String _se_waysubtype) {
		this._se_waysubtype = _se_waysubtype;
	}

	public String get_se_countyid() {
		return _se_countyid;
	}

	public void set_se_countyid(String _se_countyid) {
		this._se_countyid = _se_countyid;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_centerid() {
		return _se_centerid;
	}

	public void set_se_centerid(String _se_centerid) {
		this._se_centerid = _se_centerid;
	}

	public String get_se_custtype() {
		return _se_custtype;
	}

	public void set_se_custtype(String _se_custtype) {
		this._se_custtype = _se_custtype;
	}

	public String get_sql_waycondition() {
		return _sql_waycondition;
	}

	public void set_sql_waycondition(String _sql_waycondition) {
		this._sql_waycondition = _sql_waycondition;
	}

	public String get_sql_waystate() {
		return _sql_waystate;
	}

	public void set_sql_waystate(String _sql_waystate) {
		this._sql_waystate = _sql_waystate;
	}

	public Short get_ne_waystate() {
		return _ne_waystate;
	}

	public void set_ne_waystate(Short _ne_waystate) {
		this._ne_waystate = _ne_waystate;
	}

	public Short get_nne_waystate() {
		return _nne_waystate;
	}

	public void set_nne_waystate(Short _nne_waystate) {
		this._nne_waystate = _nne_waystate;
	}

	public String get_se_svbrchcode() {
		return _se_svbrchcode;
	}

	public void set_se_svbrchcode(String _se_svbrchcode) {
		this._se_svbrchcode = _se_svbrchcode;
	}

	public String get_se_bchlevel() {
		return _se_bchlevel;
	}

	public void set_se_bchlevel(String _se_bchlevel) {
		this._se_bchlevel = _se_bchlevel;
	}

	public String get_se_mareacode() {
		return _se_mareacode;
	}

	public void set_se_mareacode(String _se_mareacode) {
		this._se_mareacode = _se_mareacode;
	}

	public String get_se_svccode() {
		return _se_svccode;
	}

	public void set_se_svccode(String _se_svccode) {
		this._se_svccode = _se_svccode;
	}

	public String get_ne_cooperator() {
		return _ne_cooperator;
	}

	public void set_ne_cooperator(String _ne_cooperator) {
		this._ne_cooperator = _ne_cooperator;
	}

	public String get_se_cooperator() {
		return _se_cooperator;
	}

	public void set_se_cooperator(String _se_cooperator) {
		this._se_cooperator = _se_cooperator;
	}

	public ArrayList get_sin_waysubtype() {
		return _sin_waysubtype;
	}

	public void set_sin_waysubtype(ArrayList _sin_waysubtype) {
		this._sin_waysubtype = _sin_waysubtype;
	}

	public String get_se_logiscode() {
		return _se_logiscode;
	}

	public void set_se_logiscode(String _se_logiscode) {
		this._se_logiscode = _se_logiscode;
	}

	public String get_se_latitude() {
		return _se_latitude;
	}

	public void set_se_latitude(String _se_latitude) {
		this._se_latitude = _se_latitude;
	}

	public String get_se_longtitude() {
		return _se_longtitude;
	}

	public void set_se_longtitude(String _se_longtitude) {
		this._se_longtitude = _se_longtitude;
	}

	public String get_sne_waytype() {
		return _sne_waytype;
	}

	public void set_sne_waytype(String _sne_waytype) {
		this._sne_waytype = _sne_waytype;
	}

	public String get_se_waymagcode() {
		return _se_waymagcode;
	}

	public void set_se_waymagcode(String _se_waymagcode) {
		this._se_waymagcode = _se_waymagcode;
	}

	public String get_se_chainhead() {
		return _se_chainhead;
	}

	public void set_se_chainhead(String _se_chainhead) {
		this._se_chainhead = _se_chainhead;
	}

	public String get_ne_sublayer() {
		return _ne_sublayer;
	}

	public void set_ne_sublayer(String _ne_sublayer) {
		this._ne_sublayer = _ne_sublayer;
	}

	public String get_ne_runmode() {
		return _ne_runmode;
	}

	public void set_ne_runmode(String _ne_runmode) {
		this._ne_runmode = _ne_runmode;
	}

	public String get_se_creditlevel() {
		return _se_creditlevel;
	}

	public void set_se_creditlevel(String _se_creditlevel) {
		this._se_creditlevel = _se_creditlevel;
	}

	public String get_sql_starlevel() {
		return _sql_starlevel;
	}

	public void set_sql_starlevel(String _sql_starlevel) {
		this._sql_starlevel = _sql_starlevel;
	}

	public String get_ne_taxcertificate() {
		return _ne_taxcertificate;
	}

	public void set_ne_taxcertificate(String _ne_taxcertificate) {
		this._ne_taxcertificate = _ne_taxcertificate;
	}

}
