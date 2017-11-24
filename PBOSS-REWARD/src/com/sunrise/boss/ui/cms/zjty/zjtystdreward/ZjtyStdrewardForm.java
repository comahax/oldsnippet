/**
* auto-generated code
* Fri Dec 30 15:15:14 CST 2011
*/
package com.sunrise.boss.ui.cms.zjty.zjtystdreward;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.zjty.zjtystdreward.persistent.ZjtyStdrewardVO;

/**
 * <p>Title: ZjtyStdrewardForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyStdrewardForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.String opnid;
    private java.lang.Short cityid;
    private java.lang.Double rewardstd;
    private java.lang.Short intvmonth;
    private java.lang.String ruleid;
    private java.lang.Short rewardtype;
    private java.util.Date startdate;
    private java.util.Date enddate;
    private java.lang.Short rewardid;
    private java.lang.Short acctype;

    private String _ne_seq;
    private String _se_opnid;
    private String _ne_cityid;

    public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }
    public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.Short getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.Short cityid){
        this.cityid = cityid;
    }
    public java.lang.Double getRewardstd(){
        return rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd){
        this.rewardstd = rewardstd;
    }
    public java.lang.Short getIntvmonth(){
        return intvmonth;
    }

    public void setIntvmonth(java.lang.Short intvmonth){
        this.intvmonth = intvmonth;
    }
    public java.lang.String getRuleid(){
        return ruleid;
    }

    public void setRuleid(java.lang.String ruleid){
        this.ruleid = ruleid;
    }
    public java.lang.Short getRewardtype(){
        return rewardtype;
    }

    public void setRewardtype(java.lang.Short rewardtype){
        this.rewardtype = rewardtype;
    }
    public java.util.Date getStartdate(){
        return startdate;
    }

    public void setStartdate(java.util.Date startdate){
        this.startdate = startdate;
    }
    public java.util.Date getEnddate(){
        return enddate;
    }

    public void setEnddate(java.util.Date enddate){
        this.enddate = enddate;
    }

    public String get_ne_seq(){
        return _ne_seq;
    }

    public void set_ne_seq(String _ne_seq){
        this._ne_seq = _ne_seq;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_ne_cityid(){
        return _ne_cityid;
    }

    public void set_ne_cityid(String _ne_cityid){
        this._ne_cityid = _ne_cityid;
    }

}
