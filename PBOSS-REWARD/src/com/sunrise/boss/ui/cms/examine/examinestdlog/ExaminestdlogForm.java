/**
* auto-generated code
* Wed Nov 18 09:26:48 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.examinestdlog;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: ExaminestdlogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExaminestdlogForm extends BaseActionForm {

    private java.lang.Long logid;
    private java.util.Date optime;
    private java.lang.String oprcode;
    private java.lang.String oprtype;
    private java.lang.String success;
    private java.lang.Integer exmnstdid;
    private java.lang.String exmnstdname;
    private java.lang.String markmode;
    private java.lang.String syslogic;
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
    public java.lang.Integer getExmnstdid(){
        return exmnstdid;
    }

    public void setExmnstdid(java.lang.Integer exmnstdid){
        this.exmnstdid = exmnstdid;
    }
    public java.lang.String getExmnstdname(){
        return exmnstdname;
    }

    public void setExmnstdname(java.lang.String exmnstdname){
        this.exmnstdname = exmnstdname;
    }
    public java.lang.String getMarkmode(){
        return markmode;
    }

    public void setMarkmode(java.lang.String markmode){
        this.markmode = markmode;
    }
    public java.lang.String getSyslogic(){
        return syslogic;
    }

    public void setSyslogic(java.lang.String syslogic){
        this.syslogic = syslogic;
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
