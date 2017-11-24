/**
 * auto-generated code
 * Thu Sep 14 14:35:53 CST 2006
 */
package com.sunrise.boss.ui.cms.recompense;

import java.sql.Timestamp;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>
 * Title: RecompenseForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author wkx
 * @version 1.0
 */
public class RecompenseForm extends BaseActionForm {

	private static final long serialVersionUID = 8256130582605581625L;

	/** identifier field */
	private Long recid;

	/** nullable persistent field */
	private Long target;

	/** nullable persistent field */
	private Double quotiety;

	/** nullable persistent field */
	private String balanceterm;

	/** nullable persistent field */
	private Double standard;

	/** nullable persistent field */
	private String comtype;

	/** nullable persistent field */
	private String bchlevel;

	/** nullable persistent field */
	private Double integral;

	/** nullable persistent field */
	private String businesstype;

	/** nullable persistent field */
	private Integer prodid;

	/** nullable persistent field */
	private String prosalecode;

	/** nullable persistent field */
	private Integer salseprodid;

	/** nullable persistent field */
	private Long inyxplanid;

	/** nullable persistent field */
	private java.sql.Timestamp intime;

	/** nullable persistent field */
	private Short custstate;

	/** nullable persistent field */
	private Short chargetype;

	/** nullable persistent field */
	private Short moment;

	/** nullable persistent field */
	private Short fitstation;

	/** nullable persistent field */
	private String fitopr;

	/** persistent field */
	private String bossarea;

	/** nullable persistent field */
	private String calculatemode;

	/** nullable persistent field */
	private java.sql.Timestamp starttime;

	/** nullable persistent field */
	private java.sql.Timestamp stoptime;

	/** nullable persistent field */
	private Short pri;

	private String _ne_recid;

	private String _ne_target;

	private String _ne_quotiety;

	private String _ne_standard;

	private String _sk_balanceterm;

	private String _se_comtype;

	private String _se_bchlevel;

	public RecompenseForm() {
		super();
		// TODO 自动生成构造函数存根
	}
	

	public RecompenseForm(Long target, Double quotiety, String balanceterm, Double standard, String comtype, String bchlevel, Double integral, String businesstype, Integer prodid, String prosalecode, Integer salseprodid, Long inyxplanid, Timestamp intime, Short custstate, Short chargetype, Short moment, Short fitstation, String fitopr, String bossarea, String calculatemode, Timestamp starttime, Timestamp stoptime, Short pri, String _ne_recid, String _ne_target, String _ne_quotiety, String _ne_standard, String _sk_balanceterm, String _se_comtype, String _se_bchlevel) {
		super();
		// TODO 自动生成构造函数存根
		this.target = target;
		this.quotiety = quotiety;
		this.balanceterm = balanceterm;
		this.standard = standard;
		this.comtype = comtype;
		this.bchlevel = bchlevel;
		this.integral = integral;
		this.businesstype = businesstype;
		this.prodid = prodid;
		this.prosalecode = prosalecode;
		this.salseprodid = salseprodid;
		this.inyxplanid = inyxplanid;
		this.intime = intime;
		this.custstate = custstate;
		this.chargetype = chargetype;
		this.moment = moment;
		this.fitstation = fitstation;
		this.fitopr = fitopr;
		this.bossarea = bossarea;
		this.calculatemode = calculatemode;
		this.starttime = starttime;
		this.stoptime = stoptime;
		this.pri = pri;
		this._ne_recid = _ne_recid;
		this._ne_target = _ne_target;
		this._ne_quotiety = _ne_quotiety;
		this._ne_standard = _ne_standard;
		this._sk_balanceterm = _sk_balanceterm;
		this._se_comtype = _se_comtype;
		this._se_bchlevel = _se_bchlevel;
	}


	public String get_ne_quotiety() {
		return _ne_quotiety;
	}

	public void set_ne_quotiety(String _ne_quotiety) {
		this._ne_quotiety = _ne_quotiety;
	}

	public String get_ne_recid() {
		return _ne_recid;
	}

	public void set_ne_recid(String _ne_recid) {
		this._ne_recid = _ne_recid;
	}

	public String get_ne_standard() {
		return _ne_standard;
	}

	public void set_ne_standard(String _ne_standard) {
		this._ne_standard = _ne_standard;
	}

	public String get_ne_target() {
		return _ne_target;
	}

	public void set_ne_target(String _ne_target) {
		this._ne_target = _ne_target;
	}

	public String get_se_bchlevel() {
		return _se_bchlevel;
	}

	public void set_se_bchlevel(String _se_bchlevel) {
		this._se_bchlevel = _se_bchlevel;
	}

	public String get_se_comtype() {
		return _se_comtype;
	}

	public void set_se_comtype(String _se_comtype) {
		this._se_comtype = _se_comtype;
	}

	public String get_sk_balanceterm() {
		return _sk_balanceterm;
	}

	public void set_sk_balanceterm(String _sk_balanceterm) {
		this._sk_balanceterm = _sk_balanceterm;
	}

	public String getBalanceterm() {
		return balanceterm;
	}

	public void setBalanceterm(String balanceterm) {
		this.balanceterm = balanceterm;
	}

	public String getBchlevel() {
		return bchlevel;
	}

	public void setBchlevel(String bchlevel) {
		this.bchlevel = bchlevel;
	}

	public String getBossarea() {
		return bossarea;
	}

	public void setBossarea(String bossarea) {
		this.bossarea = bossarea;
	}

	public String getBusinesstype() {
		return businesstype;
	}

	public void setBusinesstype(String businesstype) {
		this.businesstype = businesstype;
	}

	public String getComtype() {
		return comtype;
	}

	public void setComtype(String comtype) {
		this.comtype = comtype;
	}

	public String getFitopr() {
		return fitopr;
	}

	public void setFitopr(String fitopr) {
		this.fitopr = fitopr;
	}

	public String getProsalecode() {
		return prosalecode;
	}

	public void setProsalecode(String prosalecode) {
		this.prosalecode = prosalecode;
	}

	public Long getRecid() {
		return recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public String getCalculatemode() {
		return calculatemode;
	}

	public void setCalculatemode(String calculatemode) {
		this.calculatemode = calculatemode;
	}

	public Short getPri() {
		return pri;
	}

	public void setPri(Short pri) {
		this.pri = pri;
	}

	public Short getChargetype() {
		return chargetype;
	}

	public void setChargetype(Short chargetype) {
		this.chargetype = chargetype;
	}

	public Short getCuststate() {
		return custstate;
	}

	public void setCuststate(Short custstate) {
		this.custstate = custstate;
	}

	public Short getFitstation() {
		return fitstation;
	}

	public void setFitstation(Short fitstation) {
		this.fitstation = fitstation;
	}

	public Double getIntegral() {
		return integral;
	}

	public void setIntegral(Double integral) {
		this.integral = integral;
	}

	public java.sql.Timestamp getIntime() {
		return intime;
	}

	public void setIntime(java.sql.Timestamp intime) {
		this.intime = intime;
	}

	public Long getInyxplanid() {
		return inyxplanid;
	}

	public void setInyxplanid(Long inyxplanid) {
		this.inyxplanid = inyxplanid;
	}

	public Short getMoment() {
		return moment;
	}

	public void setMoment(Short moment) {
		this.moment = moment;
	}

	public Integer getProdid() {
		return prodid;
	}

	public void setProdid(Integer prodid) {
		this.prodid = prodid;
	}

	public Double getQuotiety() {
		return quotiety;
	}

	public void setQuotiety(Double quotiety) {
		this.quotiety = quotiety;
	}

	public Integer getSalseprodid() {
		return salseprodid;
	}

	public void setSalseprodid(Integer salseprodid) {
		this.salseprodid = salseprodid;
	}

	public Double getStandard() {
		return standard;
	}

	public void setStandard(Double standard) {
		this.standard = standard;
	}

	public java.sql.Timestamp getStarttime() {
		return starttime;
	}

	public void setStarttime(java.sql.Timestamp starttime) {
		this.starttime = starttime;
	}

	public java.sql.Timestamp getStoptime() {
		return stoptime;
	}

	public void setStoptime(java.sql.Timestamp stoptime) {
		this.stoptime = stoptime;
	}

	public Long getTarget() {
		return target;
	}

	public void setTarget(Long target) {
		this.target = target;
	}

}
