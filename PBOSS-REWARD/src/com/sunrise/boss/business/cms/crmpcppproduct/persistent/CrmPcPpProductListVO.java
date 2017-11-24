/**
* auto-generated code
* Thu Dec 12 20:04:12 CST 2013
*/
package com.sunrise.boss.business.cms.crmpcppproduct.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: CrmPcPpProductListVO</p>
 * <p>Description: Query Params Object for CrmPcPpProductDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class CrmPcPpProductListVO extends BaseListVO {
    private String _se_prodid;
    private String _se_prodname;

    public String get_se_prodid(){
        return _se_prodid;
    }

    public void set_se_prodid(String _se_prodid){
        this._se_prodid = _se_prodid;
    }
    public String get_se_prodname(){
        return _se_prodname;
    }

    public void set_se_prodname(String _se_prodname){
        this._se_prodname = _se_prodname;
    }

}
