package com.sunrise.boss.business.resmanage.interf.param;

import java.util.Date;

/**
 * <p>
 * Title: BOSS1.5
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Rodney
 * @version 上午11:32:232006-9-5
 */
public class ComresPhoneParam extends BaseParam {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8328378629768610464L;

	private String comresid;

	private Long comid;

	private String batchno;

	private Long comstate;

	private String wayid;

	private String oprcode;

	private Date starttime;

	private Date validperiod;

	private Date comkeep;

	private Long comdisc;

	private Double dcomdisc;

	private Long price;
	
	private Double dprice;

	private Date comactive;

	private Long comsource;

	private Double dstockprice;
	
	private Long stockprice;
	
	private String imei;

	/**
	 * @return 返回 imei。
	 */
	public String getImei() {
		return imei;
	}
	/**
	 * @param imei 要设置的 imei。
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public Date getComactive() {
		return comactive;
	}

	public void setComactive(Date comactive) {
		this.comactive = comactive;
	}

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public Date getComkeep() {
		return comkeep;
	}

	public void setComkeep(Date comkeep) {
		this.comkeep = comkeep;
	}

	public String getComresid() {
		return comresid;
	}

	public void setComresid(String comresid) {
		this.comresid = comresid;
	}

	public Long getComsource() {
		return comsource;
	}

	public void setComsource(Long comsource) {
		this.comsource = comsource;
	}

	public Long getComstate() {
		return comstate;
	}

	public void setComstate(Long comstate) {
		this.comstate = comstate;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Long getComdisc() {
		return comdisc;
	}
	public void setComdisc(Long comdisc) {
		this.comdisc = comdisc;
	}
	public Double getDcomdisc() {
		return dcomdisc;
	}
	public void setDcomdisc(Double dcomdisc) {
		this.dcomdisc = dcomdisc;
		if(dcomdisc != null){
			double tmp = dcomdisc.doubleValue();
			this.comdisc = new Long((long)(tmp * 100));
		}
	}
	public Double getDprice() {
		return dprice;
	}
	public void setDprice(Double dprice) {
		this.dprice = dprice;
		if(dprice != null){
			double tmp = dprice.doubleValue();
			this.price = new Long((long)(tmp * 100));
		}
	}
	public Double getDstockprice() {
		return dstockprice;
	}
	public void setDstockprice(Double dstockprice) {
		this.dstockprice = dstockprice;
		if(dstockprice != null){
			double tmp = dstockprice.doubleValue();
			this.stockprice = new Long((long)(tmp * 100));
		}
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getStockprice() {
		return stockprice;
	}
	public void setStockprice(Long stockprice) {
		this.stockprice = stockprice;
	}
	public Date getValidperiod() {
		return validperiod;
	}

	public void setValidperiod(Date validperiod) {
		this.validperiod = validperiod;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
}
