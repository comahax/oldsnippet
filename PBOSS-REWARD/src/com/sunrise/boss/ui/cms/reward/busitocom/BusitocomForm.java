/**
* auto-generated code
* Fri Aug 28 11:17:48 CST 2009
*/
package com.sunrise.boss.ui.cms.reward.busitocom;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: BusitocomForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class BusitocomForm extends BaseActionForm {

    private java.lang.String opnid;
    private java.lang.String cityid;
    private java.lang.Integer comtype;
    private java.lang.Long comid;
    private java.lang.String comresid;
    private java.lang.Integer comclassid;
    private java.lang.Long pricelow;
    private java.lang.Long pricetop;
    private java.lang.String busitype;
    
    private java.lang.Double pricelowd;
    private java.lang.Double pricetopd;
    
	private String _sk_opnid;
	private String _se_comtype;
	private String _ne_comid;
	private String _se_comresid;
	private String _se_busitype;
	private String _sql_cityid;

    public String get_sql_cityid() {
		return _sql_cityid;
	}

	public void set_sql_cityid(String _sql_cityid) {
		this._sql_cityid = _sql_cityid;
	}

	public String get_sk_opnid() {
		return _sk_opnid;
	}

	public void set_sk_opnid(String _sk_opnid) {
		this._sk_opnid = _sk_opnid;
	}

	public String get_se_comtype() {
		return _se_comtype;
	}

	public void set_se_comtype(String _se_comtype) {
		this._se_comtype = _se_comtype;
	}

	public String get_ne_comid() {
		return _ne_comid;
	}

	public void set_ne_comid(String _ne_comid) {
		this._ne_comid = _ne_comid;
	}

	public String get_se_comresid() {
		return _se_comresid;
	}

	public void set_se_comresid(String _se_comresid) {
		this._se_comresid = _se_comresid;
	}

	public String get_se_busitype() {
		return _se_busitype;
	}

	public void set_se_busitype(String _se_busitype) {
		this._se_busitype = _se_busitype;
	}

	public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.Integer getComtype(){
        return comtype;
    }

    public void setComtype(java.lang.Integer comtype){
        this.comtype = comtype;
    }
    public java.lang.Long getComid(){
        return comid;
    }

    public void setComid(java.lang.Long comid){
        this.comid = comid;
    }
    public java.lang.String getComresid(){
        return comresid;
    }

    public void setComresid(java.lang.String comresid){
        this.comresid = comresid;
    }
    public java.lang.Integer getComclassid(){
        return comclassid;
    }

    public void setComclassid(java.lang.Integer comclassid){
        this.comclassid = comclassid;
    }
    public java.lang.Long getPricelow(){
        return pricelow;
    }

    public void setPricelow(java.lang.Long pricelow){
        this.pricelow = pricelow;
    }
    public java.lang.Long getPricetop(){
        return pricetop;
    }

    public void setPricetop(java.lang.Long pricetop){
        this.pricetop = pricetop;
    }
    public java.lang.String getBusitype(){
        return busitype;
    }

    public void setBusitype(java.lang.String busitype){
        this.busitype = busitype;
    }

	public java.lang.Double getPricelowd() {
		if(getPricelow() == null){
			return pricelowd;
		}
		return new Double(pricelow.longValue()/100.00);
	}

	public void setPricelowd(java.lang.Double pricelowd) {
		this.pricelowd = pricelowd;
	}

	public java.lang.Double getPricetopd() {
		if(getPricetop() == null){
			return pricetopd;
		}
		return new Double(pricetop.longValue()/100.00);
	}

	public void setPricetopd(java.lang.Double pricetopd) {
		this.pricetopd = pricetopd;
	}


}
