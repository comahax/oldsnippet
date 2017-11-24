package com.gmcc.pboss.business.base.organization;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrganizationVO extends BaseVO implements Serializable {

	// Fields

	private String orgid;
	private Long region;
	private String orgname;
	private String orgtype;
	private Long orglevel;
	private Long isinner;
	private String managerid;
	private String parentid;
	private String address;
	private String contactman;
	private String contactphone;
	private String openphone;
	private String postcode;
	private String email;
	private String notes;
	private Date createdate;
	private Long status;
	private Date statusdate;

	// Constructors

	/** default constructor */
	public OrganizationVO() {
	}

	/** minimal constructor */
	public OrganizationVO(String orgid) {
		this.orgid = orgid;
	}

	/** full constructor */
	public OrganizationVO(String orgid, Long region, String orgname,
			String orgtype, Long orglevel, Long isinner, String managerid,
			String parentid, String address, String contactman,
			String contactphone, String openphone, String postcode,
			String email, String notes, Date createdate, Long status,
			Date statusdate) {
		this.orgid = orgid;
		this.region = region;
		this.orgname = orgname;
		this.orgtype = orgtype;
		this.orglevel = orglevel;
		this.isinner = isinner;
		this.managerid = managerid;
		this.parentid = parentid;
		this.address = address;
		this.contactman = contactman;
		this.contactphone = contactphone;
		this.openphone = openphone;
		this.postcode = postcode;
		this.email = email;
		this.notes = notes;
		this.createdate = createdate;
		this.status = status;
		this.statusdate = statusdate;
	}

	// Property accessors

	public String getOrgid() {
		return this.orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public Long getRegion() {
		return this.region;
	}

	public void setRegion(Long region) {
		this.region = region;
	}

	public String getOrgname() {
		return this.orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getOrgtype() {
		return this.orgtype;
	}

	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	public Long getOrglevel() {
		return this.orglevel;
	}

	public void setOrglevel(Long orglevel) {
		this.orglevel = orglevel;
	}

	public Long getIsinner() {
		return this.isinner;
	}

	public void setIsinner(Long isinner) {
		this.isinner = isinner;
	}

	public String getManagerid() {
		return this.managerid;
	}

	public void setManagerid(String managerid) {
		this.managerid = managerid;
	}

	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactman() {
		return this.contactman;
	}

	public void setContactman(String contactman) {
		this.contactman = contactman;
	}

	public String getContactphone() {
		return this.contactphone;
	}

	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}

	public String getOpenphone() {
		return this.openphone;
	}

	public void setOpenphone(String openphone) {
		this.openphone = openphone;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Date getStatusdate() {
		return this.statusdate;
	}

	public void setStatusdate(Date statusdate) {
		this.statusdate = statusdate;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("orgid", this.getOrgid())
            .append("orgname", this.getOrgname())
            .toString();
    }

   

}
