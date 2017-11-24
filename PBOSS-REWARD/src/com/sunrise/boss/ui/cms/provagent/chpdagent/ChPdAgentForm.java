/**
* auto-generated code
* Mon Sep 02 12:21:21 CST 2013
*/
package com.sunrise.boss.ui.cms.provagent.chpdagent;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.provagent.chpdagent.persistent.ChPdAgentVO;

/**
 * <p>Title: ChPdAgentForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class ChPdAgentForm extends BaseActionForm {

    private java.lang.String provagentid;
    private java.lang.String provagentname;

    private String _se_provagentid;
    private String _se_provagentname;
    private String _sk_provagentname;

    public java.lang.String getProvagentid(){
        return provagentid;
    }

    public void setProvagentid(java.lang.String provagentid){
        this.provagentid = provagentid;
    }
    public java.lang.String getProvagentname(){
        return provagentname;
    }

    public void setProvagentname(java.lang.String provagentname){
        this.provagentname = provagentname;
    }

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
