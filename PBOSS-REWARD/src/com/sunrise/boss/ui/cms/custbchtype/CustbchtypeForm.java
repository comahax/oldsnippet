/**
* auto-generated code
* Fri Aug 25 11:26:23 CST 2006
*/
package com.sunrise.boss.ui.cms.custbchtype;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.custbchtype.persistent.CustbchtypeVO;

/**
 * <p>Title: CustbchtypeForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class CustbchtypeForm extends BaseActionForm {
	
	private String _sk_bchtypecode;
	
	private String _sk_bchtypename;
	
    /** identifier field */
    private String bchtypecode;

    /** persistent field */
    private String citycompid;

    /** persistent field */
    private String bchtypename;

    /** nullable persistent field */
    private Byte notusebysub;

    /** nullable persistent field */
    private String description;

	public String getBchtypecode() {
		return bchtypecode;
	}

	public void setBchtypecode(String bchtypecode) {
		this.bchtypecode = bchtypecode;
	}

	public String getBchtypename() {
		return bchtypename;
	}

	public void setBchtypename(String bchtypename) {
		this.bchtypename = bchtypename;
	}
	
	public String get_sk_bchtypecode() {
		return _sk_bchtypecode;
	}

	public void set_sk_bchtypecode(String _sk_bchtypecode) {
		this._sk_bchtypecode = _sk_bchtypecode;
	}

	public String get_sk_bchtypename() {
		return _sk_bchtypename;
	}

	public void set_sk_bchtypename(String _sk_bchtypename) {
		this._sk_bchtypename = _sk_bchtypename;
	}

	public String getCitycompid() {
		return citycompid;
	}

	public void setCitycompid(String citycompid) {
		this.citycompid = citycompid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Byte getNotusebysub() {
		return notusebysub;
	}

	public void setNotusebysub(Byte notusebysub) {
		this.notusebysub = notusebysub;
	}
    
    
}
