/**
 * auto-generated code
 * Wed Jul 08 11:39:56 CST 2009
 */
package com.gmcc.pboss.business.channel.employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sunrise.jop.infrastructure.db.DBQueryParam;

/**
 * <p>Title: EmployeeDBParam </p>;
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Jerimy
 * @version 1.0
 */
public class EmployeeDBParam extends DBQueryParam {
    private String _se_employeeid;
    private String _se_wayid;
    private String _ne_empstatus;
    private String _ne_isnet;
    private String _se_oprcode2;
    private String _sk_employeename;
    private String _se_employeename;
    private String _se_svccode;
    private String _se_servOffice;
    private Long _ne_station;
    private Date _dnl_inTimt;
    private Date _dnm_inTime;
    private String _se_officetel;
    private String _se_selectmobile;
    private String _sk_officetel;
    private List _sin_employeeid;
    
    private String _sk_wayid;
    private String _dnm_intime;
    private String _dnl_intime;
    private String _ne_isopen;
    private String _sne_employeeid;
    private String _se_waytype;
    private String _ne_posittype;
    private List _nin_station;
    private Short _se_isnet;
    private Short _se_empstatus;
    private String _nne_isnet;
    private String _sne_officetel;
    private ArrayList<Short> _nin_isnet;
   
 
	 
	/**
     * @return Returns the _se_employeeid.
     */
    public String get_se_employeeid() {
        return this._se_employeeid;
    }
    /**
     * @param _sk_companyname The _se_employeeid to set.
     */
    public void set_se_employeeid(String _se_employeeid) {
        this._se_employeeid = _se_employeeid;
    }

	/**
     * @return Returns the _se_wayid.
     */
    public String get_se_wayid() {
        return this._se_wayid;
    }
    /**
     * @param _sk_companyname The _se_wayid to set.
     */
    public void set_se_wayid(String _se_wayid) {
        this._se_wayid = _se_wayid;
    }

	/**
     * @return Returns the _ne_empstatus.
     */
    public String get_ne_empstatus() {
        return this._ne_empstatus;
    }
    /**
     * @param _sk_companyname The _ne_empstatus to set.
     */
    public void set_ne_empstatus(String _ne_empstatus) {
        this._ne_empstatus = _ne_empstatus;
    }

	/**
     * @return Returns the _ne_isnet.
     */
    public String get_ne_isnet() {
        return this._ne_isnet;
    }
    /**
     * @param _sk_companyname The _ne_isnet to set.
     */
    public void set_ne_isnet(String _ne_isnet) {
        this._ne_isnet = _ne_isnet;
    }
	public String get_se_oprcode2() {
		return _se_oprcode2;
	}
	public void set_se_oprcode2(String _se_oprcode2) {
		this._se_oprcode2 = _se_oprcode2;
	}
	public String get_sk_employeename() {
		return _sk_employeename;
	}
	public void set_sk_employeename(String _sk_employeename) {
		this._sk_employeename = _sk_employeename;
	}
	public String get_se_svccode() {
		return _se_svccode;
	}
	public void set_se_svccode(String _se_svccode) {
		this._se_svccode = _se_svccode;
	}
	public String get_se_servOffice() {
		return _se_servOffice;
	}
	public void set_se_servOffice(String office) {
		_se_servOffice = office;
	}
	public Long get_ne_station() {
		return _ne_station;
	}
	public void set_ne_station(Long _ne_station) {
		this._ne_station = _ne_station;
	}
	public Date get_dnl_inTimt() {
		return _dnl_inTimt;
	}
	public void set_dnl_inTimt(Date timt) {
		_dnl_inTimt = timt;
	}
	public Date get_dnm_inTime() {
		return _dnm_inTime;
	}
	public void set_dnm_inTime(Date time) {
		_dnm_inTime = time;
	}
	public String get_se_officetel() {
		return _se_officetel;
	}
	public void set_se_officetel(String _se_officetel) {
		this._se_officetel = _se_officetel;
	}
	public String get_se_selectmobile() {
		return _se_selectmobile;
	}
	public void set_se_selectmobile(String _se_selectmobile) {
		this._se_selectmobile = _se_selectmobile;
	}
	public String get_sk_officetel() {
		return _sk_officetel;
	}
	public void set_sk_officetel(String _sk_officetel) {
		this._sk_officetel = _sk_officetel;
	}
	public List get_sin_employeeid() {
		return _sin_employeeid;
	}
	public void set_sin_employeeid(List _sin_employeeid) {
		this._sin_employeeid = _sin_employeeid;
	}
	public String get_sk_wayid() {
		return _sk_wayid;
	}
	public void set_sk_wayid(String _sk_wayid) {
		this._sk_wayid = _sk_wayid;
	}
	public String get_dnm_intime() {
		return _dnm_intime;
	}
	public void set_dnm_intime(String _dnm_intime) {
		this._dnm_intime = _dnm_intime;
	}
	public String get_dnl_intime() {
		return _dnl_intime;
	}
	public void set_dnl_intime(String _dnl_intime) {
		this._dnl_intime = _dnl_intime;
	}
	public String get_ne_isopen() {
		return _ne_isopen;
	}
	public void set_ne_isopen(String _ne_isopen) {
		this._ne_isopen = _ne_isopen;
	}
	public String get_se_employeename() {
		return _se_employeename;
	}
	public void set_se_employeename(String _se_employeename) {
		this._se_employeename = _se_employeename;
	}
	public String get_sne_employeeid() {
		return _sne_employeeid;
	}
	public void set_sne_employeeid(String _sne_employeeid) {
		this._sne_employeeid = _sne_employeeid;
	}
	public String get_se_waytype() {
		return _se_waytype;
	}
	public void set_se_waytype(String _se_waytype) {
		this._se_waytype = _se_waytype;
	}
	public String get_ne_posittype() {
		return _ne_posittype;
	}
	public void set_ne_posittype(String _ne_posittype) {
		this._ne_posittype = _ne_posittype;
	}
	public List get_nin_station() {
		return _nin_station;
	}
	public void set_nin_station(List _nin_station) {
		this._nin_station = _nin_station;
	}
	public Short get_se_isnet() {
		return _se_isnet;
	}
	public void set_se_isnet(Short _se_isnet) {
		this._se_isnet = _se_isnet;
	}
	public Short get_se_empstatus() {
		return _se_empstatus;
	}
	public void set_se_empstatus(Short _se_empstatus) {
		this._se_empstatus = _se_empstatus;
	}
	public String get_nne_isnet() {
		return _nne_isnet;
	}
	public void set_nne_isnet(String _nne_isnet) {
		this._nne_isnet = _nne_isnet;
	}
	public ArrayList<Short> get_nin_isnet() {
		return _nin_isnet;
	}
	public void set_nin_isnet(ArrayList<Short> _nin_isnet) {
		this._nin_isnet = _nin_isnet;
	}
	public String get_sne_officetel() {
		return _sne_officetel;
	}
	public void set_sne_officetel(String _sne_officetel) {
		this._sne_officetel = _sne_officetel;
	}
 
	
}
