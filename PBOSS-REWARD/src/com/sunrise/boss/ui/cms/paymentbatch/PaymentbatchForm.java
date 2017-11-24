/**
* auto-generated code
* Tue Aug 21 10:38:32 CST 2012
*/
package com.sunrise.boss.ui.cms.paymentbatch;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.paymentbatch.persistent.PaymentbatchVO;

/**
 * <p>Title: PaymentbatchForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class PaymentbatchForm extends BaseActionForm {

    private java.lang.String batchno;
    private java.lang.Short cityid;
    private java.lang.Short paymentflag;
    private java.lang.String paymentoprcode;
    private java.util.Date paymentoprtime;
    private java.lang.Short listflag;
    private java.lang.Short endflag;

    private String _se_batchno;
    private String _ne_cityid;
    private String _dnm_paymentoprtime;
    private String _dnl_paymentoprtime;

  //判断是否有令牌CH_ADT_MONITOR_VIEW的结果，由此令牌的工号允许查询所有地市的出帐情况
    //0表示无，只能查看工号所属地市；1表示有令牌，可以查看全省
    //-1为默认值，表示尚未检查令牌权限
    private Integer provpermited = -1;
    
    private boolean supportPaymonth = false;

	public boolean isSupportPaymonth() {
		return supportPaymonth;
	}

	public void setSupportPaymonth(boolean supportPaymonth) {
		this.supportPaymonth = supportPaymonth;
	}

	public Integer getProvpermited() {
		return provpermited;
	}

	public void setProvpermited(Integer provpermited) {
		this.provpermited = provpermited;
	}
	
    public java.lang.String getBatchno(){
        return batchno;
    }

    public void setBatchno(java.lang.String batchno){
        this.batchno = batchno;
    }
    public java.lang.Short getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.Short cityid){
        this.cityid = cityid;
    }
    public java.lang.Short getPaymentflag(){
        return paymentflag;
    }

    public void setPaymentflag(java.lang.Short paymentflag){
        this.paymentflag = paymentflag;
    }
    public java.lang.String getPaymentoprcode(){
        return paymentoprcode;
    }

    public void setPaymentoprcode(java.lang.String paymentoprcode){
        this.paymentoprcode = paymentoprcode;
    }
    public java.util.Date getPaymentoprtime(){
        return paymentoprtime;
    }

    public void setPaymentoprtime(java.util.Date paymentoprtime){
        this.paymentoprtime = paymentoprtime;
    }
    public java.lang.Short getListflag(){
        return listflag;
    }

    public void setListflag(java.lang.Short listflag){
        this.listflag = listflag;
    }
    public java.lang.Short getEndflag(){
        return endflag;
    }

    public void setEndflag(java.lang.Short endflag){
        this.endflag = endflag;
    }

    public String get_se_batchno(){
        return _se_batchno;
    }

    public void set_se_batchno(String _se_batchno){
        this._se_batchno = _se_batchno;
    }
    public String get_ne_cityid(){
        return _ne_cityid;
    }

    public void set_ne_cityid(String _ne_cityid){
        this._ne_cityid = _ne_cityid;
    }
    public String get_dnm_paymentoprtime(){
        return _dnm_paymentoprtime;
    }

    public void set_dnm_paymentoprtime(String _dnm_paymentoprtime){
        this._dnm_paymentoprtime = _dnm_paymentoprtime;
    }
    public String get_dnl_paymentoprtime(){
        return _dnl_paymentoprtime;
    }

    public void set_dnl_paymentoprtime(String _dnl_paymentoprtime){
        this._dnl_paymentoprtime = _dnl_paymentoprtime;
    }

}
