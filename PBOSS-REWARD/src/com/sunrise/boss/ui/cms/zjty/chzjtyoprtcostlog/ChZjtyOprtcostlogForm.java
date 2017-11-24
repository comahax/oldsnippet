/**
* auto-generated code
* Mon Feb 16 10:04:47 CST 2009
*/
package com.sunrise.boss.ui.cms.zjty.chzjtyoprtcostlog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.zjty.chzjtyoprtcostlog.persistent.ChZjtyOprtcostlogVO;

/**
 * <p>Title: ChZjtyOprtcostlogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public class ChZjtyOprtcostlogForm extends BaseActionForm {

    private java.lang.Long logid;
    private java.util.Date optime;
    private java.lang.String oprcode;
    private java.lang.String oprtype;
    private java.lang.String success;
    private java.lang.Short citylevel;
    private java.lang.Short ctype;
    private java.lang.Double cost;
    private java.lang.String memo;


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
    public java.lang.Short getCitylevel(){
        return citylevel;
    }

    public void setCitylevel(java.lang.Short citylevel){
        this.citylevel = citylevel;
    }
    public java.lang.Short getCtype(){
        return ctype;
    }

    public void setCtype(java.lang.Short ctype){
        this.ctype = ctype;
    }
    public java.lang.Double getCost(){
        return cost;
    }

    public void setCost(java.lang.Double cost){
        this.cost = cost;
    }
    public java.lang.String getMemo(){
        return memo;
    }

    public void setMemo(java.lang.String memo){
        this.memo = memo;
    }


}
