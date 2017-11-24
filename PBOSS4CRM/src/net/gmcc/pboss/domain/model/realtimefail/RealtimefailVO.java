package net.gmcc.pboss.domain.model.realtimefail;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Realtimefail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "CH_BBC_REALTIMEFAIL")//, schema = "PBOSS_ZS"
public class RealtimefailVO implements java.io.Serializable {

	// Fields

	private Long seq;
	private String opnid;
	private String wayid;
	private String oprcode;
	private Date oprtime;
	private String mobile;
	private Double busivalue;
	private Date creattime;
	private String src;
	private String calcopnid;
	private String calcmonth;
	private String ruleid;
	private String srcseq;
	private Byte ossrc;
	private String adtremark;

	// Constructors

	/** default constructor */
	public RealtimefailVO() {
	}

	/** minimal constructor */
	public RealtimefailVO(Long seq) {
		this.seq = seq;
	}

	/** full constructor */
	public RealtimefailVO(Long seq, String opnid, String wayid, String oprcode,
			Date oprtime, String mobile, Double busivalue, Date creattime,
			String src, String calcopnid, String calcmonth, String ruleid,
			String srcseq, Byte ossrc, String adtremark) {
		this.seq = seq;
		this.opnid = opnid;
		this.wayid = wayid;
		this.oprcode = oprcode;
		this.oprtime = oprtime;
		this.mobile = mobile;
		this.busivalue = busivalue;
		this.creattime = creattime;
		this.src = src;
		this.calcopnid = calcopnid;
		this.calcmonth = calcmonth;
		this.ruleid = ruleid;
		this.srcseq = srcseq;
		this.ossrc = ossrc;
		this.adtremark = adtremark;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "SeqGenerator")
	@SequenceGenerator(name = "SeqGenerator", sequenceName = "CH_BBC_REALTIMEFAIL_SEQ", allocationSize=1)
	@Column(name = "SEQ", unique = true, nullable = false, precision = 14, scale = 0)
	public Long getSeq() {
		return this.seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	@Column(name = "OPNID", length = 18)
	public String getOpnid() {
		return this.opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	@Column(name = "WAYID", length = 18)
	public String getWayid() {
		return this.wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	@Column(name = "OPRCODE", length = 15)
	public String getOprcode() {
		return this.oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "OPRTIME", length = 7)
	public Date getOprtime() {
		return this.oprtime;
	}

	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}

	@Column(name = "MOBILE", length = 15)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "BUSIVALUE", precision = 14)
	public Double getBusivalue() {
		return this.busivalue;
	}

	public void setBusivalue(Double busivalue) {
		this.busivalue = busivalue;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATTIME", length = 7)
	public Date getCreattime() {
		return this.creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	@Column(name = "SRC")
	public String getSrc() {
		return this.src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	@Column(name = "CALCOPNID", length = 18)
	public String getCalcopnid() {
		return this.calcopnid;
	}

	public void setCalcopnid(String calcopnid) {
		this.calcopnid = calcopnid;
	}

	@Column(name = "CALCMONTH", length = 8)
	public String getCalcmonth() {
		return this.calcmonth;
	}

	public void setCalcmonth(String calcmonth) {
		this.calcmonth = calcmonth;
	}

	@Column(name = "RULEID", length = 18)
	public String getRuleid() {
		return this.ruleid;
	}

	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
	}

	@Column(name = "SRCSEQ", length = 32)
	public String getSrcseq() {
		return this.srcseq;
	}

	public void setSrcseq(String srcseq) {
		this.srcseq = srcseq;
	}

	@Column(name = "OSSRC", precision = 2, scale = 0)
	public Byte getOssrc() {
		return this.ossrc;
	}

	public void setOssrc(Byte ossrc) {
		this.ossrc = ossrc;
	}

	@Column(name = "ADTREMARK", length = 256)
	public String getAdtremark() {
		return this.adtremark;
	}

	public void setAdtremark(String adtremark) {
		this.adtremark = adtremark;
	}

}