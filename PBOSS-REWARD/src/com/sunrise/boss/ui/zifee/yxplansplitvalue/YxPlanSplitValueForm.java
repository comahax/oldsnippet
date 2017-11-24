package com.sunrise.boss.ui.zifee.yxplansplitvalue;

import com.sunrise.boss.ui.base.BaseActionForm;

public class YxPlanSplitValueForm extends BaseActionForm{
    
	private String _ne_billcycle;
	private String _se_brandid;
	private String _se_itemid;
	
	/** identifier field */
    private Long billcycle;

    /** identifier field */
    private String brandid;

    /** identifier field */
    private String itemid;

    /** persistent field */
    private Double splitfee;

    /** full constructor */
    public YxPlanSplitValueForm(java.lang.Long billcycle, java.lang.String brandid, java.lang.String itemid, java.lang.Double splitfee) {
        this.billcycle = billcycle;
        this.brandid = brandid;
        this.itemid = itemid;
        this.splitfee = splitfee;
    }

    /** default constructor */
    public YxPlanSplitValueForm() {
    }

    public java.lang.Long getBillcycle() {
        return this.billcycle;
    }

    public void setBillcycle(java.lang.Long billcycle) {
        this.billcycle = billcycle;
    }

    public java.lang.String getBrandid() {
        return this.brandid;
    }

    public void setBrandid(java.lang.String brandid) {
        this.brandid = brandid;
    }

    public java.lang.String getItemid() {
        return this.itemid;
    }

    public void setItemid(java.lang.String itemid) {
        this.itemid = itemid;
    }

    public java.lang.Double getSplitfee() {
        return this.splitfee;
    }

    public void setSplitfee(java.lang.Double splitfee) {
        this.splitfee = splitfee;
    }
    
    public String get_ne_billcycle(){
		return this._ne_billcycle;
	}
	
	public void set_ne_billcycle(String _ne_billcycle){
		this._ne_billcycle = _ne_billcycle;
	}
	
	public String get_se_brandid(){
		return this._se_brandid;
	}
	
	public void set_se_brandid(String _se_brandid){
		this._se_brandid = _se_brandid;
	}
	
	public String get_se_itemid(){
		return this._se_itemid;
	}
	
	public void set_se_itemid(String _se_itemid){
		this._se_itemid = _se_itemid;
	}
}
