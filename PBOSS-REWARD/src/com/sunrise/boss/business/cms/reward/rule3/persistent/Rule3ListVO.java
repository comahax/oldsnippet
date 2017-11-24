/**
* auto-generated code
* Mon Feb 04 12:04:50 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rule3.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: Rule3ListVO</p>
 * <p>Description: Query Params Object for Rule3DAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class Rule3ListVO extends BaseListVO {
    private String _se_ruleid;
    private String _sk_rulename;
    private String _dnl_startdate;
    private String _dnm_startdate;
    private String _dnl_enddate;
    private String _dnm_enddate;
    private String _se_opnid;

    public String get_se_ruleid(){
        return _se_ruleid;
    }

    public void set_se_ruleid(String _se_ruleid){
        this._se_ruleid = _se_ruleid;
    }
    public String get_sk_rulename(){
        return _sk_rulename;
    }

    public void set_sk_rulename(String _sk_rulename){
        this._sk_rulename = _sk_rulename;
    }
    public String get_dnl_startdate(){
        return _dnl_startdate;
    }

    public void set_dnl_startdate(String _dnl_startdate){
        this._dnl_startdate = _dnl_startdate;
    }
    public String get_dnm_startdate(){
        return _dnm_startdate;
    }

    public void set_dnm_startdate(String _dnm_startdate){
        this._dnm_startdate = _dnm_startdate;
    }
    public String get_dnl_enddate(){
        return _dnl_enddate;
    }

    public void set_dnl_enddate(String _dnl_enddate){
        this._dnl_enddate = _dnl_enddate;
    }
    public String get_dnm_enddate(){
        return _dnm_enddate;
    }

    public void set_dnm_enddate(String _dnm_enddate){
        this._dnm_enddate = _dnm_enddate;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }

}
