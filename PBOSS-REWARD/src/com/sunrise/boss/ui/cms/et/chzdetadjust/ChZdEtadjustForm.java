/**
* auto-generated code
* Thu May 09 16:24:13 CST 2013
*/
package com.sunrise.boss.ui.cms.et.chzdetadjust;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.et.chzdetadjust.persistent.ChZdEtadjustVO;

/**
 * <p>Title: ChZdEtadjustForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChZdEtadjustForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.String wayid;
    private java.lang.String platform;
    private java.lang.String producttype;
    private java.lang.Double money;
    private java.lang.String batchno;
    private java.lang.String note;

    private String _se_wayid;
    private String _se_platform;
    private String _se_producttype;
    private String _se_batchno;
    
    private String b_month;
    private String b_no;

    public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.String getPlatform(){
        return platform;
    }

    public void setPlatform(java.lang.String platform){
        this.platform = platform;
    }
    public java.lang.String getProducttype(){
        return producttype;
    }

    public void setProducttype(java.lang.String producttype){
        this.producttype = producttype;
    }
    public java.lang.Double getMoney(){
        return money;
    }

    public void setMoney(java.lang.Double money){
        this.money = money;
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

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_platform(){
        return _se_platform;
    }

    public void set_se_platform(String _se_platform){
        this._se_platform = _se_platform;
    }
    public String get_se_producttype(){
        return _se_producttype;
    }

    public void set_se_producttype(String _se_producttype){
        this._se_producttype = _se_producttype;
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
