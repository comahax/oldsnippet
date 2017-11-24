/**
* auto-generated code
* Tue May 17 15:57:34 CST 2011
*/
package com.sunrise.boss.business.cms.reward.salecredit.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: SalecreditListVO</p>
 * <p>Description: Query Params Object for SalecreditDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class SalecreditListVO extends BaseListVO {
    private String _se_wayid;
    private String _ne_busitype;

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_ne_busitype(){
        return _ne_busitype;
    }

    public void set_ne_busitype(String _ne_busitype){
        this._ne_busitype = _ne_busitype;
    }

}
