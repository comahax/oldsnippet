package com.sunrise.boss.ui.zifee.fixfeedisc;

import com.sunrise.boss.ui.base.BaseActionForm;

public class FixfeediscForm extends BaseActionForm{
	private String _ne_yxplanid;
	private String _ne_fixfeediscid;
	private String _ne_disctype;
	private String _ne_acctid;	
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
    private String operType;

    /** full constructor */
    public FixfeediscForm(java.lang.Long fixfeediscid, java.lang.Long yxplanid, java.lang.Long acctid,java.lang.Long disctype, java.lang.Float recdisamt, java.lang.Float disccount) {
        this.fixfeediscid = fixfeediscid;
        this.yxplanid = yxplanid;
        this.acctid = acctid;
        this.disctype = disctype;
        this.recdisamt = recdisamt;
        this.disccount = disccount;
    }

    /** default constructor */
    public FixfeediscForm() {
    }

    /** minimal constructor */
    public FixfeediscForm(java.lang.Long fixfeediscid, java.lang.Long yxplanid) {
        this.fixfeediscid = fixfeediscid;
        this.yxplanid = yxplanid;
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
    public java.lang.String get_ne_yxplanid() {
        return this._ne_yxplanid;
    }

    public void set_ne_yxplanid(java.lang.String _ne_yxplanid) {
        this._ne_yxplanid = _ne_yxplanid;
    }
    public java.lang.String get_ne_fixfeediscid() {
        return this._ne_fixfeediscid;
    }

    public void set_ne_fixfeediscid(java.lang.String _ne_fixfeediscid) {
        this._ne_fixfeediscid = _ne_fixfeediscid;
    }
    public java.lang.String get_ne_disctype() {
        return this._ne_disctype;
    }
    public void set_ne_disctype(java.lang.String _ne_disctype) {
        this._ne_disctype = _ne_disctype;
    }
    public java.lang.String get_ne_acctid() {
        return this._ne_acctid;
    }
    public void set_ne_acctid(java.lang.String _ne_acctid) {
        this._ne_acctid = _ne_acctid;
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

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

}
