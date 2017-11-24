/**
 * auto-generated code
 * Fri May 20 16:28:47 CST 2011
 */
package com.gmcc.pboss.business.base.batchsmsrc;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: BatchsmsrcDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author YangDaRen
 * @version 1.0
 */
public class BatchsmsrcDBParam extends DBQueryParam {
    private String _se_mobile;
    private String _se_smscode;

	/**
     * @return Returns the _se_mobile.
     */
    public String get_se_mobile() {
        return this._se_mobile;
    }
    /**
     * @param _sk_companyname The _se_mobile to set.
     */
    public void set_se_mobile(String _se_mobile) {
        this._se_mobile = _se_mobile;
    }

	/**
     * @return Returns the _se_smscode.
     */
    public String get_se_smscode() {
        return this._se_smscode;
    }
    /**
     * @param _sk_companyname The _se_smscode to set.
     */
    public void set_se_smscode(String _se_smscode) {
        this._se_smscode = _se_smscode;
    }

}
