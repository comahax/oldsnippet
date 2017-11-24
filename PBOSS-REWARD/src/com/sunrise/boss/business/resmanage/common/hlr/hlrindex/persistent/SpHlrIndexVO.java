package com.sunrise.boss.business.resmanage.common.hlr.hlrindex.persistent;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class SpHlrIndexVO implements Serializable {

	private Long id;

	private Long streamno;

	private String mobileno;

	private Long seq;

	private Long issuccess;

	private Long backissuccess;

	private Date dealtime;

	private Long dealcount;

	// Constructors

	/** default constructor */
	public SpHlrIndexVO() {
	}

	/** minimal constructor */
	public SpHlrIndexVO(Long id) {
		this.id = id;
	}

	/** full constructor */
	public SpHlrIndexVO(Long id, Long streamno, String mobileno, Long seq,
			Long issuccess, Long backissuccess, Date dealtime, Long dealcount) {
		this.id = id;
		this.streamno = streamno;
		this.mobileno = mobileno;
		this.seq = seq;
		this.issuccess = issuccess;
		this.backissuccess = backissuccess;
		this.dealtime = dealtime;
		this.dealcount = dealcount;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof SpHlrIndexVO))
			return false;
		SpHlrIndexVO castOther = (SpHlrIndexVO) other;
		return new EqualsBuilder().append(this.getId(), castOther.getId())
				.isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public Long getBackissuccess() {
		return backissuccess;
	}

	public void setBackissuccess(Long backissuccess) {
		this.backissuccess = backissuccess;
	}

	public Long getDealcount() {
		return dealcount;
	}

	public void setDealcount(Long dealcount) {
		this.dealcount = dealcount;
	}

	public Date getDealtime() {
		return dealtime;
	}

	public void setDealtime(Date dealtime) {
		this.dealtime = dealtime;
	}

	public Long getIssuccess() {
		return issuccess;
	}

	public void setIssuccess(Long issuccess) {
		this.issuccess = issuccess;
	}

	public Long getStreamno() {
		return streamno;
	}

	public void setStreamno(Long streamno) {
		this.streamno = streamno;
	}
}
