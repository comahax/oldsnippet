/**
* auto-generated code
* Thu Jul 28 10:25:58 CST 2011
*/
package com.sunrise.boss.ui.cms.rewardsms;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.rewardsms.persistent.RewardsmsVO;

/**
 * <p>Title: RewardsmsForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RewardsmsForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.String countyid;
    private java.util.Date sendtime;
    private java.lang.String calcmonth;
    private java.lang.String opercode;
    private java.lang.String opertype;
    private java.util.Date opertime;

    private String _se_countyid;
    private String _se_calcmonth;
    private String _se_opercode;
    private String _se_opertype;
    private String officetel;

    public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }
    public java.lang.String getCountyid(){
        return countyid;
    }

    public void setCountyid(java.lang.String countyid){
        this.countyid = countyid;
    }
    public java.util.Date getSendtime(){
        return sendtime;
    }

    public void setSendtime(java.util.Date sendtime){
        this.sendtime = sendtime;
    }
    public java.lang.String getCalcmonth(){
        return calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth){
        this.calcmonth = calcmonth;
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

    public String get_se_countyid(){
        return _se_countyid;
    }

    public void set_se_countyid(String _se_countyid){
        this._se_countyid = _se_countyid;
    }
    public String get_se_calcmonth(){
        return _se_calcmonth;
    }

    public void set_se_calcmonth(String _se_calcmonth){
        this._se_calcmonth = _se_calcmonth;
    }
    public String get_se_opercode(){
        return _se_opercode;
    }

    public void set_se_opercode(String _se_opercode){
        this._se_opercode = _se_opercode;
    }
    public String get_se_opertype(){
        return _se_opertype;
    }

    public void set_se_opertype(String _se_opertype){
        this._se_opertype = _se_opertype;
    }

	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}

}
