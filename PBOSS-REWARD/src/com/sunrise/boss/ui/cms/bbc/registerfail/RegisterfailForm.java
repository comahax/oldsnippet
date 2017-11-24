/**
* auto-generated code
* Fri Dec 09 10:19:02 CST 2011
*/
package com.sunrise.boss.ui.cms.bbc.registerfail;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.bbc.registerfail.persistent.RegisterfailVO;

/**
 * <p>Title: RegisterfailForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class RegisterfailForm extends BaseActionForm {

    private java.lang.String wayid;
    private java.lang.String opnid;
    private java.lang.String mobile;
    private java.lang.String officetel;
    private java.util.Date oprtime;
    private java.lang.Long seq;

    private String _se_wayid;
    private String _se_opnid;
    private String _se_officetel;

    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.String getMobile(){
        return mobile;
    }

    public void setMobile(java.lang.String mobile){
        this.mobile = mobile;
    }
    public java.lang.String getOfficetel(){
        return officetel;
    }

    public void setOfficetel(java.lang.String officetel){
        this.officetel = officetel;
    }
    public java.util.Date getOprtime(){
        return oprtime;
    }

    public void setOprtime(java.util.Date oprtime){
        this.oprtime = oprtime;
    }
    public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_se_officetel(){
        return _se_officetel;
    }

    public void set_se_officetel(String _se_officetel){
        this._se_officetel = _se_officetel;
    }

}
