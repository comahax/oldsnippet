/**
* auto-generated code
* Fri Feb 13 16:55:58 CST 2009
*/
package com.sunrise.boss.ui.cms.zjty.chzjtyopendate;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.zjty.chzjtyopendate.persistent.ChZjtyOpendateVO;

/**
 * <p>Title: ChZjtyOpendateForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public class ChZjtyOpendateForm extends BaseActionForm {

    private java.lang.String wayid;
    private java.util.Date opendate;
    private java.lang.String memo;

    private String _se_wayid;
    private String _dnm_opendate;
    private String _dnl_opendate;

    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.util.Date getOpendate(){
        return opendate;
    }

    public void setOpendate(java.util.Date opendate){
        this.opendate = opendate;
    }
    public java.lang.String getMemo(){
        return memo;
    }

    public void setMemo(java.lang.String memo){
        this.memo = memo;
    }

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_dnm_opendate(){
        return _dnm_opendate;
    }

    public void set_dnm_opendate(String _dnm_opendate){
        this._dnm_opendate = _dnm_opendate;
    }
    public String get_dnl_opendate(){
        return _dnl_opendate;
    }

    public void set_dnl_opendate(String _dnl_opendate){
        this._dnl_opendate = _dnl_opendate;
    }

}
