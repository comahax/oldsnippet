package com.sunrise.boss.business.resmanage.nosect.persistent;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class NosectVO implements java.io.Serializable {

	// Fields

	private Long nosectid;

	private Date starttime;

	private Date intime;

	private String beginno;

	private String endno;

	private Long nosectstate;

	private Long imsisectid;

	private Long nogroupid;

	private Long scpid;

	private Long vpmnid;

	private String originbrandid; // 品牌

	private String platformtype; // 平台类型

	private String bossarea;

	// Constructors

	/** default constructor */
	public NosectVO() {
	}

	/** minimal constructor */
	public NosectVO(Long nosectid) {
		this.nosectid = nosectid;
	}

	/** full constructor */
	public NosectVO(Long nosectid, Date starttime, Date intime, String beginno,
			String endno, Long nosectstate, Long imsisectid, Long nogroupid,
			Long scpid, Long vpmnid, String bossarea) {
		this.nosectid = nosectid;
		this.starttime = starttime;
		this.intime = intime;
		this.beginno = beginno;
		this.endno = endno;
		this.nosectstate = nosectstate;
		this.imsisectid = imsisectid;
		this.nogroupid = nogroupid;
		this.scpid = scpid;
		this.vpmnid = vpmnid;
		this.bossarea = bossarea;
	}

	// Property accessors

	public Long getNosectid() {
		return this.nosectid;
	}

	public void setNosectid(Long nosectid) {
		this.nosectid = nosectid;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getIntime() {
		return this.intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	public String getBeginno() {
		return this.beginno;
	}

	public void setBeginno(String beginno) {
		this.beginno = beginno;
	}

	public String getEndno() {
		return this.endno;
	}

	public void setEndno(String endno) {
		this.endno = endno;
	}

	public Long getNosectstate() {
		return this.nosectstate;
	}

	public void setNosectstate(Long nosectstate) {
		this.nosectstate = nosectstate;
	}

	public Long getImsisectid() {
		return this.imsisectid;
	}

	public void setImsisectid(Long imsisectid) {
		this.imsisectid = imsisectid;
	}

	public Long getNogroupid() {
		return this.nogroupid;
	}

	public void setNogroupid(Long nogroupid) {
		this.nogroupid = nogroupid;
	}

	public Long getScpid() {
		return this.scpid;
	}

	public void setScpid(Long scpid) {
		this.scpid = scpid;
	}

	public String getBossarea() {
		return this.bossarea;
	}

	public void setBossarea(String bossarea) {
		this.bossarea = bossarea;
	}

	public String toString() {
		return new ToStringBuilder(this).append("nosectid", getNosectid())
				.toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof NosectVO))
			return false;
		NosectVO castOther = (NosectVO) other;
		return new EqualsBuilder().append(this.getNosectid(),
				castOther.getNosectid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getNosectid()).toHashCode();
	}

	public Long getVpmnid() {
		return vpmnid;
	}

	public void setVpmnid(Long vpmnid) {
		this.vpmnid = vpmnid;
	}

	public String getOriginbrandid() {
		return originbrandid;
	}

	public void setOriginbrandid(String originbrandid) {
		this.originbrandid = originbrandid;
	}

	public String getPlatformtype() {
		return platformtype;
	}

	public void setPlatformtype(String platformtype) {
		this.platformtype = platformtype;
	}

}