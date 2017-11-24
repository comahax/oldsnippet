/**
* auto-generated code
* Fri Feb 13 16:59:53 CST 2009
*/
package com.sunrise.boss.ui.cms.zjty.chzjtyoprtcost;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.zjty.chzjtyoprtcost.persistent.ChZjtyOprtcostVO;

/**
 * <p>Title: ChZjtyOprtcostForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author wanghua
 * @version 1.0
 */
public class ChZjtyOprtcostForm extends BaseActionForm {

    private java.lang.Short citylevel;
    private java.lang.Short ctype;
    private java.lang.Double cost;
    private java.lang.String memo;

    private String _ne_citylevel;
    private String _ne_ctype;
    private String _nnm_cost;
    private String _nnl_cost;

    public java.lang.Short getCitylevel(){
        return citylevel;
    }

    public void setCitylevel(java.lang.Short citylevel){
        this.citylevel = citylevel;
    }
    public java.lang.Short getCtype(){
        return ctype;
    }

    public void setCtype(java.lang.Short ctype){
        this.ctype = ctype;
    }
    public java.lang.Double getCost(){
        return cost;
    }

    public void setCost(java.lang.Double cost){
        this.cost = cost;
    }
    public java.lang.String getMemo(){
        return memo;
    }

    public void setMemo(java.lang.String memo){
        this.memo = memo;
    }

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
