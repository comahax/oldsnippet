package com.sunrise.boss.business.fee.billing.checkprocess.persistent;

public class DictitemDTO {

    /** identifier field */
    private String dictid;

    /** identifier field */
    private String groupid;

    /** nullable persistent field */
    private String dictname;

    /** nullable persistent field */
    private Short sortorder;

    /** nullable persistent field */
    private Byte status;

    /** nullable persistent field */
    private java.util.Date statusdate;

    /** nullable persistent field */
    private String description;
    
       
    private Short state;
    
    /** nullable persistent field */
    private java.util.Date req_time;
    
    private java.util.Date deal_time;

    /** persistent field */
    private String operator;

    /** nullable persistent field */
    private String remark;

	public String getDictid() {
		return dictid;
	}

	public void setDictid(String dictid) {
		this.dictid = dictid;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getDictname() {
		return dictname;
	}

	public void setDictname(String dictname) {
		this.dictname = dictname;
	}

	public Short getSortorder() {
		return sortorder;
	}

	public void setSortorder(Short sortorder) {
		this.sortorder = sortorder;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public java.util.Date getStatusdate() {
		return statusdate;
	}

	public void setStatusdate(java.util.Date statusdate) {
		this.statusdate = statusdate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public java.util.Date getReq_time() {
		return req_time;
	}

	public void setReq_time(java.util.Date req_time) {
		this.req_time = req_time;
	}

	public java.util.Date getDeal_time() {
		return deal_time;
	}

	public void setDeal_time(java.util.Date deal_time) {
		this.deal_time = deal_time;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
	
	
    
    
}
