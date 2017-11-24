/**
* auto-generated code
* Fri Aug 25 11:25:35 CST 2006
*/
package com.sunrise.boss.ui.cms.custwaytype;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.custwaytype.persistent.CustwaytypeVO;

/**
 * <p>Title: CustwaytypeForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class CustwaytypeForm extends BaseActionForm {
	
	private String _sk_custwaytypecode;
	private String _sk_custwaytypename;
	
    /** identifier field */
    private String custwaytypecode;

    /** persistent field */
    private String citycompid;

    /** persistent field */
    private String custwaytypename;

    /** nullable persistent field */
    private Byte notusebysub;

    /** nullable persistent field */
    private String description;

	public String getCitycompid() {
		return citycompid;
	}

	public void setCitycompid(String citycompid) {
		this.citycompid = citycompid;
	}

	public String getCustwaytypecode() {
		return custwaytypecode;
	}

	
	public String get_sk_custwaytypecode() {
		return _sk_custwaytypecode;
	}

	public void set_sk_custwaytypecode(String _sk_custwaytypecode) {
		this._sk_custwaytypecode = _sk_custwaytypecode;
	}

	public String get_sk_custwaytypename() {
		return _sk_custwaytypename;
	}

	public void set_sk_custwaytypename(String _sk_custwaytypename) {
		this._sk_custwaytypename = _sk_custwaytypename;
	}

	public void setCustwaytypecode(String custwaytypecode) {
		this.custwaytypecode = custwaytypecode;
	}

	public String getCustwaytypename() {
		return custwaytypename;
	}

	public void setCustwaytypename(String custwaytypename) {
		this.custwaytypename = custwaytypename;
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
