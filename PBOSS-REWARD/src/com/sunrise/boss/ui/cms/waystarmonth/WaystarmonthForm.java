/**
* auto-generated code
* Wed Feb 24 14:10:39 CST 2010
*/
package com.sunrise.boss.ui.cms.waystarmonth;

import com.sunrise.boss.ui.base.BaseActionForm;

/**
 * <p>Title: WaystarmonthForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Canigar
 * @version 1.0
 */
public class WaystarmonthForm extends BaseActionForm {

    private java.lang.String wayid;
    private java.lang.String eftmonth;
    private java.lang.Short slv;
    private java.lang.Double busivalue;
    private java.lang.String opcode;
    private java.util.Date oprtime;
    private java.lang.Short eftmonthtype;
    private String src;

	private String _se_wayid;
	private String _se_eftmonth;
	private String _ne_slv;
	private String _se_opcode;
	private String _dnl_oprtime;
	private String _dnm_oprtime;

    public String get_se_wayid() {
		return _se_wayid;
	}

	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	public String get_se_eftmonth() {
		return _se_eftmonth;
	}

	public void set_se_eftmonth(String _se_eftmonth) {
		this._se_eftmonth = _se_eftmonth;
	}

	public String get_ne_slv() {
		return _ne_slv;
	}

	public void set_ne_slv(String _ne_slv) {
		this._ne_slv = _ne_slv;
	}

	public String get_se_opcode() {
		return _se_opcode;
	}

	public void set_se_opcode(String _se_opcode) {
		this._se_opcode = _se_opcode;
	}

	public java.lang.String getWayid(){
        return wayid;
    }

    public void setWayid(java.lang.String wayid){
        this.wayid = wayid;
    }
    public java.lang.String getEftmonth(){
        return eftmonth;
    }

    public void setEftmonth(java.lang.String eftmonth){
        this.eftmonth = eftmonth;
    }
    public java.lang.Short getSlv(){
        return slv;
    }

    public void setSlv(java.lang.Short slv){
        this.slv = slv;
    }
    public java.lang.Double getBusivalue(){
        return busivalue;
    }

    public void setBusivalue(java.lang.Double busivalue){
        this.busivalue = busivalue;
    }
    
    public java.lang.String getOpcode() {
		return opcode;
	}

	public void setOpcode(java.lang.String opcode) {
		this.opcode = opcode;
	}

	public java.util.Date getOprtime(){
        return oprtime;
    }

    public void setOprtime(java.util.Date oprtime){
        this.oprtime = oprtime;
    }

	public String get_dnl_oprtime() {
		return _dnl_oprtime;
	}

	public void set_dnl_oprtime(String _dnl_oprtime) {
		this._dnl_oprtime = _dnl_oprtime;
	}

	public String get_dnm_oprtime() {
		return _dnm_oprtime;
	}

	public void set_dnm_oprtime(String _dnm_oprtime) {
		this._dnm_oprtime = _dnm_oprtime;
	}

	public java.lang.Short getEftmonthtype() {
		return eftmonthtype;
	}

	public void setEftmonthtype(java.lang.Short eftmonthtype) {
		this.eftmonthtype = eftmonthtype;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
}
