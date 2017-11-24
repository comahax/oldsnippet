/**
* auto-generated code
* Wed Sep 04 21:04:55 CST 2013
*/
package com.sunrise.boss.ui.cms.provagent.chpdrewardrecord;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.provagent.chpdrewardrecord.persistent.ChPdRewardrecordVO;

/**
 * <p>Title: ChPdRewardrecordForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdRewardrecordForm extends BaseActionForm {

    private java.lang.Long rewardid;
    private java.lang.String provagentid;
    private java.lang.String prodno;
    private java.lang.String custid;
    private java.lang.String custname;
    private java.lang.String cityid;
    private java.lang.String rewardmonth;
    private java.lang.Double rewardmoney;
    private java.lang.Short phase;
    private java.lang.String feemonth;
    private java.lang.String version;
    private java.lang.String ruledesc;
    private java.util.Date caltime;
    private java.lang.String inbossmonth;
    private java.lang.Long adcrewardid;
    private java.lang.String recalmonth;
    private java.lang.String memo;
    private java.lang.String prodid;
    private java.lang.String prodname;
    private String _se_provagentid;
    private String _se_prodno;
    private String _se_cityid;
    private String _se_rewardmonth;
    private String _se_feemonth;
    private String _se_prodid;
	private boolean query;
    
    
    public java.lang.Long getRewardid(){
        return rewardid;
    }

    public void setRewardid(java.lang.Long rewardid){
        this.rewardid = rewardid;
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
    public java.lang.String getCustid(){
        return custid;
    }

    public void setCustid(java.lang.String custid){
        this.custid = custid;
    }
    public java.lang.String getCustname(){
        return custname;
    }

    public void setCustname(java.lang.String custname){
        this.custname = custname;
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
    public java.lang.Double getRewardmoney(){
        return rewardmoney;
    }

    public void setRewardmoney(java.lang.Double rewardmoney){
        this.rewardmoney = rewardmoney;
    }
    public java.lang.Short getPhase(){
        return phase;
    }

    public void setPhase(java.lang.Short phase){
        this.phase = phase;
    }
    public java.lang.String getFeemonth(){
        return feemonth;
    }

    public void setFeemonth(java.lang.String feemonth){
        this.feemonth = feemonth;
    }
    public java.lang.String getVersion(){
        return version;
    }

    public void setVersion(java.lang.String version){
        this.version = version;
    }
    public java.lang.String getRuledesc(){
        return ruledesc;
    }

    public void setRuledesc(java.lang.String ruledesc){
        this.ruledesc = ruledesc;
    }
    public java.util.Date getCaltime(){
        return caltime;
    }

    public void setCaltime(java.util.Date caltime){
        this.caltime = caltime;
    }
    public java.lang.String getInbossmonth(){
        return inbossmonth;
    }

    public void setInbossmonth(java.lang.String inbossmonth){
        this.inbossmonth = inbossmonth;
    }
    public java.lang.Long getAdcrewardid(){
        return adcrewardid;
    }

    public void setAdcrewardid(java.lang.Long adcrewardid){
        this.adcrewardid = adcrewardid;
    }
    public java.lang.String getRecalmonth(){
        return recalmonth;
    }

    public void setRecalmonth(java.lang.String recalmonth){
        this.recalmonth = recalmonth;
    }
    public java.lang.String getMemo(){
        return memo;
    }

    public void setMemo(java.lang.String memo){
        this.memo = memo;
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
    public String get_se_feemonth(){
        return _se_feemonth;
    }

    public void set_se_feemonth(String _se_feemonth){
        this._se_feemonth = _se_feemonth;
    }

	public java.lang.String getProdid() {
		return prodid;
	}

	public void setProdid(java.lang.String prodid) {
		this.prodid = prodid;
	}

	public java.lang.String getProdname() {
		return prodname;
	}

	public void setProdname(java.lang.String prodname) {
		this.prodname = prodname;
	}

	public String get_se_prodid() {
		return _se_prodid;
	}

	public void set_se_prodid(String _se_prodid) {
		this._se_prodid = _se_prodid;
	}
	public boolean isQuery() {
		return query;
	}

	public void setQuery(boolean query) {
		this.query = query;
	}
}
