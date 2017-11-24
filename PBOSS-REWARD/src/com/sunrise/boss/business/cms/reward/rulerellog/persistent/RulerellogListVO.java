/**
* auto-generated code
* Wed Sep 10 14:39:49 CST 2008
*/
package com.sunrise.boss.business.cms.reward.rulerellog.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: RulerellogListVO</p>
 * <p>Description: Query Params Object for RulerellogDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class RulerellogListVO extends BaseListVO {
    private String _ne_logid;
    private String _de_optime;
    private String _se_oprcode;
    private String _se_oprtype;

    public String get_ne_logid(){
        return _ne_logid;
    }

    public void set_ne_logid(String _ne_logid){
        this._ne_logid = _ne_logid;
    }
    public String get_de_optime(){
        return _de_optime;
    }

    public void set_de_optime(String _de_optime){
        this._de_optime = _de_optime;
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

}
