/**
* auto-generated code
* Thu Dec 01 14:14:15 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.assessinfo;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.assessinfo.persistent.AssessinfoVO;

/**
 * <p>Title: AssessinfoForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class AssessinfoForm extends BaseActionForm {

    private java.lang.Long seqid;
    private java.lang.String cityid;
    private java.lang.String asseremark;
    private java.lang.Short type;

    private String _se_cityid;
    private String _ne_type;

    public java.lang.Long getSeqid(){
        return seqid;
    }

    public void setSeqid(java.lang.Long seqid){
        this.seqid = seqid;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.String getAsseremark(){
        return asseremark;
    }

    public void setAsseremark(java.lang.String asseremark){
        this.asseremark = asseremark;
    }
    public java.lang.Short getType(){
        return type;
    }

    public void setType(java.lang.Short type){
        this.type = type;
    }

    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }
    public String get_ne_type(){
        return _ne_type;
    }

    public void set_ne_type(String _ne_type){
        this._ne_type = _ne_type;
    }

}
