package net.gmcc.pboss.domain.model.opnaudit;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OpnauditVO entity.
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "CH_PW_OPNAUDIT")//, schema = "PBOSS"
public class OpnauditVO implements java.io.Serializable {

	// Fields

	private String id;
	private Short cityid;
	private String opnid;
	private String opnname;
	private String parentid;
	private String busibelong;
	private Date startdate;
	private Date enddate;
	private Short state;
	private Date oprtime;

	// Constructors

	/** default constructor */
	public OpnauditVO() {
	}

	/** minimal constructor */
	public OpnauditVO(String id) {
		this.id = id;
	}

	/** full constructor */
	public OpnauditVO(String id, Short cityid, String opnid, String opnname,
			String parentid, String busibelong, Date startdate, Date enddate,
			Short state, Date oprtime) {
		this.id = id;
		this.cityid = cityid;
		this.opnid = opnid;
		this.opnname = opnname;
		this.parentid = parentid;
		this.busibelong = busibelong;
		this.startdate = startdate;
		this.enddate = enddate;
		this.state = state;
		this.oprtime = oprtime;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 23)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "CITYID", precision = 3, scale = 0)
	public Short getCityid() {
		return this.cityid;
	}

	public void setCityid(Short cityid) {
		this.cityid = cityid;
	}

	@Column(name = "OPNID", length = 13)
	public String getOpnid() {
		return this.opnid;
	}

	public void setOpnid(String opnid) {
		this.opnid = opnid;
	}

	@Column(name = "OPNNAME", length = 50)
	public String getOpnname() {
		return this.opnname;
	}

	public void setOpnname(String opnname) {
		this.opnname = opnname;
	}

	@Column(name = "PARENTID", length = 13)
	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	@Column(name = "BUSIBELONG", length = 10)
	public String getBusibelong() {
		return this.busibelong;
	}

	public void setBusibelong(String busibelong) {
		this.busibelong = busibelong;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "STARTDATE", length = 7)
	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ENDDATE", length = 7)
	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	@Column(name = "STATE", precision = 3, scale = 0)
	public Short getState() {
		return this.state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	//@Temporal(TemporalType.DATE)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OPRTIME", length = 7)
	public Date getOprtime() {
		return this.oprtime;
	}

	public void setOprtime(Date oprtime) {
		this.oprtime = oprtime;
	}

}