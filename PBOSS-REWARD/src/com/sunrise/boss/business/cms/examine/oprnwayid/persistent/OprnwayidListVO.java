/**
* auto-generated code
* Wed Nov 18 10:31:12 CST 2009
*/
package com.sunrise.boss.business.cms.examine.oprnwayid.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: OprnwayidListVO</p>
 * <p>Description: Query Params Object for OprnwayidDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class OprnwayidListVO extends BaseListVO {
    private String _se_operid;
    private String _se_wayid;

    public String get_se_operid(){
        return _se_operid;
    }

    public void set_se_operid(String _se_operid){
        this._se_operid = _se_operid;
    }
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }

}
