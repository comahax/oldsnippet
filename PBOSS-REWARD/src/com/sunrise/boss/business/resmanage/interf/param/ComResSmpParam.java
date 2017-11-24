package com.sunrise.boss.business.resmanage.interf.param;

import java.util.Date;
 /** <p>Title: BOSS1.5</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: sunrise Tech Ltd.</p>
 *
 * @author Rodney
 * @version 上午11:32:082006-9-5
 */
public class ComResSmpParam extends BaseParam {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3393583690796741043L;
	private Date s_comactive; // 最后激活日期***

	private Long simtype; // sim卡类型***

	private String especnoupd; // 特号转存模板***

	private Long simyno; // sim卡是否已入库***

	private String dummycz;// 是否具有虚拟充值卡***

	private Long comid; // 套卡商品标识 (pk)***

	private String batchno;// 套卡批次***

	private String wayid;// 渠道标识***

	private Long comdisc;// 商品折扣***
	
	private Double dcomdisc;

	private Long price;// 商品单价***
	
	private Double dprice;

	private String prodid;// 产品品牌***

	private String mobileno; // 号码

	private String simno; // 主SIM卡

	private String imsino; // IMSI

	private String pukno; // PUK
	
	private Long simprice;//sim卡价格
	
	private Double dsimprice;
	
	private Long mobiletype;//用机类型
	
	private String noprompt;//号码特定种类

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public Long getComdisc() {
		return comdisc;
	}

	public void setComdisc(Long comdisc) {
		this.comdisc = comdisc;
	}

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public String getDummycz() {
		return dummycz;
	}

	public void setDummycz(String dummycz) {
		this.dummycz = dummycz;
	}

	public String getEspecnoupd() {
		return especnoupd;
	}

	public void setEspecnoupd(String especnoupd) {
		this.especnoupd = especnoupd;
	}

	public String getImsino() {
		return imsino;
	}

	public void setImsino(String imsino) {
		this.imsino = imsino;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public String getPukno() {
		return pukno;
	}

	public void setPukno(String pukno) {
		this.pukno = pukno;
	}

	public String getSimno() {
		return simno;
	}

	public void setSimno(String simno) {
		this.simno = simno;
	}

	public Long getSimtype() {
		return simtype;
	}

	public void setSimtype(Long simtype) {
		this.simtype = simtype;
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

	public Long getSimyno() {
		return simyno;
	}

	public void setSimyno(Long simyno) {
		this.simyno = simyno;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public Long getMobiletype() {
		return mobiletype;
	}

	public void setMobiletype(Long mobiletype) {
		this.mobiletype = mobiletype;
	}

	public String getNoprompt() {
		return noprompt;
	}

	public void setNoprompt(String noprompt) {
		this.noprompt = noprompt;
	}

	public Double getDsimprice() {
		return dsimprice;
	}

	public void setDsimprice(Double dsimprice) {
		this.dsimprice = dsimprice;
		if(dsimprice != null){
			double tmp = dsimprice.doubleValue();
			this.simprice = new Long((long)(tmp * 100));
		}
	}

	public Date getS_comactive() {
		return s_comactive;
	}

	public void setS_comactive(Date s_comactive) {
		this.s_comactive = s_comactive;
	}

	public Long getSimprice() {
		return simprice;
	}

	public void setSimprice(Long simprice) {
		this.simprice = simprice;
	}
}


