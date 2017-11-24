/**
* auto-generated code
* Thu Feb 16 10:30:46 CST 2012
*/
package com.sunrise.boss.business.cms.reward.salepointflag.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: SalepointflagListVO</p>
 * <p>Description: Query Params Object for SalepointflagDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class SalepointflagListVO extends BaseListVO {
    private String _se_flag;
    private String _se_cityid;

    public String get_se_flag(){
        return _se_flag;
    }

    public void set_se_flag(String _se_flag){
        this._se_flag = _se_flag;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }

}
