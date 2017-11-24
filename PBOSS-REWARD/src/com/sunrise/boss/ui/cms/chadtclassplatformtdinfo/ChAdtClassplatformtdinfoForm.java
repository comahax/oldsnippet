/**
* auto-generated code
* Fri Feb 01 12:08:34 CST 2013
*/
package com.sunrise.boss.ui.cms.chadtclassplatformtdinfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: ChAdtClassplatformtdinfoForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtClassplatformtdinfoForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.Integer tdbrandid;
    private java.lang.String productid;
    private java.lang.String comid;
    private java.lang.String comname;
    private java.util.Date startdate;
    private java.util.Date enddate;
    private java.lang.Short citycode;
    private java.lang.String adtremark;
    
    private java.lang.String startdatestr;
    private java.lang.String enddatestr;
    private String region;
    
    SimpleDateFormat fSdf=new SimpleDateFormat("yyyy-MM-dd");
    
    private java.lang.String tdbrandname;

    private String _ne_tdbrandid;
    private String _dnl_startdate;
    private String _ne_citycode;

    public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }
    public java.lang.Integer getTdbrandid(){
        return tdbrandid;
    }

    public void setTdbrandid(java.lang.Integer tdbrandid){
        this.tdbrandid = tdbrandid;
    }
    public java.lang.String getProductid(){
        return productid;
    }

    public void setProductid(java.lang.String productid){
        this.productid = productid;
    }
    public java.lang.String getComid(){
        return comid;
    }

    public void setComid(java.lang.String comid){
        this.comid = comid;
    }
    public java.lang.String getComname(){
        return comname;
    }

    public void setComname(java.lang.String comname){
        this.comname = comname;
    }
    public java.util.Date getStartdate(){
        return startdate;
    }

    public void setStartdate(java.util.Date startdate){
        this.startdate = startdate;
    }
    public java.util.Date getEnddate(){
        return enddate;
    }

    public void setEnddate(java.util.Date enddate){
        this.enddate = enddate;
    }
    public java.lang.Short getCitycode(){
        return citycode;
    }

    public void setCitycode(java.lang.Short citycode){
        this.citycode = citycode;
    }
    public java.lang.String getAdtremark(){
        return adtremark;
    }

    public void setAdtremark(java.lang.String adtremark){
        this.adtremark = adtremark;
    }

    public String get_ne_tdbrandid(){
        return _ne_tdbrandid;
    }

    public void set_ne_tdbrandid(String _ne_tdbrandid){
        this._ne_tdbrandid = _ne_tdbrandid;
    }
    public String get_dnl_startdate(){
        return _dnl_startdate;
    }

    public void set_dnl_startdate(String _dnl_startdate){
        this._dnl_startdate = _dnl_startdate;
    }
    public String get_ne_citycode(){
        return _ne_citycode;
    }

    public void set_ne_citycode(String _ne_citycode){
        this._ne_citycode = _ne_citycode;
    }

	public java.lang.String getTdbrandname() {
		return tdbrandname;
	}

	public void setTdbrandname(java.lang.String tdbrandname) {
		this.tdbrandname = tdbrandname;
	}

	public java.lang.String getStartdatestr() {
		if(this.getStartdate() == null){
			return null;
		}
		return fSdf.format(this.getStartdate());
	}

	public void setStartdatestr(java.lang.String startdatestr) {
		try {
			this.setStartdate(fSdf.parse(startdatestr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public java.lang.String getEnddatestr() {
		if(this.getEnddate() == null){
			return null;
		}
		return fSdf.format(this.getEnddate());		
	}

	public void setEnddatestr(java.lang.String enddatestr) {
		try {
			this.setEnddate(fSdf.parse(enddatestr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
