/**
* auto-generated code
* Wed Sep 04 21:22:46 CST 2013
*/
package com.sunrise.boss.ui.cms.provagent.chpdrewardadc;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.provagent.chpdrewardadc.persistent.ChPdRewardadcVO;

/**
 * <p>Title: ChPdRewardadcForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liyanling
 * @version 1.0
 */
public class ChPdRewardadcForm extends BaseActionForm {

    private java.lang.Long rewardid;
    private java.lang.String cityid;
    private java.lang.String provagentid;
    private java.lang.String prodid;
    private java.lang.String custid;
    private java.lang.String custname;
    private java.lang.String prodno;
    private java.lang.Double rewardmoney;
    private java.lang.Short phase;
    private java.lang.Double supplemoney;
    private java.lang.Double rpmoney;
    private java.lang.String inbossmonth;
    private java.lang.String rewardmonth;
    private java.lang.String reason;
    private java.lang.String version;
    private java.lang.String ruledesc;
    private java.lang.Byte isreleaseadc;

    private String _se_cityid;
    private String _se_provagentid;
    private String _se_prodno;
    private String _se_rewardmonth;
    private String _ne_isreleaseadc;
    private boolean query;
    private String _se_prodid;

    public java.lang.Long getRewardid(){
        return rewardid;
    }

    public void setRewardid(java.lang.Long rewardid){
        this.rewardid = rewardid;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.String getProvagentid(){
        return provagentid;
    }

    public void setProvagentid(java.lang.String provagentid){
        this.provagentid = provagentid;
    }
    public java.lang.String getProdid(){
        return prodid;
    }

    public void setProdid(java.lang.String prodid){
        this.prodid = prodid;
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
    public java.lang.String getProdno(){
        return prodno;
    }

    public void setProdno(java.lang.String prodno){
        this.prodno = prodno;
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
    public java.lang.Double getSupplemoney(){
        return supplemoney;
    }

    public void setSupplemoney(java.lang.Double supplemoney){
        this.supplemoney = supplemoney;
    }
    public java.lang.Double getRpmoney(){
        return rpmoney;
    }

    public void setRpmoney(java.lang.Double rpmoney){
        this.rpmoney = rpmoney;
    }
    public java.lang.String getInbossmonth(){
        return inbossmonth;
    }

    public void setInbossmonth(java.lang.String inbossmonth){
        this.inbossmonth = inbossmonth;
    }
    public java.lang.String getRewardmonth(){
        return rewardmonth;
    }

    public void setRewardmonth(java.lang.String rewardmonth){
        this.rewardmonth = rewardmonth;
    }
    public java.lang.String getReason(){
        return reason;
    }

    public void setReason(java.lang.String reason){
        this.reason = reason;
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
    public java.lang.Byte getIsreleaseadc(){
        return isreleaseadc;
    }

    public void setIsreleaseadc(java.lang.Byte isreleaseadc){
        this.isreleaseadc = isreleaseadc;
    }

    public String get_se_cityid(){
        return _se_cityid;
    }

    public void set_se_cityid(String _se_cityid){
        this._se_cityid = _se_cityid;
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
    public String get_ne_isreleaseadc(){
        return _ne_isreleaseadc;
    }

    public void set_ne_isreleaseadc(String _ne_isreleaseadc){
        this._ne_isreleaseadc = _ne_isreleaseadc;
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
