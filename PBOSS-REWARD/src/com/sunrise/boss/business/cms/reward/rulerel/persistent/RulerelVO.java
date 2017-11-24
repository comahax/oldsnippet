package com.sunrise.boss.business.cms.reward.rulerel.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.sunrise.boss.business.cms.reward.rulelog.persistent.RulelogVO;
import com.sunrise.boss.business.cms.reward.rulerellog.persistent.RulerellogVO;
import com.sunrise.boss.business.common.dblog.OperationLog;

/** @author Hibernate CodeGenerator */
public class RulerelVO implements OperationLog {
	public Class logVOClass() {
		return RulerellogVO.class;
	}

    /** identifier field */
    private String cityid;

    /** identifier field */
    private String ruleid;

    /** identifier field */
    private String ruleitemid;

    /** nullable persistent field */
    private Short state;

    /** nullable persistent field */
    private Short isdefault;
    
    private String checked;
    
    private String disabled;
    
    private Long rulemodeid;
    
    private String paramer;

    private String ruleitemname;
    private String paramervalue;
    
    private String paramercityvalue;
    
    //1为表示勾选此项在页面上
    private Short isSelected;
    
    
    public Short getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Short isSelected) {
		this.isSelected = isSelected;
	}

	public String getParamercityvalue() {
		return paramercityvalue;
	}

	public void setParamercityvalue(String paramercityvalue) {
		this.paramercityvalue = paramercityvalue;
	}

	public String getParamervalue() {
		return paramervalue;
	}

	public void setParamervalue(String paramervalue) {
		this.paramervalue = paramervalue;
	}

	public String getRuleitemname() {
		return ruleitemname;
	}

	public void setRuleitemname(String ruleitemname) {
		this.ruleitemname = ruleitemname;
	}

	public String getParamer() {
		return paramer;
	}

	public void setParamer(String paramer) {
		this.paramer = paramer;
	}

	/** full constructor */
    public RulerelVO(java.lang.String cityid, java.lang.String ruleid, java.lang.String ruleitemid, java.lang.Short state, java.lang.Short isdefault, java.lang.Long rulemodeid ,java.lang.String paramer) {
        this.cityid = cityid;
        this.ruleid = ruleid;
        this.ruleitemid = ruleitemid;
        this.state = state;
        this.isdefault = isdefault;
        this.rulemodeid = rulemodeid;
        this.paramer=paramer;
    }

    /** default constructor */
    public RulerelVO() {
    	//disabled="false";
    	//checked="false";
    }

    /** minimal constructor */
    public RulerelVO(java.lang.String cityid, java.lang.String ruleid, java.lang.String ruleitemid, java.lang.Long rulemodeid) {
        this.cityid = cityid;
        this.ruleid = ruleid;
        this.ruleitemid = ruleitemid;
        this.rulemodeid = rulemodeid;
       
    }

    public java.lang.String getCityid() {
        return this.cityid;
    }

    public void setCityid(java.lang.String cityid) {
        this.cityid = cityid;
    }

    public java.lang.String getRuleid() {
        return this.ruleid;
    }

    public void setRuleid(java.lang.String ruleid) {
        this.ruleid = ruleid;
    }

    public java.lang.String getRuleitemid() {
        return this.ruleitemid;
    }

    public void setRuleitemid(java.lang.String ruleitemid) {
        this.ruleitemid = ruleitemid;
    }

    public java.lang.Short getState() {
        return this.state;
    }

    public void setState(java.lang.Short state) {
        this.state = state;
    }

    public java.lang.Short getIsdefault() {
        return this.isdefault;
    }

    public void setIsdefault(java.lang.Short isdefault) {
        this.isdefault = isdefault;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cityid", getCityid())
            .append("ruleid", getRuleid())
            .append("ruleitemid", getRuleitemid())
            .append("rulemodeid", getRulemodeid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RulerelVO) ) return false;
        RulerelVO castOther = (RulerelVO) other;
        return new EqualsBuilder()
            .append(this.getCityid(), castOther.getCityid())
            .append(this.getRuleid(), castOther.getRuleid())
            .append(this.getRuleitemid(), castOther.getRuleitemid())
            .append(this.getRulemodeid(), castOther.getRulemodeid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCityid())
            .append(getRuleid())
            .append(getRuleitemid())
            .append(getRulemodeid())
            .toHashCode();
    }

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public Long getRulemodeid() {
		return rulemodeid;
	}

	public void setRulemodeid(Long rulemodeid) {
		this.rulemodeid = rulemodeid;
	}

}
