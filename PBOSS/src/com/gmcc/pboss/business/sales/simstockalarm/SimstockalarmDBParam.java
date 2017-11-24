/**
 * auto-generated code
 * Sat Mar 31 10:28:57 CST 2012
 */
package com.gmcc.pboss.business.sales.simstockalarm;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: SimstockalarmDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class SimstockalarmDBParam extends DBQueryParam {
    private String _se_wayid;
    private String _se_comcategory;
    private String _se_countyid;   
	private String _ne_starlevel;
    private String _ne_waystate;    

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
    
    public String get_se_countyid() {
		return _se_countyid;
	}
	public void set_se_countyid(String seCountyid) {
		_se_countyid = seCountyid;
	}
	public String get_ne_starlevel() {
		return _ne_starlevel;
	}
	public void set_ne_starlevel(String neStarlevel) {
		_ne_starlevel = neStarlevel;
	}
	public String get_ne_waystate() {
		return _ne_waystate;
	}
	public void set_ne_waystate(String neWaystate) {
		_ne_waystate = neWaystate;
	}
	public String get_se_comcategory() {
		return _se_comcategory;
	}
	public void set_se_comcategory(String _se_comcategory) {
		this._se_comcategory = _se_comcategory;
	}

}
