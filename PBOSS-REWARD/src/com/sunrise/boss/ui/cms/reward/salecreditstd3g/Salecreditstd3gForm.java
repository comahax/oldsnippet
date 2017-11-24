/**
* auto-generated code
* Tue Dec 11 09:30:18 CST 2012
*/
package com.sunrise.boss.ui.cms.reward.salecreditstd3g;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.salecreditstd3g.persistent.Salecreditstd3gVO;

/**
 * <p>Title: Salecreditstd3gForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Shi Xiaolong
 * @version 1.0
 */
public class Salecreditstd3gForm extends BaseActionForm {

    private java.lang.Short cityid;
    private java.lang.Long busitype;
    private java.lang.Double creditstd;

    private String _ne_busitype;
    private String _ne_cityid;

    public String get_ne_cityid() {
		return _ne_cityid;
	}

	public void set_ne_cityid(String _ne_cityid) {
		this._ne_cityid = _ne_cityid;
	}

	public java.lang.Short getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.Short cityid){
        this.cityid = cityid;
    }
    public java.lang.Long getBusitype(){
        return busitype;
    }

    public void setBusitype(java.lang.Long busitype){
        this.busitype = busitype;
    }
    public java.lang.Double getCreditstd(){
        return creditstd;
    }

    public void setCreditstd(java.lang.Double creditstd){
        this.creditstd = creditstd;
    }

    public String get_ne_busitype(){
        return _ne_busitype;
    }

    public void set_ne_busitype(String _ne_busitype){
        this._ne_busitype = _ne_busitype;
    }

}
