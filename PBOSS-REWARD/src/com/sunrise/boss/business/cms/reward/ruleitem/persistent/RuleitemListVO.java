/**
* auto-generated code
* Wed Sep 10 11:29:44 CST 2008
*/
package com.sunrise.boss.business.cms.reward.ruleitem.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RuleitemListVO</p>
 * <p>Description: Query Params Object for RuleitemDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleitemListVO extends BaseListVO {
    private String _se_ruleitemid;
    private String _se_ruleitemname;

    public String get_se_ruleitemid(){
        return _se_ruleitemid;
    }

    public void set_se_ruleitemid(String _se_ruleitemid){
        this._se_ruleitemid = _se_ruleitemid;
    }
    public String get_se_ruleitemname(){
        return _se_ruleitemname;
    }

    public void set_se_ruleitemname(String _se_ruleitemname){
        this._se_ruleitemname = _se_ruleitemname;
    }

}
