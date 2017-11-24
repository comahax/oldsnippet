/**
* auto-generated code
* Sat Aug 26 11:33:48 CST 2006
*/
package com.sunrise.boss.ui.cms.wayagentbch;

import com.sunrise.boss.ui.base.BaseActionForm;
import com.sunrise.boss.business.cms.wayagentbch.persistent.WayagentbchVO;

/**
 * <p>Title: WayagentbchForm</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author He Kun
 * @version 1.0
 */
public class WayagentbchForm extends BaseActionForm {
	
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
    private String bossoprcode;

    /** nullable persistent field */
    private Integer busarea;

    /** nullable persistent field */
    private Integer seatcnt;

    /** nullable persistent field */
    private String envmemo;

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
	 * @return Returns the bossoprcode.
	 */
	public String getBossoprcode() {
		return bossoprcode;
	}

	/**
	 * @param bossoprcode The bossoprcode to set.
	 */
	public void setBossoprcode(String bossoprcode) {
		this.bossoprcode = bossoprcode;
	}

	/**
	 * @return Returns the busarea.
	 */
	public Integer getBusarea() {
		return busarea;
	}

	/**
	 * @param busarea The busarea to set.
	 */
	public void setBusarea(Integer busarea) {
		this.busarea = busarea;
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
	 * @return Returns the envmemo.
	 */
	public String getEnvmemo() {
		return envmemo;
	}

	/**
	 * @param envmemo The envmemo to set.
	 */
	public void setEnvmemo(String envmemo) {
		this.envmemo = envmemo;
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
	 * @return Returns the seatcnt.
	 */
	public Integer getSeatcnt() {
		return seatcnt;
	}

	/**
	 * @param seatcnt The seatcnt to set.
	 */
	public void setSeatcnt(Integer seatcnt) {
		this.seatcnt = seatcnt;
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
