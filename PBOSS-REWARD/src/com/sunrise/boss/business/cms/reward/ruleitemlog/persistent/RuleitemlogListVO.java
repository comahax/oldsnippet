/**
* auto-generated code
* Wed Sep 10 14:41:39 CST 2008
*/
package com.sunrise.boss.business.cms.reward.ruleitemlog.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RuleitemlogListVO</p>
 * <p>Description: Query Params Object for RuleitemlogDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RuleitemlogListVO extends BaseListVO {
    private String _ne_logid;
    private String _se_oprcode;
    private String _se_oprtype;
    private String _se_contype;

    public String get_ne_logid(){
        return _ne_logid;
    }

    public void set_ne_logid(String _ne_logid){
        this._ne_logid = _ne_logid;
    }
    public String get_se_oprcode(){
        return _se_oprcode;
    }

    public void set_se_oprcode(String _se_oprcode){
        this._se_oprcode = _se_oprcode;
    }
    public String get_se_oprtype(){
        return _se_oprtype;
    }

    public void set_se_oprtype(String _se_oprtype){
        this._se_oprtype = _se_oprtype;
    }
    public String get_se_contype(){
        return _se_contype;
    }

    public void set_se_contype(String _se_contype){
        this._se_contype = _se_contype;
    }

}
