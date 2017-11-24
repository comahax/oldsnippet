/**
* auto-generated code
* Wed Apr 11 11:02:17 CST 2007
*/
package com.sunrise.boss.business.cms.servcent.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ServcentListVO</p>
 * <p>Description: Query Params Object for ServcentDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Ye Daoe
 * @version 1.0
 */
public class ServcentListVO extends BaseListVO {
    private String _se_svccode;
    private String _se_countyid;
    private String _sk_svcname;
    private String _se_adacode;

    public String get_se_svccode(){
        return _se_svccode;
    }

    public void set_se_svccode(String _se_svccode){
        this._se_svccode = _se_svccode;
    }
    public String get_se_countyid(){
        return _se_countyid;
    }

    public void set_se_countyid(String _se_countyid){
        this._se_countyid = _se_countyid;
    }
    public String get_sk_svcname(){
        return _sk_svcname;
    }

    public void set_sk_svcname(String _sk_svcname){
        this._sk_svcname = _sk_svcname;
    }
    public String get_se_adacode(){
        return _se_adacode;
    }

    public void set_se_adacode(String _se_adacode){
        this._se_adacode = _se_adacode;
    }

}
