/**
* auto-generated code
* Fri Jul 08 11:36:28 CST 2011
*/
package com.sunrise.boss.ui.cms.waystrarewardstd;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.waystrarewardstd.persistent.WaystrarewardstdVO;

/**
 * <p>Title: WaystrarewardstdForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class WaystrarewardstdForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.String wayid;
    private java.lang.Short cityid;
    private java.lang.Double rewardstd;
    private java.lang.Long rewardtype;
    private java.lang.String remark;
    private java.lang.String opercode;
    private java.lang.String opertype;
    private java.util.Date opertime;

    private String _ne_cityid;
    private String _ne_rewardtype;
    private String _se_wayid;

    
    
    public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

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
    public java.lang.Long getRewardtype(){
        return rewardtype;
    }

    public void setRewardtype(java.lang.Long rewardtype){
        this.rewardtype = rewardtype;
    }
    public java.lang.String getRemark(){
        return remark;
    }

    public void setRemark(java.lang.String remark){
        this.remark = remark;
    }
    public java.lang.String getOpercode(){
        return opercode;
    }

    public void setOpercode(java.lang.String opercode){
        this.opercode = opercode;
    }
    public java.lang.String getOpertype(){
        return opertype;
    }

    public void setOpertype(java.lang.String opertype){
        this.opertype = opertype;
    }
    public java.util.Date getOpertime(){
        return opertime;
    }

    public void setOpertime(java.util.Date opertime){
        this.opertime = opertime;
    }

    public String get_ne_cityid(){
        return _ne_cityid;
    }

    public void set_ne_cityid(String _ne_cityid){
        this._ne_cityid = _ne_cityid;
    }
    public String get_ne_rewardtype(){
        return _ne_rewardtype;
    }

    public void set_ne_rewardtype(String _ne_rewardtype){
        this._ne_rewardtype = _ne_rewardtype;
    }

}
