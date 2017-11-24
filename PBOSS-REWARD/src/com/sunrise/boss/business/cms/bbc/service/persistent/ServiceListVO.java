/**
* auto-generated code
* Sat Dec 03 10:12:28 CST 2011
*/
package com.sunrise.boss.business.cms.bbc.service.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ServiceListVO</p>
 * <p>Description: Query Params Object for ServiceDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class ServiceListVO extends BaseListVO {
    private String _sk_name;
    private String _se_opnid;

    public String get_sk_name(){
        return _sk_name;
    }

    public void set_sk_name(String _sk_name){
        this._sk_name = _sk_name;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }

}
