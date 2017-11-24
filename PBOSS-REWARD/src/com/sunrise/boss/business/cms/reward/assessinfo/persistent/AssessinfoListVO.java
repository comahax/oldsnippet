/**
* auto-generated code
* Thu Dec 01 14:14:15 CST 2011
*/
package com.sunrise.boss.business.cms.reward.assessinfo.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: AssessinfoListVO</p>
 * <p>Description: Query Params Object for AssessinfoDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class AssessinfoListVO extends BaseListVO {
    private String _se_cityid;
    private String _ne_type;

    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }
    public String get_ne_type(){
        return _ne_type;
    }

    public void set_ne_type(String _ne_type){
        this._ne_type = _ne_type;
    }

}
