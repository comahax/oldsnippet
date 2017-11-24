/**
* auto-generated code
* Fri Jun 24 11:00:35 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.chadtimportrecord;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: ChAdtImportrecordForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class ChadtimportrecordForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.String wayid;
    private java.lang.String mobile;
    private java.lang.String opnid;
    private java.util.Date oprtime;
    private java.lang.Long importtype;
    private java.util.Date runtime;
    private java.lang.String opercode;
    private java.lang.Double amt;
    
    private java.lang.Double assegrade;
    private java.lang.String remark;

	private String _se_wayid;
    private String _dnm_oprtime;
    private String _dnl_oprtime;
    private String _ne_importtype;

    private java.lang.String opnname;
    private java.lang.String typename;
    
    public java.lang.Double getAmt() {
		return amt;
	}

	public void setAmt(java.lang.Double amt) {
		this.amt = amt;
	}

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
    public java.lang.String getMobile(){
        return mobile;
    }

    public void setMobile(java.lang.String mobile){
        this.mobile = mobile;
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
    public java.lang.Long getImporttype(){
        return importtype;
    }

    public void setImporttype(java.lang.Long importtype){
        this.importtype = importtype;
    }
    public java.util.Date getRuntime(){
        return runtime;
    }

    public void setRuntime(java.util.Date runtime){
        this.runtime = runtime;
    }
    public java.lang.String getOpercode(){
        return opercode;
    }

    public void setOpercode(java.lang.String opercode){
        this.opercode = opercode;
    }

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
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
    public String get_ne_importtype(){
        return _ne_importtype;
    }

    public void set_ne_importtype(String _ne_importtype){
        this._ne_importtype = _ne_importtype;
    }

	public java.lang.String getOpnname() {
		return opnname;
	}

	public void setOpnname(java.lang.String opnname) {
		this.opnname = opnname;
	}

	public java.lang.String getTypename() {
		return typename;
	}

	public void setTypename(java.lang.String typename) {
		this.typename = typename;
	}

	public java.lang.Double getAssegrade() {
		return assegrade;
	}

	public void setAssegrade(java.lang.Double assegrade) {
		this.assegrade = assegrade;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

}
