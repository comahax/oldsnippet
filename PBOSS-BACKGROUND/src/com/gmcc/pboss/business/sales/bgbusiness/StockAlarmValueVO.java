package com.gmcc.pboss.business.sales.bgbusiness;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * 装载最高库存和预警阀值的VO
 * @author 
 *
 */
public class StockAlarmValueVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long maxstock;//最高库存
	private String alarmvalue;//级别和阀值，预警级别和阀值的组合，以冒号和分号间隔。预警级别参数FX_STOCKALARMLEVEL
	
	public Long getMaxstock() {
		return maxstock;
	}

	public void setMaxstock(Long maxstock) {
		this.maxstock = maxstock;
	}

	public String getAlarmvalue() {
		return alarmvalue;
	}

	public void setAlarmvalue(String alarmvalue) {
		this.alarmvalue = alarmvalue;
	}

	public StockAlarmValueVO() {
	}
	
	public StockAlarmValueVO(Long maxstock) {
		this.maxstock = maxstock;
	}
	
	public StockAlarmValueVO(Long maxstock,String level,String alarmvalue) {
		this.maxstock = maxstock;
		this.alarmvalue = alarmvalue;
	}
	
	public boolean equals(Object other) {
		 if ( !(other instanceof StockAlarmValueVO) ) return false;
		 StockAlarmValueVO castOther = (StockAlarmValueVO) other;
	        return new EqualsBuilder()
	            .append(this.getMaxstock(), castOther.getMaxstock())
	            .append(this.getAlarmvalue(), castOther.getAlarmvalue())
	            .isEquals();
	}
	
	public int hashCode() {
        return new HashCodeBuilder()
            .append(getMaxstock())
            .append(getAlarmvalue())
            .toHashCode();
    }
}
