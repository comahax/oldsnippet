/**
* auto-generated code
* Fri Aug 25 11:24:52 CST 2006
*/
package com.sunrise.boss.ui.cms.waytype;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.waytype.persistent.WaytypeVO;

/**
 * <p>Title: WaytypeForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class WaytypeForm extends BaseActionForm {
	
	private String _se_waytypecode;
	private String _se_uppercode;
	
    /** identifier field */
    private String waytypecode;

    /** persistent field */
    private String waytypename;

    /** nullable persistent field */
    private String uppercode;

    /** nullable persistent field */
    private String desp;

	public String getDesp() {
		return desp;
	}

	public void setDesp(String desp) {
		this.desp = desp;
	}

	public String getUppercode() {
		return uppercode;
	}

	public void setUppercode(String uppercode) {
		this.uppercode = uppercode;
	}

	public String getWaytypecode() {
		return waytypecode;
	}

	public void setWaytypecode(String waytypecode) {
		this.waytypecode = waytypecode;
	}

	public String getWaytypename() {
		return waytypename;
	}

	public void setWaytypename(String waytypename) {
		this.waytypename = waytypename;
	}

	public String get_se_uppercode() {
		return _se_uppercode;
	}

	public void set_se_uppercode(String _se_uppercode) {
		this._se_uppercode = _se_uppercode;
	}

	public String get_se_waytypecode() {
		return _se_waytypecode;
	}

	public void set_se_waytypecode(String _se_waytypecode) {
		this._se_waytypecode = _se_waytypecode;
	}
    
    
	
}
