/**
* auto-generated code
* Wed Dec 07 09:27:39 CST 2011
*/
package com.sunrise.boss.ui.cms.bbc.blacklist;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.bbc.blacklist.persistent.BlacklistVO;

/**
 * <p>Title: BlacklistForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class BlacklistForm extends BaseActionForm {

    private java.lang.String name;
    private java.lang.String mobile;
    private java.lang.String filtertype;
    private java.util.Date starttime;
    private java.util.Date endtime;

    private String _se_mobile;

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

    public String get_se_mobile(){
        return _se_mobile;
    }

    public void set_se_mobile(String _se_mobile){
        this._se_mobile = _se_mobile;
    }

}
