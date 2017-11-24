/**
 * auto-generated code
 * Fri Aug 03 11:10:45 CST 2007
 */
package com.sunrise.boss.ui.cms.cardsalebusi;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.cardsalebusi.persistent.CardsalebusiVO;

/**
 * <p>
 * Title: CardsalebusiForm
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * Company: Maywide Tech Ltd.
 * </p>
 * 
 * @author
 * @version 1.0
 */
public class CardsalebusiForm extends BaseActionForm {
	private String _ne_itemid;

	private String _dnl_opntime;

	private String _dnm_opntime;

	private Long itemid;

	private java.util.Date opntime;

	private String mobile;

	private Long brand;

	private String opntype;

	private String wayid;

	private Double retailprice;

	private Double buyprice;

	private Double discount;

	public String get_ne_itemid() {
		return _ne_itemid;
	}

	public void set_ne_itemid(String _ne_itemid) {
		this._ne_itemid = _ne_itemid;
	}

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public java.util.Date getOpntime() {
		return opntime;
	}

	public void setOpntime(java.util.Date opntime) {
		this.opntime = opntime;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getBrand() {
		return brand;
	}

	public void setBrand(Long brand) {
		this.brand = brand;
	}

	public String getOpntype() {
		return opntype;
	}

	public void setOpntype(String opntype) {
		this.opntype = opntype;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public Double getRetailprice() {
		return retailprice;
	}

	public void setRetailprice(Double retailprice) {
		this.retailprice = retailprice;
	}

	public Double getBuyprice() {
		return buyprice;
	}

	public void setBuyprice(Double buyprice) {
		this.buyprice = buyprice;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String get_dnl_opntime() {
		return _dnl_opntime;
	}

	public void set_dnl_opntime(String _dnl_opntime) {
		this._dnl_opntime = _dnl_opntime;
	}

	public String get_dnm_opntime() {
		return _dnm_opntime;
	}

	public void set_dnm_opntime(String _dnm_opntime) {
		this._dnm_opntime = _dnm_opntime;
	}

}
