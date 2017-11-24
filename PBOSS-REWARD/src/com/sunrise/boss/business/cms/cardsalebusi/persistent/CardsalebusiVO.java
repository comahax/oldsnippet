package com.sunrise.boss.business.cms.cardsalebusi.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class CardsalebusiVO implements Serializable {

	private Long itemid;
	private java.util.Date opntime;
	private String mobile;
	private Long brand;
	private String opntype;
	private String wayid;
	private Double retailprice;
	private Double buyprice;
	private Double discount;
    public Long getBrand() {
		return brand;
	}


	public void setBrand(Long brand) {
		this.brand = brand;
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


	public Long getItemid() {
		return itemid;
	}


	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public java.util.Date getOpntime() {
		return opntime;
	}


	public void setOpntime(java.util.Date opntime) {
		this.opntime = opntime;
	}


	public String getOpntype() {
		return opntype;
	}


	public void setOpntype(String opntype) {
		this.opntype = opntype;
	}


	public Double getRetailprice() {
		return retailprice;
	}


	public void setRetailprice(Double retailprice) {
		this.retailprice = retailprice;
	}


	public String getWayid() {
		return wayid;
	}


	public void setWayid(String wayid) {
		this.wayid = wayid;
	}


	/** full constructor */
    public CardsalebusiVO() {
    }
    

    public String toString() {
        return new ToStringBuilder(this)
            .toString();
    }

}
