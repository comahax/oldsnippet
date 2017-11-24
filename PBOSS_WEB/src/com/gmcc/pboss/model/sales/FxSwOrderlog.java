package com.gmcc.pboss.model.sales;

import java.util.Date;

/**
 * FxSwOrderlog entity. @author MyEclipse Persistence Tools
 */

public class FxSwOrderlog extends com.gmcc.pboss.common.bean.CodeReverse
		implements java.io.Serializable {

	// Fields

	private Long logid;
	private Date optime;
	private String oprcode;
	private String oprtype;
	private String success;
	private String orderid;
	private Long flowid;
	private String wayid;
	private String countyid;
	private String cooptype;
	private Byte starlevel;
	private String orderave;
	private String storarea;
	private Date createtime;
	private String orderstate;
	private Date statechgtime;
	private String paytype;
	private String delitype;
	private Double recamt;
	private Double actamt;
	private String posstream;
	private String bossworkfid;
	private String memo;
	private String discomcode;
	private Date paytime;
	private String deductstate;
	private String signstate;
	private String alarmlevel;
	private Short confirmflag;
	private String mareacode;

	// Constructors

	/** default constructor */
	public FxSwOrderlog() {
	}

	/** full constructor */
	public FxSwOrderlog(Date optime, String oprcode, String oprtype,
			String success, String orderid, Long flowid, String wayid,
			String countyid, String cooptype, Byte starlevel, String orderave,
			String storarea, Date createtime, String orderstate,
			Date statechgtime, String paytype, String delitype, Double recamt,
			Double actamt, String posstream, String bossworkfid, String memo,
			String discomcode, Date paytime, String deductstate,
			String signstate, String alarmlevel, Short confirmflag,
			String mareacode) {
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
		this.success = success;
		this.orderid = orderid;
		this.flowid = flowid;
		this.wayid = wayid;
		this.countyid = countyid;
		this.cooptype = cooptype;
		this.starlevel = starlevel;
		this.orderave = orderave;
		this.storarea = storarea;
		this.createtime = createtime;
		this.orderstate = orderstate;
		this.statechgtime = statechgtime;
		this.paytype = paytype;
		this.delitype = delitype;
		this.recamt = recamt;
		this.actamt = actamt;
		this.posstream = posstream;
		this.bossworkfid = bossworkfid;
		this.memo = memo;
		this.discomcode = discomcode;
		this.paytime = paytime;
		this.deductstate = deductstate;
		this.signstate = signstate;
		this.alarmlevel = alarmlevel;
		this.confirmflag = confirmflag;
		this.mareacode = mareacode;
	}

	// Property accessors

	public Long getLogid() {
		return this.logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	public Date getOptime() {
		return this.optime;
	}

	public void setOptime(Date optime) {
		this.optime = optime;
	}

	public String getOprcode() {
		return this.oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public String getOprtype() {
		return this.oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	public String getSuccess() {
		return this.success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Long getFlowid() {
		return this.flowid;
	}

	public void setFlowid(Long flowid) {
		this.flowid = flowid;
	}

	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getCountyid() {
		return this.countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getCooptype() {
		return this.cooptype;
	}

	public void setCooptype(String cooptype) {
		this.cooptype = cooptype;
	}

	public Byte getStarlevel() {
		return this.starlevel;
	}

	public void setStarlevel(Byte starlevel) {
		this.starlevel = starlevel;
	}

	public String getOrderave() {
		return this.orderave;
	}

	public void setOrderave(String orderave) {
		this.orderave = orderave;
	}

	public String getStorarea() {
		return this.storarea;
	}

	public void setStorarea(String storarea) {
		this.storarea = storarea;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getOrderstate() {
		return this.orderstate;
	}

	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}

	public Date getStatechgtime() {
		return this.statechgtime;
	}

	public void setStatechgtime(Date statechgtime) {
		this.statechgtime = statechgtime;
	}

	public String getPaytype() {
		return this.paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public String getDelitype() {
		return this.delitype;
	}

	public void setDelitype(String delitype) {
		this.delitype = delitype;
	}

	public Double getRecamt() {
		return this.recamt;
	}

	public void setRecamt(Double recamt) {
		this.recamt = recamt;
	}

	public Double getActamt() {
		return this.actamt;
	}

	public void setActamt(Double actamt) {
		this.actamt = actamt;
	}

	public String getPosstream() {
		return this.posstream;
	}

	public void setPosstream(String posstream) {
		this.posstream = posstream;
	}

	public String getBossworkfid() {
		return this.bossworkfid;
	}

	public void setBossworkfid(String bossworkfid) {
		this.bossworkfid = bossworkfid;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDiscomcode() {
		return this.discomcode;
	}

	public void setDiscomcode(String discomcode) {
		this.discomcode = discomcode;
	}

	public Date getPaytime() {
		return this.paytime;
	}

	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

	public String getDeductstate() {
		return this.deductstate;
	}

	public void setDeductstate(String deductstate) {
		this.deductstate = deductstate;
	}

	public String getSignstate() {
		return this.signstate;
	}

	public void setSignstate(String signstate) {
		this.signstate = signstate;
	}

	public String getAlarmlevel() {
		return this.alarmlevel;
	}

	public void setAlarmlevel(String alarmlevel) {
		this.alarmlevel = alarmlevel;
	}

	public Short getConfirmflag() {
		return this.confirmflag;
	}

	public void setConfirmflag(Short confirmflag) {
		this.confirmflag = confirmflag;
	}

	public String getMareacode() {
		return this.mareacode;
	}

	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}

}