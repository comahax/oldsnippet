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
 * @version ÉÏÎç10:06:322006-9-6
 */
public class VipCardParam extends BaseParam {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6016287360635346445L;

	private String vipcardno;

	private Long cardtype;

	private Long cardstate;

	private String wayid;

	private Date begintime;

	private Date endtime;

	private String memo;

	public Long getCardstate() {
		return cardstate;
	}

	public void setCardstate(Long cardstate) {
		this.cardstate = cardstate;
	}

	public Long getCardtype() {
		return cardtype;
	}

	public void setCardtype(Long cardtype) {
		this.cardtype = cardtype;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getBegintime() {
		return begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getVipcardno() {
		return vipcardno;
	}

	public void setVipcardno(String vipcardno) {
		this.vipcardno = vipcardno;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}
}
