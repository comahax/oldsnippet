/**
* auto-generated code
* Tue May 01 15:39:58 CST 2007
*/
package com.sunrise.boss.business.cms.coststatrelative.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: CoststatrelativeListVO</p>
 * <p>Description: Query Params Object for CoststatrelativeDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Cai Jianhui
 * @version 1.0
 */
public class CoststatrelativeListVO extends BaseListVO {
    private String _ne_recid;
    private String _ne_statmode;

    public String get_ne_recid(){
        return _ne_recid;
    }

    public void set_ne_recid(String _ne_id){
        this._ne_recid = _ne_id;
    }
    public String get_ne_statmode(){
        return _ne_statmode;
    }

    public void set_ne_statmode(String _ne_statmode){
        this._ne_statmode = _ne_statmode;
    }

}
