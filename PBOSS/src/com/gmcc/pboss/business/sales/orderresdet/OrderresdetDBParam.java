/**
 * auto-generated code
 * Tue Oct 13 15:13:34 CST 2009
 */
package com.gmcc.pboss.business.sales.orderresdet;

import java.util.List;
import java.util.Map;
import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: OrderresdetDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wefrogll
 * @version 1.0
 */
public class OrderresdetDBParam extends DBQueryParam {
    private String _ne_detid;
    private String _se_orderid;
    private List _sin_orderid;
    private String _se_ordercomtype;
    private String _se_comcategory;
    private String _se_restype;
    private String _sne_restype;
    private String _ne_comid;
    private String _se_boxnum;
    private String _se_batchno;
    private String _se_comresid;
    private String _se_brand;
    private Double _nne_actprice;
    
    private Map drawPara;//用于充值卡指定号段
    
	public String get_se_batchno() {
		return _se_batchno;
	}
	public void set_se_batchno(String _se_batchno) {
		this._se_batchno = _se_batchno;
	}
	/**
     * @return Returns the _ne_detid.
     */
    public String get_ne_detid() {
        return this._ne_detid;
    }
    /**
     * @param _sk_companyname The _ne_detid to set.
     */
    public void set_ne_detid(String _ne_detid) {
        this._ne_detid = _ne_detid;
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
     * @return Returns the _se_restype.
     */
    public String get_se_restype() {
        return this._se_restype;
    }
    /**
     * @param _sk_companyname The _se_restype to set.
     */
    public void set_se_restype(String _se_restype) {
        this._se_restype = _se_restype;
    }

	/**
     * @return Returns the _ne_comid.
     */
    public String get_ne_comid() {
        return this._ne_comid;
    }
    /**
     * @param _sk_companyname The _ne_comid to set.
     */
    public void set_ne_comid(String _ne_comid) {
        this._ne_comid = _ne_comid;
    }

	/**
     * @return Returns the _se_boxnum.
     */
    public String get_se_boxnum() {
        return this._se_boxnum;
    }
    /**
     * @param _sk_companyname The _se_boxnum to set.
     */
    public void set_se_boxnum(String _se_boxnum) {
        this._se_boxnum = _se_boxnum;
    }

	/**
     * @return Returns the _se_comresid.
     */
    public String get_se_comresid() {
        return this._se_comresid;
    }
    /**
     * @param _sk_companyname The _se_comresid to set.
     */
    public void set_se_comresid(String _se_comresid) {
        this._se_comresid = _se_comresid;
    }

	/**
     * @return Returns the _se_brand.
     */
    public String get_se_brand() {
        return this._se_brand;
    }
    /**
     * @param _sk_companyname The _se_brand to set.
     */
    public void set_se_brand(String _se_brand) {
        this._se_brand = _se_brand;
    }
	public Map getDrawPara() {
		return drawPara;
	}
	public void setDrawPara(Map drawPara) {
		this.drawPara = drawPara;
	}
	public String get_sne_restype() {
		return _sne_restype;
	}
	public void set_sne_restype(String sneRestype) {
		_sne_restype = sneRestype;
	}
	public Double get_nne_actprice() {
		return _nne_actprice;
	}
	public void set_nne_actprice(Double _nne_actprice) {
		this._nne_actprice = _nne_actprice;
	}
	public List get_sin_orderid() {
		return _sin_orderid;
	}
	public void set_sin_orderid(List _sin_orderid) {
		this._sin_orderid = _sin_orderid;
	}

}
