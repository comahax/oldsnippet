/**
* auto-generated code
* Sun Aug 01 20:25:48 CST 2010
*/
package com.sunrise.boss.ui.cms.reward.vbusyxplan;

import java.util.ArrayList;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.reward.vbusyxplan.persistent.VbusyxplanVO;

/**
 * <p>Title: VbusyxplanForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimyy
 * @version 1.0
 */
public class VbusyxplanForm extends BaseActionForm {

    private java.lang.String opnid;
    private java.lang.Long yxplanid;
    private java.lang.Double wrapfee;
    private java.lang.String cityid;
    private java.lang.String planbusitype;
    private java.lang.String wayid;
    private String _ne_yxplanid;
	private String _se_cityid;
	private String _sql_cityid;
	private String _se_opnid;
	private String _se_opnname;
	private String _se_yxplanname;
	private ArrayList _sin_opnid;
	private ArrayList _nin_yxplanid;
	private String _se_areacode;
	private Long noncyc ; //客户维系酬金发放期数
	private String   _se_prodid;

    public String get_se_areacode() {
		return _se_areacode;
	}

	public void set_se_areacode(String _se_areacode) {
		this._se_areacode = _se_areacode;
	}

	public java.lang.String getOpnid(){
        return opnid;
    }

    public void setOpnid(java.lang.String opnid){
        this.opnid = opnid;
    }
    public java.lang.Long getYxplanid(){
        return yxplanid;
    }

    public void setYxplanid(java.lang.Long yxplanid){
        this.yxplanid = yxplanid;
    }
    public java.lang.Double getWrapfee(){
        return wrapfee;
    }

    public void setWrapfee(java.lang.Double wrapfee){
        this.wrapfee = wrapfee;
    }
    public java.lang.String getCityid(){
        return cityid;
    }

    public void setCityid(java.lang.String cityid){
        this.cityid = cityid;
    }
    public java.lang.String getPlanbusitype(){
        return planbusitype;
    }

    public void setPlanbusitype(java.lang.String planbusitype){
        this.planbusitype = planbusitype;
    }
    public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }

	public String get_ne_yxplanid() {
		return _ne_yxplanid;
	}

	public void set_ne_yxplanid(String _ne_yxplanid) {
		this._ne_yxplanid = _ne_yxplanid;
	}

	public String get_se_cityid() {
		return _se_cityid;
	}

	public void set_se_cityid(String _se_cityid) {
		this._se_cityid = _se_cityid;
	}

	public String get_sql_cityid() {
		return _sql_cityid;
	}

	public void set_sql_cityid(String _sql_cityid) {
		this._sql_cityid = _sql_cityid;
	}

	public String get_se_opnid() {
		return _se_opnid;
	}

	public void set_se_opnid(String _se_opnid) {
		this._se_opnid = _se_opnid;
	}

	public String get_se_opnname() {
		return _se_opnname;
	}

	public void set_se_opnname(String _se_opnname) {
		this._se_opnname = _se_opnname;
	}

	public String get_se_yxplanname() {
		return _se_yxplanname;
	}

	public void set_se_yxplanname(String _se_yxplanname) {
		this._se_yxplanname = _se_yxplanname;
	}

	public ArrayList get_sin_opnid() {
		return _sin_opnid;
	}

	public void set_sin_opnid(ArrayList _sin_opnid) {
		this._sin_opnid = _sin_opnid;
	}

	public ArrayList get_nin_yxplanid() {
		return _nin_yxplanid;
	}

	public void set_nin_yxplanid(ArrayList _nin_yxplanid) {
		this._nin_yxplanid = _nin_yxplanid;
	}

	public Long getNoncyc() {
		return noncyc;
	}

	public void setNoncyc(Long noncyc) {
		this.noncyc = noncyc;
	}

	public String get_se_prodid() {
		return _se_prodid;
	}

	public void set_se_prodid(String _se_prodid) {
		this._se_prodid = _se_prodid;
	}


}
