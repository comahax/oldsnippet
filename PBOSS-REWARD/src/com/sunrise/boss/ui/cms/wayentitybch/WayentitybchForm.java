/**
* auto-generated code
* Sat Aug 26 11:34:28 CST 2006
*/
package com.sunrise.boss.ui.cms.wayentitybch;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.wayentitybch.persistent.WayentitybchVO;

/**
 * <p>Title: WayentitybchForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayentitybchForm extends BaseActionForm {
	
	private String _se_wayid;
	
	/** identifier field */
    private String wayid;

    /** nullable persistent field */
    private String bchtype;

    /** nullable persistent field */
    private String ownedby;

    /** persistent field */
    private String wayarea;

    /** nullable persistent field */
    private String areaattr;

    /** nullable persistent field */
    private Short constrtype;

    /** persistent field */
    private java.sql.Date opentime;

    /** persistent field */
    private java.sql.Date worktime;

    /** nullable persistent field */
    private String bussupply;

    /** persistent field */
    private Short busstate;

    /** persistent field */
    private Integer employcnt;

    /** nullable persistent field */
    private Short buytype;

    /** nullable persistent field */
    private Double byeprice;

    /** nullable persistent field */
    private String rentunit;

    /** nullable persistent field */
    private String rentperiod;

    /** nullable persistent field */
    private Double rent;

    /** nullable persistent field */
    private Double decinvest;

    /** nullable persistent field */
    private Double compactarea;

    /** nullable persistent field */
    private String envdescp;

    /** nullable persistent field */
    private String bossarea;

	/**
	 * @return Returns the _se_wayid.
	 */
	public String get_se_wayid() {
		return _se_wayid;
	}

	/**
	 * @param _se_wayid The _se_wayid to set.
	 */
	public void set_se_wayid(String _se_wayid) {
		this._se_wayid = _se_wayid;
	}

	/**
	 * @return Returns the areaattr.
	 */
	public String getAreaattr() {
		return areaattr;
	}

	/**
	 * @param areaattr The areaattr to set.
	 */
	public void setAreaattr(String areaattr) {
		this.areaattr = areaattr;
	}

	/**
	 * @return Returns the bchtype.
	 */
	public String getBchtype() {
		return bchtype;
	}

	/**
	 * @param bchtype The bchtype to set.
	 */
	public void setBchtype(String bchtype) {
		this.bchtype = bchtype;
	}

	/**
	 * @return Returns the bossarea.
	 */
	public String getBossarea() {
		return bossarea;
	}

	/**
	 * @param bossarea The bossarea to set.
	 */
	public void setBossarea(String bossarea) {
		this.bossarea = bossarea;
	}

	/**
	 * @return Returns the busstate.
	 */
	public Short getBusstate() {
		return busstate;
	}

	/**
	 * @param busstate The busstate to set.
	 */
	public void setBusstate(Short busstate) {
		this.busstate = busstate;
	}

	/**
	 * @return Returns the bussupply.
	 */
	public String getBussupply() {
		return bussupply;
	}

	/**
	 * @param bussupply The bussupply to set.
	 */
	public void setBussupply(String bussupply) {
		this.bussupply = bussupply;
	}

	/**
	 * @return Returns the buytype.
	 */
	public Short getBuytype() {
		return buytype;
	}

	/**
	 * @param buytype The buytype to set.
	 */
	public void setBuytype(Short buytype) {
		this.buytype = buytype;
	}

	/**
	 * @return Returns the byeprice.
	 */
	public Double getByeprice() {
		return byeprice;
	}

	/**
	 * @param byeprice The byeprice to set.
	 */
	public void setByeprice(Double byeprice) {
		this.byeprice = byeprice;
	}

	/**
	 * @return Returns the compactarea.
	 */
	public Double getCompactarea() {
		return compactarea;
	}

	/**
	 * @param compactarea The compactarea to set.
	 */
	public void setCompactarea(Double compactarea) {
		this.compactarea = compactarea;
	}

	/**
	 * @return Returns the constrtype.
	 */
	public Short getConstrtype() {
		return constrtype;
	}

	/**
	 * @param constrtype The constrtype to set.
	 */
	public void setConstrtype(Short constrtype) {
		this.constrtype = constrtype;
	}

	/**
	 * @return Returns the decinvest.
	 */
	public Double getDecinvest() {
		return decinvest;
	}

	/**
	 * @param decinvest The decinvest to set.
	 */
	public void setDecinvest(Double decinvest) {
		this.decinvest = decinvest;
	}

	/**
	 * @return Returns the employcnt.
	 */
	public Integer getEmploycnt() {
		return employcnt;
	}

	/**
	 * @param employcnt The employcnt to set.
	 */
	public void setEmploycnt(Integer employcnt) {
		this.employcnt = employcnt;
	}

	/**
	 * @return Returns the envdescp.
	 */
	public String getEnvdescp() {
		return envdescp;
	}

	/**
	 * @param envdescp The envdescp to set.
	 */
	public void setEnvdescp(String envdescp) {
		this.envdescp = envdescp;
	}

	/**
	 * @return Returns the opentime.
	 */
	public java.sql.Date getOpentime() {
		return opentime;
	}

	/**
	 * @param opentime The opentime to set.
	 */
	public void setOpentime(java.sql.Date opentime) {
		this.opentime = opentime;
	}

	/**
	 * @return Returns the ownedby.
	 */
	public String getOwnedby() {
		return ownedby;
	}

	/**
	 * @param ownedby The ownedby to set.
	 */
	public void setOwnedby(String ownedby) {
		this.ownedby = ownedby;
	}

	/**
	 * @return Returns the rent.
	 */
	public Double getRent() {
		return rent;
	}

	/**
	 * @param rent The rent to set.
	 */
	public void setRent(Double rent) {
		this.rent = rent;
	}

	/**
	 * @return Returns the rentperiod.
	 */
	public String getRentperiod() {
		return rentperiod;
	}

	/**
	 * @param rentperiod The rentperiod to set.
	 */
	public void setRentperiod(String rentperiod) {
		this.rentperiod = rentperiod;
	}

	/**
	 * @return Returns the rentunit.
	 */
	public String getRentunit() {
		return rentunit;
	}

	/**
	 * @param rentunit The rentunit to set.
	 */
	public void setRentunit(String rentunit) {
		this.rentunit = rentunit;
	}

	/**
	 * @return Returns the wayarea.
	 */
	public String getWayarea() {
		return wayarea;
	}

	/**
	 * @param wayarea The wayarea to set.
	 */
	public void setWayarea(String wayarea) {
		this.wayarea = wayarea;
	}

	/**
	 * @return Returns the wayid.
	 */
	public String getWayid() {
		return wayid;
	}

	/**
	 * @param wayid The wayid to set.
	 */
	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	/**
	 * @return Returns the worktime.
	 */
	public java.sql.Date getWorktime() {
		return worktime;
	}

	/**
	 * @param worktime The worktime to set.
	 */
	public void setWorktime(java.sql.Date worktime) {
		this.worktime = worktime;
	}

	
    
}
