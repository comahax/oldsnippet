/**
* auto-generated code
* Sat Feb 02 15:15:28 CST 2008
*/
package com.sunrise.boss.business.cms.reward.busyxplanlog.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: BusyxplanlogListVO</p>
 * <p>Description: Query Params Object for BusyxplanlogDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class BusyxplanlogListVO extends BaseListVO {
    private String _se_opnid;
    private String _ne_yxplanid;

    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_ne_yxplanid(){
        return _ne_yxplanid;
    }

    public void set_ne_yxplanid(String _ne_yxplanid){
        this._ne_yxplanid = _ne_yxplanid;
    }

}
