/**
* auto-generated code
* Fri Aug 25 11:16:40 CST 2006
*/
package com.sunrise.boss.ui.cms.cntycompany;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.cntycompany.persistent.CntycompanyVO;

/**
 * <p>Title: CntycompanyForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class CntycompanyForm extends BaseActionForm {
    
    private String _sk_countycompid;
	
	private String _se_citycompid;
	
	private String _sk_countycompname;

	private String _sk_agent;
	
	private String _ne_countycomptype;

	private String _se_billingcode;
	
	/** identifier field */
    private String countycompid;

    /** nullable persistent field */
    private String citycompid;

    /** nullable persistent field */
    private String countycompname;

    /** nullable persistent field */
    private Short countycomptype;

    /** nullable persistent field */
    private String agent;

    /** nullable persistent field */
    private String billingcode;
    
    private String adacode;
	private String longitude;
	private String latitude;

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getBillingcode() {
		return billingcode;
	}

	public void setBillingcode(String billingcode) {
		this.billingcode = billingcode;
	}

	public String getCitycompid() {
		return citycompid;
	}

	public void setCitycompid(String citycompid) {
		this.citycompid = citycompid;
	}

	public String getCountycompid() {
		return countycompid;
	}

	public void setCountycompid(String countycompid) {
		this.countycompid = countycompid;
	}

	public String getCountycompname() {
		return countycompname;
	}

	public void setCountycompname(String countycompname) {
		this.countycompname = countycompname;
	}

	public Short getCountycomptype() {
		return countycomptype;
	}

	public void setCountycomptype(Short countycomptype) {
		this.countycomptype = countycomptype;
	}

	public String get_se_billingcode() {
		return _se_billingcode;
	}

	public void set_se_billingcode(String _se_billingcode) {
		this._se_billingcode = _se_billingcode;
	}

	public String get_se_citycompid() {
		return _se_citycompid;
	}

	public void set_se_citycompid(String _se_citycompid) {
		this._se_citycompid = _se_citycompid;
	}

	public String get_sk_agent() {
		return _sk_agent;
	}

	public void set_sk_agent(String _sk_agent) {
		this._sk_agent = _sk_agent;
	}

	public String get_sk_countycompid() {
		return _sk_countycompid;
	}

	public void set_sk_countycompid(String _sk_countycompid) {
		this._sk_countycompid = _sk_countycompid;
	}

	public String get_sk_countycompname() {
		return _sk_countycompname;
	}

	public void set_sk_countycompname(String _sk_countycompname) {
		this._sk_countycompname = _sk_countycompname;
	}

	public String get_ne_countycomptype() {
		return _ne_countycomptype;
	}

	public void set_ne_countycomptype(String _ne_countycomptype) {
		this._ne_countycomptype = _ne_countycomptype;
	}

	public String getAdacode() {
		return adacode;
	}

	public void setAdacode(String adacode) {
		this.adacode = adacode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
    
}
