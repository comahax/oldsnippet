/**
* auto-generated code
* Sat Mar 09 12:10:11 CST 2013
*/
package com.sunrise.boss.ui.cms.zjty.chzjtylocalperconfigtotal;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: ChZjtyLocalperconfigtotalForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ChZjtyLocalperconfigtotalForm extends BaseActionForm {

    private java.lang.Long recid;
    private java.lang.String wayname;
    private java.lang.String companytype;
    private java.lang.String cityid;
    private java.lang.String zjtyname;
    private java.util.Date connecttime;
    private java.lang.Long total;
    private java.lang.String rewardreporttime;

    private String _ne_recid;
    private String _sk_cityid;
    private String _se_rewardreporttime;

    private boolean query;

    public java.lang.Long getRecid(){
        return recid;
    }

    public void setRecid(java.lang.Long recid){
        this.recid = recid;
    }
    public java.lang.String getWayname(){
        return wayname;
    }

    public void setWayname(java.lang.String wayname){
        this.wayname = wayname;
    }
    public java.lang.String getCompanytype(){
        return companytype;
    }

    public void setCompanytype(java.lang.String companytype){
        this.companytype = companytype;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.String getZjtyname(){
        return zjtyname;
    }

    public void setZjtyname(java.lang.String zjtyname){
        this.zjtyname = zjtyname;
    }
    public java.util.Date getConnecttime(){
        return connecttime;
    }

    public void setConnecttime(java.util.Date connecttime){
        this.connecttime = connecttime;
    }
    public java.lang.Long getTotal(){
        return total;
    }

    public void setTotal(java.lang.Long total){
        this.total = total;
    }
    public java.lang.String getRewardreporttime(){
        return rewardreporttime;
    }

    public void setRewardreporttime(java.lang.String rewardreporttime){
        this.rewardreporttime = rewardreporttime;
    }

    public String get_ne_recid(){
        return _ne_recid;
    }

    public void set_ne_recid(String _ne_recid){
        this._ne_recid = _ne_recid;
    }
    public String get_sk_cityid(){
        return _sk_cityid;
    }

    public void set_sk_cityid(String _sk_cityid){
        this._sk_cityid = _sk_cityid;
    }
    public String get_se_rewardreporttime(){
        return _se_rewardreporttime;
    }

    public void set_se_rewardreporttime(String _se_rewardreporttime){
        this._se_rewardreporttime = _se_rewardreporttime;
    }

	public boolean isQuery() {
		return query;
	}

	public void setQuery(boolean query) {
		this.query = query;
	}

}
