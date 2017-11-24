/**
* auto-generated code
* Tue Nov 22 15:32:38 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.ywjfjlmxb;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.ywjfjlmxb.persistent.YwjfjlmxbVO;

/**
 * <p>Title: YwjfjlmxbForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class YwjfjlmxbForm extends BaseActionForm {

	
    private java.lang.String wayid;
    private java.lang.String countycompid;
    private java.lang.String wayname;
    private java.lang.String chainhead;
    private java.lang.String countycompname;
    private java.lang.Short starlevel;
    private java.lang.String calcmonth;
    private java.lang.String flag;
    private java.lang.Double busivalue;
    private java.lang.Double creditaccount;
    private java.lang.Double paysum;
    private java.lang.Double creditstd;
    
    private String _se_wayid;
    private String _se_calcmonth;
    
    //CH_ADT_SALEPOINTFLAG中的 flag 命名为flag1
    private String _se_flag;

    public java.lang.Double getCreditstd() {
		return creditstd;
	}

	public void setCreditstd(java.lang.Double creditstd) {
		this.creditstd = creditstd;
	}

	public String get_se_flag() {
		return _se_flag;
	}

	public void set_se_flag(String _se_flag) {
		this._se_flag = _se_flag;
	}

	public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
   
    public java.lang.String getCountycompid() {
		return countycompid;
	}

	public void setCountycompid(java.lang.String countycompid) {
		this.countycompid = countycompid;
	}

	public java.lang.String getWayname(){
        return wayname;
    }

    public void setWayname(java.lang.String wayname){
        this.wayname = wayname;
    }
    public java.lang.String getChainhead(){
        return chainhead;
    }

    public void setChainhead(java.lang.String chainhead){
        this.chainhead = chainhead;
    }
    public java.lang.String getCountycompname(){
        return countycompname;
    }

    public void setCountycompname(java.lang.String countycompname){
        this.countycompname = countycompname;
    }
    public java.lang.Short getStarlevel(){
        return starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel){
        this.starlevel = starlevel;
    }
    public java.lang.String getCalcmonth(){
        return calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth){
        this.calcmonth = calcmonth;
    }
    public java.lang.String getFlag(){
        return flag;
    }

    public void setFlag(java.lang.String flag){
        this.flag = flag;
    }
    public java.lang.Double getBusivalue(){
        return busivalue;
    }

    public void setBusivalue(java.lang.Double busivalue){
        this.busivalue = busivalue;
    }
    public java.lang.Double getCreditaccount(){
        return creditaccount;
    }

    public void setCreditaccount(java.lang.Double creditaccount){
        this.creditaccount = creditaccount;
    }
    public java.lang.Double getPaysum(){
        return paysum;
    }

    public void setPaysum(java.lang.Double paysum){
        this.paysum = paysum;
    }

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_calcmonth(){
        return _se_calcmonth;
    }

    public void set_se_calcmonth(String _se_calcmonth){
        this._se_calcmonth = _se_calcmonth;
    }

}
