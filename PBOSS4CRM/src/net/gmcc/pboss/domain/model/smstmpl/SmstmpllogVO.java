package net.gmcc.pboss.domain.model.smstmpl;

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
 * SmstmpllogVO entity. @author MyEclipse Persistence Tools
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "CH_SMS_SMSTMPLLOG")
public class SmstmpllogVO implements java.io.Serializable {

	// Fields

	private Long logid;
	private Date optime;
	private String oprcode;
	private String oprtype;
	private String success;
	private String sid;
	private String sname;
	private String stype;
	private String sstate;
	private String scontent;
	private String smemo;

	// Constructors

	/** default constructor */
	public SmstmpllogVO() {
	}

	/** full constructor */
	public SmstmpllogVO(Date optime, String oprcode, String oprtype,
			String success, String sid, String sname, String stype,
			String sstate, String scontent, String smemo) {
		this.optime = optime;
		this.oprcode = oprcode;
		this.oprtype = oprtype;
		this.success = success;
		this.sid = sid;
		this.sname = sname;
		this.stype = stype;
		this.sstate = sstate;
		this.scontent = scontent;
		this.smemo = smemo;
	}

	// Property accessors
	//@SequenceGenerator(name = "generator")
	@Id
	//@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	//@Column(name = "LOGID", unique = true, nullable = false, precision = 14, scale = 0)
	@GeneratedValue(strategy = SEQUENCE, generator = "SeqGenerator")
	@SequenceGenerator(name = "SeqGenerator", sequenceName = "CH_SMS_SMSTMPLLOG", allocationSize=1)
	@Column(name = "LOGID", unique = true, nullable = false, precision = 14, scale = 0)
	public Long getLogid() {
		return this.logid;
	}

	public void setLogid(Long logid) {
		this.logid = logid;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OPTIME", length = 7)
	public Date getOptime() {
		return this.optime;
	}

	public void setOptime(Date optime) {
		this.optime = optime;
	}

	@Column(name = "OPRCODE", length = 16)
	public String getOprcode() {
		return this.oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	@Column(name = "OPRTYPE", length = 8)
	public String getOprtype() {
		return this.oprtype;
	}

	public void setOprtype(String oprtype) {
		this.oprtype = oprtype;
	}

	@Column(name = "SUCCESS", length = 8)
	public String getSuccess() {
		return this.success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	@Column(name = "SID", length = 32)
	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	@Column(name = "SNAME", length = 50)
	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Column(name = "STYPE", length = 32)
	public String getStype() {
		return this.stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	@Column(name = "SSTATE", length = 32)
	public String getSstate() {
		return this.sstate;
	}

	public void setSstate(String sstate) {
		this.sstate = sstate;
	}

	@Column(name = "SCONTENT", length = 1024)
	public String getScontent() {
		return this.scontent;
	}

	public void setScontent(String scontent) {
		this.scontent = scontent;
	}

	@Column(name = "SMEMO", length = 1024)
	public String getSmemo() {
		return this.smemo;
	}

	public void setSmemo(String smemo) {
		this.smemo = smemo;
	}

}