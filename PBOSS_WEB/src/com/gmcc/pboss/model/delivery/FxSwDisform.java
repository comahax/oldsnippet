package com.gmcc.pboss.model.delivery;

import java.util.Date;

/**
 * FxSwDisform entity. @author MyEclipse Persistence Tools
 */

public class FxSwDisform extends DeliveryMainVo 
		implements java.io.Serializable {

	// Fields

	private Long recid;
	private String orderid;
	private String recewayid;
	private String recename;
	private String recetel;
	private String receadd;
	private String discomcode;
	private Date createtime;
	private Date arrivetime;
	private String disstate;
	private String memo;
	private String logisticsno;

	// Constructors
	/** default constructor */
	public FxSwDisform() {
	}

	/** minimal constructor */
	public FxSwDisform(String orderid, String recewayid, String recename,
			String recetel, String receadd, String discomcode, Date createtime,
			Date arrivetime, String disstate) {
		this.orderid = orderid;
		this.recewayid = recewayid;
		this.recename = recename;
		this.recetel = recetel;
		this.receadd = receadd;
		this.discomcode = discomcode;
		this.createtime = createtime;
		this.arrivetime = arrivetime;
		this.disstate = disstate;
	}

	/** full constructor */
	public FxSwDisform(String orderid, String recewayid, String recename,
			String recetel, String receadd, String discomcode, Date createtime,
			Date arrivetime, String disstate, String memo, String logisticsno) {
		this.orderid = orderid;
		this.recewayid = recewayid;
		this.recename = recename;
		this.recetel = recetel;
		this.receadd = receadd;
		this.discomcode = discomcode;
		this.createtime = createtime;
		this.arrivetime = arrivetime;
		this.disstate = disstate;
		this.memo = memo;
		this.logisticsno = logisticsno;
	}	
	public FxSwDisform(String orderid, String recewayid, String recename,
			String recetel, String receadd, String discomcode, Date createtime,
			Date arrivetime, String disstate, String memo) {
		this.orderid = orderid;
		this.recewayid = recewayid;
		this.recename = recename;
		this.recetel = recetel;
		this.receadd = receadd;
		this.discomcode = discomcode;
		this.createtime = createtime;
		this.arrivetime = arrivetime;
		this.disstate = disstate;
		this.memo = memo;
	}

	// Property accessors

	public Long getRecid() {
		return this.recid;
	}

	public void setRecid(Long recid) {
		this.recid = recid;
	}

	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getRecewayid() {
		return this.recewayid;
	}

	public void setRecewayid(String recewayid) {
		this.recewayid = recewayid;
	}

	public String getRecename() {
		return this.recename;
	}

	public void setRecename(String recename) {
		this.recename = recename;
	}

	public String getRecetel() {
		return this.recetel;
	}

	public void setRecetel(String recetel) {
		this.recetel = recetel;
	}

	public String getReceadd() {
		return this.receadd;
	}

	public void setReceadd(String receadd) {
		this.receadd = receadd;
	}

	public String getDiscomcode() {
		return this.discomcode;
	}

	public void setDiscomcode(String discomcode) {
		this.discomcode = discomcode;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getArrivetime() {
		return this.arrivetime;
	}

	public void setArrivetime(Date arrivetime) {
		this.arrivetime = arrivetime;
	}

	public String getDisstate() {
		return this.disstate;
	}

	public void setDisstate(String disstate) {
		this.disstate = disstate;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public String getLogisticsno() {
		return logisticsno;
	}

	public void setLogisticsno(String logisticsno) {
		this.logisticsno = logisticsno;
	}

}