/**
* auto-generated code
* Wed Dec 07 09:31:25 CST 2011
*/
package com.sunrise.boss.ui.cms.bbc.blacklistlog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.bbc.blacklistlog.persistent.BlacklistlogVO;

/**
 * <p>Title: BlacklistlogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class BlacklistlogForm extends BaseActionForm {

    private java.lang.Long logid;
    private java.util.Date optime;
    private java.lang.String oprcode;
    private java.lang.String oprtype;
    private java.lang.String success;
    private java.lang.String name;
    private java.lang.String mobile;
    private java.lang.String filtertype;
    private java.util.Date starttime;
    private java.util.Date endtime;


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
    public java.lang.String getMobile(){
        return mobile;
    }

    public void setMobile(java.lang.String mobile){
        this.mobile = mobile;
    }
    public java.lang.String getFiltertype(){
        return filtertype;
    }

    public void setFiltertype(java.lang.String filtertype){
        this.filtertype = filtertype;
    }
    public java.util.Date getStarttime(){
        return starttime;
    }

    public void setStarttime(java.util.Date starttime){
        this.starttime = starttime;
    }
    public java.util.Date getEndtime(){
        return endtime;
    }

    public void setEndtime(java.util.Date endtime){
        this.endtime = endtime;
    }


}
