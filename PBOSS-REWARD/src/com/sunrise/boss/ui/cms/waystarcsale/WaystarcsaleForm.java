/**
* auto-generated code
* Wed Feb 24 11:50:56 CST 2010
*/
package com.sunrise.boss.ui.cms.waystarcsale;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.waystarcsale.persistent.WaystarcsaleVO;

/**
 * <p>Title: WaystarcsaleForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class WaystarcsaleForm extends BaseActionForm {

    private java.lang.String cityid;
    private java.lang.Short slv;
    private java.lang.String busitype;
    private java.lang.Double busivalue;

	private String _ne_slv;

    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.Short getSlv(){
        return slv;
    }

    public void setSlv(java.lang.Short slv){
        this.slv = slv;
    }
    public java.lang.String getBusitype(){
        return busitype;
    }

    public void setBusitype(java.lang.String busitype){
        this.busitype = busitype;
    }
    public java.lang.Double getBusivalue(){
        return busivalue;
    }

    public void setBusivalue(java.lang.Double busivalue){
        this.busivalue = busivalue;
    }

	public String get_ne_slv() {
		return _ne_slv;
	}

	public void set_ne_slv(String _ne_slv) {
		this._ne_slv = _ne_slv;
	}


}
