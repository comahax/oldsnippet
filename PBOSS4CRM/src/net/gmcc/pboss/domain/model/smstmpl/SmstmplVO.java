package net.gmcc.pboss.domain.model.smstmpl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * SmstmplVO entity. @author MyEclipse Persistence Tools
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "CH_SMS_SMSTMPL")
public class SmstmplVO implements java.io.Serializable {

	// Fields

	private String sid;
	private String sname;
	private String stype;
	private String sstate;
	private String scontent;
	private String smemo;

	// Constructors

	/** default constructor */
	public SmstmplVO() {
	}

	/** minimal constructor */
	public SmstmplVO(String sid) {
		this.sid = sid;
	}

	/** full constructor */
	public SmstmplVO(String sid, String sname, String stype, String sstate,
			String scontent, String smemo) {
		this.sid = sid;
		this.sname = sname;
		this.stype = stype;
		this.sstate = sstate;
		this.scontent = scontent;
		this.smemo = smemo;
	}

	// Property accessors
	@Id
	@Column(name = "SID", unique = true, nullable = false, length = 32)
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