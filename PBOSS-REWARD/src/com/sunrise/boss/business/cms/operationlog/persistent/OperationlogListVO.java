/**
* auto-generated code
* Tue May 01 15:19:39 CST 2007
*/
package com.sunrise.boss.business.cms.operationlog.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: OperationlogListVO</p>
 * <p>Description: Query Params Object for OperationlogDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class OperationlogListVO extends BaseListVO {
    private String _ne_logid;
    private String _de_optime;
    private String _se_oprcode;
    private String _se_success;
    private String _dnl_optime;
    private String _dnm_optime;
    private String _se_oprtype;
    private String _se_opnid;
    private String _sk_name;
    
    public String get_ne_logid(){
        return _ne_logid;
    }

    public void set_ne_logid(String _ne_logid){
        this._ne_logid = _ne_logid;
    }
    public String get_de_optime(){
        return _de_optime;
    }

    public void set_de_optime(String _de_optime){
        this._de_optime = _de_optime;
    }
    public String get_se_oprcode(){
        return _se_oprcode;
    }

    public void set_se_oprcode(String _se_oprcode){
        this._se_oprcode = _se_oprcode;
    }
    public String get_se_success(){
        return _se_success;
    }

    public void set_se_success(String _se_success){
        this._se_success = _se_success;
    }
    public String get_dnl_optime(){
        return _dnl_optime;
    }

    public void set_dnl_optime(String _dnl_optime){
        this._dnl_optime = _dnl_optime;
    }
    public String get_dnm_optime(){
        return _dnm_optime;
    }

    public void set_dnm_optime(String _dnm_optime){
        this._dnm_optime = _dnm_optime;
    }
    public String get_se_oprtype(){
        return _se_oprtype;
    }

    public void set_se_oprtype(String _se_oprtype){
        this._se_oprtype = _se_oprtype;
    }
    public String get_sk_name(){
        return _sk_name;
    }

    public void set_sk_name(String _sk_name){
        this._sk_name = _sk_name;
    }

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}
}
