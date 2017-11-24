package com.gmcc.pboss.model.sales;

import java.util.Date;

import com.gmcc.pboss.common.bean.AutoLogBean;

/**
 * FxSwOrder entity. @author MyEclipse Persistence Tools
 */

public class FxSwOrder extends com.gmcc.pboss.common.bean.CodeReverse implements AutoLogBean {

	// Fields

	private String orderid;
	private Long flowid;
	private String wayid;
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
	private String countyid;
	private String discomcode;
	private Date paytime;
	private String deductstate;
	private String signstate;
	private String alarmlevel;
	private Short confirmflag;
	private String mareacode;
	private Date signtime;
    private Date recordtime;
    private Date disovertime;

	// Constructors

	/** default constructor */
	public FxSwOrder() {
	}

	/** minimal constructor */
	public FxSwOrder(Long flowid, String wayid) {
		this.flowid = flowid;
		this.wayid = wayid;
	}
	public FxSwOrder(String orderid, Long flowid, String wayid) {
		this.flowid = flowid;
		this.wayid = wayid;
		this.flowid = flowid;
    }

	/** full constructor */
	public FxSwOrder(Long flowid, String wayid, String cooptype,
			Byte starlevel, String orderave, String storarea, Date createtime,
			String orderstate, Date statechgtime, String paytype,
			String delitype, Double recamt, Double actamt, String posstream,
			String bossworkfid, String memo, String countyid,
			String discomcode, Date paytime, String deductstate,
			String signstate, String alarmlevel, Short confirmflag,
			String mareacode, Date signtime, Date recordtime, Date disovertime) {
		this.flowid = flowid;
		this.wayid = wayid;
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
		this.countyid = countyid;
		this.discomcode = discomcode;
		this.paytime = paytime;
		this.deductstate = deductstate;
		this.signstate = signstate;
		this.alarmlevel = alarmlevel;
		this.confirmflag = confirmflag;
		this.mareacode = mareacode;
		this.signtime = signtime;
        this.recordtime = recordtime;
        this.disovertime = disovertime;
	}

	// Property accessors

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

	public String getCountyid() {
		return this.countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
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

	public Class getLogClass() {
		// TODO Auto-generated method stub
		return FxSwOrderlog.class;
	}

	public String[] getLogProperties() {
		// TODO Auto-generated method stub
		return AutoLogBean.odrLogProperties;
	}
	
	public Date getSigntime() {
        return this.signtime;
    }
    
    public void setSigntime(Date signtime) {
        this.signtime = signtime;
    }

    public Date getRecordtime() {
        return this.recordtime;
    }
    
    public void setRecordtime(Date recordtime) {
        this.recordtime = recordtime;
    }

    public Date getDisovertime() {
        return this.disovertime;
    }
    
    public void setDisovertime(Date disovertime) {
        this.disovertime = disovertime;
    }
}