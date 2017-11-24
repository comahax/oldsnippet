/**
* auto-generated code
* Wed Oct 18 21:00:42 CST 2006
*/
package com.sunrise.boss.ui.zifee.fixfeedisclog;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.zifee.fixfeedisc.persistent.PcPsFixfeedislogVO;

/**
 * <p>Title: FixfeedisclogForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class FixfeedisclogForm extends BaseActionForm {

	/** identifier field */
    private Long _ne_logid;

    /** persistent field */
    private String _dnl_optime;
    
    /** persistent field */
    private String _dnm_optime;

    /** persistent field */
    private String _se_oprcode;

    /** persistent field */
    private String _se_oprtype;

    /** nullable persistent field */
    private String _se_success;
    
    private String _se_yxplanid;
    
    /** identifier field */
    private Long fixfeediscid;

    /** identifier field */
    private Long yxplanid;

    /** nullable persistent field */
    private Long acctid;
    
    private Long disctype;

    /** nullable persistent field */
    private Float recdisamt;

    /** nullable persistent field */
    private Float disccount;

    public java.lang.Long get_ne_logid() {
        return this._ne_logid;
    }

    public void set_ne_logid(java.lang.Long _ne_logid) {
        this._ne_logid = _ne_logid;
    }

    public String get_dnl_optime() {
        return this._dnl_optime;
    }
    
    public void set_dnl_optime(String _dnl_optime) {
        this._dnl_optime = _dnl_optime;
    }

    public void set_dnm_optime(String _dnm_optime) {
        this._dnm_optime = _dnm_optime;
    }
    
    public String get_dnm_optime() {
        return this._dnm_optime;
    }

    

    public java.lang.String get_se_oprcode() {
        return this._se_oprcode;
    }

    public void set_se_oprcode(java.lang.String _se_oprcode) {
        this._se_oprcode = _se_oprcode;
    }

    public java.lang.String get_se_oprtype() {
        return this._se_oprtype;
    }

    public void set_se_oprtype(java.lang.String _se_oprtype) {
        this._se_oprtype = _se_oprtype;
    }

    public java.lang.String get_se_success() {
        return this._se_success;
    }

    public void set_se_success(java.lang.String _se_success) {
        this._se_success = _se_success;
    }
    public java.lang.Long getFixfeediscid() {
        return this.fixfeediscid;
    }

    public void setFixfeediscid(java.lang.Long fixfeediscid) {
        this.fixfeediscid = fixfeediscid;
    }

    public java.lang.Long getYxplanid() {
        return this.yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid) {
        this.yxplanid = yxplanid;
    }

    public java.lang.Long getAcctid() {
        return this.acctid;
    }
    
    public void setAcctid(java.lang.Long acctid) {
        this.acctid = acctid;
    }   
    public java.lang.Long getDisctype() {
        return this.disctype;
    }

    public void setDisctype(java.lang.Long disctype) {
        this.disctype = disctype;
    }

    public java.lang.Float getRecdisamt() {
        return this.recdisamt;
    }

    public void setRecdisamt(java.lang.Float recdisamt) {
        this.recdisamt = recdisamt;
    }

    public java.lang.Float getDisccount() {
        return this.disccount;
    }

    public void setDisccount(java.lang.Float disccount) {
        this.disccount = disccount;
    }

	public String get_se_yxplanid() {
		return _se_yxplanid;
	}

	public void set_se_yxplanid(String _se_yxplanid) {
		this._se_yxplanid = _se_yxplanid;
	}
    

}
