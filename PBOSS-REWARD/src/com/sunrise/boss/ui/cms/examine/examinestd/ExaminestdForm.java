/**
* auto-generated code
* Tue Nov 17 16:06:35 CST 2009
*/
package com.sunrise.boss.ui.cms.examine.examinestd;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: ExaminestdForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class ExaminestdForm extends BaseActionForm {

    private java.lang.Integer exmnstdid;
    private java.lang.String exmnstdname;
    private java.lang.String markmode;
    private java.lang.String syslogic;

    private String _sk_exmnstdname;
    private String _se_markmode;
    private String _ne_exmnstdid;
    private String exmnid;

    public String getExmnid() {
		return exmnid;
	}

	public void setExmnid(String exmnid) {
		this.exmnid = exmnid;
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

    public String get_sk_exmnstdname(){
        return _sk_exmnstdname;
    }

    public void set_sk_exmnstdname(String _sk_exmnstdname){
        this._sk_exmnstdname = _sk_exmnstdname;
    }
    public String get_se_markmode(){
        return _se_markmode;
    }

    public void set_se_markmode(String _se_markmode){
        this._se_markmode = _se_markmode;
    }

	public String get_ne_exmnstdid() {
		return _ne_exmnstdid;
	}

	public void set_ne_exmnstdid(String _ne_exmnstdid) {
		this._ne_exmnstdid = _ne_exmnstdid;
	}

}
