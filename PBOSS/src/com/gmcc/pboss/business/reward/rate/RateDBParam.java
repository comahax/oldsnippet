package com.gmcc.pboss.business.reward.rate;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: RateDBParam </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author a-biao
 * @version 1.0
 */
public class RateDBParam extends DBQueryParam {
    private String _se_cityid;

	/**
     * @return Returns the _se_cityid.
     */
    public String get_se_cityid() {
        return this._se_cityid;
    }
    /**
     * @param _sk_companyname The _se_cityid to set.
     */
    public void set_se_cityid(String _se_cityid) {
        this._se_cityid = _se_cityid;
    }

}
