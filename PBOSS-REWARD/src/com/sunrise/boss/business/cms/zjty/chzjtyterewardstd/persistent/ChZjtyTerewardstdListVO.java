/**
* auto-generated code
* Mon Apr 08 15:52:02 CST 2013
*/
package com.sunrise.boss.business.cms.zjty.chzjtyterewardstd.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChZjtyTerewardstdListVO</p>
 * <p>Description: Query Params Object for ChZjtyTerewardstdDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChZjtyTerewardstdListVO extends BaseListVO {
    private String _ne_rewardtype;
    private String _ne_citycode;

    public String get_ne_rewardtype(){
        return _ne_rewardtype;
    }

    public void set_ne_rewardtype(String _ne_rewardtype){
        this._ne_rewardtype = _ne_rewardtype;
    }
    public String get_ne_citycode(){
        return _ne_citycode;
    }

    public void set_ne_citycode(String _ne_citycode){
        this._ne_citycode = _ne_citycode;
    }

}
