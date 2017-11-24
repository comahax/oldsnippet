/**
* auto-generated code
* Wed Dec 14 10:29:07 CST 2011
*/
package com.sunrise.boss.ui.cms.bbc.hpolregistersucc;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.bbc.hpolregistersucc.persistent.HpolregistersuccVO;

/**
 * <p>Title: HpolregistersuccForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class HpolregistersuccForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.String wayid;
    private java.lang.String wayname;
    private java.lang.Short starlevel;
    private java.lang.String officetel;
    private java.util.Date oprtime;
    private java.lang.String mobile;
    private java.util.Date startdate;
    private java.lang.Integer subnumber;

    private String _se_wayid;
    private String _se_officetel;
    private String _se_mobile;

    public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.String getWayname(){
        return wayname;
    }

    public void setWayname(java.lang.String wayname){
        this.wayname = wayname;
    }
    public java.lang.Short getStarlevel(){
        return starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel){
        this.starlevel = starlevel;
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
    public java.lang.String getMobile(){
        return mobile;
    }

    public void setMobile(java.lang.String mobile){
        this.mobile = mobile;
    }
    public java.util.Date getStartdate(){
        return startdate;
    }

    public void setStartdate(java.util.Date startdate){
        this.startdate = startdate;
    }
    public java.lang.Integer getSubnumber(){
        return subnumber;
    }

    public void setSubnumber(java.lang.Integer subnumber){
        this.subnumber = subnumber;
    }

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_officetel(){
        return _se_officetel;
    }

    public void set_se_officetel(String _se_officetel){
        this._se_officetel = _se_officetel;
    }
    public String get_se_mobile(){
        return _se_mobile;
    }

    public void set_se_mobile(String _se_mobile){
        this._se_mobile = _se_mobile;
    }

}
