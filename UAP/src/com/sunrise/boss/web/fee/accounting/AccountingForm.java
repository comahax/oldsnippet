/**
 * 
 */
package com.sunrise.boss.web.fee.accounting;

import com.sunrise.boss.business.fee.acccounting.persistent.AccountingVO;



/**
 * Title: CompanyDelegate
 * Description:
 * Copyright: Copyright (c) 2006
 * Company: sunrise Tech Ltd.
 * @author mys
 * @version 1.0
 */
public class AccountingForm extends AccountingVO {
	
	private String year;	
	private String month;
	private String _ne_validbillcyc;
	private String _se_batchnum;
	private String regiongroup;
	private String[] _selectitem1;
	private String[] _selectitem2;
	private String[] _selectitem3;
	private String[] _selectitem4;
	private String isshowlog;
	
	
	
	private String _se_subphase;
	private String _se_billingphase;
	
	
	public String get_se_billingphase() {
		return _se_billingphase;
	}
	public void set_se_billingphase(String _se_billingphase) {
		this._se_billingphase = _se_billingphase;
	}
	public String get_se_subphase() {
		return _se_subphase;
	}
	public void set_se_subphase(String _se_subphase) {
		this._se_subphase = _se_subphase;
	}
	public String get_ne_validbillcyc() {
		return _ne_validbillcyc;
	}
	public void set_ne_validbillcyc(String _ne_validbillcyc) {
		this._ne_validbillcyc = _ne_validbillcyc;
	}
	public String get_se_batchnum() {
		return _se_batchnum;
	}
	public void set_se_batchnum(String _se_batchnum) {
		this._se_batchnum = _se_batchnum;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getRegiongroup() {
		return regiongroup;
	}
	public void setRegiongroup(String regiongroup) {
		this.regiongroup = regiongroup;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String[] get_selectitem1() {
		return _selectitem1;
	}
	public void set_selectitem1(String[] _selectitem1) {
		this._selectitem1 = _selectitem1;
	}
	public String[] get_selectitem2() {
		return _selectitem2;
	}
	public void set_selectitem2(String[] _selectitem2) {
		this._selectitem2 = _selectitem2;
	}
	public String[] get_selectitem3() {
		return _selectitem3;
	}
	public void set_selectitem3(String[] _selectitem3) {
		this._selectitem3 = _selectitem3;
	}
	public String[] get_selectitem4() {
		return _selectitem4;
	}
	public void set_selectitem4(String[] _selectitem4) {
		this._selectitem4 = _selectitem4;
	}
	public String getIsshowlog() {
		return isshowlog;
	}
	public void setIsshowlog(String isshowlog) {
		this.isshowlog = isshowlog;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
