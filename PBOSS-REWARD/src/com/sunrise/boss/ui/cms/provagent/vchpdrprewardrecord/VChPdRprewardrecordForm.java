/**
* auto-generated code
* Wed Sep 04 21:16:54 CST 2013
*/
package com.sunrise.boss.ui.cms.provagent.vchpdrprewardrecord;

import com.sunrise.boss.ui.base.BaseActionForm; 

/**
 * <p>Title: ChPdRprewardrecordForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class VChPdRprewardrecordForm extends BaseActionForm {

    private java.lang.Long rpseqid;
    private java.lang.String provagentid;
    private java.lang.String prodno;
    private java.lang.String rewardmonth;
    private java.lang.Short phase;
    private java.lang.String cityid;
    private java.lang.Double rpmoney;
    private java.lang.Long adcrewardid;

    private String _se_provagentid;
    private String _se_prodno;
    private String _se_rewardmonth;
    private String _se_cityid;
    private String _se_prodid;
    private boolean query;
    public java.lang.Long getRpseqid(){
        return rpseqid;
    }

    public void setRpseqid(java.lang.Long rpseqid){
        this.rpseqid = rpseqid;
    }
    public java.lang.String getProvagentid(){
        return provagentid;
    }

    public void setProvagentid(java.lang.String provagentid){
        this.provagentid = provagentid;
    }
    public java.lang.String getProdno(){
        return prodno;
    }

    public void setProdno(java.lang.String prodno){
        this.prodno = prodno;
    }
    public java.lang.String getRewardmonth(){
        return rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth){
        this.rewardmonth = rewardmonth;
    }
    public java.lang.Short getPhase(){
        return phase;
    }

    public void setPhase(java.lang.Short phase){
        this.phase = phase;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.Double getRpmoney(){
        return rpmoney;
    }

    public void setRpmoney(java.lang.Double rpmoney){
        this.rpmoney = rpmoney;
    }
    public java.lang.Long getAdcrewardid(){
        return adcrewardid;
    }

    public void setAdcrewardid(java.lang.Long adcrewardid){
        this.adcrewardid = adcrewardid;
    }

    public String get_se_provagentid(){
        return _se_provagentid;
    }

    public void set_se_provagentid(String _se_provagentid){
        this._se_provagentid = _se_provagentid;
    }
    public String get_se_prodno(){
        return _se_prodno;
    }

    public void set_se_prodno(String _se_prodno){
        this._se_prodno = _se_prodno;
    }
    public String get_se_rewardmonth(){
        return _se_rewardmonth;
    }

    public void set_se_rewardmonth(String _se_rewardmonth){
        this._se_rewardmonth = _se_rewardmonth;
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

	public String get_se_prodid() {
		return _se_prodid;
	}

	public void set_se_prodid(String _se_prodid) {
		this._se_prodid = _se_prodid;
	}

}
