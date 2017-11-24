/**
* auto-generated code
* Thu Mar 20 15:48:33 CST 2008
*/
package com.sunrise.boss.business.fee.billing.rhtouchrule.persistent;

import com.sunrise.jop.infrastructure.db.DBQueryParam;



/**
 * <p>Title: RhTouchRuleListVO</p>
 * <p>Description: Query Params Object for RhTouchRuleDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wkx
 * @version 1.0
 */
public class RhTouchRuleDBParam extends DBQueryParam {

	private String regiongroup;

	private String[] citygroup; 
	
	private String _ne_validbillcyc;
	
	private String _ne_region;

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
	}
	
	

}
