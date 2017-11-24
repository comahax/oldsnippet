/**
* auto-generated code
* Thu Jul 28 20:52:00 CST 2011
*/
package com.sunrise.boss.ui.cms.rewardranlog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.rewardranlog.persistent.RewardranlogVO;

/**
 * <p>Title: RewardranlogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RewardranlogForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.String wayid;
    private java.lang.String paccount;
    private java.lang.String raccount;
    private java.lang.Double remark;
    private java.util.Date ptime;
    private java.lang.String calcmonth;
    private java.lang.String memo;
    private java.lang.String opercode;
    private java.util.Date opertime;
    private java.lang.String opertype;

    private String _se_wayid;
    private String _se_paccount;
    private String _se_raccount;
    private String _se_calcmonth;
    private String _se_opercode;
    private String _se_opertype;

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
    public java.lang.String getPaccount(){
        return paccount;
    }

    public void setPaccount(java.lang.String paccount){
        this.paccount = paccount;
    }
    public java.lang.String getRaccount(){
        return raccount;
    }

    public void setRaccount(java.lang.String raccount){
        this.raccount = raccount;
    }
    public java.lang.Double getRemark(){
        return remark;
    }

    public void setRemark(java.lang.Double remark){
        this.remark = remark;
    }
    public java.util.Date getPtime(){
        return ptime;
    }

    public void setPtime(java.util.Date ptime){
        this.ptime = ptime;
    }
    public java.lang.String getCalcmonth(){
        return calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth){
        this.calcmonth = calcmonth;
    }
    public java.lang.String getMemo(){
        return memo;
    }

    public void setMemo(java.lang.String memo){
        this.memo = memo;
    }
    public java.lang.String getOpercode(){
        return opercode;
    }

    public void setOpercode(java.lang.String opercode){
        this.opercode = opercode;
    }
    public java.util.Date getOpertime(){
        return opertime;
    }

    public void setOpertime(java.util.Date opertime){
        this.opertime = opertime;
    }
    public java.lang.String getOpertype(){
        return opertype;
    }

    public void setOpertype(java.lang.String opertype){
        this.opertype = opertype;
    }

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_paccount(){
        return _se_paccount;
    }

    public void set_se_paccount(String _se_paccount){
        this._se_paccount = _se_paccount;
    }
    public String get_se_raccount(){
        return _se_raccount;
    }

    public void set_se_raccount(String _se_raccount){
        this._se_raccount = _se_raccount;
    }
    public String get_se_calcmonth(){
        return _se_calcmonth;
    }

    public void set_se_calcmonth(String _se_calcmonth){
        this._se_calcmonth = _se_calcmonth;
    }
    public String get_se_opercode(){
        return _se_opercode;
    }

    public void set_se_opercode(String _se_opercode){
        this._se_opercode = _se_opercode;
    }
    public String get_se_opertype(){
        return _se_opertype;
    }

    public void set_se_opertype(String _se_opertype){
        this._se_opertype = _se_opertype;
    }

}
