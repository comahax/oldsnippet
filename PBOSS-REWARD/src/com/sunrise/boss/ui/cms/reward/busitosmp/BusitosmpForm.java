/**
* auto-generated code
* Mon Jan 04 11:40:46 CST 2010
*/
package com.sunrise.boss.ui.cms.reward.busitosmp;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.busitosmp.persistent.BusitosmpVO;

/**
 * <p>Title: BusitosmpForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class BusitosmpForm extends BaseActionForm {

    private java.lang.String opnid;
    private java.lang.Integer comclassid;
    private java.lang.Byte brand;
    private java.lang.Long comprice;
    private java.lang.String cityid;
    
    private Double comprice_change;

    private String _se_opnid;
	private String _se_brand;
	private String _se_comclassid;
	private Long comid;
	private String _se_comid;
	
    public String get_se_comid() {
		return _se_comid;
	}

	public void set_se_comid(String _se_comid) {
		this._se_comid = _se_comid;
	}

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_se_brand() {
		return _se_brand;
	}

	public void set_se_brand(String _se_brand) {
		this._se_brand = _se_brand;
	}

	public String get_se_comclassid() {
		return _se_comclassid;
	}

	public void set_se_comclassid(String _se_comclassid) {
		this._se_comclassid = _se_comclassid;
	}

	public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.Integer getComclassid(){
        return comclassid;
    }

    public void setComclassid(java.lang.Integer comclassid){
        this.comclassid = comclassid;
    }
    public java.lang.Byte getBrand(){
        return brand;
    }

    public void setBrand(java.lang.Byte brand){
        this.brand = brand;
    }
    public java.lang.Long getComprice(){
        return comprice;
    }

    public void setComprice(java.lang.Long comprice){
        this.comprice = comprice;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }

	public Double getComprice_change() {
		if(getComprice() != null){
			return new Double(getComprice().longValue() * 1.0 / 100.0);
		}
		return comprice_change;
	}

	public void setComprice_change(Double comprice_change) {
		this.comprice_change = comprice_change;
	}


}
