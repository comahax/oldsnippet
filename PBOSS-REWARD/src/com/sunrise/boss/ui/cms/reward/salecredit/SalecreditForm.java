/**
* auto-generated code
* Tue May 17 15:57:34 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.salecredit;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.salecredit.persistent.SalecreditVO;

/**
 * <p>Title: SalecreditForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class SalecreditForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.String wayid;
    private java.lang.String calcmonth;
    private java.lang.Long busitype;
    private java.lang.Double creditaccount;
    private java.lang.Double busivalue;
    private java.lang.Double creditstd;

    private String _se_wayid;
    private String _ne_busitype;

    public java.lang.Long getSeq(){
        return seq;
    }

    public void setSeq(java.lang.Long seq){
        this.seq = seq;
    }
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.String getCalcmonth(){
        return calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth){
        this.calcmonth = calcmonth;
    }
    public java.lang.Long getBusitype(){
        return busitype;
    }

    public void setBusitype(java.lang.Long busitype){
        this.busitype = busitype;
    }
    public java.lang.Double getCreditaccount(){
        return creditaccount;
    }

    public void setCreditaccount(java.lang.Double creditaccount){
        this.creditaccount = creditaccount;
    }
    public java.lang.Double getBusivalue(){
        return busivalue;
    }

    public void setBusivalue(java.lang.Double busivalue){
        this.busivalue = busivalue;
    }
    public java.lang.Double getCreditstd(){
        return creditstd;
    }

    public void setCreditstd(java.lang.Double creditstd){
        this.creditstd = creditstd;
    }

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_ne_busitype(){
        return _ne_busitype;
    }

    public void set_ne_busitype(String _ne_busitype){
        this._ne_busitype = _ne_busitype;
    }

}
