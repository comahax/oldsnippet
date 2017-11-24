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
 * @version ÉÏÎç11:03:092006-9-5
 */
public class ManageResParam extends BaseParam {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8866742766192660154L;

	private Long logid;

	private Long restype;

	private String begno;

	private String endno;

	private Long comid;
	
	private Long comtype;

	private Long num;

	private String inwayid;

	private String outwayid;

	private String inoprcode;

	private String outoprcode;

	private Date creattime;

	private String batchno;

	private Long resoprtype;

	private Long success;

	private String oprcode;

	private Long oldstate;

	private Long newstate;

	private Long comsource;

	private String source;

	private String buf;

	private String sendno;

	public String getBatchno() {
		return batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public String getBegno() {
		return begno;
	}

	public void setBegno(String begno) {
		this.begno = begno;
	}

	public String getBuf() {
		return buf;
	}

	public void setBuf(String buf) {
		this.buf = buf;
	}

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public Long getComsource() {
		return comsource;
	}

	public void setComsource(Long comsource) {
		this.comsource = comsource;
	}

	public Date getCreattime() {
		return creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	public String getEndno() {
		return endno;
	}

	public void setEndno(String endno) {
		this.endno = endno;
	}

	public String getInoprcode() {
		return inoprcode;
	}

	public void setInoprcode(String inoprcode) {
		this.inoprcode = inoprcode;
	}

	public String getInwayid() {
		return inwayid;
	}

	public void setInwayid(String inwayid) {
		this.inwayid = inwayid;
	}

	public Long getLogid() {
		return logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public Long getNewstate() {
		return newstate;
	}

	public void setNewstate(Long newstate) {
		this.newstate = newstate;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getOldstate() {
		return oldstate;
	}

	public void setOldstate(Long oldstate) {
		this.oldstate = oldstate;
	}

	public String getOprcode() {
		return oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getOutoprcode() {
		return outoprcode;
	}

	public void setOutoprcode(String outoprcode) {
		this.outoprcode = outoprcode;
	}

	public String getOutwayid() {
		return outwayid;
	}

	public void setOutwayid(String outwayid) {
		this.outwayid = outwayid;
	}

	public Long getResoprtype() {
		return resoprtype;
	}

	public void setResoprtype(Long resoprtype) {
		this.resoprtype = resoprtype;
	}

	public Long getRestype() {
		return restype;
	}

	public void setRestype(Long restype) {
		this.restype = restype;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getSuccess() {
		return success;
	}

	public void setSuccess(Long success) {
		this.success = success;
	}

	public String getSendno() {
		return sendno;
	}

	public void setSendno(String sendno) {
		this.sendno = sendno;
	}

	public Long getComtype() {
		return comtype;
	}

	public void setComtype(Long comtype) {
		this.comtype = comtype;
	}
}
