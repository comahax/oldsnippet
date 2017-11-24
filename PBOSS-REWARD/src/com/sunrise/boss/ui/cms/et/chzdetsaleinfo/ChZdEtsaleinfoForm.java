/**
* auto-generated code
* Wed May 15 11:11:33 CST 2013
*/
package com.sunrise.boss.ui.cms.et.chzdetsaleinfo;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.et.chzdetsaleinfo.persistent.ChZdEtsaleinfoVO;

/**
 * <p>Title: ChZdEtsaleinfoForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChZdEtsaleinfoForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.String city;
    private java.lang.String wayid;
    private java.lang.String wayname;
    private java.lang.String oprcode;
    private java.lang.String zdplatform;
    private java.lang.String producttype;
    private java.lang.String imei;
    private java.lang.Float saleprice;
    private java.lang.Float lsaleprice;
    private java.lang.Integer salenum;
    private java.util.Date saleday;
    private java.lang.String batchno;
    private java.lang.String note;
    
    private String b_month;
    private String b_no;

    private String _se_city;
    private String _se_wayid;
    private String _se_oprcode;
    private String _se_zdplatform;
    private String _se_producttype;
    private String _se_imei;
    private String _nnm_salenum;
    private String _nnl_salenum;
    private String _dnm_saleday;
    private String _dnl_saleday;
    private String _se_batchno;

    public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }
    public java.lang.String getCity(){
        return city;
    }

    public void setCity(java.lang.String city){
        this.city = city;
    }
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.String getWayname(){
        return wayname;
    }

    public void setWayname(java.lang.String wayname){
        this.wayname = wayname;
    }
    public java.lang.String getOprcode(){
        return oprcode;
    }

    public void setOprcode(java.lang.String oprcode){
        this.oprcode = oprcode;
    }
    public java.lang.String getZdplatform(){
        return zdplatform;
    }

    public void setZdplatform(java.lang.String zdplatform){
        this.zdplatform = zdplatform;
    }
    public java.lang.String getProducttype(){
        return producttype;
    }

    public void setProducttype(java.lang.String producttype){
        this.producttype = producttype;
    }
    public java.lang.String getImei(){
        return imei;
    }

    public void setImei(java.lang.String imei){
        this.imei = imei;
    }
    public java.lang.Float getSaleprice(){
        return saleprice;
    }

    public void setSaleprice(java.lang.Float saleprice){
        this.saleprice = saleprice;
    }
    public java.lang.Float getLsaleprice(){
        return lsaleprice;
    }

    public void setLsaleprice(java.lang.Float lsaleprice){
        this.lsaleprice = lsaleprice;
    }
    public java.lang.Integer getSalenum(){
        return salenum;
    }

    public void setSalenum(java.lang.Integer salenum){
        this.salenum = salenum;
    }
    public java.util.Date getSaleday(){
        return saleday;
    }

    public void setSaleday(java.util.Date saleday){
        this.saleday = saleday;
    }
    public java.lang.String getBatchno(){
        return batchno;
    }

    public void setBatchno(java.lang.String batchno){
        this.batchno = batchno;
    }
    public java.lang.String getNote(){
        return note;
    }

    public void setNote(java.lang.String note){
        this.note = note;
    }

    public String get_se_city(){
        return _se_city;
    }

    public void set_se_city(String _se_city){
        this._se_city = _se_city;
    }
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_oprcode(){
        return _se_oprcode;
    }

    public void set_se_oprcode(String _se_oprcode){
        this._se_oprcode = _se_oprcode;
    }
    public String get_se_zdplatform(){
        return _se_zdplatform;
    }

    public void set_se_zdplatform(String _se_zdplatform){
        this._se_zdplatform = _se_zdplatform;
    }
    public String get_se_producttype(){
        return _se_producttype;
    }

    public void set_se_producttype(String _se_producttype){
        this._se_producttype = _se_producttype;
    }
    public String get_se_imei(){
        return _se_imei;
    }

    public void set_se_imei(String _se_imei){
        this._se_imei = _se_imei;
    }
    public String get_nnm_salenum(){
        return _nnm_salenum;
    }

    public void set_nnm_salenum(String _nnm_salenum){
        this._nnm_salenum = _nnm_salenum;
    }
    public String get_nnl_salenum(){
        return _nnl_salenum;
    }

    public void set_nnl_salenum(String _nnl_salenum){
        this._nnl_salenum = _nnl_salenum;
    }
    public String get_dnm_saleday(){
        return _dnm_saleday;
    }

    public void set_dnm_saleday(String _dnm_saleday){
        this._dnm_saleday = _dnm_saleday;
    }
    public String get_dnl_saleday(){
        return _dnl_saleday;
    }

    public void set_dnl_saleday(String _dnl_saleday){
        this._dnl_saleday = _dnl_saleday;
    }
    public String get_se_batchno(){
        return _se_batchno;
    }

    public void set_se_batchno(String _se_batchno){
        this._se_batchno = _se_batchno;
    }

	public String getB_month() {
		return b_month;
	}

	public void setB_month(String bMonth) {
		b_month = bMonth;
	}

	public String getB_no() {
		return b_no;
	}

	public void setB_no(String bNo) {
		b_no = bNo;
	}

}
