/**
* auto-generated code
* Tue Sep 12 17:06:59 CST 2006
*/
package com.sunrise.boss.ui.cms.wayhierarchy;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.wayhierarchy.persistent.WayhierarchyVO;

/**
 * <p>Title: WayhierarchyForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayhierarchyForm extends BaseActionForm {
	
	  /** identifier field */
    private String parwayid;

    /** identifier field */
    private String subwayid;

    /** persistent field */
    private Short hichyoffset;

    /** nullable persistent field */
    private java.sql.Timestamp createtime;
    
	private String _se_parwayid;
	private String _se_subwayid;
	private Short _ne_hichyoffset;
	
	private String baseWayId;
	
	public Short get_ne_hichyoffset() {
		return _ne_hichyoffset;
	}
	public void set_ne_hichyoffset(Short _ne_hichyoffset) {
		this._ne_hichyoffset = _ne_hichyoffset;
	}
	public String get_se_parwayid() {
		return _se_parwayid;
	}
	public void set_se_parwayid(String _se_parwayid) {
		this._se_parwayid = _se_parwayid;
	}
	public String get_se_subwayid() {
		return _se_subwayid;
	}
	public void set_se_subwayid(String _se_subwayid) {
		this._se_subwayid = _se_subwayid;
	}
	public java.sql.Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(java.sql.Timestamp createtime) {
		this.createtime = createtime;
	}
	public Short getHichyoffset() {
		return hichyoffset;
	}
	public void setHichyoffset(Short hichyoffset) {
		this.hichyoffset = hichyoffset;
	}
	public String getParwayid() {
		return parwayid;
	}
	public void setParwayid(String parwayid) {
		this.parwayid = parwayid;
	}
	public String getSubwayid() {
		return subwayid;
	}
	public void setSubwayid(String subwayid) {
		this.subwayid = subwayid;
	}
	public String getBaseWayId() {
		return baseWayId;
	}
	public void setBaseWayId(String baseWayId) {
		this.baseWayId = baseWayId;
	}	
}
