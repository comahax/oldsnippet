/**
* auto-generated code
* Sat May 11 16:40:18 CST 2013
*/
package com.sunrise.boss.ui.cms.chzdplatforminfo;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.chzdplatforminfo.persistent.ChZdPlatforminfoVO;

/**
 * <p>Title: ChZdPlatforminfoForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChZdPlatforminfoForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.Long productid;
    private java.lang.String producttype;
    private java.lang.String zdplatform;
    private java.lang.Double saleprice;
    private java.util.Date starttime;
    private java.util.Date endtime;
    private java.lang.String batchno;

    private String _ne_productid;
    private String _se_producttype;
    private String _se_zdplatform;
    private String _dnl_starttime;
    private String _dnm_endtime;
    private String _se_batchno;

    public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }
    public java.lang.Long getProductid(){
        return productid;
    }

    public void setProductid(java.lang.Long productid){
        this.productid = productid;
    }
    public java.lang.String getProducttype(){
        return producttype;
    }

    public void setProducttype(java.lang.String producttype){
        this.producttype = producttype;
    }
    public java.lang.String getZdplatform(){
        return zdplatform;
    }

    public void setZdplatform(java.lang.String zdplatform){
        this.zdplatform = zdplatform;
    }
    public java.lang.Double getSaleprice(){
        return saleprice;
    }

    public void setSaleprice(java.lang.Double saleprice){
        this.saleprice = saleprice;
    }
    public java.util.Date getStarttime(){
        return starttime;
    }

    public void setStarttime(java.util.Date starttime){
        this.starttime = starttime;
    }
    public java.util.Date getEndtime(){
        return endtime;
    }

    public void setEndtime(java.util.Date endtime){
        this.endtime = endtime;
    }
    public java.lang.String getBatchno(){
        return batchno;
    }

    public void setBatchno(java.lang.String batchno){
        this.batchno = batchno;
    }

    public String get_ne_productid(){
        return _ne_productid;
    }

    public void set_ne_productid(String _ne_productid){
        this._ne_productid = _ne_productid;
    }
    public String get_se_producttype(){
        return _se_producttype;
    }

    public void set_se_producttype(String _se_producttype){
        this._se_producttype = _se_producttype;
    }
    public String get_se_zdplatform(){
        return _se_zdplatform;
    }

    public void set_se_zdplatform(String _se_zdplatform){
        this._se_zdplatform = _se_zdplatform;
    }
    public String get_dnl_starttime(){
        return _dnl_starttime;
    }

    public void set_dnl_starttime(String _dnl_starttime){
        this._dnl_starttime = _dnl_starttime;
    }
    public String get_dnm_endtime(){
        return _dnm_endtime;
    }

    public void set_dnm_endtime(String _dnm_endtime){
        this._dnm_endtime = _dnm_endtime;
    }
    public String get_se_batchno(){
        return _se_batchno;
    }

    public void set_se_batchno(String _se_batchno){
        this._se_batchno = _se_batchno;
    }

}
