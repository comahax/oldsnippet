/**
* auto-generated code
* Tue Aug 21 10:38:31 CST 2012
*/
package com.sunrise.boss.business.cms.paymentbatch.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: PaymentbatchListVO</p>
 * <p>Description: Query Params Object for PaymentbatchDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class PaymentbatchListVO extends BaseListVO {
    private String _se_batchno;
    private String _ne_cityid;
    private String _dnm_paymentoprtime;
    private String _dnl_paymentoprtime;

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
