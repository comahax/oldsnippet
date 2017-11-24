/**
* auto-generated code
* Fri Aug 03 11:10:45 CST 2007
*/
package com.sunrise.boss.business.cms.cardsalebusi.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: CardsalebusiListVO</p>
 * <p>Description: Query Params Object for CardsalebusiDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class CardsalebusiListVO extends BaseListVO {
    private String _ne_itemid;

	private String _dnl_opntime;

	private String _dnm_opntime;
	
	private String _se_mobile;

    public String get_dnl_opntime() {
		return _dnl_opntime;
	}

	public void set_dnl_opntime(String _dnl_opntime) {
		this._dnl_opntime = _dnl_opntime;
	}

	public String get_dnm_opntime() {
		return _dnm_opntime;
	}

	public void set_dnm_opntime(String _dnm_opntime) {
		this._dnm_opntime = _dnm_opntime;
	}

	public String get_ne_itemid(){
        return _ne_itemid;
    }

    public void set_ne_itemid(String _ne_itemid){
        this._ne_itemid = _ne_itemid;
    }

	public String get_se_mobile() {
		return _se_mobile;
	}

	public void set_se_mobile(String _se_mobile) {
		this._se_mobile = _se_mobile;
	}
    
}
