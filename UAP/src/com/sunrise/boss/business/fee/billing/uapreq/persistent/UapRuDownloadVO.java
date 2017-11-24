package com.sunrise.boss.business.fee.billing.uapreq.persistent;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.sunrise.jop.infrastructure.db.BaseVO;

/** @author Hibernate CodeGenerator */
public class UapRuDownloadVO extends BaseVO implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -621249273178201332L;
	
	// Fields

	private String ruleId;
	private String ruleName;
	private String srcPath;
	private String srcFilename;
	private String dstPath;
	private String dstHost;
	private String dstUsr;
	private String dstPwd;
	private String remark;
	private Integer region;

	// Constructors

	/** default constructor */
	public UapRuDownloadVO() {
	}

	/** minimal constructor */
	public UapRuDownloadVO(String ruleId) {
		this.ruleId = ruleId;
	}

	/** full constructor */
	public UapRuDownloadVO(String ruleId, String ruleName,
			String srcPath, String srcFilename, String dstPath, String dstHost,
			String dstUsr, String dstPwd, String remark, Integer region) {
		this.ruleId = ruleId;
		this.ruleName = ruleName;
		this.srcPath = srcPath;
		this.srcFilename = srcFilename;
		this.dstPath = dstPath;
		this.dstHost = dstHost;
		this.dstUsr = dstUsr;
		this.dstPwd = dstPwd;
		this.remark = remark;
		this.region = region;
	}

	// Property accessors

	public String getRuleId() {
		return this.ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getRuleName() {
		return this.ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getSrcPath() {
		return this.srcPath;
	}

	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}

	public String getSrcFilename() {
		return this.srcFilename;
	}

	public void setSrcFilename(String srcFilename) {
		this.srcFilename = srcFilename;
	}

	public String getDstPath() {
		return this.dstPath;
	}

	public void setDstPath(String dstPath) {
		this.dstPath = dstPath;
	}

	public String getDstHost() {
		return this.dstHost;
	}

	public void setDstHost(String dstHost) {
		this.dstHost = dstHost;
	}

	public String getDstUsr() {
		return this.dstUsr;
	}

	public void setDstUsr(String dstUsr) {
		this.dstUsr = dstUsr;
	}

	public String getDstPwd() {
		return this.dstPwd;
	}

	public void setDstPwd(String dstPwd) {
		this.dstPwd = dstPwd;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getRegion() {
		return this.region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public boolean equals(Object other) {
        if ( !(other instanceof UapRuDownloadVO) ) return false;
        UapRuDownloadVO castOther = (UapRuDownloadVO) other;
        return new EqualsBuilder()
            .append(this.getRuleId(), castOther.getRuleId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRuleId())
            .toHashCode();
    }

}
