/**
* auto-generated code
* Tue Feb 05 10:11:13 CST 2008
*/
package com.sunrise.boss.business.cms.busicityload.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: BusicityloadListVO</p>
 * <p>Description: Query Params Object for BusicityloadDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BusicityloadListVO extends BaseListVO {
    private String _sk_opnid;
    private String _sk_cityid;
    private String _se_opnid;
    private String _se_cityid;
    private String _dnl_createtime;
    private String _dnm_createtime;
    private String _ne_state;
    private String _ne_calcflag;
    private String _se_simcode;
    
    public String get_sk_opnid(){
        return _sk_opnid;
    }

    public void set_sk_opnid(String _sk_opnid){
        this._sk_opnid = _sk_opnid;
    }
    public String get_sk_cityid(){
        return _sk_cityid;
    }

    public void set_sk_cityid(String _sk_cityid){
        this._sk_cityid = _sk_cityid;
    }
    public String get_dnl_createtime(){
        return _dnl_createtime;
    }

    public void set_dnl_createtime(String _dnl_createtime){
        this._dnl_createtime = _dnl_createtime;
    }
    public String get_dnm_createtime(){
        return _dnm_createtime;
    }

    public void set_dnm_createtime(String _dnm_createtime){
        this._dnm_createtime = _dnm_createtime;
    }
    public String get_ne_state(){
        return _ne_state;
    }

    public void set_ne_state(String _ne_state){
        this._ne_state = _ne_state;
    }
    public String get_ne_calcflag(){
        return _ne_calcflag;
    }

    public void set_ne_calcflag(String _ne_calcflag){
        this._ne_calcflag = _ne_calcflag;
    }

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_se_simcode() {
		return _se_simcode;
	}

	public void set_se_simcode(String _se_simcode) {
		this._se_simcode = _se_simcode;
	}

}
