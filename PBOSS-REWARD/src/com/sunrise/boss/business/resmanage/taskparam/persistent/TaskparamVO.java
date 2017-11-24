package com.sunrise.boss.business.resmanage.taskparam.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class TaskparamVO implements Serializable {

	private String paramcode;

	private Long taskid;

	private String paramvalue;

	public TaskparamVO(java.lang.String paramcode, java.lang.Long taskid,
			java.lang.String paramvalue) {
		this.paramcode = paramcode;
		this.taskid = taskid;
		this.paramvalue = paramvalue;
	}

	public TaskparamVO() {
	}

	public TaskparamVO(java.lang.String paramcode, java.lang.Long taskid) {
		this.paramcode = paramcode;
		this.taskid = taskid;
	}

	public java.lang.String getParamcode() {
		return this.paramcode;
	}

	public void setParamcode(java.lang.String paramcode) {
		this.paramcode = paramcode;
	}

	public java.lang.Long getTaskid() {
		return this.taskid;
	}

	public void setTaskid(java.lang.Long taskid) {
		this.taskid = taskid;
	}

	public java.lang.String getParamvalue() {
		return this.paramvalue;
	}

	public void setParamvalue(java.lang.String paramvalue) {
		this.paramvalue = paramvalue;
	}

	public String toString() {
		return new ToStringBuilder(this).append("paramcode", getParamcode())
				.append("taskid", getTaskid()).toString();
	}

	public boolean equals(Object other) {
		if (!(other instanceof TaskparamVO))
			return false;
		TaskparamVO castOther = (TaskparamVO) other;
		return new EqualsBuilder().append(this.getParamcode(),
				castOther.getParamcode()).append(this.getTaskid(),
				castOther.getTaskid()).isEquals();
	}

	public int hashCode() {
		return new HashCodeBuilder().append(getParamcode()).append(getTaskid())
				.toHashCode();
	}

}
