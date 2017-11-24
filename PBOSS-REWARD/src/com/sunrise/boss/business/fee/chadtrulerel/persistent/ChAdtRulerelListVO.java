/**
* auto-generated code
* Wed Feb 06 14:54:24 CST 2013
*/
package com.sunrise.boss.business.fee.chadtrulerel.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChAdtRulerelListVO</p>
 * <p>Description: Query Params Object for ChAdtRulerelDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author lc
 * @version 1.0
 */
public class ChAdtRulerelListVO extends BaseListVO {
    private String _se_ruleitemid;
    private String _se_ruleid;
    private String _se_cityid;
    private String _ne_state;
    private String _ne_isdefault;
    private String _ne_rulemodeid;
    private String _se_paramer;
    private String _sql_condintion;

    public String get_sql_condintion() {
		return _sql_condintion;
	}

	public void set_sql_condintion(String _sql_condintion) {
		this._sql_condintion = _sql_condintion;
	}

	public String get_se_ruleitemid(){
        return _se_ruleitemid;
    }

    public void set_se_ruleitemid(String _se_ruleitemid){
        this._se_ruleitemid = _se_ruleitemid;
    }
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
    public String get_ne_state(){
        return _ne_state;
    }

    public void set_ne_state(String _ne_state){
        this._ne_state = _ne_state;
    }
    public String get_ne_isdefault(){
        return _ne_isdefault;
    }

    public void set_ne_isdefault(String _ne_isdefault){
        this._ne_isdefault = _ne_isdefault;
    }
    public String get_ne_rulemodeid(){
        return _ne_rulemodeid;
    }

    public void set_ne_rulemodeid(String _ne_rulemodeid){
        this._ne_rulemodeid = _ne_rulemodeid;
    }
    public String get_se_paramer(){
        return _se_paramer;
    }

    public void set_se_paramer(String _se_paramer){
        this._se_paramer = _se_paramer;
    }

}
