/**
* auto-generated code
* Thu Mar 20 15:48:34 CST 2008
*/
package com.sunrise.boss.web.fee.billing.rhtouchrule;

import org.apache.commons.lang.StringUtils;


import com.sunrise.boss.business.fee.billing.rhtouchrule.persistent.RhTouchRuleVO;

/**
 * <p>Title: RhTouchRuleForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wkx
 * @version 1.0
 */
public class RhTouchRuleForm extends RhTouchRuleVO {


	private String regiongroup;

	private String[] citygroup; 
	
	private String _ne_validbillcyc;

	private String year ;
	private String month;
	private String step;
	
	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String[] getCitygroup() {
		return citygroup;
	}

	public void setCitygroup(String[] citygroup) {
		this.citygroup = citygroup;
	}

	public String getRegiongroup() {
		return regiongroup;
	}

	public void setRegiongroup(String regiongroup) {
		this.regiongroup = regiongroup;
		this.citygroup = StringUtils.split(regiongroup, ",");
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

	

	
	
}
