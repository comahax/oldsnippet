/**
* auto-generated code
* Mon Jan 14 14:13:06 CST 2013
*/
package com.sunrise.boss.business.cms.chadtsales.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChAdtSalesListVO</p>
 * <p>Description: Query Params Object for ChAdtSalesDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author limin
 * @version 1.0
 */
public class ChAdtSalesListVO extends BaseListVO {
    private String _se_opnid;
    private String _se_wayattr;
    private Short _ne_cityid;
    private String _se_sales;
    

    public String get_se_opnid(){
        return _se_opnid;
    }

    public void set_se_opnid(String _se_opnid){
        this._se_opnid = _se_opnid;
    }
    public String get_se_wayattr(){
        return _se_wayattr;
    }

    public void set_se_wayattr(String _se_wayattr){
        this._se_wayattr = _se_wayattr;
    }

	
	public Short get_ne_cityid() {
		return _ne_cityid;
	}

	public void set_ne_cityid(Short _ne_cityid) {
		this._ne_cityid = _ne_cityid;
	}

	public String get_se_sales() {
		return _se_sales;
	}

	public void set_se_sales(String _se_sales) {
		this._se_sales = _se_sales;
	}

}
