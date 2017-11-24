/**
* auto-generated code
* Fri Aug 11 16:47:18 CST 2006
*/
package com.sunrise.boss.ui.commons.sysparam;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.pub.tools.PublicUtils;
/**
 * <p>Title: SysparamForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author xqy
 * @version 1.0
 */
public class SysparamForm extends BaseActionForm {
    /** identifier field */
    private Long systemid;

    /** persistent field */
    private String paramtype;

    /** persistent field */
    private java.util.Date begintime;

    /** persistent field */
    private java.util.Date endtime;

    /** persistent field */
    private String paramname;

    /** persistent field */
    private String paramvalue;
    
    /** nullable persistent field */
    private String memo;    

	public java.util.Date getBegintime() {
		return begintime;
	}

	public void setBegintime(java.util.Date begintime) {
		this.begintime = begintime;
	}

	public java.util.Date getEndtime() {
		return endtime;
	}

	public void setEndtime(java.util.Date endtime) {
		this.endtime = endtime;
	}
	
	public String getParamname() {
		return paramname;
	}

	public void setParamname(String paramname) {
		this.paramname = paramname;
	}


	public String getParamvalue() {
		return paramvalue;
	}

	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}

	public Long getSystemid() {
		return systemid;
	}

	public void setSystemid(Long systemid) {
		this.systemid = systemid;
	}

	private String _ne_systemid;
	private String _sk_paramtype;
	private String _sk_paramname;
	public String get_ne_systemid() {
		return _ne_systemid;
	}
	public void set_ne_systemid(String _ne_systemid) {
		this._ne_systemid = _ne_systemid;
	}
	public String get_sk_paramname() {
		return _sk_paramname;
	}
	public void set_sk_paramname(String _sk_paramname) {
		this._sk_paramname = _sk_paramname;
	}

	public String get_sk_paramtype() {
		return _sk_paramtype;
	}

	public void set_sk_paramtype(String _sk_paramtype) {
		this._sk_paramtype = _sk_paramtype;
	}	
	private String strBegintime;
	private String strEndtime;

	public String getStrBegintime() {
		return strBegintime;
	}

	public void setStrBegintime(String strBegintime) {
		this.strBegintime = strBegintime;
		//PublicUtils.utilDateToStr(endtime);
	}

	public String getStrEndtime() {
		return strEndtime;
	}

	public void setStrEndtime(String strEndtime) {
		this.strEndtime = strEndtime;
	}

	public String getParamtype() {
		return paramtype;
	}

	public void setParamtype(String paramtype) {
		this.paramtype = paramtype;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	
}
