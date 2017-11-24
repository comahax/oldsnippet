/**
* auto-generated code
* Mon Feb 21 10:31:26 CST 2011
*/
package com.sunrise.boss.business.cms.reward.operationsms.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: OperationsmsListVO</p>
 * <p>Description: Query Params Object for OperationsmsDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class OperationsmsListVO extends BaseListVO {
    private String _se_cityid;
    private String _se_opnid;
    private String _sk_opnname;
    private String _se_smsno;
    private String _se_opntype;

    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_sk_opnname(){
        return _sk_opnname;
    }

    public void set_sk_opnname(String _sk_opnname){
        this._sk_opnname = _sk_opnname;
    }
    public String get_se_smsno(){
        return _se_smsno;
    }

    public void set_se_smsno(String _se_smsno){
        this._se_smsno = _se_smsno;
    }
    public String get_se_opntype(){
        return _se_opntype;
    }

    public void set_se_opntype(String _se_opntype){
        this._se_opntype = _se_opntype;
    }

}
