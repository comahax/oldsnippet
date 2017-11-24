/**
* auto-generated code
* Sat Dec 03 10:15:10 CST 2011
*/
package com.sunrise.boss.ui.cms.bbc.servicelog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.bbc.servicelog.persistent.ServicelogVO;

/**
 * <p>Title: ServicelogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class ServicelogForm extends BaseActionForm {

    private java.lang.Long logid;
    private java.util.Date optime;
    private java.lang.String oprcode;
    private java.lang.String oprtype;
    private java.lang.String success;
    private java.lang.String name;
    private java.lang.String opnid;
    private java.lang.Float baserewardstd;
    private java.lang.Float bonusrewardstd;


    public java.lang.Long getLogid(){
        return logid;
    }

    public void setLogid(java.lang.Long logid){
        this.logid = logid;
    }
    public java.util.Date getOptime(){
        return optime;
    }

    public void setOptime(java.util.Date optime){
        this.optime = optime;
    }
    public java.lang.String getOprcode(){
        return oprcode;
    }

    public void setOprcode(java.lang.String oprcode){
        this.oprcode = oprcode;
    }
    public java.lang.String getOprtype(){
        return oprtype;
    }

    public void setOprtype(java.lang.String oprtype){
        this.oprtype = oprtype;
    }
    public java.lang.String getSuccess(){
        return success;
    }

    public void setSuccess(java.lang.String success){
        this.success = success;
    }
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


}
