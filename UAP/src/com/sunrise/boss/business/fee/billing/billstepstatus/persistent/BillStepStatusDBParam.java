/**
* auto-generated code
* Tue Aug 10 08:38:40 GMT 2010
*/
package com.sunrise.boss.business.fee.billing.billstepstatus.persistent;


import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: BillStepStatusListVO</p>
 * <p>Description: Query Params Object for BillStepStatusDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wangguangying
 * @version 1.0
 */
public class BillStepStatusDBParam extends DBQueryParam {
    private String _ne_validbillcyc;
    private String _ne_stepno;
    private String _ne_taskstatus;
    private String _ne_region;

    public String get_ne_region() {
    	return _ne_region;
    }

    public void set_ne_region(String _ne_region) {
    	this._ne_region = _ne_region;
    }

    public String get_ne_validbillcyc(){
        return _ne_validbillcyc;
    }

    public void set_ne_validbillcyc(String _ne_validbillcyc){
        this._ne_validbillcyc = _ne_validbillcyc;
    }
    public String get_ne_stepno(){
        return _ne_stepno;
    }

    public void set_ne_stepno(String _ne_stepno){
        this._ne_stepno = _ne_stepno;
    }
    public String get_ne_taskstatus(){
        return _ne_taskstatus;
    }

    public void set_ne_taskstatus(String _ne_taskstatus){
        this._ne_taskstatus = _ne_taskstatus;
    }

}
