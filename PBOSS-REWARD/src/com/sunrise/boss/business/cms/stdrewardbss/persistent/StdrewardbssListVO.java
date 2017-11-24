/**
* auto-generated code
* Sat Apr 23 11:54:03 CST 2011
*/
package com.sunrise.boss.business.cms.stdrewardbss.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: StdrewardbssListVO</p>
 * <p>Description: Query Params Object for StdrewardbssDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class StdrewardbssListVO extends BaseListVO {
    private String _ne_rewardid;
    private String _se_region;
    private String _se_slv;

    public String get_ne_rewardid(){
        return _ne_rewardid;
    }

    public void set_ne_rewardid(String _ne_rewardid){
        this._ne_rewardid = _ne_rewardid;
    }
    public String get_se_region(){
        return _se_region;
    }

    public void set_se_region(String _se_region){
        this._se_region = _se_region;
    }
    public String get_se_slv(){
        return _se_slv;
    }

    public void set_se_slv(String _se_slv){
        this._se_slv = _se_slv;
    }

}
