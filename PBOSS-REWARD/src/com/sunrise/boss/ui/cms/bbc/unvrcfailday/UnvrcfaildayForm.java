/**
* auto-generated code
* Wed Dec 07 14:34:03 CST 2011
*/
package com.sunrise.boss.ui.cms.bbc.unvrcfailday;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.bbc.unvrcfailday.persistent.UnvrcfaildayVO;

/**
 * <p>Title: UnvrcfaildayForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class UnvrcfaildayForm extends BaseActionForm {

    private java.lang.Long failid;
    private java.lang.String rcno;
    private java.lang.String mobileno;
    private java.lang.String opnid;
    private java.lang.String rcmonth;
    private java.util.Date rcdate;
    private java.lang.String reason;
    private java.lang.Short ossrc;
    private java.lang.String wayid;
    private java.lang.String src;
//    private java.lang.String wayname;
//    private java.lang.Short empattr2;    

	private String _se_rcno;
    private String _se_opnid;
    private String _dnm_rcdate;
    private String _dnl_rcdate;
    private String _se_wayid;
    private String _ne_empattr2;
    private String _sk_opnname;

    public String get_ne_empattr2() {
		return _ne_empattr2;
	}

	public void set_ne_empattr2(String _ne_empattr2) {
		this._ne_empattr2 = _ne_empattr2;
	}

	public String get_sk_opnname() {
		return _sk_opnname;
	}

	public void set_sk_opnname(String _sk_opnname) {
		this._sk_opnname = _sk_opnname;
	}

	public java.lang.Long getFailid(){
        return failid;
    }

    public void setFailid(java.lang.Long failid){
        this.failid = failid;
    }
    public java.lang.String getRcno(){
        return rcno;
    }

    public void setRcno(java.lang.String rcno){
        this.rcno = rcno;
    }
    public java.lang.String getMobileno(){
        return mobileno;
    }

    public void setMobileno(java.lang.String mobileno){
        this.mobileno = mobileno;
    }
    public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.String getRcmonth(){
        return rcmonth;
    }

    public void setRcmonth(java.lang.String rcmonth){
        this.rcmonth = rcmonth;
    }
    public java.util.Date getRcdate(){
        return rcdate;
    }

    public void setRcdate(java.util.Date rcdate){
        this.rcdate = rcdate;
    }
    public java.lang.String getReason(){
        return reason;
    }

    public void setReason(java.lang.String reason){
        this.reason = reason;
    }
    public java.lang.Short getOssrc(){
        return ossrc;
    }

    public void setOssrc(java.lang.Short ossrc){
        this.ossrc = ossrc;
    }
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.String getSrc(){
        return src;
    }

    public void setSrc(java.lang.String src){
        this.src = src;
    }

    public String get_se_rcno(){
        return _se_rcno;
    }

    public void set_se_rcno(String _se_rcno){
        this._se_rcno = _se_rcno;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_dnm_rcdate(){
        return _dnm_rcdate;
    }

    public void set_dnm_rcdate(String _dnm_rcdate){
        this._dnm_rcdate = _dnm_rcdate;
    }
    public String get_dnl_rcdate(){
        return _dnl_rcdate;
    }

    public void set_dnl_rcdate(String _dnl_rcdate){
        this._dnl_rcdate = _dnl_rcdate;
    }
    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    
//    public java.lang.String getWayname() {
//		return wayname;
//	}
//
//	public void setWayname(java.lang.String wayname) {
//		this.wayname = wayname;
//	}
//
//	public java.lang.Short getEmpattr2() {
//		return empattr2;
//	}
//
//	public void setEmpattr2(java.lang.Short empattr2) {
//		this.empattr2 = empattr2;
//	}

}
