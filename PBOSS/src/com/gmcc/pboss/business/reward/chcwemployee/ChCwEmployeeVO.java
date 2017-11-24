package com.gmcc.pboss.business.reward.chcwemployee;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class ChCwEmployeeVO extends BaseVO implements Serializable {

    /** identifier field */
    private String employeeNum;

    /** nullable persistent field */
    private String employeeName;

    /** nullable persistent field */
    private Long deptId;

    /** full constructor */
    public ChCwEmployeeVO(java.lang.String employeeNum, java.lang.String employeeName, java.lang.Long deptId) {
        this.employeeNum = employeeNum;
        this.employeeName = employeeName;
        this.deptId = deptId;
    }

    /** default constructor */
    public ChCwEmployeeVO() {
    }

    /** minimal constructor */
    public ChCwEmployeeVO(java.lang.String employeeNum) {
        this.employeeNum = employeeNum;
    }

    public java.lang.String getEmployeeNum() {
        return this.employeeNum;
    }

    public void setEmployeeNum(java.lang.String employeeNum) {
        this.employeeNum = employeeNum;
    }

    public java.lang.String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(java.lang.String employeeName) {
        this.employeeName = employeeName;
    }

    public java.lang.Long getDeptId() {
        return this.deptId;
    }

    public void setDeptId(java.lang.Long deptId) {
        this.deptId = deptId;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("employeeNum", getEmployeeNum())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof ChCwEmployeeVO) ) return false;
        ChCwEmployeeVO castOther = (ChCwEmployeeVO) other;
        return new EqualsBuilder()
            .append(this.getEmployeeNum(), castOther.getEmployeeNum())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getEmployeeNum())
            .toHashCode();
    }

}
