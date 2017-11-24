/**
* auto-generated code
* Thu Dec 24 14:22:12 CST 2009
*/
package com.sunrise.boss.ui.cms.zjty.zjtycompcoef;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.zjty.zjtycompcoef.persistent.ZjtyCompcoefVO;

/**
 * <p>Title: ZjtyCompcoefForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author LiZhaoLiang
 * @version 1.0
 */
public class ZjtyCompcoefForm extends BaseActionForm {

    private java.lang.String wayid;
    private java.lang.Float compcoef;

    private String _se_wayid;

    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.Float getCompcoef(){
        return compcoef;
    }

    public void setCompcoef(java.lang.Float compcoef){
        this.compcoef = compcoef;
    }

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }

}
