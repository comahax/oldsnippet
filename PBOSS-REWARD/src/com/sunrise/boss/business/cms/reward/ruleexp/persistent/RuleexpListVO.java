/**
* auto-generated code
* Fri Jul 17 11:20:44 CST 2009
*/
package com.sunrise.boss.business.cms.reward.ruleexp.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RuleexpListVO</p>
 * <p>Description: Query Params Object for RuleexpDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class RuleexpListVO extends BaseListVO {
    private String _se_ruleid;
    private String _se_cityid;
    private String _ne_rulemodeid;
    private String _ne_state;

    public String get_se_ruleid(){
        return _se_ruleid;
    }

    public void set_se_ruleid(String _se_ruleid){
        this._se_ruleid = _se_ruleid;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }
    public String get_ne_rulemodeid(){
        return _ne_rulemodeid;
    }

    public void set_ne_rulemodeid(String _ne_rulemodeid){
        this._ne_rulemodeid = _ne_rulemodeid;
    }
    public String get_ne_state(){
        return _ne_state;
    }

    public void set_ne_state(String _ne_state){
        this._ne_state = _ne_state;
    }

}
