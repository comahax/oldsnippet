/**
* auto-generated code
* Tue Jul 14 09:24:12 CST 2009
*/
package com.sunrise.boss.business.cms.reward.rulemode.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RulemodeListVO</p>
 * <p>Description: Query Params Object for RulemodeDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
public class RulemodeListVO extends BaseListVO {
	
    private String _se_ruleid;
    private String _se_cityid;
    private String _sk_rulemodename;

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
    public String get_sk_rulemodename(){
        return _sk_rulemodename;
    }

    public void set_sk_rulemodename(String _sk_rulemodename){
        this._sk_rulemodename = _sk_rulemodename;
    }

}
