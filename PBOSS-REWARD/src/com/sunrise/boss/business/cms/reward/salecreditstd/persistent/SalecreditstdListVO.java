/**
* auto-generated code
* Wed May 18 10:32:19 CST 2011
*/
package com.sunrise.boss.business.cms.reward.salecreditstd.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: SalecreditstdListVO</p>
 * <p>Description: Query Params Object for SalecreditstdDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class SalecreditstdListVO extends BaseListVO {
    private String _ne_cityid;
    private String _ne_busitype;

    public String get_ne_cityid(){
        return _ne_cityid;
    }

    public void set_ne_cityid(String _ne_cityid){
        this._ne_cityid = _ne_cityid;
    }
    public String get_ne_busitype(){
        return _ne_busitype;
    }

    public void set_ne_busitype(String _ne_busitype){
        this._ne_busitype = _ne_busitype;
    }

}
