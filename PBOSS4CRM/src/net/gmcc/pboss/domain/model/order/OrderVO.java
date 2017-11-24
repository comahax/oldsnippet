package net.gmcc.pboss.domain.model.order;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "FX_SW_ORDER")
public class OrderVO implements java.io.Serializable {

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
	private String signtype;
	private String smssignno;

	// Constructors

	/** default constructor */
	public OrderVO() {
	}

	/** minimal constructor */
	public OrderVO(String orderid, Long flowid, String wayid) {
		this.orderid = orderid;
		this.flowid = flowid;
		this.wayid = wayid;
	}

	/** full constructor */
	public OrderVO(String orderid, Long flowid, String wayid, String cooptype,
			Byte starlevel, String orderave, String storarea, Date createtime,
			String orderstate, Date statechgtime, String paytype,
			String delitype, Double recamt, Double actamt, String posstream,
			String bossworkfid, String memo, String countyid,
			String discomcode, Date paytime, String deductstate,
			String signstate, String alarmlevel, Short confirmflag,
			String mareacode, Date signtime, Date recordtime, Date disovertime,
			String signtype, String smssignno) {
		this.orderid = orderid;
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
		this.signtype = signtype;
		this.smssignno = smssignno;
	}

	// Property accessors
	@Id
	@Column(name = "ORDERID", unique = true, nullable = false, length = 18)
	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	@Column(name = "FLOWID", nullable = false, precision = 14, scale = 0)
	public Long getFlowid() {
		return this.flowid;
	}

	public void setFlowid(Long flowid) {
		this.flowid = flowid;
	}

	@Column(name = "WAYID", nullable = false, length = 18)
	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	@Column(name = "COOPTYPE", length = 16)
	public String getCooptype() {
		return this.cooptype;
	}

	public void setCooptype(String cooptype) {
		this.cooptype = cooptype;
	}

	@Column(name = "STARLEVEL", precision = 2, scale = 0)
	public Byte getStarlevel() {
		return this.starlevel;
	}

	public void setStarlevel(Byte starlevel) {
		this.starlevel = starlevel;
	}

	@Column(name = "ORDERAVE", length = 16)
	public String getOrderave() {
		return this.orderave;
	}

	public void setOrderave(String orderave) {
		this.orderave = orderave;
	}

	@Column(name = "STORAREA", length = 16)
	public String getStorarea() {
		return this.storarea;
	}

	public void setStorarea(String storarea) {
		this.storarea = storarea;
	}

	@Temporal(TemporalType.TIMESTAMP)//DATE
	@Column(name = "CREATETIME", length = 7)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name = "ORDERSTATE", length = 16)
	public String getOrderstate() {
		return this.orderstate;
	}

	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}

	@Temporal(TemporalType.TIMESTAMP)//DATE
	@Column(name = "STATECHGTIME", length = 7)
	public Date getStatechgtime() {
		return this.statechgtime;
	}

	public void setStatechgtime(Date statechgtime) {
		this.statechgtime = statechgtime;
	}

	@Column(name = "PAYTYPE", length = 16)
	public String getPaytype() {
		return this.paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	@Column(name = "DELITYPE", length = 16)
	public String getDelitype() {
		return this.delitype;
	}

	public void setDelitype(String delitype) {
		this.delitype = delitype;
	}

	@Column(name = "RECAMT", precision = 16)
	public Double getRecamt() {
		return this.recamt;
	}

	public void setRecamt(Double recamt) {
		this.recamt = recamt;
	}

	@Column(name = "ACTAMT", precision = 16)
	public Double getActamt() {
		return this.actamt;
	}

	public void setActamt(Double actamt) {
		this.actamt = actamt;
	}

	@Column(name = "POSSTREAM", length = 32)
	public String getPosstream() {
		return this.posstream;
	}

	public void setPosstream(String posstream) {
		this.posstream = posstream;
	}

	@Column(name = "BOSSWORKFID", length = 32)
	public String getBossworkfid() {
		return this.bossworkfid;
	}

	public void setBossworkfid(String bossworkfid) {
		this.bossworkfid = bossworkfid;
	}

	@Column(name = "MEMO", length = 256)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "COUNTYID", length = 14)
	public String getCountyid() {
		return this.countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	@Column(name = "DISCOMCODE", length = 18)
	public String getDiscomcode() {
		return this.discomcode;
	}

	public void setDiscomcode(String discomcode) {
		this.discomcode = discomcode;
	}

	@Temporal(TemporalType.TIMESTAMP)//DATE
	@Column(name = "PAYTIME", length = 7)
	public Date getPaytime() {
		return this.paytime;
	}

	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}

	@Column(name = "DEDUCTSTATE", length = 16)
	public String getDeductstate() {
		return this.deductstate;
	}

	public void setDeductstate(String deductstate) {
		this.deductstate = deductstate;
	}

	@Column(name = "SIGNSTATE", length = 16)
	public String getSignstate() {
		return this.signstate;
	}

	public void setSignstate(String signstate) {
		this.signstate = signstate;
	}

	@Column(name = "ALARMLEVEL", length = 16)
	public String getAlarmlevel() {
		return this.alarmlevel;
	}

	public void setAlarmlevel(String alarmlevel) {
		this.alarmlevel = alarmlevel;
	}

	@Column(name = "CONFIRMFLAG", precision = 3, scale = 0)
	public Short getConfirmflag() {
		return this.confirmflag;
	}

	public void setConfirmflag(Short confirmflag) {
		this.confirmflag = confirmflag;
	}

	@Column(name = "MAREACODE", length = 14)
	public String getMareacode() {
		return this.mareacode;
	}

	public void setMareacode(String mareacode) {
		this.mareacode = mareacode;
	}

	@Temporal(TemporalType.TIMESTAMP)//DATE
	@Column(name = "SIGNTIME", length = 7)
	public Date getSigntime() {
		return this.signtime;
	}

	public void setSigntime(Date signtime) {
		this.signtime = signtime;
	}

	@Temporal(TemporalType.TIMESTAMP)//DATE
	@Column(name = "RECORDTIME", length = 7)
	public Date getRecordtime() {
		return this.recordtime;
	}

	public void setRecordtime(Date recordtime) {
		this.recordtime = recordtime;
	}

	@Temporal(TemporalType.TIMESTAMP)//DATE
	@Column(name = "DISOVERTIME", length = 7)
	public Date getDisovertime() {
		return this.disovertime;
	}

	public void setDisovertime(Date disovertime) {
		this.disovertime = disovertime;
	}

	@Column(name = "SIGNTYPE", length = 16)
	public String getSigntype() {
		return this.signtype;
	}

	public void setSigntype(String signtype) {
		this.signtype = signtype;
	}

	@Column(name = "SMSSIGNNO", length = 14)
	public String getSmssignno() {
		return this.smssignno;
	}

	public void setSmssignno(String smssignno) {
		this.smssignno = smssignno;
	}

}