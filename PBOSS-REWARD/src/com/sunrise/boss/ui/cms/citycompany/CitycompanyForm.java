/**
* auto-generated code
* Fri Aug 25 11:23:52 CST 2006
*/
package com.sunrise.boss.ui.cms.citycompany;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.citycompany.persistent.CitycompanyVO;

/**
 * <p>Title: CitycompanyForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author yjr
 * @version 1.0
 */
public class CitycompanyForm extends BaseActionForm {
	
	
	private String _sk_citycompid;
	
	private String _se_centerid;
	
	private String _sk_citycompname;
	
	private String _ne_citycomptype;

	private String _sk_agent;

	private String _se_billingcode;
	
	/** identifier field */
    private String citycompid;

    /** nullable persistent field */
    private String centerid;

    /** nullable persistent field */
    private String citycompname;

    /** nullable persistent field */
    private Short citycomptype;

    /** nullable persistent field */
    private String agent;

    /** nullable persistent field */
    private String billingcode;
    
    private String areacode;
    
    private String adacode;
	private String longitude;
	private String latitude;
	private Short citylevel;	

	public Short getCitylevel() {
		return citylevel;
	}

	public void setCitylevel(Short citylevel) {
		this.citylevel = citylevel;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

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

	public String getCenterid() {
		return centerid;
	}

	public void setCenterid(String centerid) {
		this.centerid = centerid;
	}

	public String getCitycompid() {
		return citycompid;
	}

	public void setCitycompid(String citycompid) {
		this.citycompid = citycompid;
	}

	public String getCitycompname() {
		return citycompname;
	}

	public void setCitycompname(String citycompname) {
		this.citycompname = citycompname;
	}

	public Short getCitycomptype() {
		return citycomptype;
	}

	public void setCitycomptype(Short citycomptype) {
		this.citycomptype = citycomptype;
	}

	public String get_se_billingcode() {
		return _se_billingcode;
	}

	public void set_se_billingcode(String _se_billingcode) {
		this._se_billingcode = _se_billingcode;
	}

	public String get_se_centerid() {
		return _se_centerid;
	}

	public void set_se_centerid(String _se_centerid) {
		this._se_centerid = _se_centerid;
	}

	public String get_sk_citycompid() {
		return _sk_citycompid;
	}

	public void set_sk_citycompid(String _sk_citycompid) {
		this._sk_citycompid = _sk_citycompid;
	}

	public String get_sk_agent() {
		return _sk_agent;
	}

	public void set_sk_agent(String _sk_agent) {
		this._sk_agent = _sk_agent;
	}

	public String get_sk_citycompname() {
		return _sk_citycompname;
	}

	public void set_sk_citycompname(String _sk_citycompname) {
		this._sk_citycompname = _sk_citycompname;
	}

	public String get_ne_citycomptype() {
		return _ne_citycomptype;
	}

	public void set_ne_citycomptype(String _ne_citycomptype) {
		this._ne_citycomptype = _ne_citycomptype;
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
