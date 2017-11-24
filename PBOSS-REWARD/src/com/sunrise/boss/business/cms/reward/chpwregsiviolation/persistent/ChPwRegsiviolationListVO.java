/**
* auto-generated code
* Fri Oct 18 14:59:15 CST 2013
*/
package com.sunrise.boss.business.cms.reward.chpwregsiviolation.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChPwRegsiviolationListVO</p>
 * <p>Description: Query Params Object for ChPwRegsiviolationDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChPwRegsiviolationListVO extends BaseListVO {
    private String _se_mobile;
    private String _se_vmonth;

    public String get_se_mobile(){
        return _se_mobile;
    }

    public void set_se_mobile(String _se_mobile){
        this._se_mobile = _se_mobile;
    }
    public String get_se_vmonth(){
        return _se_vmonth;
    }

    public void set_se_vmonth(String _se_vmonth){
        this._se_vmonth = _se_vmonth;
    }

}
