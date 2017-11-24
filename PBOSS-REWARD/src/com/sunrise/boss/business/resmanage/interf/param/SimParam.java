package com.sunrise.boss.business.resmanage.interf.param;

import java.util.Date;

/**
 * <p>
 * Title: BOSS1.5
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company: sunrise Tech Ltd.
 * </p>
 * 
 * @author Rodney
 * @version ÉÏÎç11:30:192006-9-5
 */
public class SimParam extends BaseParam {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1981695321407005741L;

	private String iccid;

	private String pukno;

	private Date begintime;

	private Date stoptime;

	private Long usestate;

	private Date intime;

	private Long simtype;

	private String wayid;

	private Long capacity;

	private Long smscapacity;

	private Long telcapacity;

	private Long cardmill;

	private String oprcode;

	private Long backup;

	private String hostimsi;

	private String deputyimsi;

	public String getDeputyimsi() {
		return deputyimsi;
	}

	public void setDeputyimsi(String deputyimsi) {
		this.deputyimsi = deputyimsi;
	}

	public String getHostimsi() {
		return hostimsi;
	}

	public void setHostimsi(String hostimsi) {
		this.hostimsi = hostimsi;
	}

	public Long getBackup() {
		return backup;
	}

	public void setBackup(Long backup) {
		this.backup = backup;
	}

	public Date getBegintime() {
		return begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	public Long getCardmill() {
		return cardmill;
	}

	public void setCardmill(Long cardmill) {
		this.cardmill = cardmill;
	}

	public String getIccid() {
		return iccid;
	}

	public void setIccid(String iccid) {
		this.iccid = iccid;
	}

	public Date getIntime() {
		return intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getPukno() {
		return pukno;
	}

	public void setPukno(String pukno) {
		this.pukno = pukno;
	}

	public Long getSimtype() {
		return simtype;
	}

	public void setSimtype(Long simtype) {
		this.simtype = simtype;
	}

	public Long getSmscapacity() {
		return smscapacity;
	}

	public void setSmscapacity(Long smscapacity) {
		this.smscapacity = smscapacity;
	}

	public Date getStoptime() {
		return stoptime;
	}

	public void setStoptime(Date stoptime) {
		this.stoptime = stoptime;
	}

	public Long getTelcapacity() {
		return telcapacity;
	}

	public void setTelcapacity(Long telcapacity) {
		this.telcapacity = telcapacity;
	}

	public Long getUsestate() {
		return usestate;
	}

	public void setUsestate(Long usestate) {
		this.usestate = usestate;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
}
