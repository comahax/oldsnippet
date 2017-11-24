/**
* auto-generated code
* Thu Feb 16 10:30:46 CST 2012
*/
package com.sunrise.boss.ui.cms.reward.salepointflag;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.salepointflag.persistent.SalepointflagVO;

/**
 * <p>Title: SalepointflagForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class SalepointflagForm extends BaseActionForm {

    private java.lang.String flag;
    private java.lang.String flagname;
    private java.lang.String cityid;

    private String _se_flag;
    private String _se_cityid;

    public java.lang.String getFlag(){
        return flag;
    }

    public void setFlag(java.lang.String flag){
        this.flag = flag;
    }
    public java.lang.String getFlagname(){
        return flagname;
    }

    public void setFlagname(java.lang.String flagname){
        this.flagname = flagname;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }

    public String get_se_flag(){
        return _se_flag;
    }

    public void set_se_flag(String _se_flag){
        this._se_flag = _se_flag;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }

}
