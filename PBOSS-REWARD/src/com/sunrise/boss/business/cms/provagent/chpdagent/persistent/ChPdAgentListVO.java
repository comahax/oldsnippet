/**
* auto-generated code
* Mon Sep 02 12:21:21 CST 2013
*/
package com.sunrise.boss.business.cms.provagent.chpdagent.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChPdAgentListVO</p>
 * <p>Description: Query Params Object for ChPdAgentDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChPdAgentListVO extends BaseListVO {
    private String _se_provagentid;
    private String _se_provagentname;
    private String _sk_provagentname;

    public String get_se_provagentid(){
        return _se_provagentid;
    }

    public void set_se_provagentid(String _se_provagentid){
        this._se_provagentid = _se_provagentid;
    }
    public String get_se_provagentname(){
        return _se_provagentname;
    }

    public void set_se_provagentname(String _se_provagentname){
        this._se_provagentname = _se_provagentname;
    }
    public String get_sk_provagentname(){
        return _sk_provagentname;
    }

    public void set_sk_provagentname(String _sk_provagentname){
        this._sk_provagentname = _sk_provagentname;
    }

}
