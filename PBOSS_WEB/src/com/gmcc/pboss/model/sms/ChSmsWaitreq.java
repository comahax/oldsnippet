package com.gmcc.pboss.model.sms;

import java.util.Date;

/**
 * ChSmsWaitreq entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ChSmsWaitreq implements java.io.Serializable {

	// Fields

	private Long streamno;
	private Long smstype;
	private String areacode;
	private Date creattime;
	private Date dealtime;
	private String message;
	private String sendno;
	private String recno;
	private Long dealcount;
	private Long issuccess;
	private String resultcode;
	private String resultdesc;
	private Date senttime;

	// Constructors

	/** default constructor */
	public ChSmsWaitreq() {
	}

	/** minimal constructor */
	public ChSmsWaitreq(Long streamno) {
		this.streamno = streamno;
	}

	/** full constructor */
	public ChSmsWaitreq(Long streamno, Long smstype, String areacode,
			Date creattime, Date dealtime, String message, String sendno,
			String recno, Long dealcount, Long issuccess, String resultcode,
			String resultdesc, Date senttime) {
		this.streamno = streamno;
		this.smstype = smstype;
		this.areacode = areacode;
		this.creattime = creattime;
		this.dealtime = dealtime;
		this.message = message;
		this.sendno = sendno;
		this.recno = recno;
		this.dealcount = dealcount;
		this.issuccess = issuccess;
		this.resultcode = resultcode;
		this.resultdesc = resultdesc;
		this.senttime = senttime;
	}

	// Property accessors

	public Long getStreamno() {
		return this.streamno;
	}

	public void setStreamno(Long streamno) {
		this.streamno = streamno;
	}

	public Long getSmstype() {
		return this.smstype;
	}

	public void setSmstype(Long smstype) {
		this.smstype = smstype;
	}

	public String getAreacode() {
		return this.areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public Date getCreattime() {
		return this.creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public Date getDealtime() {
		return this.dealtime;
	}

	public void setDealtime(Date dealtime) {
		this.dealtime = dealtime;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSendno() {
		return this.sendno;
	}

	public void setSendno(String sendno) {
		this.sendno = sendno;
	}

	public String getRecno() {
		return this.recno;
	}

	public void setRecno(String recno) {
		this.recno = recno;
	}

	public Long getDealcount() {
		return this.dealcount;
	}

	public void setDealcount(Long dealcount) {
		this.dealcount = dealcount;
	}

	public Long getIssuccess() {
		return this.issuccess;
	}

	public void setIssuccess(Long issuccess) {
		this.issuccess = issuccess;
	}

	public String getResultcode() {
		return this.resultcode;
	}

	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}

	public String getResultdesc() {
		return this.resultdesc;
	}

	public void setResultdesc(String resultdesc) {
		this.resultdesc = resultdesc;
	}
	
	public Date getSenttime() {
		return senttime;
	}

	public void setSenttime(Date senttime) {
		this.senttime = senttime;
	}

}