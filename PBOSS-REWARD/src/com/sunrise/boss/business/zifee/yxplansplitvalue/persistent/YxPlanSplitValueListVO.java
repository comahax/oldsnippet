/**
* auto-generated code
* Thu Aug 31 16:01:07 CST 2006
*/
package com.sunrise.boss.business.zifee.yxplansplitvalue.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: YxPlanSplitValueListVO</p>
 * <p>Description: Query Params Object for YxPlanSplitValueDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class YxPlanSplitValueListVO extends BaseListVO {
 
	String _ne_billcycle;
	String _se_brandid;
	String _se_itemid;
	
	public String get_ne_billcycle(){
		return this._ne_billcycle;
	}
	
	public void set_ne_billcycle(String _ne_billcycle){
		this._ne_billcycle = _ne_billcycle;
	}
	
	public String get_se_brandid(){
		return this._se_brandid;
	}
	
	public void set_se_brandid(String _se_brandid){
		this._se_brandid = _se_brandid;
	}
	
	public String get_se_itemid(){
		return this._se_itemid;
	}
	
	public void set_se_itemid(String _se_itemid){
		this._se_itemid = _se_itemid;
	}

}
