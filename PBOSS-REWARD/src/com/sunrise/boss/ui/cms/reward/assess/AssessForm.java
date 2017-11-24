/**
* auto-generated code
* Sat Jun 25 17:13:50 CST 2011
*/
package com.sunrise.boss.ui.cms.reward.assess;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.assess.persistent.AssessVO;

/**
 * <p>Title: AssessForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author liuchao
 * @version 1.0
 */
public class AssessForm extends BaseActionForm {

    private java.lang.Long seq;
    private java.lang.String wayid;
    private java.lang.Long assesstype;
    private java.lang.Double value;
    private java.lang.String remark;
    private java.lang.String opercode;
    private java.lang.String opertype;
    private java.util.Date oprtime;
    private java.lang.String calcmonth;

    private String _se_wayid;
    private String _ne_assesstype;
    private String _ne_value;
    private String _se_opercode;
    private String _se_opertype;
    private String _dnm_oprtime;
    private String _dnl_oprtime;
    private String _se_calcmonth;
    
    private java.lang.String assesstypename;

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
    public java.lang.Long getAssesstype(){
        return assesstype;
    }

    public void setAssesstype(java.lang.Long assesstype){
        this.assesstype = assesstype;
    }
    public java.lang.Double getValue(){
        return value;
    }

    public void setValue(java.lang.Double value){
        this.value = value;
    }
    public java.lang.String getRemark(){
        return remark;
    }

    public void setRemark(java.lang.String remark){
        this.remark = remark;
    }
    public java.lang.String getOpercode(){
        return opercode;
    }

    public void setOpercode(java.lang.String opercode){
        this.opercode = opercode;
    }
    
    public java.util.Date getOprtime(){
        return oprtime;
    }

    public void setOprtime(java.util.Date oprtime){
        this.oprtime = oprtime;
    }
    public java.lang.String getCalcmonth(){
        return calcmonth;
    }

    public void setCalcmonth(java.lang.String calcmonth){
        this.calcmonth = calcmonth;
    }

    public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }
    public String get_ne_assesstype(){
        return _ne_assesstype;
    }

    public void set_ne_assesstype(String _ne_assesstype){
        this._ne_assesstype = _ne_assesstype;
    }
    public String get_ne_value(){
        return _ne_value;
    }

    public void set_ne_value(String _ne_value){
        this._ne_value = _ne_value;
    }
    public String get_se_opercode(){
        return _se_opercode;
    }

    public void set_se_opercode(String _se_opercode){
        this._se_opercode = _se_opercode;
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
    public String get_se_calcmonth(){
        return _se_calcmonth;
    }

    public void set_se_calcmonth(String _se_calcmonth){
        this._se_calcmonth = _se_calcmonth;
    }

	public java.lang.String getOpertype() {
		return opertype;
	}

	public void setOpertype(java.lang.String opertype) {
		this.opertype = opertype;
	}

	public String get_se_opertype() {
		return _se_opertype;
	}

	public void set_se_opertype(String _se_opertype) {
		this._se_opertype = _se_opertype;
	}

	public java.lang.String getAssesstypename() {
		return assesstypename;
	}

	public void setAssesstypename(java.lang.String assesstypename) {
		this.assesstypename = assesstypename;
	}
    
    
}
