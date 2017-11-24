/**
* auto-generated code
* Tue Mar 18 11:36:17 CST 2008
*/
package com.sunrise.boss.web.fee.billing.rhruledeta;


import com.sunrise.boss.business.fee.billing.rhruledeta.persistent.RhRuleDetaVO;

/**
 * <p>Title: RhRuleDetaForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wkx
 * @version 1.0
 */
public class RhRuleDetaForm extends RhRuleDetaVO {

	private String _ne_validbillcyc;
	private String _ne_state;
	
	private String _ne_rhphase;
	
	
	private String year ;
	private String month;
	

	/* 新增地市字段，对应VO */
	private Integer region;

	/* 新增地市查询条件，对应ListVO */
	private String _ne_region;

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public String get_ne_region() {
		return _ne_region;
	}

	public void set_ne_region(String _ne_region) {
		this._ne_region = _ne_region;
	}
		
	 
	
	public String get_ne_validbillcyc() {
		return _ne_validbillcyc;
	}

	public void set_ne_validbillcyc(String _ne_validbillcyc) {
		this._ne_validbillcyc = _ne_validbillcyc;
	}

	 

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String get_ne_rhphase() {
		return _ne_rhphase;
	}

	public void set_ne_rhphase(String _ne_rhphase) {
		this._ne_rhphase = _ne_rhphase;
	}

	public String get_ne_state() {
		return _ne_state;
	}

	public void set_ne_state(String _ne_state) {
		this._ne_state = _ne_state;
	}
	
	
	



}
