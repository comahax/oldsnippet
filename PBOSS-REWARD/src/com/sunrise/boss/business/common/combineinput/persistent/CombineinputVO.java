package com.sunrise.boss.business.common.combineinput.persistent;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * <p>Title: CombineinputVO </p>
 * <p>Description: ��װ������VO�࣬��ʵ�ʿ���Ӧ </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Sunrise Tech Ltd.</p>
 * @author Zhang Fengchao
 * @since 1.0
 * @version 1.0
 * @date 2007-11-16
 */
public class CombineinputVO implements Serializable, Comparable {
	private String id = ""; // ��ʶ
	private String name = ""; // ����
	private String upid = ""; // �ϼ���ʶ [���ϼ���ʶ������]
	private String extend1 = ""; // Ԥ����չ
	private String extend2 = ""; // Ԥ����չ
	private String extend3 = ""; // Ԥ����չ
	
    /** full constructor */
    public CombineinputVO(java.lang.String id, java.lang.String name, java.lang.String upid, java.lang.String extend1, java.lang.String extend2, java.lang.String extend3) {
        this.id = id;
        this.name = name;
        this.upid = upid;
        this.extend1 = extend1;
        this.extend2 = extend2;
        this.extend2 = extend2;
    }

    /** default constructor */
    public CombineinputVO() {
    }

    /** minimal constructor */
    public CombineinputVO(java.lang.String id) {
        this.id = id;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpid() {
		return upid;
	}

	public void setUpid(String upid) {
		this.upid = upid;
	}

	public String getExtend1() {
		return extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	public String getExtend3() {
		return extend3;
	}

	public void setExtend3(String extend3) {
		this.extend3 = extend3;
	}
	
    public String toString() {
		return new ToStringBuilder(this).append("id", getId()).toString();
	}

    public boolean equals(Object other) {
		if (!(other instanceof CombineinputVO)) {
			return false;
		}
		CombineinputVO castOther = (CombineinputVO) other;
		return new EqualsBuilder().append(this.getId(), castOther.getId())
				.isEquals();
	}

    public int hashCode() {
        return new HashCodeBuilder().append(getId()).toHashCode();
    }

	public int compareTo(Object obj) {
		CombineinputVO another = (CombineinputVO) obj;
		return id.compareTo(another.getId());
	}
}