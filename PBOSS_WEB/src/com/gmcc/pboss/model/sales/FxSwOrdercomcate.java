package com.gmcc.pboss.model.sales;

import com.gmcc.pboss.biz.info.delivery.bean.OrderComcateDtl;

/**
 * FxSwOrdercomcate entity. @author MyEclipse Persistence Tools
 */

public class FxSwOrdercomcate extends OrderComcateDtl implements java.io.Serializable {

	// Fields

	private Long recid;
	private String orderid;
	private String ordercomtype;
	private String comcategory;
	private Long orderamt;
	private Double unitprice;
	private Double totalprice;

	// Constructors

	/** default constructor */
	public FxSwOrdercomcate() {
	}

	/** minimal constructor */
	public FxSwOrdercomcate(String orderid, String ordercomtype,
			String comcategory, Long orderamt) {
		this.orderid = orderid;
		this.ordercomtype = ordercomtype;
		this.comcategory = comcategory;
		this.orderamt = orderamt;
	}

	/** full constructor */
	public FxSwOrdercomcate(String orderid, String ordercomtype,
			String comcategory, Long orderamt, Double unitprice,
			Double totalprice) {
		this.orderid = orderid;
		this.ordercomtype = ordercomtype;
		this.comcategory = comcategory;
		this.orderamt = orderamt;
		this.unitprice = unitprice;
		this.totalprice = totalprice;
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

	public String getOrdercomtype() {
		return this.ordercomtype;
	}

	public void setOrdercomtype(String ordercomtype) {
		this.ordercomtype = ordercomtype;
	}

	public String getComcategory() {
		return this.comcategory;
	}

	public void setComcategory(String comcategory) {
		this.comcategory = comcategory;
	}

	public Long getOrderamt() {
		return this.orderamt;
	}

	public void setOrderamt(Long orderamt) {
		this.orderamt = orderamt;
	}

	public Double getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Double getTotalprice() {
		return this.totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

}