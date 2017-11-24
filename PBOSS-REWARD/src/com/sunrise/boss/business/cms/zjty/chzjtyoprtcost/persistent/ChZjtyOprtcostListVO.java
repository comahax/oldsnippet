/**
* auto-generated code
* Fri Feb 13 16:59:53 CST 2009
*/
package com.sunrise.boss.business.cms.zjty.chzjtyoprtcost.persistent;

import com.sunrise.boss.common.base.db.BaseListVO;

/**
 * <p>Title: ChZjtyOprtcostListVO</p>
 * <p>Description: Query Params Object for ChZjtyOprtcostDAO</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public class ChZjtyOprtcostListVO extends BaseListVO {
    private String _ne_citylevel;
    private String _ne_ctype;
    private String _nnm_cost;
    private String _nnl_cost;

    public String get_ne_citylevel(){
        return _ne_citylevel;
    }

    public void set_ne_citylevel(String _ne_citylevel){
        this._ne_citylevel = _ne_citylevel;
    }
    public String get_ne_ctype(){
        return _ne_ctype;
    }

    public void set_ne_ctype(String _ne_ctype){
        this._ne_ctype = _ne_ctype;
    }
    public String get_nnm_cost(){
        return _nnm_cost;
    }

    public void set_nnm_cost(String _nnm_cost){
        this._nnm_cost = _nnm_cost;
    }
    public String get_nnl_cost(){
        return _nnl_cost;
    }

    public void set_nnl_cost(String _nnl_cost){
        this._nnl_cost = _nnl_cost;
    }

}
