package com.gmcc.pboss.business.sales.orderorderproce;

import com.sunrise.jop.infrastructure.db.BaseVO;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** @author Hibernate CodeGenerator */
public class OrderOrderproceVO extends BaseVO implements Serializable {

	private Long rowcountid;

    /** nullable persistent field */
    private String countyid;

    /** nullable persistent field */
    private String paytype;

    private Double sumrecamt;
    
    private Long countrecamt;
    
    //总计的格式化
    private String sumrecamtFormat;
    
    private String wayid;
    
    private String orderid;
    
    private String deacctno;
    
    private String deacctname;
    
    private String debankname;
    
    private Double recamt;
    
    private String debankid;
    
    
    
    public String getDebankid() {
		return debankid;
	}

	public void setDebankid(String debankid) {
		this.debankid = debankid;
	}

	public Double getRecamt() {
		return recamt;
	}

	public void setRecamt(Double recamt) {
		this.recamt = recamt;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getDeacctno() {
		return deacctno;
	}

	public void setDeacctno(String deacctno) {
		this.deacctno = deacctno;
	}

	public String getDeacctname() {
		return deacctname;
	}

	public void setDeacctname(String deacctname) {
		this.deacctname = deacctname;
	}

	public String getDebankname() {
		return debankname;
	}

	public void setDebankname(String debankname) {
		this.debankname = debankname;
	}

	public String getWayid() {
		return wayid;
	}

	public void setWayid(String wayid) {
		this.wayid = wayid;
	}

	public String getSumrecamtFormat() {
		return sumrecamtFormat;
	}

	public void setSumrecamtFormat(String sumrecamtFormat) {
		this.sumrecamtFormat = sumrecamtFormat;
	}

	public Long getRowcountid() {
		return rowcountid;
	}

	public void setRowcountid(Long rowcountid) {
		this.rowcountid = rowcountid;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public Double getSumrecamt() {
		return sumrecamt;
	}

	public void setSumrecamt(Double sumrecamt) {
		this.sumrecamt = sumrecamt;
	}

	public Long getCountrecamt() {
		return countrecamt;
	}

	public void setCountrecamt(Long countrecamt) {
		this.countrecamt = countrecamt;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("rowcountid", getRowcountid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrderOrderproceVO) ) return false;
        OrderOrderproceVO castOther = (OrderOrderproceVO) other;
        return new EqualsBuilder()
            .append(this.getRowcountid(), castOther.getRowcountid())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRowcountid())
            .toHashCode();
    }

}
