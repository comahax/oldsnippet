package com.gmcc.pboss.business.sales.ordercomcate;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrdercomcateVO extends BaseVO implements Serializable {

    /** identifier field */
    private Long recid;

    /** persistent field */
    private String orderid;

    /** persistent field */
    private String ordercomtype;

    /** persistent field */
    private String comcategory;

    /** persistent field */
    private Long orderamt;

    /** nullable persistent field */
    private Double unitprice;

    /** nullable persistent field */
    private Double totalprice;

    private String changeFlag;
    
    private String planCode;
    
    private String planName;
    
    private String comcategoryType;
    
    private String memo;
    
    /** full constructor */
    public OrdercomcateVO(java.lang.String orderid, java.lang.String ordercomtype, java.lang.String comcategory, java.lang.Long orderamt, java.lang.Double unitprice, java.lang.Double totalprice) {
        this.orderid = orderid;
        this.ordercomtype = ordercomtype;
        this.comcategory = comcategory;
        this.orderamt = orderamt;
        this.unitprice = unitprice;
        this.totalprice = totalprice;
    }

    /** default constructor */
    public OrdercomcateVO() {
    }

    /** minimal constructor */
    public OrdercomcateVO(java.lang.String orderid, java.lang.String ordercomtype, java.lang.String comcategory, java.lang.Long orderamt) {
        this.orderid = orderid;
        this.ordercomtype = ordercomtype;
        this.comcategory = comcategory;
        this.orderamt = orderamt;
    }

    public java.lang.Long getRecid() {
        return this.recid;
    }

    public void setRecid(java.lang.Long recid) {
        this.recid = recid;
    }

    public java.lang.String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(java.lang.String orderid) {
        this.orderid = orderid;
    }

    public java.lang.String getOrdercomtype() {
        return this.ordercomtype;
    }

    public void setOrdercomtype(java.lang.String ordercomtype) {
        this.ordercomtype = ordercomtype;
    }

    public java.lang.String getComcategory() {
        return this.comcategory;
    }

    public void setComcategory(java.lang.String comcategory) {
        this.comcategory = comcategory;
    }

    public java.lang.Long getOrderamt() {
        return this.orderamt;
    }

    public void setOrderamt(java.lang.Long orderamt) {
        this.orderamt = orderamt;
    }

    public java.lang.Double getUnitprice() {
        return this.unitprice;
    }

    public void setUnitprice(java.lang.Double unitprice) {
        this.unitprice = unitprice;
    }

    public java.lang.Double getTotalprice() {
        return this.totalprice;
    }

    public void setTotalprice(java.lang.Double totalprice) {
        this.totalprice = totalprice;
    }

    public String getChangeFlag() {
		return changeFlag;
	}

	public void setChangeFlag(String changeFlag) {
		this.changeFlag = changeFlag;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("recid", getRecid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrdercomcateVO) ) return false;
        OrdercomcateVO castOther = (OrdercomcateVO) other;
        return new EqualsBuilder()
            .append(this.getRecid(), castOther.getRecid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRecid())
            .toHashCode();
    }

	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getComcategoryType() {
		return comcategoryType;
	}

	public void setComcategoryType(String comcategoryType) {
		this.comcategoryType = comcategoryType;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
