/**
* auto-generated code
* Mon Jan 14 14:13:07 CST 2013
*/
package com.sunrise.boss.ui.cms.chadtsales;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.chadtsales.persistent.ChAdtSalesVO;

/**
 * <p>Title: ChAdtSalesForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtSalesForm extends BaseActionForm {

    private java.lang.Short cityid;
    private java.lang.String opnid;
    private java.lang.String wayattr;
    private java.lang.Long sales;
    private java.lang.Double rewardstd;

    private String _se_opnid;
    private String _se_wayattr;

    public java.lang.Short getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.Short cityid){
        this.cityid = cityid;
    }
    public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.String getWayattr(){
        return wayattr;
    }

    public void setWayattr(java.lang.String wayattr){
        this.wayattr = wayattr;
    }
    public java.lang.Long getSales(){
        return sales;
    }

    public void setSales(java.lang.Long sales){
        this.sales = sales;
    }
    public java.lang.Double getRewardstd(){
        return rewardstd;
    }

    public void setRewardstd(java.lang.Double rewardstd){
        this.rewardstd = rewardstd;
    }

    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_se_wayattr(){
        return _se_wayattr;
    }

    public void set_se_wayattr(String _se_wayattr){
        this._se_wayattr = _se_wayattr;
    }

}
