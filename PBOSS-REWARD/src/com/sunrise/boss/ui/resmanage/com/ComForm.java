package com.sunrise.boss.ui.resmanage.com;

import java.util.Date;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.pub.tools.PublicUtils;

public class ComForm extends BaseActionForm {

	private static final long serialVersionUID = -8293701165999181913L;

	private String startindex;

	private String endindex;

	private String _ne_comclassid;

	private String _ne_comtype;

	private String _ne_comid;

	private String _se_cityid;

	private String _sk_comname;

	private String _sk_comid;

	private Long comid;

	private Long comprice;

	private String longPrice;

	private Long comclassid;

	private Long comtype;

	private Date comfreeze;

	private Long comkeep;

	private Date comvalid;

	private String comname;

	private String comsource;

	private String colordes;

	private String accessory;

	private String presentdes;

	private Long active;

	private Long length;

	private String item;

	private String comcode;

	private String cityid;

	private String scomvalid = "2099-01-01";
	
	private Long comstate;

	public Long getComstate() {
		return comstate;
	}

	public void setComstate(Long comstate) {
		this.comstate = comstate;
	}

	public String get_ne_comid() {
		return _ne_comid;
	}

	public void set_ne_comid(String _ne_comid) {
		this._ne_comid = _ne_comid;
	}

	public String get_sk_comname() {
		return _sk_comname;
	}

	public void set_sk_comname(String _sk_comname) {
		this._sk_comname = _sk_comname;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public String get_ne_comclassid() {
		return _ne_comclassid;
	}

	public void set_ne_comclassid(String _ne_comclassid) {
		this._ne_comclassid = _ne_comclassid;
	}

	public String get_ne_comtype() {
		return _ne_comtype;
	}

	public void set_ne_comtype(String _ne_comtype) {
		this._ne_comtype = _ne_comtype;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String getScomvalid() {
		String str = PublicUtils.formatUtilDate(this.comvalid, "yyyy-MM-dd");
		if (str == null || str.equals("")) {
			return scomvalid;
		} else
			return str;
	}

	public void setScomvalid(String scomvalid) {
		try {
			this.comvalid = PublicUtils.UtilStrToDate(scomvalid, "yyyy-MM-dd");
		} catch (Exception e) {
			this.comvalid = new Date();
		}
	}

	public String getAccessory() {
		return accessory;
	}

	public void setAccessory(String accessory) {
		this.accessory = accessory;
	}

	public Long getActive() {
		return active;
	}

	public void setActive(Long active) {
		this.active = active;
	}

	public String getColordes() {
		return colordes;
	}

	public void setColordes(String colordes) {
		this.colordes = colordes;
	}

	public Date getComfreeze() {
		return comfreeze;
	}

	public void setComfreeze(Date comfreeze) {
		this.comfreeze = comfreeze;
	}

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public Long getComkeep() {
		return comkeep;
	}

	public void setComkeep(Long comkeep) {
		this.comkeep = comkeep;
	}

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public Long getComprice() {
		return comprice;
	}

	public void setComprice(Long comprice) {
		this.comprice = comprice;
	}

	public String getComsource() {
		return comsource;
	}

	public void setComsource(String comsource) {
		this.comsource = comsource;
	}

	public Long getComtype() {
		return comtype;
	}

	public void setComtype(Long comtype) {
		this.comtype = comtype;
	}

	public Date getComvalid() {
		return comvalid;
	}

	public void setComvalid(Date comvalid) {
		this.comvalid = comvalid;
	}

	public String getPresentdes() {
		return presentdes;
	}

	public void setPresentdes(String presentdes) {
		this.presentdes = presentdes;
	}

	public Long getComclassid() {
		return comclassid;
	}

	public void setComclassid(Long comclassid) {
		this.comclassid = comclassid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}

	public String getLongPrice() {
		if (this.comprice == null)
			return longPrice;
		else
			return String.valueOf(this.comprice.doubleValue() / 100);

	}

	public void setLongPrice(String longPrice) {
		if (longPrice == null || longPrice.equals("")) {
			this.longPrice = "";
		} else
			this.comprice = new Long(new Double(
					Double.parseDouble(longPrice) * 100).longValue());
	}

	public String getEndindex() {
		return endindex;
	}

	public void setEndindex(String endindex) {
		this.endindex = endindex;
	}

	public String getStartindex() {
		return startindex;
	}

	public void setStartindex(String startindex) {
		this.startindex = startindex;
	}

	public String get_sk_comid() {
		return _sk_comid;
	}

	public void set_sk_comid(String _sk_comid) {
		this._sk_comid = _sk_comid;
	}
}
