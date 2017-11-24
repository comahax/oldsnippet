/**
* auto-generated code
* Fri Feb 13 16:49:58 CST 2009
*/
package com.sunrise.boss.ui.cms.zjty.chzjtyempltotal;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.zjty.chzjtyempltotal.persistent.ChZjtyEmpltotalVO;

/**
 * <p>Title: ChZjtyEmpltotalForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public class ChZjtyEmpltotalForm extends BaseActionForm {

    private java.lang.String yearmonth;
    private java.lang.String wayid;
    private java.lang.Double amount;
    private java.lang.String memo;

    private String _snm_yearmonth;
    private String _snl_yearmonth;
    private String _se_wayid;

    public java.lang.String getYearmonth(){
        return yearmonth;
    }

    public void setYearmonth(java.lang.String yearmonth){
        this.yearmonth = yearmonth;
    }
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.Double getAmount(){
        return amount;
    }

    public void setAmount(java.lang.Double amount){
        this.amount = amount;
    }
    public java.lang.String getMemo(){
        return memo;
    }

    public void setMemo(java.lang.String memo){
        this.memo = memo;
    }

    public String get_snm_yearmonth(){
        return _snm_yearmonth;
    }

    public void set_snm_yearmonth(String _snm_yearmonth){
        this._snm_yearmonth = _snm_yearmonth;
    }
    public String get_snl_yearmonth(){
        return _snl_yearmonth;
    }

    public void set_snl_yearmonth(String _snl_yearmonth){
        this._snl_yearmonth = _snl_yearmonth;
    }

	public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

}
