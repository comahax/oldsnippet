/**
* auto-generated code
* Wed Dec 28 14:39:42 CST 2011
*/
package com.sunrise.boss.ui.cms.zjty.zjtycompact;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.zjty.zjtycompact.persistent.ZjtyCompactVO;

/**
 * <p>Title: ZjtyCompactForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author qiuzhi
 * @version 1.0
 */
public class ZjtyCompactForm extends BaseActionForm {

    private java.lang.String wayid;
    private java.lang.Float conef;
    private java.util.Date opertime;
    private java.lang.String opercode;
    private java.lang.Short cityid;
    private java.lang.Integer fixednum;

    private String _se_wayid;
    private String _ne_cityid; 

    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.Float getConef(){
        return conef;
    }

    public void setConef(java.lang.Float conef){
        this.conef = conef;
    }
    public java.util.Date getOpertime(){
        return opertime;
    }

    public void setOpertime(java.util.Date opertime){
        this.opertime = opertime;
    }
    public java.lang.String getOpercode(){
        return opercode;
    }

    public void setOpercode(java.lang.String opercode){
        this.opercode = opercode;
    }

    public java.lang.Short getCityid() {
		return cityid;
	}

	public void setCityid(java.lang.Short cityid) {
		this.cityid = cityid;
	}

	public java.lang.Integer getFixednum() {
		return fixednum;
	}

	public void setFixednum(java.lang.Integer fixednum) {
		this.fixednum = fixednum;
	}

	public String get_se_wayid(){
        return _se_wayid;
    }

    public void set_se_wayid(String _se_wayid){
        this._se_wayid = _se_wayid;
    }

	public String get_ne_cityid() {
		return _ne_cityid;
	}

	public void set_ne_cityid(String neCityid) {
		_ne_cityid = neCityid;
	}

}
