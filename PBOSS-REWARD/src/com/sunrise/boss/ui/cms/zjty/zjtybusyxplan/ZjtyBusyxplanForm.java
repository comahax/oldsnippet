/**
* auto-generated code
* Mon Dec 28 10:41:51 CST 2009
*/
package com.sunrise.boss.ui.cms.zjty.zjtybusyxplan;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.zjty.zjtybusyxplan.persistent.ZjtyBusyxplanVO;

/**
 * <p>Title: ZjtyBusyxplanForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class ZjtyBusyxplanForm extends BaseActionForm {

    private java.lang.String opnid;
    private java.lang.String prodid;
    private java.lang.Double wrapfee;
    private java.lang.String cityid;
    private java.lang.String planbusitype;
    
	private String _se_prodid;
	private String _se_opnid;
	private String _se_planbusitype;
	private String _se_cityid;

    public String get_se_planbusitype() {
		return _se_planbusitype;
	}

	public void set_se_planbusitype(String _se_planbusitype) {
		this._se_planbusitype = _se_planbusitype;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.String getProdid(){
        return prodid;
    }

    public void setProdid(java.lang.String prodid){
        this.prodid = prodid;
    }
    public java.lang.Double getWrapfee(){
        return wrapfee;
    }

    public void setWrapfee(java.lang.Double wrapfee){
        this.wrapfee = wrapfee;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.String getPlanbusitype(){
        return planbusitype;
    }

    public void setPlanbusitype(java.lang.String planbusitype){
        this.planbusitype = planbusitype;
    }

	public String get_se_prodid() {
		return _se_prodid;
	}

	public void set_se_prodid(String _se_prodid) {
		this._se_prodid = _se_prodid;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}


}
