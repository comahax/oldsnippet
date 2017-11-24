package com.sunrise.boss.ui.resmanage.comrescard;

import java.util.Date;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.pub.tools.PublicUtils;

public class ComrescardBatchForm extends BaseActionForm {
	private String begno;

	private String endno;

	private String batchno;

	private Double comdisc;

	private Long comid;

	private Double price;

	private Date comactive;

	private String wayid;

	private Long comstate;

	private String strcomactive;
	
	private Date starttime;

	private Date validperiod;

	private Date comkeep;

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public String getBegno() {
		return begno;
	}

	public void setBegno(String begno) {
		this.begno = begno;
	}

	public Date getComactive() {
		return comactive;
	}

	public void setComactive(Date comactive) {
		this.comactive = comactive;
	}


	public Double getComdisc() {
		return comdisc;
	}

	public void setComdisc(Double comdisc) {
		this.comdisc = comdisc;
	}

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public Long getComstate() {
		return comstate;
	}

	public void setComstate(Long comstate) {
		this.comstate = comstate;
	}

	public String getEndno() {
		return endno;
	}

	public void setEndno(String endno) {
		this.endno = endno;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStrcomactive() {
		String str = PublicUtils.formatUtilDate(this.comactive, "yyyy-MM-dd");
		if (str == null || str.equals("")) {
			return strcomactive;
		} else
			return str;
	}

	public void setStrcomactive(String strcomactive) {
		try {
			this.comactive = PublicUtils.UtilStrToDate(strcomactive,
					"yyyy-MM-dd");
		} catch (Exception e) {
			this.comactive = new Date();
		}
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getValidperiod() {
		return validperiod;
	}

	public void setValidperiod(Date validperiod) {
		this.validperiod = validperiod;
	}

	public Date getComkeep() {
		return comkeep;
	}

	public void setComkeep(Date comkeep) {
		this.comkeep = comkeep;
	}

}
