package net.gmcc.pboss.domain.model.waitreq;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * WaitreqVO entity. @author MyEclipse Persistence Tools
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "CH_SMS_WAITREQ")
public class WaitreqVO implements java.io.Serializable {

	// Fields

	private Long streamno;
	private Short smstype;
	private String areacode;
	private Date creattime;
	private Date dealtime;
	private String message;
	private String sendno;
	private String recno;
	private Short dealcount;
	private Short issuccess;
	private String resultcode;
	private String resultdesc;
	private Date senttime;

	// Constructors

	/** default constructor */
	public WaitreqVO() {
	}

	/** full constructor */
	public WaitreqVO(Short smstype, String areacode, Date creattime,
			Date dealtime, String message, String sendno, String recno,
			Short dealcount, Short issuccess, String resultcode,
			String resultdesc, Date senttime) {
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
	//@SequenceGenerator(name = "generator")
	@Id
	//@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	//@Column(name = "STREAMNO", unique = true, nullable = false, precision = 15, scale = 0)
	@GeneratedValue(strategy = SEQUENCE, generator = "SeqGenerator")
	@SequenceGenerator(name = "SeqGenerator", sequenceName = "CH_SMS_WAITREQ_SEQ", allocationSize=1)
	@Column(name = "STREAMNO", unique = true, nullable = false, precision = 14, scale = 0)
	public Long getStreamno() {
		return this.streamno;
	}

	public void setStreamno(Long streamno) {
		this.streamno = streamno;
	}

	@Column(name = "SMSTYPE", precision = 3, scale = 0)
	public Short getSmstype() {
		return this.smstype;
	}

	public void setSmstype(Short smstype) {
		this.smstype = smstype;
	}

	@Column(name = "AREACODE", length = 3)
	public String getAreacode() {
		return this.areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATTIME", length = 7)
	public Date getCreattime() {
		return this.creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DEALTIME", length = 7)
	public Date getDealtime() {
		return this.dealtime;
	}

	public void setDealtime(Date dealtime) {
		this.dealtime = dealtime;
	}

	@Column(name = "MESSAGE", length = 1000)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "SENDNO", length = 20)
	public String getSendno() {
		return this.sendno;
	}

	public void setSendno(String sendno) {
		this.sendno = sendno;
	}

	@Column(name = "RECNO", length = 20)
	public String getRecno() {
		return this.recno;
	}

	public void setRecno(String recno) {
		this.recno = recno;
	}

	@Column(name = "DEALCOUNT", precision = 3, scale = 0)
	public Short getDealcount() {
		return this.dealcount;
	}

	public void setDealcount(Short dealcount) {
		this.dealcount = dealcount;
	}

	@Column(name = "ISSUCCESS", precision = 3, scale = 0)
	public Short getIssuccess() {
		return this.issuccess;
	}

	public void setIssuccess(Short issuccess) {
		this.issuccess = issuccess;
	}

	@Column(name = "RESULTCODE", length = 3)
	public String getResultcode() {
		return this.resultcode;
	}

	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}

	@Column(name = "RESULTDESC")
	public String getResultdesc() {
		return this.resultdesc;
	}

	public void setResultdesc(String resultdesc) {
		this.resultdesc = resultdesc;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SENTTIME", length = 7)
	public Date getSenttime() {
		return this.senttime;
	}

	public void setSenttime(Date senttime) {
		this.senttime = senttime;
	}

}