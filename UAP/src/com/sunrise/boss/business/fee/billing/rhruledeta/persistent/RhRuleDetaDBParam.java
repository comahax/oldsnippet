/**
* auto-generated code
* Tue Mar 18 11:36:17 CST 2008
*/
package com.sunrise.boss.business.fee.billing.rhruledeta.persistent;


import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: RhRuleDetaListVO</p>
 * <p>Description: Query Params Object for RhRuleDetaDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wkx
 * @version 1.0
 */
public class RhRuleDetaDBParam extends DBQueryParam {

	private String _ne_state;
	private String _ne_validbillcyc;
	
    private String _ne_rhphase;
    
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
