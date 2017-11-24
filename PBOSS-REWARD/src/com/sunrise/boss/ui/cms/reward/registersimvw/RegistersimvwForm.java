/**
* auto-generated code
* Mon Feb 21 10:20:07 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.registersimvw;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.registersimvw.persistent.RegistersimvwVO;

/**
 * <p>Title: RegistersimvwForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yangdaren
 * @version 1.0
 */
public class RegistersimvwForm extends BaseActionForm {

    private java.lang.Long seqid;
    private java.lang.String wayid;
    private java.lang.String wayname;
    private java.lang.String waymagcode;
    private java.lang.String countyid;
    private java.lang.Short starlevel;
    private java.lang.String svccode;
    private java.lang.String employeeid;
    private java.lang.String employeename;
    private java.lang.String name;
    private java.lang.String oprcode;
    private java.lang.String officetel;
    private java.lang.String mobile;
    private java.lang.Short brand;
    private java.lang.String opnid;
    private java.util.Date oprtime;
    private java.util.Date activedate;
    private java.lang.Short comclassid;
    private java.lang.Long comprice;
    private java.lang.Short mendfalg;

    //add by liuchao 20111128
    private java.lang.Short comtype;
    private java.lang.String comname;
   
    private String _se_wayid;
    private String _se_waymagcode;
    private String _se_countyid;
    private String _ne_starlevel;
    private String _se_svccode;
    private String _se_employeeid;
    private String _se_oprcode;
    private String _ne_brand;
    private String _se_opnid;
    private String _dnm_oprtime;
    private String _dnl_oprtime;
    private String _dnm_activedate;
    private String _dnl_activedate;
    private String _ne_comclassid;
    private String _se_mobile;
    private String _ne_mendfalg;

    public java.lang.Short getComtype() {
		return comtype;
	}

	public void setComtype(java.lang.Short comtype) {
		this.comtype = comtype;
	}

	public java.lang.String getComname() {
		return comname;
	}

	public void setComname(java.lang.String comname) {
		this.comname = comname;
	}

	public java.lang.Long getSeqid(){
        return seqid;
    }

    public void setSeqid(java.lang.Long seqid){
        this.seqid = seqid;
    }
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.String getWayname(){
        return wayname;
    }

    public void setWayname(java.lang.String wayname){
        this.wayname = wayname;
    }
    public java.lang.String getWaymagcode(){
        return waymagcode;
    }

    public void setWaymagcode(java.lang.String waymagcode){
        this.waymagcode = waymagcode;
    }
    public java.lang.String getCountyid(){
        return countyid;
    }

    public void setCountyid(java.lang.String countyid){
        this.countyid = countyid;
    }
    public java.lang.Short getStarlevel(){
        return starlevel;
    }

    public void setStarlevel(java.lang.Short starlevel){
        this.starlevel = starlevel;
    }
    public java.lang.String getSvccode(){
        return svccode;
    }

    public void setSvccode(java.lang.String svccode){
        this.svccode = svccode;
    }
    public java.lang.String getEmployeeid(){
        return employeeid;
    }

    public void setEmployeeid(java.lang.String employeeid){
        this.employeeid = employeeid;
    }
    public java.lang.String getEmployeename(){
        return employeename;
    }

    public void setEmployeename(java.lang.String employeename){
        this.employeename = employeename;
    }
    public java.lang.String getName(){
        return name;
    }

    public void setName(java.lang.String name){
        this.name = name;
    }
    public java.lang.String getOprcode(){
        return oprcode;
    }

    public void setOprcode(java.lang.String oprcode){
        this.oprcode = oprcode;
    }
    public java.lang.String getOfficetel(){
        return officetel;
    }

    public void setOfficetel(java.lang.String officetel){
        this.officetel = officetel;
    }
    public java.lang.String getMobile(){
        return mobile;
    }

    public void setMobile(java.lang.String mobile){
        this.mobile = mobile;
    }
    public java.lang.Short getBrand(){
        return brand;
    }

    public void setBrand(java.lang.Short brand){
        this.brand = brand;
    }
    public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.util.Date getOprtime(){
        return oprtime;
    }

    public void setOprtime(java.util.Date oprtime){
        this.oprtime = oprtime;
    }
    public java.util.Date getActivedate(){
        return activedate;
    }

    public void setActivedate(java.util.Date activedate){
        this.activedate = activedate;
    }

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_se_waymagcode(){
        return _se_waymagcode;
    }

    public void set_se_waymagcode(String _se_waymagcode){
        this._se_waymagcode = _se_waymagcode;
    }
    public String get_se_countyid(){
        return _se_countyid;
    }

    public void set_se_countyid(String _se_countyid){
        this._se_countyid = _se_countyid;
    }
    public String get_ne_starlevel(){
        return _ne_starlevel;
    }

    public void set_ne_starlevel(String _ne_starlevel){
        this._ne_starlevel = _ne_starlevel;
    }
    public String get_se_svccode(){
        return _se_svccode;
    }

    public void set_se_svccode(String _se_svccode){
        this._se_svccode = _se_svccode;
    }
    public String get_se_employeeid(){
        return _se_employeeid;
    }

    public void set_se_employeeid(String _se_employeeid){
        this._se_employeeid = _se_employeeid;
    }
    public String get_se_oprcode(){
        return _se_oprcode;
    }

    public void set_se_oprcode(String _se_oprcode){
        this._se_oprcode = _se_oprcode;
    }
    public String get_ne_brand(){
        return _ne_brand;
    }

    public void set_ne_brand(String _ne_brand){
        this._ne_brand = _ne_brand;
    }
    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_dnm_oprtime(){
        return _dnm_oprtime;
    }

    public void set_dnm_oprtime(String _dnm_oprtime){
        this._dnm_oprtime = _dnm_oprtime;
    }
    public String get_dnl_oprtime(){
        return _dnl_oprtime;
    }

    public void set_dnl_oprtime(String _dnl_oprtime){
        this._dnl_oprtime = _dnl_oprtime;
    }
    public String get_dnm_activedate(){
        return _dnm_activedate;
    }

    public void set_dnm_activedate(String _dnm_activedate){
        this._dnm_activedate = _dnm_activedate;
    }
    public String get_dnl_activedate(){
        return _dnl_activedate;
    }

    public void set_dnl_activedate(String _dnl_activedate){
        this._dnl_activedate = _dnl_activedate;
    }

	public java.lang.Short getComclassid() {
		return comclassid;
	}

	public void setComclassid(java.lang.Short comclassid) {
		this.comclassid = comclassid;
	}

	public java.lang.Long getComprice() {
		return comprice;
	}

	public void setComprice(java.lang.Long comprice) {
		this.comprice = comprice;
	}

	public String get_ne_comclassid() {
		return _ne_comclassid;
	}

	public void set_ne_comclassid(String _ne_comclassid) {
		this._ne_comclassid = _ne_comclassid;
	}

	public String get_se_mobile() {
		return _se_mobile;
	}

	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}

	public String get_ne_mendfalg() {
		return _ne_mendfalg;
	}

	public void set_ne_mendfalg(String _ne_mendfalg) {
		this._ne_mendfalg = _ne_mendfalg;
	}

	public java.lang.Short getMendfalg() {
		return mendfalg;
	}

	public void setMendfalg(java.lang.Short mendfalg) {
		this.mendfalg = mendfalg;
	}

}
