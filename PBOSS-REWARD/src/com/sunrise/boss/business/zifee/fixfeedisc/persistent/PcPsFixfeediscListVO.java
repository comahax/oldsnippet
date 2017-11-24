package com.sunrise.boss.business.zifee.fixfeedisc.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: FixfeediscListVO</p>
 * <p>Description: Query Params Object for FixfeediscDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author Danny(luozhoujie)
 * @version 1.0
 */
public class PcPsFixfeediscListVO extends BaseListVO {
	private String _ne_yxplanid;
	private String _ne_fixfeediscid;
	private String _ne_disctype;
	private String _ne_acctid;
	
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
}
