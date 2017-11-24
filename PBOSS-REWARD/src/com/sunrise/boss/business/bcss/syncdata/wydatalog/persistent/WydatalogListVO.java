/**
* auto-generated code
* Wed Feb 18 23:47:47 CST 2009
*/
package com.sunrise.boss.business.bcss.syncdata.wydatalog.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: WydatalogListVO</p>
 * <p>Description: Query Params Object for WydatalogDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class WydatalogListVO extends BaseListVO {
	private String _se_filecode;
	private String _snl_oprtime;
	private String _snm_oprtime;
	private String _se_oprtype;
	public String get_se_oprtype() {
		return _se_oprtype;
	}
	public void set_se_oprtype(String _se_oprtype) {
		this._se_oprtype = _se_oprtype;
	}
	public String get_se_filecode() {
		return _se_filecode;
	}
	public void set_se_filecode(String _se_filecode) {
		this._se_filecode = _se_filecode;
	}
	public String get_snl_oprtime() {
		return _snl_oprtime;
	}
	public void set_snl_oprtime(String _snl_oprtime) {
		this._snl_oprtime = _snl_oprtime;
	}
	public String get_snm_oprtime() {
		return _snm_oprtime;
	}
	public void set_snm_oprtime(String _snm_oprtime) {
		this._snm_oprtime = _snm_oprtime;
	}
}
