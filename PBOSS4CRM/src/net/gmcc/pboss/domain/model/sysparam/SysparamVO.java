package net.gmcc.pboss.domain.model.sysparam;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SysparamVO entity. @author MyEclipse Persistence Tools
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name = "IB_GL_SYSPARAM")
public class SysparamVO implements java.io.Serializable {

	// Fields

	private SysparamVOId id;
	private Date begintime;
	private Date endtime;
	private String paramname;
	private String paramvalue;
	private String memo;

	// Constructors

	/** default constructor */
	public SysparamVO() {
	}

	/** minimal constructor */
	public SysparamVO(SysparamVOId id) {
		this.id = id;
	}

	/** full constructor */
	public SysparamVO(SysparamVOId id, Date begintime, Date endtime,
			String paramname, String paramvalue, String memo) {
		this.id = id;
		this.begintime = begintime;
		this.endtime = endtime;
		this.paramname = paramname;
		this.paramvalue = paramvalue;
		this.memo = memo;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "systemid", column = @Column(name = "SYSTEMID", nullable = false, precision = 14, scale = 0)),
			@AttributeOverride(name = "paramtype", column = @Column(name = "PARAMTYPE", nullable = false, length = 16)) })
	public SysparamVOId getId() {
		return this.id;
	}

	public void setId(SysparamVOId id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BEGINTIME", length = 7)
	public Date getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ENDTIME", length = 7)
	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	@Column(name = "PARAMNAME", length = 32)
	public String getParamname() {
		return this.paramname;
	}

	public void setParamname(String paramname) {
		this.paramname = paramname;
	}

	@Column(name = "PARAMVALUE", length = 256)
	public String getParamvalue() {
		return this.paramvalue;
	}

	public void setParamvalue(String paramvalue) {
		this.paramvalue = paramvalue;
	}

	@Column(name = "MEMO", length = 256)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}