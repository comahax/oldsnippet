/**
* auto-generated code
* Sat Nov 28 17:54:36 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.itemgradedlog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.examine.itemgradedlog.persistent.ItemgradedlogVO;

/**
 * <p>Title: ItemgradedlogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ItemgradedlogForm extends BaseActionForm {

    private java.lang.Long logid;
    private java.util.Date optime;
    private java.lang.String oprcode;
    private java.lang.String oprtype;
    private java.lang.String success;
    private java.lang.Long seqid;
    private java.lang.String wayid;
    private java.lang.Integer exmnid;
    private java.lang.Integer exmnstdid;
    private java.lang.String exmnperiod;
    private java.lang.Float penalmark;
    private java.lang.String memo;
    private java.lang.String registercode;
    private java.lang.String state;
    private java.lang.String curauditor;
    private String _dnl_optime;
	private String _dnm_optime;
	private String _sk_oprcode;
	private String _se_oprtype;
	private String _se_success;

    public java.lang.Long getLogid(){
        return logid;
    }

    public void setLogid(java.lang.Long logid){
        this.logid = logid;
    }
    public java.util.Date getOptime(){
        return optime;
    }

    public void setOptime(java.util.Date optime){
        this.optime = optime;
    }
    public java.lang.String getOprcode(){
        return oprcode;
    }

    public void setOprcode(java.lang.String oprcode){
        this.oprcode = oprcode;
    }
    public java.lang.String getOprtype(){
        return oprtype;
    }

    public void setOprtype(java.lang.String oprtype){
        this.oprtype = oprtype;
    }
    public java.lang.String getSuccess(){
        return success;
    }

    public void setSuccess(java.lang.String success){
        this.success = success;
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
    public java.lang.Integer getExmnid(){
        return exmnid;
    }

    public void setExmnid(java.lang.Integer exmnid){
        this.exmnid = exmnid;
    }
    public java.lang.Integer getExmnstdid(){
        return exmnstdid;
    }

    public void setExmnstdid(java.lang.Integer exmnstdid){
        this.exmnstdid = exmnstdid;
    }
    public java.lang.String getExmnperiod(){
        return exmnperiod;
    }

    public void setExmnperiod(java.lang.String exmnperiod){
        this.exmnperiod = exmnperiod;
    }
    public java.lang.Float getPenalmark(){
        return penalmark;
    }

    public void setPenalmark(java.lang.Float penalmark){
        this.penalmark = penalmark;
    }
    public java.lang.String getMemo(){
        return memo;
    }

    public void setMemo(java.lang.String memo){
        this.memo = memo;
    }
    public java.lang.String getRegistercode(){
        return registercode;
    }

    public void setRegistercode(java.lang.String registercode){
        this.registercode = registercode;
    }
    public java.lang.String getState(){
        return state;
    }

    public void setState(java.lang.String state){
        this.state = state;
    }
    public java.lang.String getCurauditor(){
        return curauditor;
    }

    public void setCurauditor(java.lang.String curauditor){
        this.curauditor = curauditor;
    }

	public String get_dnl_optime() {
		return _dnl_optime;
	}

	public void set_dnl_optime(String _dnl_optime) {
		this._dnl_optime = _dnl_optime;
	}

	public String get_dnm_optime() {
		return _dnm_optime;
	}

	public void set_dnm_optime(String _dnm_optime) {
		this._dnm_optime = _dnm_optime;
	}

	public String get_se_oprtype() {
		return _se_oprtype;
	}

	public void set_se_oprtype(String _se_oprtype) {
		this._se_oprtype = _se_oprtype;
	}

	public String get_se_success() {
		return _se_success;
	}

	public void set_se_success(String _se_success) {
		this._se_success = _se_success;
	}

	public String get_sk_oprcode() {
		return _sk_oprcode;
	}

	public void set_sk_oprcode(String _sk_oprcode) {
		this._sk_oprcode = _sk_oprcode;
	}


}
