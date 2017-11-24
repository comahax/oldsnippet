/**
* auto-generated code
* Wed Sep 04 16:18:46 CST 2013
*/
package com.sunrise.boss.ui.cms.provagent.chpdreportitem;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.provagent.chpdreportitem.persistent.ChPdReportitemVO;

/**
 * <p>Title: ChPdReportitemForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdReportitemForm extends BaseActionForm {

    private java.lang.Long itemid;
    private java.lang.String rewardmonth;
    private java.lang.String provagentid;
    private java.lang.String cityid;
    private java.lang.String columncode;
    private java.lang.String columnname;
    private java.lang.Double rewardsum;

    private String _se_rewardmonth;
    private String _se_provagentid;
    private String _se_cityid;
    
    private boolean query;

    public java.lang.Long getItemid(){
        return itemid;
    }

    public void setItemid(java.lang.Long itemid){
        this.itemid = itemid;
    }
    public java.lang.String getRewardmonth(){
        return rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth){
        this.rewardmonth = rewardmonth;
    }
    public java.lang.String getProvagentid(){
        return provagentid;
    }

    public void setProvagentid(java.lang.String provagentid){
        this.provagentid = provagentid;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.String getColumncode(){
        return columncode;
    }

    public void setColumncode(java.lang.String columncode){
        this.columncode = columncode;
    }
    public java.lang.String getColumnname(){
        return columnname;
    }

    public void setColumnname(java.lang.String columnname){
        this.columnname = columnname;
    }
    public java.lang.Double getRewardsum(){
        return rewardsum;
    }

    public void setRewardsum(java.lang.Double rewardsum){
        this.rewardsum = rewardsum;
    }

    public String get_se_rewardmonth(){
        return _se_rewardmonth;
    }

    public void set_se_rewardmonth(String _se_rewardmonth){
        this._se_rewardmonth = _se_rewardmonth;
    }
    public String get_se_provagentid(){
        return _se_provagentid;
    }

    public void set_se_provagentid(String _se_provagentid){
        this._se_provagentid = _se_provagentid;
    }
    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
    }

	public boolean isQuery() {
		return query;
	}

	public void setQuery(boolean query) {
		this.query = query;
	}

}
