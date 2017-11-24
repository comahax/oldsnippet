/**
* auto-generated code
* Mon Aug 11 11:30:37 CST 2014
*/
package com.sunrise.boss.ui.cms.chbbcmarketact;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.chbbcmarketact.persistent.ChBbcMarketactVO;

/**
 * <p>Title: ChBbcMarketactForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author hejw
 * @version 1.0
 */
public class ChBbcMarketactForm extends BaseActionForm {

    private java.lang.String opnid;
    private java.lang.String cityid;
    private java.lang.String rewardmonth;
    private java.lang.String acttype;
    private java.lang.String actprofile;
    private java.util.Date updatetime;
    private java.lang.String remark;

    private String[] _selectopnid;

    private String _se_opnid;
    private String _sne_opnid;
    private String _se_cityid;
    private String _se_rewardmonth;

    public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.String getRewardmonth(){
        return rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth){
        this.rewardmonth = rewardmonth;
    }
    public java.lang.String getActtype(){
        return acttype;
    }

    public void setActtype(java.lang.String acttype){
        this.acttype = acttype;
    }
    public java.lang.String getActprofile(){
        return actprofile;
    }

    public void setActprofile(java.lang.String actprofile){
        this.actprofile = actprofile;
    }
    public java.util.Date getUpdatetime(){
        return updatetime;
    }

    public void setUpdatetime(java.util.Date updatetime){
        this.updatetime = updatetime;
    }
    public java.lang.String getRemark(){
        return remark;
    }

    public void setRemark(java.lang.String remark){
        this.remark = remark;
    }

    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_sne_opnid(){
        return _sne_opnid;
    }

    public void set_sne_opnid(String _sne_opnid){
        this._sne_opnid = _sne_opnid;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }
    public String get_se_rewardmonth(){
        return _se_rewardmonth;
    }

    public void set_se_rewardmonth(String _se_rewardmonth){
        this._se_rewardmonth = _se_rewardmonth;
    }

	public String[] get_selectopnid() {
		return _selectopnid;
	}

	public void set_selectopnid(String[] _selectopnid) {
		this._selectopnid = _selectopnid;
	}

}
