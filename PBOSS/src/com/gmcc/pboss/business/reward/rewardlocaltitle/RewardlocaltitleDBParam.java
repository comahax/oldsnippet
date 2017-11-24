/**
 * auto-generated code
 * Wed Jul 28 14:27:43 CST 2010
 */
package com.gmcc.pboss.business.reward.rewardlocaltitle;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: RewardlocaltitleDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class RewardlocaltitleDBParam extends DBQueryParam {
    private String _se_rpttype;
    private String _ne_seq;
    private String _ne_titleno;
    private String _sk_titlename;
    private String _se_rewardmonth;

	/**
     * @return Returns the _se_rpttype.
     */
    public String get_se_rpttype() {
        return this._se_rpttype;
    }
    /**
     * @param _sk_companyname The _se_rpttype to set.
     */
    public void set_se_rpttype(String _se_rpttype) {
        this._se_rpttype = _se_rpttype;
    }

	/**
     * @return Returns the _ne_seq.
     */
    public String get_ne_seq() {
        return this._ne_seq;
    }
    /**
     * @param _sk_companyname The _ne_seq to set.
     */
    public void set_ne_seq(String _ne_seq) {
        this._ne_seq = _ne_seq;
    }

	/**
     * @return Returns the _ne_titleno.
     */
    public String get_ne_titleno() {
        return this._ne_titleno;
    }
    /**
     * @param _sk_companyname The _ne_titleno to set.
     */
    public void set_ne_titleno(String _ne_titleno) {
        this._ne_titleno = _ne_titleno;
    }

	/**
     * @return Returns the _sk_titlename.
     */
    public String get_sk_titlename() {
        return this._sk_titlename;
    }
    /**
     * @param _sk_companyname The _sk_titlename to set.
     */
    public void set_sk_titlename(String _sk_titlename) {
        this._sk_titlename = _sk_titlename;
    }
	public String get_se_rewardmonth() {
		return _se_rewardmonth;
	}
	public void set_se_rewardmonth(String seRewardmonth) {
		_se_rewardmonth = seRewardmonth;
	}

}
