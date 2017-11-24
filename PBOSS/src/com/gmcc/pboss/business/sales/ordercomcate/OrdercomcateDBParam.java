/**
 * auto-generated code
 * Tue Oct 13 12:38:53 CST 2009
 */
package com.gmcc.pboss.business.sales.ordercomcate;

import java.util.List;
import java.util.Set;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OrdercomcateDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrdercomcateDBParam extends DBQueryParam {
    private String _se_orderid;
    private String _se_ordercomtype;
    private String _se_comcategory;
    private String _ne_orderamt;
    
    private Set<String> _sin_comcategory;
    private List<String> _sin_orderid;

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

	/**
     * @return Returns the _se_ordercomtype.
     */
    public String get_se_ordercomtype() {
        return this._se_ordercomtype;
    }
    /**
     * @param _sk_companyname The _se_ordercomtype to set.
     */
    public void set_se_ordercomtype(String _se_ordercomtype) {
        this._se_ordercomtype = _se_ordercomtype;
    }

	/**
     * @return Returns the _se_comcategory.
     */
    public String get_se_comcategory() {
        return this._se_comcategory;
    }
    /**
     * @param _sk_companyname The _se_comcategory to set.
     */
    public void set_se_comcategory(String _se_comcategory) {
        this._se_comcategory = _se_comcategory;
    }

	/**
     * @return Returns the _ne_orderamt.
     */
    public String get_ne_orderamt() {
        return this._ne_orderamt;
    }
    /**
     * @param _sk_companyname The _ne_orderamt to set.
     */
    public void set_ne_orderamt(String _ne_orderamt) {
        this._ne_orderamt = _ne_orderamt;
    }
	public Set<String> get_sin_comcategory() {
		return _sin_comcategory;
	}
	public void set_sin_comcategory(Set<String> _sin_comcategory) {
		this._sin_comcategory = _sin_comcategory;
	}
	public List<String> get_sin_orderid() {
		return _sin_orderid;
	}
	public void set_sin_orderid(List<String> _sin_orderid) {
		this._sin_orderid = _sin_orderid;
	}
    

}
