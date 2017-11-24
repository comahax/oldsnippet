/**
* auto-generated code
* Sat Dec 03 10:12:28 CST 2011
*/
package com.sunrise.boss.ui.cms.bbc.service;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.bbc.service.persistent.ServiceVO;

/**
 * <p>Title: ServiceForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class ServiceForm extends BaseActionForm {

    private java.lang.String name;
    private java.lang.String opnid;
    private java.lang.Float baserewardstd;
    private java.lang.Float bonusrewardstd;

    private String _sk_name;
    private String _se_opnid;

    public java.lang.String getName(){
        return name;
    }

    public void setName(java.lang.String name){
        this.name = name;
    }
    public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.Float getBaserewardstd(){
        return baserewardstd;
    }

    public void setBaserewardstd(java.lang.Float baserewardstd){
        this.baserewardstd = baserewardstd;
    }
    public java.lang.Float getBonusrewardstd(){
        return bonusrewardstd;
    }

    public void setBonusrewardstd(java.lang.Float bonusrewardstd){
        this.bonusrewardstd = bonusrewardstd;
    }

    public String get_sk_name(){
        return _sk_name;
    }

    public void set_sk_name(String _sk_name){
        this._sk_name = _sk_name;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }

}
