package com.gmcc.pboss.business.reward.rewardlocalvalue;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class RewardlocalvalueVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long mstid;

    /** identifier field */
    private Integer seq;

    /** nullable persistent field */
    private String content;
    
    private String type;//DETAILID

    /** full constructor */
    public RewardlocalvalueVO(java.lang.Long mstid, java.lang.Integer seq, java.lang.String content,String type) {
        this.mstid = mstid;
        this.seq = seq;
        this.content = content;
        this.type=type;
    }

    /** default constructor */
    public RewardlocalvalueVO() {
    }

    /** minimal constructor */
    public RewardlocalvalueVO(java.lang.Long mstid, java.lang.Integer seq) {
        this.mstid = mstid;
        this.seq = seq;
    }

    public java.lang.Long getMstid() {
        return this.mstid;
    }

    public void setMstid(java.lang.Long mstid) {
        this.mstid = mstid;
    }

    public java.lang.Integer getSeq() {
        return this.seq;
    }

    public void setSeq(java.lang.Integer seq) {
        this.seq = seq;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public void setContent(java.lang.String content) {
        this.content = content;
    }
    

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("mstid", getMstid())
            .append("seq", getSeq())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof RewardlocalvalueVO) ) return false;
        RewardlocalvalueVO castOther = (RewardlocalvalueVO) other;
        return new EqualsBuilder()
            .append(this.getMstid(), castOther.getMstid())
            .append(this.getSeq(), castOther.getSeq())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getMstid())
            .append(getSeq())
            .toHashCode();
    }

}
