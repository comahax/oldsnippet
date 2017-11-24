/**
 * auto-generated code
 * Fri Dec 17 11:26:27 CST 2010
 */
package com.gmcc.pboss.business.sales.auditdet;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: AuditdetDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author yedaoe
 * @version 1.0
 */
public class AuditdetDBParam extends DBQueryParam {
    private String _ne_recid;
    private String _ne_auditseq;
    private String _se_orderid;

	/**
     * @return Returns the _ne_recid.
     */
    public String get_ne_recid() {
        return this._ne_recid;
    }
    /**
     * @param _sk_companyname The _ne_recid to set.
     */
    public void set_ne_recid(String _ne_recid) {
        this._ne_recid = _ne_recid;
    }

	/**
     * @return Returns the _ne_auditseq.
     */
    public String get_ne_auditseq() {
        return this._ne_auditseq;
    }
    /**
     * @param _sk_companyname The _ne_auditseq to set.
     */
    public void set_ne_auditseq(String _ne_auditseq) {
        this._ne_auditseq = _ne_auditseq;
    }

	/**
     * @return Returns the _se_orderid.
     */
    public String get_se_orderid() {
        return this._se_orderid;
    }
    /**
     * @param _sk_companyname The _se_orderid to set.
     */
    public void set_se_orderid(String _se_orderid) {
        this._se_orderid = _se_orderid;
    }

}
