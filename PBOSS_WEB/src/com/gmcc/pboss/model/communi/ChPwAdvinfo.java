package com.gmcc.pboss.model.communi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Set;

import javax.sql.rowset.serial.SerialClob;

import com.gmcc.pboss.common.bean.BaseModel;

/**
 * ChPwAdvinfo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class ChPwAdvinfo extends BaseModel implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5224800549215880742L;
	private Long advinfoid;
	private String title;
	private String content;
	private Long type;
	private Date releasetime;
	private Date plantime;
	private Date enddate;
	private Long desttype;
	private Long smsnotify;
	private Long ndapproval;
	private String oprcode;
	private Long state;
	private String stateName;
	private String imgLogoPath;
	private String url;
	/**
	 * 接收对象
	 */
	private Set rcvObjs;
	
	/**
	 * 附件
	 */
	private Set affixs;
	// Constructors

	/** default constructor */
	public ChPwAdvinfo() {
	}

	/** minimal constructor */
	public ChPwAdvinfo(Long advinfoid) {
		this.advinfoid = advinfoid;
	}

	/** full constructor */
	public ChPwAdvinfo(Long advinfoid, String title, String content, Long type,
			Date releasetime, Date plantime, Date enddate, Long desttype,
			Long smsnotify, Long ndapproval, String oprcode, Long state) {
		this.advinfoid = advinfoid;
		this.title = title;
		this.content = content;
		this.type = type;
		this.releasetime = releasetime;
		this.plantime = plantime;
		this.enddate = enddate;
		this.desttype = desttype;
		this.smsnotify = smsnotify;
		this.ndapproval = ndapproval;
		this.oprcode = oprcode;
		this.state = state;
	}

	// Property accessors

	public Long getAdvinfoid() {
		return this.advinfoid;
	}

	public void setAdvinfoid(Long advinfoid) {
		this.advinfoid = advinfoid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getType() {
		return this.type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Date getReleasetime() {
		return this.releasetime;
	}

	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
	}

	public Date getPlantime() {
		return this.plantime;
	}

	public void setPlantime(Date plantime) {
		this.plantime = plantime;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Long getDesttype() {
		return this.desttype;
	}

	public void setDesttype(Long desttype) {
		this.desttype = desttype;
	}

	public Long getSmsnotify() {
		return this.smsnotify;
	}

	public void setSmsnotify(Long smsnotify) {
		this.smsnotify = smsnotify;
	}

	public Long getNdapproval() {
		return this.ndapproval;
	}

	public void setNdapproval(Long ndapproval) {
		this.ndapproval = ndapproval;
	}

	public String getOprcode() {
		return this.oprcode;
	}

	public void setOprcode(String oprcode) {
		this.oprcode = oprcode;
	}

	public Long getState() {
		return this.state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public Set getRcvObjs() {
		return rcvObjs;
	}

	public void setRcvObjs(Set rcvObjs) {
		this.rcvObjs = rcvObjs;
	}

	public Set getAffixs() {
		return affixs;
	}

	public void setAffixs(Set affixs) {
		this.affixs = affixs;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getImgLogoPath() {
		return imgLogoPath;
	}

	public void setImgLogoPath(String imgLogoPath) {
		this.imgLogoPath = imgLogoPath;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}