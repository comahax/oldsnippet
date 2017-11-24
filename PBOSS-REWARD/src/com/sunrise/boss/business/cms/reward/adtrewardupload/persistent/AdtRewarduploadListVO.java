/**
* auto-generated code
* Thu Mar 15 15:06:14 CST 2012
*/
package com.sunrise.boss.business.cms.reward.adtrewardupload.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: AdtRewarduploadListVO</p>
 * <p>Description: Query Params Object for AdtRewarduploadDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Qiu Zhi
 * @version 1.0
 */
public class AdtRewarduploadListVO extends BaseListVO {
    private String _ne_taskid;
    private String _ne_taskstate;
    private String _se_oprcode;
    private String _dnm_uploadtime;
    private String _dnl_uploadtime;
    private String _se_mobile;

    public String get_ne_taskid(){
        return _ne_taskid;
    }

    public void set_ne_taskid(String _ne_taskid){
        this._ne_taskid = _ne_taskid;
    }
    public String get_ne_taskstate(){
        return _ne_taskstate;
    }

    public void set_ne_taskstate(String _ne_taskstate){
        this._ne_taskstate = _ne_taskstate;
    }
    public String get_se_oprcode(){
        return _se_oprcode;
    }

    public void set_se_oprcode(String _se_oprcode){
        this._se_oprcode = _se_oprcode;
    }
    public String get_dnm_uploadtime(){
        return _dnm_uploadtime;
    }

    public void set_dnm_uploadtime(String _dnm_uploadtime){
        this._dnm_uploadtime = _dnm_uploadtime;
    }
    public String get_dnl_uploadtime(){
        return _dnl_uploadtime;
    }

    public void set_dnl_uploadtime(String _dnl_uploadtime){
        this._dnl_uploadtime = _dnl_uploadtime;
    }
    public String get_se_mobile(){
        return _se_mobile;
    }

    public void set_se_mobile(String _se_mobile){
        this._se_mobile = _se_mobile;
    }

}
